package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class updateS {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement stmt=con.prepareStatement("update entreprise set Salaire=? where matriculeE=?");  
			stmt.setDouble(1,143);//1 specifies the first parameter in the query i.e. name  
			stmt.setInt(2,14);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
		}catch(Exception e){ System.out.println(e);} 


	}

}
