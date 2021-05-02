package com.Login.Dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;

public class LoginDao {
	
	String sql="select * from UserCredential where username=? and userpassword=?";
	String url="jdbc:mysql://localhost/Login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username="root";
	String password="vikram@123";
	
	public boolean  check(String uname,String upassword)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =(Connection) DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upassword);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
