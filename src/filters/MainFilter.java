package filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Usersdao;
import model.Users;

/**
 * Servlet Filter implementation class MainFilter
 */
@WebFilter(urlPatterns = {"/home", "/clients", "/suppliers"})
public class MainFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MainFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Filtering");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		//retrieve cookies
		Cookie[] cookies = httpRequest.getCookies();
		String uuid = null;
		
		//if username cookie exists
		if (cookies != null) {
			for (Cookie c: cookies) {
				if (c.getName().equals("uuid")) {
					uuid = c.getValue();
					c.setMaxAge(60*30);
					c.setHttpOnly(true);
					httpResponse.addCookie(c);
					System.out.println(uuid);
				}
			}
		}
		
		//if exists
		if (!session.isNew()) {
			//Allow Access if for User Type Authentication Don't use Yet
			//boolean allowAccess = false;
			
			if (uuid != null) {
				boolean found = false;
				ArrayList<Users> usersList = new ArrayList<Users>();
				
				usersList = Usersdao.getAllUsers();
				
				int i = 0;
				while (!found && i < usersList.size()) {
					Users user = usersList.get(i);
					if (user.getUserhash().equals(uuid)) {
						session.setAttribute("loginUser", user);
						found = true;
					} else 
						i++;
				}
				
				if (found) {
					chain.doFilter(request, response);
				} else {
					httpResponse.sendRedirect("/Six_Eagles/login");
				}
			} else {
				httpResponse.sendRedirect("/Six_Eagles/login");
			}
		} else {
			httpResponse.sendRedirect("/Six_Eagles/logOut");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
