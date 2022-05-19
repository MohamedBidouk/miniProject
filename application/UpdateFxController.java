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
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UpdateFxController implements Initializable{
	
	public boolean updated = false;
	
	@FXML
	public AnchorPane scenePane;
	
	Stage stage1;
	
	public void confirmed(ActionEvent event) {
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	
	
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
		public ToggleButton confirm;
		
		@FXML 
		 public Button confirmBtn;
		
		@FXML 
		 private Button cancelBtn;
		
		updateUtility importedEmploye ;
		public static int mat ;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) { 

			
			confirmBtn.setOnAction((event) -> {
				updateMethod();
				confirmed(event);
			});
			
			this.importedEmploye = new updateUtility(mat); 
			 try {
				importEmploye();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@FXML
		 public void importEmploye() throws Throwable{
				nom.setText(importedEmploye.getImportEmploye().getNom());
				email.setText(importedEmploye.getImportEmploye().getEmail());
				date.setText(String.valueOf(importedEmploye.getImportEmploye().getRecrutement()));
				sup.setText(String.valueOf(importedEmploye.getImportEmploye().getHSupp()));
				category.setText(importedEmploye.getImportEmploye().getClass().getName().substring(12));
			}
		
		private Stage stage;
		private Scene scene;
		
		public void switchToVueScene(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("VueDetail.fxml"));
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
		public void updateMethod() {
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3307/miniprojet","root","");  
				
				PreparedStatement ps=con.prepareStatement("update entreprise set nom=?, email=?, salaire=?, dateEmbauche=?, sup=?, supDT=?, category=? where matriculeE=?");  			
				
				int matricule=mat;
				 
				String newNom=nom.getText();  
				
				String newEmail=email.getText();  
				
				  
				double NewDateE=Double.parseDouble(date.getText());
				  
				double NewSup=Double.parseDouble(sup.getText());
				
				double supDT=setP(Double.parseDouble(sup.getText()));
				double salaryFinal=setSalaireFinal(NewDateE, supDT);
				
				  
				String newCategory=category.getText(); 
				
				
				ps.setInt(8, matricule);
				ps.setString(1,newNom);  
				ps.setString(2,newEmail);
				ps.setDouble(3, salaryFinal);
				ps.setDouble(4, NewDateE);
				ps.setDouble(5, NewSup);
				ps.setDouble(6, supDT);
				ps.setString(7,newCategory);
				
				ps.executeUpdate();  
				  
				con.close();
				
				
			}catch(Exception e){ System.out.println(e);} 
		}
		


		
		
}
