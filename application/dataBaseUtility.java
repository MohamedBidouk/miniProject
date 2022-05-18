package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;

public class dataBaseUtility {
	private List<employes> sal;
	public dataBaseUtility() {
		sal = new ArrayList<employes>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from entreprise");
	
			while(rs.next())  
				sal.add(new employes (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(4)));	
			con.close();  
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public List<employes> getImportlist() { return sal;}
	
	public double setSalaireFinal (double dateE, double pour) {
		if (dateE>=2005) {
			return  (400 + pour);
		}else {
			return  280 + pour;
		}
	}
	
	public double setP(double su) {
		return su*0.2;
	}
	
	
	public void addS() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("insert into entreprise values(?,?,?,?,?,?,?,?)");  
			  
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
			
			if(category=="employe") {
				vendeur s = new vendeur(matricule,nom,email,dateE,salaryFinal,sup,supDT);
				ps.setInt(1, s.matricule);
				ps.setString(2,s.nom);  
				ps.setString(3,s.email);
				ps.setDouble(4, s.salaireF);
				ps.setDouble(5, s.recrutement);
				ps.setDouble(6, s.getVente());
				ps.setDouble(7, s.getPourcentage());
				ps.setString(8,category);
				}
			else {
				employes s = new employes(matricule,nom,email,dateE,salaryFinal,sup,supDT);
				ps.setInt(1, s.matricule);
				ps.setString(2,s.nom);  
				ps.setString(3,s.email);
				ps.setDouble(4, s.salaireF);
				ps.setDouble(5, s.recrutement);
				ps.setDouble(6, s.getPHSupp());
				ps.setDouble(7, s.getHSupp());
				ps.setString(8,category);
			}
			
			
			
			
			int i=ps.executeUpdate();  
			System.out.println(i+" emaploye added to entreprise");  
			  
			con.close();  
			
		}catch(Exception e){ System.out.println(e);} 
	}

}
