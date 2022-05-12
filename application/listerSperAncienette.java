package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class listerSperAncienette {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement stmt=con.prepareStatement("select * from entreprise where dateEmbauche>?");  
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter date:");  
			double dateEmbauche=Double.parseDouble(br.readLine());  
			  
			stmt.setDouble(1, dateEmbauche);
			
			ResultSet rs=stmt.executeQuery();
			System.out.println("matricule"+"  "+"nom"+"  "+"email"+"  "+"Salaire"+"  "+"dateEmbauche"+"  "+"Hsup"+"  "+"SSup"+"  "+"catégorie");
			while(rs.next()) 
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDouble(5)
				+"  "+rs.getDouble(6)+"  "+rs.getString(7)+"  ");  
			con.close();  
		}catch(Exception e){ System.out.println(e);}

	}

}
