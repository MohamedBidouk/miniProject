package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class afficheListeSalarié {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from entreprise");
			System.out.println("matricule"+"  "+"nom"+"  "+"email"+"  "+"catégorie"+"  "+"Salaire");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(7)+"  "+rs.getDouble(4)+"  ");  
			con.close();  
		}catch(Exception e){ System.out.println(e);} 

	}

}
