package lti.hola.web;

import javax.servlet.http.HttpServletRequest;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;
import lti.hola.service.UserService;
import lti.hola.service.UserServiceImpl;

public class LoginController {

	public static RegisterBean autheticate(HttpServletRequest request) {
		UserService service = new UserServiceImpl();

		// Instantiating loginbean to hold login credentials
		LoginBean login = new LoginBean();

		// reading request parameters and storing in loginbean object
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));

		// Passing loginBean object to service method
		RegisterBean user = service.authenticate(login);
		System.out.println("User authenticated");
		return user;

	}

	public static boolean changePassword(HttpServletRequest request) {

		UserService service = new UserServiceImpl();
		LoginBean change = new LoginBean();
		// Reading request parameter and storing in login bean object
		change.setEmail(request.getParameter("email"));
		change.setPassword(request.getParameter("password"));
		return service.changePassword(change);
	}

	public static boolean forgetPassword(HttpServletRequest request) {
		UserService service = new UserServiceImpl();
		ForgetBean forget = new ForgetBean();
		forget.setEmail(request.getParameter("email"));
		forget.setMovie(request.getParameter("movie"));
		return service.validate(forget);
	}

}
