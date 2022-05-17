package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class vueDetailController extends VueController implements Initializable{
	public static int num ;

	private showDetailUtility data;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		matCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
		 nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		 salaireCol.setCellValueFactory(new PropertyValueFactory<>("recrutement"));
		 dateCol.setCellValueFactory(new PropertyValueFactory<>("salaireF"));
		 supCol.setCellValueFactory(new PropertyValueFactory<>("hSupp"));
		 this.data = new showDetailUtility(num); 
		 try {
			importList();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void importEmp() {
		
	}
	
	@FXML
	 public void importList() throws Throwable{
			table.getItems().addAll(data.getImportlist());
		}
	
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
	private Button btn;
	
	

}
