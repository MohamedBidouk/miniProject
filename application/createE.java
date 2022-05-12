package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class createE {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("insert into employe values(?,?,?,?,?,?)");  
			  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			  
			do{  
			System.out.println("enter nom:");  
			String nom=br.readLine();  
			System.out.println("enter email:");  
			String email=br.readLine();  
			System.out.println("enter recrutement:");  
			double recrutement=Double.parseDouble(br.readLine());  
			System.out.println("enter salaireF:");  
			double salaryF=Double.parseDouble(br.readLine());
			System.out.println("enter salaireFinal:");  
			double salaryFinal=Double.parseDouble(br.readLine());
			System.out.println("enter matricule:");  
			int matricule=Integer.parseInt(br.readLine());
			
			ps.setString(1,nom);  
			ps.setString(2,email);  
			ps.setDouble(3,recrutement);
			ps.setDouble(4, salaryF);
			ps.setDouble(5, salaryFinal);
			ps.setInt(6, matricule);
			
			int i=ps.executeUpdate();  
			System.out.println(i+" emaploye created");  
			  
			System.out.println("Do you want to continue: y/n");  
			String s=br.readLine();  
			if(s.startsWith("n")){  
			break;  
			}  
			}while(true);  
			  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  

	}

}
