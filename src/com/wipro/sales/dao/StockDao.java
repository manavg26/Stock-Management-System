package com.wipro.sales.dao;
import com.wipro.sales.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.sales.util.DButil;

public class StockDao {
	public void insertStock(Product sales){
		Connection con = DButil.getConnection();
		 PreparedStatement ps;
		 try {
			ps=con.prepareStatement("insert into TBL_STOCK values(?,?,?,?)");
			ps.setString(1,sales.getProductID());
			ps.setString(2,sales.getProductName());
			ps.setInt(3,sales.getQuantiyOnHand());
			ps.setDouble(4, sales.getProductUnitPrice());
			ps.setInt(5, sales.getRecorderLevel());
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	 public String generateProductId(String productName) {
		String s=productName.substring(0,2);
		Connection con = DButil.getConnection();
		 PreparedStatement ps;
		 String id = null;
		 try {
			ps=con.prepareStatement("select SEQ_PRODUCT_ID.nextval from dual");
			ResultSet rs=ps.executeQuery();
			int a=rs.getInt(1);
			id=s+a;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return id;

		
	}
	
	public int updateStock(String productId,int soldQTY) {
		Connection con = DButil.getConnection();
		 PreparedStatement ps;
		 int t=0;
		 try {
			 ps=con.prepareStatement("select Quantity_On_Hand from TBL_STOCK where Product_ID=?");
			 ps.setString(1,productId);
			 ResultSet r=ps.executeQuery();		 
			ps=con.prepareStatement("update TBL_STOCK set Quantity_On_Hand=?-? where Product_ID=?");
			r.next();
			ps.setInt(1, r.getInt(1));
			ps.setInt(2, soldQTY);
			ps.setString(3,productId);
			t=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(t>0)
			 return 1;
		 else
			 return 0;
	}
	public Product getStock(String productID) {
		Connection con = DButil.getConnection();
		PreparedStatement ps;
		Product p=new Product(); 
		 try {
			ps=con.prepareStatement("select * from TBL_STOCK where Product_ID=productID");
			ResultSet rs=ps.executeQuery();
			p.setProductID(rs.getString(1));
			p.setProductName(rs.getString(2));
			p.setQuantiyOnHand(rs.getInt(3));
			p.setProductUnitPrice(rs.getDouble(4));
			p.setRecorderLevel(rs.getInt(5));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;		
	}
	public int deleteStock(String productID){
		Connection con = DButil.getConnection();
		PreparedStatement ps;
		int t=0;
		try {
			ps=con.prepareStatement("delete from TBL_STOCK where Product_ID = ?");
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
}
