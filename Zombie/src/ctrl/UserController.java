package ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;
import service.UserService;
//sterotype of component annotation

@Controller
public class UserController {
	//user service object injection
	@Autowired
	private UserService service;
	
	//request of login page
	
	@RequestMapping("login.do")
	public String checkLogin(LoginBean login,Map model,HttpSession session)
	{
		User user=service.authenticate(login);
		//checking if user exist
		
		if(user!=null)
			{
			session.setAttribute("User", user);//user details saved in session object
			return "dashboard";
			}
		else
			{
			model.put("Prompt", "User id password incorrect");
			return "home";
			}
	}
	//request of forget page
	
	@RequestMapping("forget.do")
	public String forgetPass(ForgetBean forget,Map model,HttpSession session)
	{
		//checking if email id and userid match
		
		if(service.validate(forget)) {
			session.setAttribute("Id", forget.getUserId());//id saved in session object
			return "change";
		}
		else
		{
			model.put("Invalid", "User id and email incorrect");
			return "forget";
		}
		
	}
	//request from change page
	
	@RequestMapping("change.do")
	public String changePass(LoginBean change,Map model,HttpSession session)
	{ 
		change.setUserId((String)session.getAttribute("Id"));//getting user id from session object
		//checking if password is change in db 
		
		if(service.changePassword(change)) {
	
			model.put("Prompt", "Password changed succesfully");
			return "home";
		}
		else
		{
			model.put("Invalid", "Password does not match");
			return "change";
		}
	
	}
	//request from register page
	
	@RequestMapping("register.do")
	public String persist(User user,Map model) {
		//checking if user added succesfully
		
		if(service.persist(user)) {
			model.put("Prompt", "Thanku for registration");
			return "home";
			
		}else
		{
			model.put("Invalid", "user id already exist");
			return "register";
		}
	}
	// request from banner(logout.do)
	
	@RequestMapping("logout.do")
	public String logout(Map model, HttpSession session) {
	
		//removing session object
	session.invalidate();
	model.put("Prompt", "logout successful");
	return "home";
	
	}
}

