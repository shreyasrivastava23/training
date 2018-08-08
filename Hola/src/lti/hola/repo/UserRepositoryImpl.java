package lti.hola.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import lti.hola.bean.ForgetBean;
import lti.hola.bean.LoginBean;
import lti.hola.bean.RegisterBean;

public class UserRepositoryImpl implements UserRepository {

	private Connection getConnection() throws SQLException {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public RegisterBean authenticate(LoginBean login) {
		String sql = "select * from users where email=? and password=?";
		Connection conn = null;
		RegisterBean user = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			System.out.println( login.getEmail());
			System.out.println( login.getPassword());

			ResultSet rs = stmt.executeQuery();
			System.out.println(rs.next());
			if (rs.next()) {
				user = new RegisterBean();
				
				user.setEmail(rs.getString(1));
				user.setName(rs.getString(2));
				
			    user.setGender(rs.getString(3));
			    user.setPassword(rs.getString(4));
				user.setCity(rs.getString(5));
				user.setMovie(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setPhoto(rs.getString(8));

			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//Checking the person is validate user or not
	
	public boolean validate(ForgetBean forget) {
		String sql = "select * from users where email=? and movie=?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, forget.getEmail());
			stmt.setString(2, forget.getMovie());
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean changePassword(LoginBean login) {

		String sql = "update users set password=? where email=?";
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			//stmt.setString(2, login.getEmail());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// return false;

	@Override
	public boolean persist(RegisterBean register) {
		String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, register.getEmail());
			stmt.setString(2, register.getName());
			stmt.setString(3, register.getGender());
			stmt.setString(4, register.getPassword());
		
			stmt.setString(5, register.getCity());
			stmt.setString(6, register.getMovie());
			stmt.setInt(7, register.getAge());
			stmt.setString(8, register.getPhoto());
			stmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
