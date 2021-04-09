package com.wipro.sales.util;
import java.sql.*;
public class DButil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","manav","manav");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return con;
		
	}  
	

}
