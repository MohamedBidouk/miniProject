package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtilityParAnc {
	private List<employes> sal;
	public DataBaseUtilityParAnc() {
		sal = new ArrayList<employes>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from entreprise order by dateEmbauche desc;");
	
			while(rs.next())  
				sal.add(new employes (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(4)));	
			con.close();  
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public List<employes> getImportlistParAnc() { return sal;}
}
