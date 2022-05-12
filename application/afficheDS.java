package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class afficheDS {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from entreprise");
			System.out.println("matricule"+"  "+"nom"+"  "+"email"+"  "+"Salaire"+"  "+"dateEmbauche"+"  "+"Hsup"+"  "+"SSup"+"  "+"catégorie");
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDouble(5)
				+"  "+rs.getDouble(6)+"  "+rs.getString(7)+"  ");  
			con.close();  
		}catch(Exception e){ System.out.println(e);} 

	}

}
