package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class entreprise {
	String nomE;
	double Salaire;
	Map<Integer, Salaire> salarié = new TreeMap<Integer,Salaire>();
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public Map<Integer, Salaire> getSalarié() {
		return salarié;
	}
	public void setSalarié(Map<Integer, Salaire> salarié) {
		this.salarié = salarié;
	}
	public entreprise(String nomE, double salaire, Map<Integer, application.Salaire> salarié) {
		super();
		this.nomE = nomE;
		Salaire = salaire;
		this.salarié = salarié;
	}  
	
	public void InsertPrepared(int a, double b){  

			try{  

				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3307/miniprojet","root","");  
	  
				PreparedStatement stmt=con.prepareStatement("insert into entreprise values(?,?)");  
				stmt.setInt(1, a);
				stmt.setDouble(2,b); 
				int i=stmt.executeUpdate();  
				System.out.println(i+" Salarié inserted");  
				con.close();  
			}catch(Exception e){ System.out.println(e);}  
		}    
}
