package application;

import java.sql.*;


public class ajoutS {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement stmt=con.prepareStatement("insert into entreprise values(?,?)");  
			stmt.setInt(1,65);
			stmt.setDouble(2,844.6); 
			int i=stmt.executeUpdate();  
			System.out.println(i+" Salarié inserted");  
			con.close();  
		}catch(Exception e){ System.out.println(e);} 

	}

}
