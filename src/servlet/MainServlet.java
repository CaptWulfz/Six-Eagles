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
import dao.supplyorderdetailsdao;
import dao.supplyordersdao;
import model.Client;
import model.ingredients;
import model.product;
import model.rawmaterials;
import model.suppliers;
import model.supplyorders;
import temporary_models.SupplyOrderItem;
import url_patterns.URLPatterns;

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
			URLPatterns.MANAGESUPPLYORDER,
			URLPatterns.CREATEUSER,
			URLPatterns.CHANGECODE,
			URLPatterns.SUBMITCHANGECODE,
			URLPatterns.INVENTORY,
			URLPatterns.CHANGETHRESHOLDS,
			URLPatterns.CHANGEINGRTHREHSOLDS
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
			case URLPatterns.CREATEUSER:
				goToCreateUsersPage(request, response);
				break;
			case URLPatterns.CHANGECODE:
				changeProductCode(request, response);
				break;
			case URLPatterns.INVENTORY:
				goToInventory(request, response);
				break;
			case URLPatterns.CHANGETHRESHOLDS:
				changeThreshold(request, response);
				break;
			case URLPatterns.CHANGEINGRTHREHSOLDS:
				changeIngrThreshold(request, response);
				break;
		}
	}
	
	private void changeIngrThreshold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("ingrName"));
		int threshold = Integer.parseInt(request.getParameter("threshold"));
		int ceiling = Integer.parseInt(request.getParameter("ceiling"));
		
		ingredientsdao.changeThresholds(code, threshold, ceiling);
		
		response.sendRedirect("/Six_Eagles/ingredients");
	}
	
	private void changeThreshold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int code = Integer.parseInt(request.getParameter("productName"));
		int threshold = Integer.parseInt(request.getParameter("threshold"));
		int ceiling = Integer.parseInt(request.getParameter("ceiling"));
		
		productdao.changeThresholds(code, threshold, ceiling);
		
		response.sendRedirect("/Six_Eagles/inventory");
		
	}
	
	private void goToInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			ArrayList<product> prodList = productdao.viewproductactive();
			ArrayList<ingredients> ingList = ingredientsdao.viewIngredientactive();
			
			request.setAttribute("prodList", prodList);
			request.setAttribute("ingList", ingList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		request.getRequestDispatcher("inventory.jsp").forward(request, response);
	}
	
	private void changeProductCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int prodCode = Integer.parseInt(request.getParameter("productName"));
		int newCode = Integer.parseInt(request.getParameter("productCode"));
		
		System.out.println(prodCode + " " + newCode);
		
		productdao.changeProductCode(prodCode, newCode);
		response.sendRedirect("/Six_Eagles/inventory");
		
	}
	
	//This is the function that goes to the CreateUsers Page
	private void goToCreateUsersPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String errorMessage = (String) session.getAttribute("errorMessage");
		if (errorMessage != null) {
			request.setAttribute("errorMessage", errorMessage);
			session.setAttribute("errorMessage", null);
		}
		
		request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
	}
	
	//This is the function that goes to the home page
	private void goToHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String successMessage = (String) session.getAttribute("successMessage");

		if (successMessage != null) {
			request.setAttribute("successMessage", successMessage);
			session.setAttribute("successMessage", null);
		}

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
		ArrayList<rawmaterials> rawMaterialsList = rawmaterialsdao.viewRaw();
		ArrayList<supplyorders> supplyOrdersCart = new ArrayList<supplyorders>();
		
		
		request.setAttribute("suppliersList",  suppliersList);
		request.setAttribute("rawMaterialsList", rawMaterialsList);
		
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
		
		
		System.out.println(actionToDo);
		
		if (actionToDo.equals("addToOrder")) {
			int rawmCode = Integer.parseInt(request.getParameter("rawmCode"));
			ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
			SupplyOrderItem item = new SupplyOrderItem();
			
			
			try {
				//product p = productdao.getProduct(productCode);
				rawmaterials rawm = rawmaterialsdao.getRawMaterialById(rawmCode);
				item.setRawMaterials(rawm);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if (supplyOrdersCart == null)
				supplyOrdersCart = new ArrayList<SupplyOrderItem>();
			
			int SupplierID = Integer.parseInt(request.getParameter("supplierName"));
	        int supplyOrderNum = Integer.parseInt(request.getParameter("supplyOrder"));
	        String OrderDate = request.getParameter("orderDate");
	        String DeliveryDate = request.getParameter("deliveryDate");
	        int quantity = Integer.parseInt(request.getParameter("quantity"));
	        //Subject to Change
	        int StatusID = 2;
	        String Comment = "";
	        
	        String supplierName = Supplierdao.getSupplierNameFromId(SupplierID);
	         
	        //supplyorders b = new supplyorders(SupplierID,0,OrderDate,DeliveryDate,StatusID,Comment);
			supplyorders b = new supplyorders(supplierName, supplyOrderNum, SupplierID, 0, OrderDate, DeliveryDate, StatusID, Comment);
	        item.setSupplyOrders(b);
	        item.setQuantity(quantity);
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
				ArrayList<rawmaterials> rawMaterialsList = rawmaterialsdao.viewRaw();
				
				request.setAttribute("rawMaterialsList", rawMaterialsList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
			
			
	        request.getRequestDispatcher("newsupplierorder2.jsp").forward(request, response);
		} else if (actionToDo.equals("checkout")) {
			System.out.println("ADD THE ORDERS");
			//response.sendRedirect("/Six_Eagles/addSupplyOrder");

	        ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
	        
	        for (SupplyOrderItem item : supplyOrdersCart) {
	        	rawmaterials r = item.getRawMaterials();
	        	supplyorders sb = item.getSupplyOrders();
	        	
	        	if(supplyordersdao.addingSupplyOrder(sb)){
	        		supplyorderdetailsdao.AddSupplyOrderDetails(item);
	        		response.sendRedirect("/Six_Eagles/home");
	        	}
	        }
			
		} else if (actionToDo.equals("Remove")) {
			ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
			 supplyOrdersCart = new ArrayList<SupplyOrderItem>();
			
			 session.setAttribute("supplyOrdersCart", supplyOrdersCart);
			 
			 try {
				ArrayList<suppliers> suppliersList = Supplierdao.viewSupplier();
				request.setAttribute("suppliersList",  suppliersList);
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			try {
				ArrayList<rawmaterials> rawMaterialsList = rawmaterialsdao.viewRaw();
				
				request.setAttribute("rawMaterialsList", rawMaterialsList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("newsupplierorder2.jsp").forward(request, response);
			 
		}
		
	}

}
