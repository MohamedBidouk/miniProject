package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutController implements Initializable{
	//table column
	
	@FXML 
	 private TextField nom;
	
	@FXML 
	 private TextField email;
	
	@FXML 
	 private TextField date;
	
	@FXML 
	 private TextField sup;
	
	@FXML 
	 private TextField category;
	
	//button
	@FXML 
	 private Button confirmBtn;
	
	@FXML 
	 private Button cancelBtn;
	
	updateUtility importedEmploye ;
	public static int mat ;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) { 

	
		
	}
	
	private Stage stage;
	private Scene scene;
	
	public void switchToVueScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Vue.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

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
	
	@FXML
	public void getEntredData() {
		System.out.println(nom.getText());
	}
	
	@FXML
	public void addMethod() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("insert into entreprise values(?,?,?,?,?,?,?,?)");  			
			
			int matricule=mat;
			 
			String newNom=nom.getText();  
			
			String newEmail=email.getText();  
			
			  
			double NewDateE=Double.parseDouble(date.getText());
			  
			double NewSup=Double.parseDouble(sup.getText());
			
			double supDT=setP(Double.parseDouble(sup.getText()));
			double salaryFinal=setSalaireFinal(NewDateE, supDT);
			
			  
			String newCategory=category.getText(); 
			
			
			if(newCategory=="employe") {
				vendeur s = new vendeur(matricule,newNom,newEmail,NewDateE,salaryFinal,NewSup,supDT);
				ps.setInt(1, s.matricule);
				ps.setString(2,s.nom);  
				ps.setString(3,s.email);
				ps.setDouble(4, s.salaireF);
				ps.setDouble(5, s.recrutement);
				ps.setDouble(6, s.getVente());
				ps.setDouble(7, s.getPourcentage());
				ps.setString(8, newCategory);
				}
			else {
				employes s = new employes(matricule,newNom,newEmail,NewDateE,salaryFinal,NewSup,supDT);
				ps.setInt(1, s.matricule);
				ps.setString(2,s.nom);  
				ps.setString(3,s.email);
				ps.setDouble(4, s.salaireF);
				ps.setDouble(5, s.recrutement);
				ps.setDouble(6, s.getPHSupp());
				ps.setDouble(7, s.getHSupp());
				ps.setString(8, newCategory);
			}
			
			ps.executeUpdate();  
			  
			con.close();
			
		}catch(Exception e){ System.out.println(e);} 
	}
	
}
