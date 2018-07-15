package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Supplierdao;
import dao.clientdao;
import dao.ingredientsdao;
import dao.productdao;
import dao.rawmaterialsdao;
import model.Client;
import model.ingredients;
import model.product;
import model.rawmaterials;
import model.suppliers;
import model.supplyorders;
import temporary_models.SupplyOrderItem;

class URLPatterns {
	public final static String HOME = "/home";
	public final static String INGREDIENTS = "/ingredients"; 
	public final static String RAWMATS = "/rawmats";
	public final static String CLIENTORDER = "/newClientOrder";
	public final static String SUPPLIERORDER = "/newSupplierOrder";
	public final static String LOGOUT = "/logOut";
	public final static String CLIENTS = "/clients";
	public final static String SUPPLIERS = "/suppliers";
	public final static String LOGIN = "/login";
	public final static String MANAGESUPPLYORDER = "/manageSupplyOrder";
}

/**
 * Servlet implementation class MainServlet
 */
@WebServlet({URLPatterns.HOME,
			URLPatterns.INGREDIENTS,
			URLPatterns.RAWMATS,
			URLPatterns.CLIENTORDER,
			URLPatterns.SUPPLIERORDER,
			URLPatterns.LOGOUT,
			URLPatterns.CLIENTS,
			URLPatterns.SUPPLIERS,
			URLPatterns.LOGIN,
			URLPatterns.MANAGESUPPLYORDER
			})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pattern = request.getServletPath();
		
		switch (pattern) {
			case URLPatterns.HOME:
				goToHomepage(request, response);
				break;
			case URLPatterns.INGREDIENTS:
				try {
					showIngredients(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case URLPatterns.RAWMATS:
				try {
					showRawMaterials(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case URLPatterns.CLIENTORDER:
				try {
					addNewClientOrder(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case URLPatterns.SUPPLIERORDER:
				try {
					addNewSupplierOrder(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case URLPatterns.CLIENTS:
				try {
					goToClientsPage(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case URLPatterns.SUPPLIERS:
				try {
					goToSuppliersPage(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case URLPatterns.LOGOUT:
				logOutUser(request, response);
				break;
			case URLPatterns.LOGIN:
				goToLoginPage(request, response);
				break;
			case URLPatterns.MANAGESUPPLYORDER:
				addSupplyOrder(request, response);
				break;
		}
	}
	
	//This is the function that goes to the home page
	private void goToHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.jsp").forward(request, response);		
	}
	
	private void goToLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	//This is the function that goes to the Clients List Page
	private void goToClientsPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ArrayList<Client> clientList = clientdao.viewClientactive();
		
		request.setAttribute("clientList", clientList);
		
		request.getRequestDispatcher("client.jsp").forward(request, response);	
	}
	
	//This is the function that goes to the Suppliers Page
	private void goToSuppliersPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ArrayList<suppliers> suppliersList = Supplierdao.viewSupplier();

		
		request.setAttribute("suppliersList", suppliersList);
		
		request.getRequestDispatcher("supplier.jsp").forward(request, response);
		
	}
	
	// This is the function for Showing the ingredients in a table
	private void showIngredients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String searchKey = request.getParameter("ingredient-name");
		ArrayList<ingredients> ingr = new ArrayList<ingredients>();
		
		System.out.println(searchKey);
		
		if (searchKey == null)
			searchKey = "";
	
		if (!searchKey.equals("")) {
				ingredients i = ingredientsdao.getIngredientByName(searchKey);
				if (i != null)
					ingr.add(i);
		} else {
			ingr = ingredientsdao.viewIngredientactive();
		}
		
		request.setAttribute("ingredientsList", ingr);
		
		request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	}
	
	//This is the function for showing the raw materials in a table
	private void showRawMaterials(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String searchKey = request.getParameter("raw-material-name");
		ArrayList<rawmaterials> rawm = new ArrayList<rawmaterials>();
		ArrayList<ingredients> ingr = ingredientsdao.viewIngredientactive();
		
		if (searchKey == null)
			searchKey = "";
		
		if (!searchKey.equals("")) {
			rawmaterials r = rawmaterialsdao.getRawMaterialByName(searchKey);
			if (r != null)
				rawm.add(r);
		} else
			rawm = rawmaterialsdao.viewRaw();
		
		request.setAttribute("rawMaterialsList", rawm);
		request.setAttribute("ingredientsList", ingr);
		
		request.getRequestDispatcher("rawmats.jsp").forward(request, response);

	}
	
	//This is the function for going to the servlet for a new Client Order
	private void addNewClientOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ArrayList<Client> clientList = clientdao.viewClientactive();
		
		ArrayList<Client> uniqueClientList = new ArrayList<Client>();
		
		for (Client c : clientList) {
			boolean found = false;
			int i = 0;
			if (uniqueClientList.size() > 0) {
				while ( i < uniqueClientList.size() && !found) {
					Client uniqueClient = uniqueClientList.get(i);
					
					if (c.getClientName().equals(uniqueClient.getClientName()))
						found = true;
					else 
						i++;	
				}
				
				if (!found)
					uniqueClientList.add(c);
			} else 
				uniqueClientList.add(c);
		}
		
		
		HttpSession session = request.getSession();
		
		String selectedClientName = (String) session.getAttribute("selectedClientName");
		String selectedIndex = (String) request.getAttribute("selectedIndex");
		
		session.setAttribute("selectedClientName", null);
		session.setAttribute("selectedIndex", null);
		
		if (selectedClientName == null) {
			selectedClientName = uniqueClientList.get(0).getClientName();
			selectedIndex = "0";
		}
		
		if (selectedIndex == null) {
			boolean found = false;
			int i = 0;
			while (i < uniqueClientList.size() && !found) {
				if (uniqueClientList.get(i).getClientName().equals(selectedClientName)) {
					found = true;
					selectedIndex = Integer.toString(i);
				} else
					i++;
			}
		}
		
		request.setAttribute("selectedIndex", selectedIndex);
			
		ArrayList<Client> allEntriesOfSelectedClient = new ArrayList<Client>();
		
		for (Client c : clientList) {
			if (c.getClientName().equals(selectedClientName))
					allEntriesOfSelectedClient.add(c);
		}
		
		request.setAttribute("clientList", uniqueClientList);
		request.setAttribute("allEntriesOfSelectedClient", allEntriesOfSelectedClient);
		
		request.getRequestDispatcher("neworder.jsp").forward(request, response);
	}
	
	//This is the function for going to the servlet for a new Supplier Order
	private void addNewSupplierOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ArrayList<suppliers> suppliersList = Supplierdao.viewSupplier();
		ArrayList<ingredients> ingredientsList = ingredientsdao.viewIngredientactive();
		ArrayList<supplyorders> supplyOrdersCart = new ArrayList<supplyorders>();
		
		request.setAttribute("suppliersList",  suppliersList);
		request.setAttribute("ingredientsList", ingredientsList);
		
		request.getSession().setAttribute("supplyOrdersCart", supplyOrdersCart);
		
		request.getRequestDispatcher("newsupplierorder2.jsp").forward(request, response);
	}
	
	//This is the function to log the user out
	private void logOutUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		//invalidate session
		session.invalidate();
		
		//kill cookie
		// kill cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i = 0; i < cookies.length; i++){
				Cookie currentCookie = cookies[i];
				if(currentCookie.getName().equals("uuid")){
					currentCookie.setMaxAge(0);
					response.addCookie(currentCookie);
				}
				if (currentCookie.getName().equals("JSESSIONID")) {
					System.out.println("FOUND JSESSIONID");
					currentCookie.setMaxAge(0);
					response.addCookie(currentCookie);
				}
			}
		}
		
		response.sendRedirect("/Six_Eagles/login");
		//request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	//This is the function for adding Supply Orders
	private void addSupplyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String actionToDo = request.getParameter("submit");
		int productCode = Integer.parseInt(request.getParameter("ingredientCode"));
		
		if (actionToDo.equals("addToOrder")) {
			ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
			SupplyOrderItem item = new SupplyOrderItem();
			
			try {
				product p = productdao.getProduct(productCode);
				item.setProduct(p);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if (supplyOrdersCart == null)
				supplyOrdersCart = new ArrayList<SupplyOrderItem>();
			
			int SupplierID = Integer.parseInt(request.getParameter("supplierName"));
	        int supplyOrderNum = Integer.parseInt(request.getParameter("supplyOrder"));
	        String OrderDate = request.getParameter("orderDate");
	        String DeliveryDate = request.getParameter("deliveryDate");
	        //Subject to Change
	        int StatusID = 2;
	        String Comment = "";
	        
	        String supplierName = Supplierdao.getSupplierNameFromId(SupplierID);
	         
	        //supplyorders b = new supplyorders(SupplierID,0,OrderDate,DeliveryDate,StatusID,Comment);
			supplyorders b = new supplyorders(supplierName, supplyOrderNum, SupplierID, 0, OrderDate, DeliveryDate, StatusID, Comment);
	        item.setSupplyOrders(b);
			supplyOrdersCart.add(item);
	        session.setAttribute("supplyOrdersCart", supplyOrdersCart);
	        
	        try {
				ArrayList<suppliers> suppliersList = Supplierdao.viewSupplier();
				request.setAttribute("suppliersList",  suppliersList);
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ArrayList<ingredients> ingredientsList = ingredientsdao.viewIngredientactive();
				request.setAttribute("ingredientsList", ingredientsList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			
			
	        request.getRequestDispatcher("newsupplierorder2.jsp").forward(request, response);
		} else if (actionToDo.equals("checkout")) {
			response.sendRedirect("/addSupplyOrder");
		}
		
	}

}
