package lti.hola.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.hola.bean.RegisterBean;
import lti.hola.service.UserService;
import lti.hola.service.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// service layer
	private UserService service;

	@Override
	public void init() throws ServletException {

		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String referer = request.getHeader("referer");
		//Getting session from request.If session id exists in request header
		//old session object returned otherwise fresh session created
		HttpSession session=request.getSession();
		
		
		if (referer.contains("home.jsp")) {
			// Request coming from home for login authentication
			RegisterBean user = LoginController.autheticate(request);
			System.out.println(user);
			
			if(user != null) {
				// login successful-Keeping logged in user details in session
				session.setAttribute("User", user);
				
				
				//System.out.println("user exists");
				response.sendRedirect("profile.jsp");
			} else {
				// login failed
				response.sendRedirect("home.jsp?invalid=yes");
			}

		} else if (referer.contains("register.jsp")) {
			// Request coming for user registration

			if (RegisterController.registration(request))

			{
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("register.jsp");
			}
		} else if (referer.contains("forget.jsp")) {
			// Request coming for validating user for password change
			if (LoginController.forgetPassword(request)) {
				response.sendRedirect("change.jsp");
			} else {
				response.sendRedirect("forget.jsp");
			}
		} else if (referer.contains("change.jsp"))  {
			// Request coming for updating password
			System.out.println("USER NULL");
			if (LoginController.changePassword(request))
				response.sendRedirect("home.jsp");
			else
				response.sendRedirect("change.jsp");
		}else {
			//Requesting coming for logout-destroying session
			session.invalidate();
			response.sendRedirect("home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// delegatingcall to doGet method to perform common logic
		doGet(request, response);// method chaining
	}

}
