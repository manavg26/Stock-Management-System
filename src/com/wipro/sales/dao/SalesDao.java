package com.wipro.sales.dao;
import com.wipro.sales.util.DButil;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;

 public class SalesDao {
	
	public int insertSales(Sales sales) {
		 Connection con = DButil.getConnection();
		 PreparedStatement ps;
		int t=0;
	try {
		
		ps=con.prepareStatement("insert into TBL_SALES values(?,?,?,?,?)");
		ps.setString(1, sales.getSalesId());
		ps.setObject(2,sales.getSalesDate());
		ps.setString(3, sales.getProductID());
		ps.setInt(4, sales.getQuantitySold());
		ps.setDouble(5, sales.getSalesPricePerUnit());
		t=ps.executeUpdate();
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (t>0)
		return 1;
	else
		return 0;	
	
		}
	public int deleteSales(String productID) {
		Connection con = DButil.getConnection();
		PreparedStatement ps;
		int t=0;
		try {
			ps=con.prepareStatement("delete from TBL_SALES where Product_ID = ?");
			ps.setString(1, productID);
			t=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (t>0)
			return 1;
		else
			return 0;
	}
public	String generateSalesId(java.util.Date salesDate) {
		Connection con = DButil.getConnection();
		 PreparedStatement ps;
		DateFormat df=new SimpleDateFormat("yy");
		String yy=df.format(salesDate);
		ResultSet rs;
		String id = null;
		try {
			ps=con.prepareStatement("select SEQ_SALES_ID.nextval from dual");
			rs = ps.executeQuery();
			if(rs.next())
				id=yy+rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;		
	}
	
	public ArrayList<SalesReport> getSalesReport() throws Exception{ 
		Connection con = DButil.getConnection();
		Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM V_SALES_REPORT");
	    
	    ArrayList<SalesReport> sales = new ArrayList<SalesReport>();
	    while(rs.next()){
	      SalesReport temp = new SalesReport();
	      temp.setSalesId(rs.getString("Sales_ID"));
	      temp.setProductId(rs.getString("Product_ID"));
	      temp.setProductName(rs.getString("Product_Name"));
	      temp.setQuantitySold(rs.getInt("Quantity_Sold"));
	      temp.setProductUnitPrice(rs.getDouble("Product_Unit_Price"));
	      temp.setSalesPricePerUnit(rs.getDouble("Sales_Price_Per_Unit"));
	      temp.setProfitAmount(rs.getDouble("Profit_Amount"));
	      
	      sales.add(temp);
	    }
	    return sales;
	    
	  }
	
}
