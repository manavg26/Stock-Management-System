package com.wipro.sales.service;
import java.sql.*;
import java.util.Date;
import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.dao.StockDao;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.util.DButil;

public class Administrator {
	public String insertStock(Product stockobj) {
		StockDao ob=new StockDao();
		String id;
		if(stockobj == null)
			return "Data not valid for insertion";
		else if (stockobj.getProductName().length()<2)
			return "Data not valid for insertion";
		else
			{id=ob.generateProductId(stockobj.getProductName());
			 stockobj.setProductID(id);
			 ob.insertStock(stockobj);
			  return "generated product id";} 
		}
	public String deleteStock(String ProductID) {
		StockDao ob=new StockDao();
		int r=ob.deleteStock(ProductID);
		if (r==1)
			return "deleted";
		else
			return "record cannot be deleted";
		
	}
	public String deleteSales(String ProductID) {
		SalesDao ob1=new SalesDao();
		int r=ob1.deleteSales(ProductID);
		if (r==1)
			return "deleted";
		else
			return "record cannot be deleted";
		
	}
	
		
	
	
	public String insertSales(Sales salesobj) throws SQLException {
		Connection con = DButil.getConnection();
		 PreparedStatement ps;
		 ResultSet rt = null;
		 String pid=salesobj.getProductID(); 
			ps=con.prepareStatement("select Quantity_On_Hand from TBL_STOCK where Product_ID=?");
			ps.setString(1, pid);
			rt=ps.executeQuery();
			int r,u;	
		java.sql.Date date=new java.sql.Date(salesobj.getSalesDate().getTime());
		java.sql.Date cdate = new java.sql.Date(new java.util.Date().getTime());
		if (salesobj==null)
			return "object not valid for insertion";
		 if (salesobj.getProductID()==null)
			return "Unknown product for sales";
		 if(true)
		{
			while(rt.next()) {
			if(rt.getInt("Quantity_On_Hand")<salesobj.getQuantitySold())
				return "Not enough stock on hand for sales";
		}}
		 if (date.compareTo(cdate)>0)
			return "invalid date";
		else
		{
			SalesDao sob=new SalesDao();			
			salesobj.setSalesId(sob.generateSalesId(salesobj.getSalesDate()));
			r=sob.insertSales(salesobj);
			if(r==1)
			{
				StockDao sd=new StockDao();
				u=sd.updateStock(salesobj.getProductID(),salesobj.getQuantitySold());
				if (u==1)
					return "Sales Completed";
				else
					return "error";
				
			}
			else
				return "error";
		}
		
		
		
	}
	

}
