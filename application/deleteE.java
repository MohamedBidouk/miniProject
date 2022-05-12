package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class deleteE {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("delete from employe where matricule=?");  
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter matricule:");  
			int matricule=Integer.parseInt(br.readLine());
			
			ps.setInt(1, matricule);
			
			
			int i=ps.executeUpdate();  
			System.out.println(i+" emaploye deleted");  
			  
			con.close();  
		}catch(Exception e){ System.out.println(e);} 

	}

}
