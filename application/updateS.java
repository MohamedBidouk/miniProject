package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class updateS {

	public static double setSalaireFinal (double dateE, double pour) {
		if (dateE>=2005) {
			return  (400 + pour);
		}else {
			return  280 + pour;
		}
	}
	
	public static double setP(double su) {
		return su*0.2;
	}


	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("update entreprise set nom=?, email=?, salaire=?, dateEmbauche=?, sup=?, supDT=?, category=? where matriculeE=?");  
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter matricule:");  
			int matricule=Integer.parseInt(br.readLine());
			System.out.println("enter nom:");  
			String nom=br.readLine();  
			System.out.println("enter email:");  
			String email=br.readLine();  
			
			System.out.println("enter dateEmbauche:");  
			double dateE=Double.parseDouble(br.readLine());
			System.out.println("enter valeur supplémentaire:");  
			double sup=Double.parseDouble(br.readLine());
			
			double supDT=setP(sup);
			double salaryFinal=setSalaireFinal(dateE, supDT);
			
			System.out.println("enter category:");  
			String category=br.readLine();  
			
			
			ps.setInt(8, matricule);
			ps.setString(1,nom);  
			ps.setString(2,email);
			ps.setDouble(3, salaryFinal);
			ps.setDouble(4, dateE);
			ps.setDouble(5, sup);
			ps.setDouble(6, supDT);
			ps.setString(7,category);
			
			ps.executeUpdate();  
			System.out.println("emplyoe de metricule "+matricule+" updated on entreprise");  
			  
			con.close();
		}catch(Exception e){ System.out.println(e);} 


	}

}
