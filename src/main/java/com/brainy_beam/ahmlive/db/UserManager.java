package com.brainy_beam.ahmlive.db;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.brainy_beam.ahmlive.entity.User;
public class UserManager {


	public boolean registerUser(User user) throws SQLException,Exception{
		String query="insert into user_table(fname,lname,password,email,address,phone)  values('"+user.getFname()+"','"+user.getLname()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getAddress()+"','"+user.getPhoneNumber()+"')";
		Statement st=DatabaseConnectionUtil.getConnection().createStatement();			
		int isSuccess=st.executeUpdate(query);
		if(isSuccess>0) {
			System.out.print("true");
			return true;
		}
		else {
			throw new Exception();
		}
		
	}
	
	public boolean updateUser(User user) throws SQLException,Exception{
		
		Statement statementObj = DatabaseConnectionUtil.getConnection().createStatement();
		int isSuccess = statementObj.executeUpdate("update user_table set fname = '"+user.getFname()+"',lname ='"+user.getLname()+"',email ='"+user.getEmail()+"',phone = '"+user.getPhoneNumber()+"',password = '"+user.getPassword()+"' where id = '"+user.getId()+"' ");
		if(isSuccess>0) {
			
			return true;
		}else {
			
			throw new Exception();
		}
	}
	
	public User getUserByEmail(String email) throws Exception,SQLException{
		
		Statement st=DatabaseConnectionUtil.getConnection().createStatement();
		ResultSet rs=st.executeQuery("Select * from user_table where email='"+email+"'");
		User user=new User();
		while(rs.next()) {
			user.setEmail(rs.getString("email"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
	
			user.setPhoneNumber(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setPassword(rs.getString("password"));
//			System.out.print(user.getPassword());
			user.setEmail(rs.getString("email"));
			user.setId(rs.getInt("id"));
		}
		return user;
		
	}
}
