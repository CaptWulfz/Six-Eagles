package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientOrderdao;
import dao.SupplierStockService;
import dao.Supplierdao;
import dao.clientdao;
import dao.ingredientsdao;
import dao.productdao;
import dao.rawmaterialsdao;
import dao.supplyorderdetailsdao;
import dao.supplyordersdao;
import model.Client;
import model.Orders;
import model.SupplierStock;
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
			URLPatterns.CHANGEINGRTHREHSOLDS,
			URLPatterns.REACTIVATECLIENT,
			URLPatterns.REACTIVATEINGREDIENT,
			URLPatterns.PRODUCTPHYSICALCOUNT,
			URLPatterns.REACTIVATEPRODUCT,
			URLPatterns.VIEWINACTIVEPRODUCTS,
			URLPatterns.UPDATEINVENTORY,
			URLPatterns.MANAGEORDERS,
			URLPatterns.VIEWARCHIVEDCLIENTORDERS,
			URLPatterns.VIEWSUPPLYORDERS,
			URLPatterns.MANAGEREPORTS,
			URLPatterns.VIEWARCHIVEDSUPPLYORDERS
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
			case URLPatterns.REACTIVATECLIENT:
				goToReactivateClientsPage(request, response);
				break;
			case URLPatterns.REACTIVATEINGREDIENT:
				goToReactivateIngredients(request, response);
				break;
			case URLPatterns.PRODUCTPHYSICALCOUNT:
				goToProductsPhysicalCountPage(request, response);
				break;
			case URLPatterns.VIEWINACTIVEPRODUCTS:
				goToInactiveProducts(request, response);
			case URLPatterns.UPDATEINVENTORY:
				goToProduceProducts(request, response);
				break;
			case URLPatterns.MANAGEORDERS:
				goToManageOrders(request, response);
				break;
			case URLPatterns.VIEWARCHIVEDCLIENTORDERS:
				goToArchivedClientOrders(request, response);
				break;
			case URLPatterns.VIEWSUPPLYORDERS:
				goToSupplyOrders(request, response);
				break;
			case URLPatterns.MANAGEREPORTS:
				goToReportsPage(request, response);
				break;
			case URLPatterns.VIEWARCHIVEDSUPPLYORDERS:
				goToArchivedSupplyOrders(request, response);
		}
	}
	
	private void goToArchivedSupplyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				ArrayList<supplyorders>supplyOrders = supplyordersdao.viewSupplyOrdersdelivered();
				ArrayList<suppliers>suppliersList = new ArrayList<suppliers>();
				
				for (supplyorders s : supplyOrders) {
					suppliers sp = Supplierdao.getSupplierFromId(s.getSupplierID());
					suppliersList.add(sp);
				}
				
				request.setAttribute("supplyOrders", supplyOrders);
				request.setAttribute("suppliersList", suppliersList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 request.getRequestDispatcher("Archivedsupplyorders.jsp").forward(request, response);
	}
	
	private void goToReportsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		String dateToday = dtf.format(localDate);
		String dateTomorrow = dtf.format(localDate.plusDays(1));
		
		request.setAttribute("dateToday", dateToday);
		request.setAttribute("dateTomorrow", dateTomorrow);
		
		request.getRequestDispatcher("generateReports.jsp").forward(request, response);
		
	}
	
	private void goToSupplyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			ArrayList<supplyorders>supplyOrders = supplyordersdao.viewSupplyOrders();
			ArrayList<suppliers>suppliersList = new ArrayList<suppliers>();
			
			for (supplyorders s : supplyOrders) {
				suppliers sp = Supplierdao.getSupplierFromId(s.getSupplierID());
				suppliersList.add(sp);
			}
			
			request.setAttribute("supplyOrders", supplyOrders);
			request.setAttribute("suppliersList", suppliersList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 request.getRequestDispatcher("supplyorders.jsp").forward(request, response);
		 
	}
	
	private void goToArchivedClientOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Orders> ordersList = ClientOrderdao.viewClientOrderdelivered();
			ArrayList<Client> clientList = new ArrayList<Client>();
			
			for (Orders o : ordersList) {
				Client c = clientdao.getClientByID(o.getClientID());
				clientList.add(c);
			}
			
			request.setAttribute("clientList", clientList);
			request.setAttribute("ordersList", ordersList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ArchivedClientOrders.jsp").forward(request, response);
	}
	
	private void goToManageOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Orders> ordersList = ClientOrderdao.viewClientOrder();
			ArrayList<Client> clientList = new ArrayList<Client>();
			
			for (Orders o : ordersList) {
				Client c = clientdao.getClientByID(o.getClientID());
				clientList.add(c);
			}
			
			request.setAttribute("clientList", clientList);
			request.setAttribute("ordersList", ordersList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("orders.jsp").forward(request, response);
	}
	
	private void goToProduceProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<product> prodList = productdao.viewproductactive();
			request.setAttribute("prodList", prodList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("updateprodad.jsp").forward(request, response);
	}
	
	private void goToInactiveProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<product> prodList = productdao.viewproductdeactive();
			request.setAttribute("prodList", prodList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("reactivateinventory.jsp").forward(request, response);
		
	}
	
	private void goToProductsPhysicalCountPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<product> prodList = productdao.viewproductactive();
			request.setAttribute("prodList", prodList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("physicalcount.jsp").forward(request, response);
		
	}
	
	private void goToReactivateIngredients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<ingredients> ingrList = ingredientsdao.viewIngredientdeactive();
			request.setAttribute("ingrList", ingrList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("reactivateingredients.jsp").forward(request, response);
	}
	
	private void goToReactivateClientsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Client> clientList;
		try {
			clientList = clientdao.viewClientdeactive();
			request.setAttribute("clientList", clientList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("reactivateclient.jsp").forward(request, response);
	}
	
	private void changeIngrThreshold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("ingrName"));
		int threshold = Integer.parseInt(request.getParameter("threshold"));
		int ceiling = Integer.parseInt(request.getParameter("ceiling"));
		
		HttpSession session = request.getSession();
		
		if (threshold < ceiling) {
			ingredientsdao.changeThresholds(code, threshold, ceiling);
			session.setAttribute("message", "Successfully Changed Treshold!!!");
		} else {
			session.setAttribute("message", "Treshold Cannot be Greater or Equal to the Ceiling!!!");
		}
		
		response.sendRedirect("/Six_Eagles/ingredients");
	}
	
	private void changeThreshold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int code = Integer.parseInt(request.getParameter("productName"));
		int threshold = Integer.parseInt(request.getParameter("threshold"));
		int ceiling = Integer.parseInt(request.getParameter("ceiling"));
		
		HttpSession session = request.getSession();
		
		if (threshold < ceiling || (threshold == 0 && ceiling == 0)) {
			productdao.changeThresholds(code, threshold, ceiling);
			session.setAttribute("message", "Successfully Changed The Thresholds!!!");
		} else {
			session.setAttribute("message", "Threshold cannot be Greater than or Equal to Ceiling!!!");
		}
		
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
		
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("message");
		
		if (message != null) {
			request.setAttribute("message", message);
			session.setAttribute("message", null);
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
		
		String message = (String) session.getAttribute("message");

		if (message != null) {
			request.setAttribute("message", message);
			session.setAttribute("message", null);
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
		ArrayList<ingredients> ingrList = ingredientsdao.viewIngredientactive();
		
		request.setAttribute("suppliersList", suppliersList);
		request.setAttribute("ingrList", ingrList);
		
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
		
		HttpSession session = request.getSession();
		
		String message = (String) session.getAttribute("message");
		
		if (message != null) {
			request.setAttribute("message", message);
			session.setAttribute("message", null);
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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		String dateToday = dtf.format(localDate);
		String dateTomorrow = dtf.format(localDate.plusDays(1));
		
		request.setAttribute("dateToday", dateToday);
		request.setAttribute("dateTomorrow", dateTomorrow);
		
		String message = (String) session.getAttribute("message");
		if (message != null) {
			request.setAttribute("message", message);
			session.setAttribute("message", null);
		}
		
		request.getRequestDispatcher("neworder.jsp").forward(request, response);
	}
	
	//This is the function for going to the servlet for a new Supplier Order
	private void addNewSupplierOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ArrayList<suppliers> suppliersList = Supplierdao.viewSupplier();
		ArrayList<supplyorders> supplyOrdersCart;
		
		request.setAttribute("suppliersList",  suppliersList);
		
		HttpSession session = request.getSession();
		
		ArrayList<ingredients> ingrList = (ArrayList<ingredients>) session.getAttribute("ingrList");
		
		if(ingrList != null) {
			request.setAttribute("ingrList", ingrList);
			session.setAttribute("ingrList", null);
		} else {
			ingrList = new ArrayList<ingredients>();
			ArrayList<SupplierStock> stockList = SupplierStockService.getSupplierStockBySupplierID(1);
			for (SupplierStock s : stockList) {
				ingredients i = ingredientsdao.getIngredientByCode(s.getIngredientID());
				ingrList.add(i);
			}
			request.setAttribute("ingrList", ingrList);
		}
		
		System.out.println(ingrList.size());
		System.out.println("here");
		
		String index = (String) session.getAttribute("currSupplierID");
		
		System.out.println(index);
		
		if (index != null) {
			request.setAttribute("index", Integer.parseInt(index));
			session.setAttribute("index", null);
		} else {
			request.setAttribute("index", 0);
		}
		
		System.out.println("INDEX IS: " + request.getAttribute("index"));
		
		supplyOrdersCart = (ArrayList<supplyorders>) session.getAttribute("supplyOrdersCart");
		
		if (supplyOrdersCart == null) {
			supplyOrdersCart = new ArrayList<supplyorders>();
			session.setAttribute("supplyOrdersCart", supplyOrdersCart);
		}
		
		String message = (String) session.getAttribute("message");
		
		if (message != null) {
			request.setAttribute("message", message);
			session.setAttribute("message", null);
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		String dateToday = dtf.format(localDate);
		String dateTomorrow = dtf.format(localDate.plusDays(1));
		
		request.setAttribute("dateToday", dateToday);
		request.setAttribute("dateTomorrow", dateTomorrow);
		
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
		
		String actionToDo = request.getParameter("submitBtn");
		
		System.out.println(actionToDo);
		if (actionToDo != null) {
			if (actionToDo.equals("addToOrder")) {
				int ingrCode = Integer.parseInt(request.getParameter("ingrCode"));
				ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
				SupplyOrderItem item = new SupplyOrderItem();
				
				
				try {
					//product p = productdao.getProduct(productCode);
					ingredients ingr = ingredientsdao.getIngredientByCode(ingrCode);
					item.setIngredient(ingr);
				} catch (Exception e) {
					e.printStackTrace();
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
		        
		        System.out.println("THE ORDER DATE IS: " + OrderDate);
		        System.out.println("THE DELIVERY DATE IS: " + DeliveryDate);
		        
		        supplyorders sp = supplyordersdao.getSupplyOrderBySupplyOrderNum(supplyOrderNum);
		        
		        if (sp == null) {
		        	
		        	boolean found = false;
		        	int i = 0;
		        	while (i < supplyOrdersCart.size() && !found) {
		        		SupplyOrderItem s = supplyOrdersCart.get(i);
		        		if (s.getSupplyOrders().getSupplyOrderNum() == supplyOrderNum) 
		        			found = true;
		        		else
		        			i++;
		        	}
		        	
		        	if (!found) {
				        if (DeliveryDate.compareTo(OrderDate) > 0) {
				        
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
					        
					        session.setAttribute("message", "Successfully Added New Supply Order!!!");
					        
					        //request.getRequestDispatcher("newsupplierorder2.jsp").forward(request, response);
				        } else {
				        	session.setAttribute("message", "Order Date cannot come after the Delivery Date!!!");
				        }
		        	} else {
		        		session.setAttribute("message", "This Supply Order Number is already in the cart!!!");
		        	}
		        } else {
		        	session.setAttribute("message", "This Supply Order Number already exists!!!");
		        }
		        
		        response.sendRedirect("/Six_Eagles/newSupplierOrder");
			} else if (actionToDo.equals("checkout")) {
				System.out.println("ADD THE ORDERS");
				//response.sendRedirect("/Six_Eagles/addSupplyOrder");
	
		        ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
		        
		        for (SupplyOrderItem item : supplyOrdersCart) {
		        	ingredients ingr = item.getIngredient();
		        	supplyorders sb = item.getSupplyOrders();
		        	
		        	supplyordersdao.addingSupplyOrder(sb);
	        		supplyorderdetailsdao.AddSupplyOrderDetails(item);
	        		response.sendRedirect("/Six_Eagles/home");
		        	
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
		} else {
			
			int supplierID = Integer.parseInt(request.getParameter("supplierName"));
			
			ArrayList<SupplierStock> stockList = SupplierStockService.getSupplierStockBySupplierID(supplierID);
			ArrayList<ingredients> ingrList = new ArrayList<ingredients>();
			for (SupplierStock s : stockList) {
				ingredients i = ingredientsdao.getIngredientByCode(s.getIngredientID());
				ingrList.add(i);
			}
			
			System.out.println("HERE NOW");
			String newID = Integer.toString(supplierID - 1);
			session.setAttribute("ingrList", ingrList);
			session.setAttribute("currSupplierID", newID);
			
			response.sendRedirect("/Six_Eagles/newSupplierOrder");
		}
	}

}