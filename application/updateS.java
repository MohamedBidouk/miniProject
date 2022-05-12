package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class updateS {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("update entreprise set nom=?, email=?, dateEmbauche=?, sup=?, category=? where matriculeE=?");  
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter matricule:");  
			int matricule=Integer.parseInt(br.readLine());
			System.out.println("enter nom:");  
			String nom=br.readLine();  
			System.out.println("enter email:");  
			String email=br.readLine(); 
			System.out.println("enter dateEmbauche:");  
			double dateEmbauche=Double.parseDouble(br.readLine());
			System.out.println("enter sup:");  
			double sup=Double.parseDouble(br.readLine());
			System.out.println("enter category:");  
			String category=br.readLine();  
			  
			ps.setInt(6, matricule);
			ps.setString(1,nom);  
			ps.setString(2,email);  
			ps.setDouble(3, dateEmbauche);
			ps.setDouble(4, sup);
			ps.setString(5,category);
			
			ps.executeUpdate();  
			System.out.println("emplyoe de metricule "+matricule+" updated on entreprise");  
			  
			con.close();
		}catch(Exception e){ System.out.println(e);} 


	}

}
