package repo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;
@Repository
public class UserRepoImpl implements UserRepo {
 
	//dependency injection in spring 
	
	@Autowired
	private SessionFactory factory;
	@Override
	public User authenticate(LoginBean login) {
		Session session = factory.openSession();// opening session
		User user=(User)session.get(User.class, login.getUserId());// fetching from loginbean
		if(user!=null&&user.getPassword().equals(login.getPassword()))// if user exist or not and then matching password
			return user;
		
		else
			return null;
		
	}

	@Override
	public boolean validate(ForgetBean forget) {
		Session session = factory.openSession();
		User user=(User)session.get(User.class, forget.getUserId());// fetching from forgetbean
		if(user!=null&&user.getEmail().equals(forget.getEmail()))// if user exist or not and then matching email
			return true;
		
		else
			return false;
		
	}

	@Override
	public boolean changePassword(LoginBean change) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();// creating transaction to update db
		try {
			User user=(User)session.get(User.class, change.getUserId());// fetching userid from loginbean
			user.setPassword(change.getPassword());// changing password
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			return false;
		}
	}

	@Override
	public boolean persist(User user) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();// creating transaction to update db
		
		try {
			session.save(user);// saving details after registration
			txn.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			txn.rollback();
			return false;
		}
				
	}

}
