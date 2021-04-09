package com.wipro.sales.main;
import java.sql.*;
import java.util.*;
import com.wipro.sales.bean.*;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.service.Administrator;
import com.wipro.sales.util.DButil;
public class SalesApplication {
	public static void dispMenu() {
		System.out.println("Choose one option");
		System.out.println("1. Insert Stock");
		System.out.println("2. Delete Stock");
		System.out.println("3. Insert Sales");
		System.out.println("4. Delete Sales");
		System.out.println("5. View Sales Report");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		dispMenu();
		int c=sc.nextInt();
		Administrator admin=new Administrator();
		switch(c){
		case 1:
			Product obj=new Product();
			System.out.println("Enter Product ID ");
			obj.setProductID(sc.next());
			System.out.println("Enter Product Name");
			obj.setProductName(sc.next());
			System.out.println("Enter Product Unit Price");
			obj.setProductUnitPrice(sc.nextDouble());
			System.out.println("Enter Quantity on Hand");
			obj.setQuantiyOnHand(sc.nextInt());
			System.out.println("Enter Recorder Level");
			obj.setRecorderLevel(sc.nextInt());
			
			admin.insertStock(obj);
			break;
		case 2:
			System.out.println("Enter Product ID ");
			String id =sc.next();
			System.out.println(admin.deleteStock(id));
		case 3:
			Sales obj1=new Sales();
			String ret=null;
			System.out.println("Enter Product ID ");
			obj1.setProductID(sc.next());
			System.out.println("Enter Quantity Sold");
			obj1.setQuantitySold(sc.nextInt());
			System.out.println("Enter Sales Price per Unit");
			obj1.setSalesPricePerUnit(sc.nextDouble());
			java.sql.Date cdate =new java.sql.Date(new java.util.Date().getTime());
			obj1.setSalesDate(cdate);
			try {
				 ret=admin.insertSales(obj1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(ret);
			break;
		case 4:
			System.out.println("Enter Product ID ");
			String id1 =sc.next();
			System.out.println(admin.deleteSales(id1));
		case 5:
			SalesDao rep=new SalesDao();
			try {
				System.out.println(rep.getSalesReport());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			  Connection con = DButil.getConnection();
			 Statement ps;
			 try {
				ps=con.createStatement();
				ResultSet r=ps.executeQuery("select * from V_SALES_REPORT");
				while(r.next()) {
					System.out.println(r.getObject(1)+" "+r.getObject(2)+" "+r.getObject(3)+" "+r.getObject(4)+" "+r.getObject(5)+" "+r.getObject(6)+" "+r.getObject(7)+" "+r.getObject(8));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  */
			 
			
		}
		sc.close();

	}

}
