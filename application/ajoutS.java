package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


public class ajoutS {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("insert into entreprise values(?,?,?,?,?)");  
			  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter matricule:");  
			int matricule=Integer.parseInt(br.readLine());
			System.out.println("enter nom:");  
			String nom=br.readLine();  
			System.out.println("enter email:");  
			String email=br.readLine();  
			System.out.println("enter category:");
			String category = "";
			do {
				String c=br.readLine();
				if(c!="employe"&&c!="vendeur") {
					System.out.println("enter valide category (employe || vendeur):");
				}
				else {
					category=br.readLine();
				}
			}while(category==null);
			  
			System.out.println("enter salaireFinal:");  
			double salaryFinal=Double.parseDouble(br.readLine());
			
			ps.setInt(1, matricule);
			ps.setString(2,nom);  
			ps.setString(3,email);  
			ps.setString(4,category);
			ps.setDouble(5, salaryFinal);
			
			int i=ps.executeUpdate();  
			System.out.println(i+" emaploye added to entreprise");  
			  
			con.close();  
			
		}catch(Exception e){ System.out.println(e);} 

	}

}
