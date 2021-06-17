package com.brainy_beam.ahmlive.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.brainy_beam.ahmlive.entity.Complain;
public class ComplainManagement {

	public List<Complain> getAllComplainByUserId(int userId) throws SQLException, Exception {
		Statement statementObj=DatabaseConnectionUtil.getConnection().createStatement();
		ResultSet responseData=statementObj.executeQuery("select * from complain where user_id= "+userId);
		List<Complain> complainList=getComplainListByResultSet(responseData);
		return complainList;
	}
	
	
	// for getting one complain in base of id
	public Complain getComplainById(int id,int userId) throws Exception {
		Statement statementObj = DatabaseConnectionUtil.getConnection().createStatement();
		ResultSet responseData =  statementObj.executeQuery("select * from complain where id = "+id+" and user_id = "+userId);
		Complain complain = null;
		while(responseData.next()) {
			complain = getComplainObjectByResultSet(responseData);
		}
		System.out.println("true");
		return complain;
	}
	
	
	public boolean removeComplainById(long id) throws SQLException, Exception {
		Statement statementObj = DatabaseConnectionUtil.getConnection().createStatement();
		int isSuccess = statementObj.executeUpdate("delete from complain where id = "+id);
		if(isSuccess > 0) {
			return true;
		}
		else {
			
			return false;
		}
	}
	 public List<Complain> getAllComplain() throws SQLException, Exception {
		Statement statementObj=DatabaseConnectionUtil.getConnection().createStatement();
		ResultSet responseData=statementObj.executeQuery("select * from complain ");
		List<Complain> complainList=getComplainListByResultSet(responseData);
		return complainList;
	 }
	

	 public Complain getAllComplainById(int id) throws SQLException, Exception {
		Statement statementObj=DatabaseConnectionUtil.getConnection().createStatement();
		ResultSet responseData=statementObj.executeQuery("select * from complain where id="+id);
		Complain complain=null;
		while(responseData.next()) {
			complain=getComplainObjectByResultSet(responseData);
		}
		return complain;
	}
	
	 public boolean updateComplain(Complain complain) throws Exception{
		Statement statementObj =  DatabaseConnectionUtil.getConnection().createStatement();
			int isSuccess = statementObj.executeUpdate("update complain set title='"+complain.getTitle()+"',description='"+complain.getDescription()+"' ,mobile_no='"+complain.getMobileNo()+"'  ,address='"+complain.getAddress()+"' where id='"+complain.getId()+"'");
			if(isSuccess > 0) {
				
				return true;
			}
			else {
			
				return false;
			}
		}
	 

		public boolean saveComplain(Complain complain) throws Exception {
		
			Statement statementObj =DatabaseConnectionUtil.getConnection().createStatement();
			int isSuccess = statementObj.executeUpdate("insert into complain (user_id,title,description,mobile_no,address) values ('"+complain.getUserId()+"','"+complain.getTitle()+"','"+complain.getDescription()+"','"+complain.getMobileNo()+"','"+complain.getAddress()+"')");
			if(isSuccess > 0) {
				
				return true;
			}
			else {
				
				return false;
			}
		}
		

	
	private List<Complain> getComplainListByResultSet(ResultSet responseData) throws SQLException{
		List<Complain> complainList=new ArrayList<>();
		while(responseData.next()) {
			Complain obj=getComplainObjectByResultSet(responseData);
			complainList.add(obj);
		}
		return complainList;
		
	}

	private Complain getComplainObjectByResultSet(ResultSet responseData) throws SQLException {

		Complain obj=new Complain();
		obj.setId(responseData.getInt("id"));
		obj.setUserId(responseData.getInt("user_id"));
		obj.setTitle(responseData.getString("title"));
		obj.setDescription(responseData.getString("description"));
		obj.setAddress(responseData.getString("address"));
		obj.setMobileNo(responseData.getString("mobile_no"));
		return obj;
	}
	
	
}
