package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class deleteS {

	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement stmt=con.prepareStatement("delete from entreprise where matriculeE=?");  
			stmt.setInt(1,45);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" Salarié deleted");  
			
		}catch(Exception e){ System.out.println(e);} 

	}

}
