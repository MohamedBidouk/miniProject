package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VueController implements Initializable{
	private dataBaseUtility data;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		matCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
		 nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		 salaireCol.setCellValueFactory(new PropertyValueFactory<>("recrutement"));
		 dateCol.setCellValueFactory(new PropertyValueFactory<>("salaireF"));
		 supCol.setCellValueFactory(new PropertyValueFactory<>("hSupp"));
		 categoryCol.setCellValueFactory(new PropertyValueFactory<>("pHSupp"));
		 this.data = new dataBaseUtility(); 
		
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
	public void deleteS() throws Throwable{
		Integer a = table.getSelectionModel().getSelectedItem().getMatricule();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3307/miniprojet","root","");  
			
			PreparedStatement ps=con.prepareStatement("delete from entreprise where matriculeE=?");  
			
			ps.setInt(1, a);
			
			int i=ps.executeUpdate();  
			System.out.println(i+" emaploye from entreprise deleted");table.refresh();  
			  
			con.close();
		}catch(Exception e){ System.out.println(e);} 
	}
	
	@FXML
	 public void importList() throws Throwable{
			table.getItems().addAll(data.getImportlist());
		}
	

}
