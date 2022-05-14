package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class updateUtility {
	private employes employe;
	public updateUtility() {
		employe = new employes(12, "dsf", "dsf", 234.5, 234.5, 34, 234);
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("select * from entreprise where matriculeE=?");
			ps.setInt(1, 34);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {  
				employe.setMatricule(rs.getInt(1));
				employe.setNom(rs.getString(2));
				employe.setEmail(rs.getString(3));
				employe.setSalaireF(rs.getDouble(4));
				employe.setRecrutement(rs.getDouble(5));
				employe.setHSupp(rs.getDouble(6));
				employe.setPHSupp(rs.getDouble(7));
			}
					
			con.close();  
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public employes getImportEmploye() { return employe;}
}
