package service;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.ForgetBean;
import bean.LoginBean;
import entity.User;
import repo.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	
	// Injecting object of repo class
	@Autowired
	private UserRepo repo;
	@Override
	public User authenticate(LoginBean login) {
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(login.getPassword().getBytes());// encoding password
		login.setPassword(encoded);
		return repo.authenticate(login);// calling repo
		
	}

	@Override
	public boolean validate(ForgetBean forget) {
		return repo.validate(forget);// calling repo
	
	}

	@Override
	public boolean changePassword(LoginBean change) {
		Encoder encoder = Base64.getEncoder();
		change.setPassword(encoder.encodeToString(change.getPassword().getBytes()));//encoding password
		return repo.changePassword(change);// calling repo
	}

	@Override
	public boolean persist(User user) {
		Encoder encoder = Base64.getEncoder();
		user.setPassword(encoder.encodeToString(user.getPassword().getBytes()));//encoding password
		return repo.persist(user);// calling repo
	
	}

}
