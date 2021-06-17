package com.brainy_beam.ahmlive.db;
import com.brainy_beam.ahmlive.entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnectionUtil {
		 static Connection connectionObj=null;

		 public static Connection getConnection() throws Exception{
				String url="jdbc:mysql://localhost:3306/javaproject";
				String uname="root";
				String pass="sau$$@@X";	
			
			if(connectionObj==null) {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				connectionObj=DriverManager.getConnection(url,uname,pass);
			}
			

			else if(!connectionObj.isClosed()) {
				return connectionObj;
			}
			else {
				 Class.forName("com.mysql.cj.jdbc.Driver");
					connectionObj=DriverManager.getConnection(url,uname,pass);
			}
			
			return connectionObj;

				
			}
	
			public static void main(String[] args) throws Exception  {
				
		

				getConnection();


			}
}
