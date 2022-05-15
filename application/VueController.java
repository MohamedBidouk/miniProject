package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class VueController implements Initializable{
	private dataBaseUtility data;
	private Alert a = new Alert(AlertType.NONE);
	private Alert confirmation = new Alert(AlertType.NONE); 
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		matCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
		 nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		 salaireCol.setCellValueFactory(new PropertyValueFactory<>("recrutement"));
		 dateCol.setCellValueFactory(new PropertyValueFactory<>("salaireF"));
		 supCol.setCellValueFactory(new PropertyValueFactory<>("hSupp"));
		 categoryCol.setCellValueFactory(new PropertyValueFactory<>("pHSupp"));
		 seeDetailButtonCol.setCellFactory(ActionButtonTableCell.<employes>forTableColumn("Detail", (employes e) -> {
			    
			 table.getItems().remove(e);
			    
			    return e;
			}));    
		 
		 modifyButtonCol.setCellFactory(ActionButtonTableCell.<employes>forTableColumn("Modify", (employes e) -> {
			    table.getItems().remove(e);
			    
			    return e;
			}));    
		 
		 deleteButtonCol.setCellFactory(ActionButtonTableCell.<employes>forTableColumn("Remove", (employes e) -> {
			 a.setAlertType(AlertType.CONFIRMATION);
             a.setContentText("are yu sure to delete "+ e.getNom()+" "+"de matricule "+e.getMatricule());
             Optional<ButtonType> option = a.showAndWait();
             confirmation.setAlertType(AlertType.WARNING);
             if (option.get() == null) {
            	
              } else if (option.get() == ButtonType.OK) {
            	  try {
					System.out.println("Ill delete");
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              } else if (option.get() == ButtonType.CANCEL) {
            	  confirmation.close();
              } else {
            	  confirmation.close();
              }
           
			    return e;
			}));    
		 
		 
		 this.data = new dataBaseUtility(); 
		 try {
			importList();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//table
	@FXML
	private TableView<Salaire> table;
	
	//table column
	@FXML 
	 private TableColumn<Salaire, Integer> matCol;
	
	@FXML 
	 private TableColumn<Salaire, String> nomCol;
	
	@FXML 
	 private TableColumn<Salaire, String> emailCol;
	
	@FXML 
	 private TableColumn<Salaire, Double> salaireCol;
	
	@FXML 
	 private TableColumn<Salaire, Double> dateCol;
	
	@FXML 
	 private TableColumn<Salaire, Double> supCol;
	
	@FXML 
	 private TableColumn<Salaire, Double> categoryCol;
	
	@FXML
	private TableColumn seeDetailButtonCol;
	
	@FXML
	private TableColumn modifyButtonCol;
	
	@FXML
	private TableColumn deleteButtonCol;
	
	//button
	@FXML 
	 private Button ajoutBtn;
	
	@FXML 
	 private Button deleteBtn;
	
	@FXML 
	 private Button detailBtn; 
	
	@FXML 
	 private Button modifyBtn;
	
	@FXML 
	 private Button listerBtn;
	
	
	//switcher between scene
		@FXML
		Button switch1;
		
		@FXML
		Button switch2;
		

		private Stage stage;
		private Scene scene;
		private Parent root;
	 
		public void switchToUpdateScene(ActionEvent event) throws IOException {
			root = FXMLLoader.load(getClass().getResource("UpdateFx.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	 
		public void switchToVueDetailScene(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("VueDetailEmploye.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
	//database utility

		@FXML
		 public void importList() throws Throwable{
				table.getItems().addAll(data.getImportlist());
			}
		
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
		
		//load database content
		@FXML
		public void ajoutSalary() throws Throwable{
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
				System.out.println(i+" employe added to entreprise");
				
				con.close();  
				
			}catch(Exception e){ System.out.println(e);} 
		}
		
		//delete employe
		@FXML
		public void deleteS(employes selected) throws Throwable{
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3307/miniprojet","root","");  
				
				PreparedStatement ps=con.prepareStatement("delete from entreprise where matriculeE=?");  
				
				ps.setInt(1, selected.getMatricule());
				
				int i=ps.executeUpdate();  
				System.out.println(i+" emaploye from entreprise deleted");
				  
				con.close();
				importList();
			}catch(Exception e){ System.out.println(e);} 
		}
		
		
}
