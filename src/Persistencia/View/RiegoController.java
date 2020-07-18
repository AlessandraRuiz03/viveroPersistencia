package Persistencia.View;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

import Persistencia.Conexion;
import Persistencia.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RiegoController {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	DAORiego riego = new DAORiego();
	
	ObservableList<Riego> rieg = FXCollections.observableArrayList();

	private Main main;

	 @FXML
	    private Button registrar;

	    @FXML
	    private TextField idRiegoE;

	    @FXML
	    private Button eliminar;

	    @FXML
	    private TextField idRiegoA;

	    @FXML
	    private Button actualizar;

	    @FXML
	    private Button mostrarDatos;

	    @FXML
	    private Button RegresarR;

	    @FXML
	    private TableView<Riego> MostrarTabla;

	    @FXML
	    private TableColumn<Riego, String> IDRiego;

	    @FXML
	    private TableColumn<Riego, Date> FechaRiegoTab;

	    @FXML
	    private TableColumn<Riego, String> ProductoID;

	    @FXML
	    private DatePicker fechaRiegoRe;

	    @FXML
	    private DatePicker fechaRiegoACT;

	    @FXML
	    private ComboBox<String> idProductoRe;

	    @FXML
	    private ComboBox<String> idProductoA;
	    
	    @FXML
		 void initialize() {
			llenarComboBox();
			llenarComboBox1();
		}
	    
	    public void CargarTabla() {
	    	 List list = riego.listRiego();
	    	for (Iterator iterator = list.iterator(); iterator.hasNext();){
	    			Riego riegoA = (Riego) iterator.next(); 
	    			rieg.add(riegoA);
	    	}
	    	IDRiego.setCellValueFactory(new PropertyValueFactory<>("Id"));
	    	FechaRiegoTab.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
	        ProductoID.setCellValueFactory(cellData ->{
				SimpleStringProperty valorA = new SimpleStringProperty();
				if(cellData.getValue().getIdProducto()!= null) {
					valorA.setValue(cellData.getValue().getIdProducto().getNombre());
				}
				return valorA;
			});
	        MostrarTabla.setItems(rieg);
	    }

    @FXML
    void Actualizar() {
    	String Id = idRiegoA.getText();
    	int ID = Integer.parseInt(Id);
    	
        Date date = Date.from(fechaRiegoACT.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        String riegoC= idProductoA.getSelectionModel().getSelectedItem();
    	String [] cRiego = riegoC.split("-");String riegoA = cRiego[0];
    	int ARiego = Integer.parseInt(riegoA);
    
    	 Producto product = new Producto();
         product.setId(ARiego);
        
       riego.updateRiego(ID,date,product);
       System.out.println(date);

    }

    @FXML
    void ClickRegresarR() {
    	main.getVentanaRiego().close();
    	main.VentanaMenu();

    }

    @FXML
    void Eliminar() {
    	String Id = idRiegoE.getText();
    	Integer ID = Integer.parseInt(Id);
    	
    	
    	DAORiego tipo = new DAORiego();
    	tipo.deleteRiego(ID);

    }

    @FXML
    void MostrarDatos() {
    	rieg.clear();
    	riego.listRiego();
    	CargarTabla();

    }

    @FXML
    void Registro() {	
        Date fecha = Date.from(fechaRiegoRe.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
    	String riegoC= idProductoRe.getSelectionModel().getSelectedItem();
    	String [] cRiego = riegoC.split("-"); String riegoR = cRiego[0];
    	int RRiego = Integer.parseInt(riegoR);
    	
    	Producto product = new Producto();
        product.setId(RRiego);

        System.out.println(product);
        
        
       DAORiego riego = new DAORiego();
       riego.addRiego(fecha,product);
        
        System.out.println(fecha);
       System.out.println(product);
    }


	public void setMain(Main main) {
		this.main=main;
		
	}
	
	public void llenarComboBox() {
		Session session;
		idProductoRe.getItems().removeAll(idProductoRe.getItems());
	 	  factory = Conexion.getConexion(); 
	 	 session = factory.openSession();
	 	   ObservableList<String> aux = FXCollections.observableArrayList();
	 	  Criteria crit =
	        		 session.createCriteria(Producto.class);
	        List listRiego = crit.list(); 
	 	   for(Iterator iterator =
	 			   listRiego.iterator(); iterator.hasNext();) {
	 		   Producto dao = (Producto) iterator.next();
	 		   aux.add(dao.getId()+"-"+dao.getNombre());
	 	   } 
	 	   
	 	  idProductoRe.getItems().addAll(aux);
	     
	    } 
	
	public void llenarComboBox1() {
		Session session;
		idProductoA.getItems().removeAll(idProductoA.getItems());
	 	  factory = Conexion.getConexion(); 
	 	 session = factory.openSession();
	 	   ObservableList<String> aux = FXCollections.observableArrayList();
	 	  Criteria crit =
	        		 session.createCriteria(Producto.class);
	        List listRiego1 = crit.list(); 
	 	   for(Iterator iterator =
	 			   		listRiego1.iterator(); iterator.hasNext();) {
	 		   Producto dao = (Producto) iterator.next();
	 		   aux.add(dao.getId()+"-"+dao.getNombre());
	 	   } 
	 	   
	 	  idProductoA.getItems().addAll(aux);
	     
	    } 
	
	 
	
	
}
