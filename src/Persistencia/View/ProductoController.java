package Persistencia.View;

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
import Persistencia.View.DAOProducto;
import Persistencia.View.DAOTipo;
import Persistencia.View.TipoProducto;

public class ProductoController {
	DAOProducto producto = new DAOProducto();
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	@FXML
    private ComboBox<String> tipoProducto;

    @FXML
    private ComboBox<String> tipoPactualizar;

    @FXML 
    private TextField nombre;

    @FXML
    private DatePicker fechaIngreso;

    @FXML
    private TextField IdEliminar;

    @FXML
    private TableView<Producto> MostrarDatos;

    @FXML
    private TableColumn<Producto, String> TipoProducto;

    @FXML
    private TableColumn<Producto, Integer> IDProducto;

    @FXML
    private TableColumn<Producto, String> Nombre;

    @FXML
    private TableColumn<Producto, Date> FechaIngreso;

    @FXML
    private TableColumn<Producto, String> Condicion;

    @FXML
    private TextField IdPactualizar;

    @FXML
    private TextField nombreAct;

    @FXML
    private DatePicker FIactualizar;

    @FXML
    private TextField condicion;

    @FXML
    private TextField condicionAct;

    @FXML
    private Button MostrarTabla;

    @FXML
    private Button RegresarTP;

    @FXML
    private Button Registrar;

    @FXML
    private Button eliminar;

    @FXML
    private Button Actualizar;

	private Main main;
	@FXML
	
    private Button Cargar;
	
	ObservableList<Producto> product = FXCollections.observableArrayList();

	 @FXML
	 void initialize() {
    	llenarComboBox();
    	llenarComboBox1();
    }

    @FXML
    void Actualizar() {
    	String Id = IdPactualizar.getText();
    	int ID = Integer.parseInt(Id);
    	
    	String Nombre = nombreAct.getText();
    	
        String comboProduct= tipoPactualizar.getValue();
    	String [] prod = comboProduct.split("-"); String productID = prod[0];
    	int combo = Integer.parseInt(productID);

        String Condicion = condicionAct.getText();
        
        Date date = Date.from(FIactualizar.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        TipoProducto tipo = new TipoProducto();
        tipo.setId(combo);
        
        DAOProducto product = new DAOProducto();
       
        product.updateProducto(ID,Nombre,tipo, Condicion, date);

    }

    @FXML
    void ClickRegresarTP() {
    	main.getVentanaProducto().close();
    	main.VentanaMenu();

    }

    @FXML
    void Eliminar() {
    	String Id = IdEliminar.getText();
    	int ID = Integer.parseInt(Id);
    	
    	DAOProducto product = new DAOProducto();
        
        product.deleteProducto(ID);

    	
    }
    
    public void CargarTabla() {
    	 List list = producto.listProducto();
    	for (Iterator iterator = list.iterator(); iterator.hasNext();){
    			Producto productoA = (Producto) iterator.next(); 
    			product.add(productoA);
    	}
    	IDProducto.setCellValueFactory(new PropertyValueFactory<>("Id"));
    	Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        FechaIngreso.setCellValueFactory(new PropertyValueFactory<>("FechaIngreso"));
        Condicion.setCellValueFactory(new PropertyValueFactory<>("Condicion"));
        TipoProducto.setCellValueFactory(cellData ->{
			SimpleStringProperty valorA = new SimpleStringProperty();
			if(cellData.getValue().getTipoP()!= null) {
				valorA.setValue(cellData.getValue().getTipoP().getTipoProducto());
			}
			return valorA;
		});
        MostrarDatos.setItems(product);
    }

    @FXML
    void MostrarDatos() {
    	product.clear();
    	DAOProducto.listProducto();
    	CargarTabla();
    }

    @FXML
    void Registro() {
	try {
		String Nombre = nombre.getText();
		
		String comboProductR= tipoProducto.getSelectionModel().getSelectedItem();
		String [] c = comboProductR.split("-"); String productR = c[0];
		int RProduct = Integer.parseInt(productR);
	
	    String Condicion = condicion.getText();
	    
        Date date = Date.from(fechaIngreso.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
	    
	    TipoProducto tipo = new TipoProducto();
	    tipo.setId(RProduct);
	    
	    DAOProducto product = new DAOProducto();
	   
	    product.addProducto(Nombre,date, Condicion, tipo);
		
		System.out.println("Nombre:"+Nombre+"  Fecha:"+date+"  Tipo:"+ tipo +"    Condicion:"+Condicion);
	
    	}catch(Exception e) {
			e.printStackTrace();
		}
	
	
    }

	public void setMain(Main main) {
		this.main = main; 
		
	}
	
	public void llenarComboBox() {
		Session session;
	 	  tipoProducto.getItems().removeAll(tipoProducto.getItems());
	 	  factory = Conexion.getConexion(); 
	 	 session = factory.openSession();
	 	   ObservableList<String> aux = FXCollections.observableArrayList();
	 	  Criteria crit =
	        		 session.createCriteria(TipoProducto.class);
	        List listTipoProducto = crit.list(); 
	 	   for(Iterator iterator =
	 			   		listTipoProducto.iterator(); iterator.hasNext();) {
	 		   TipoProducto dao = (TipoProducto) iterator.next();
	 		   aux.add(dao.getId()+"-"+dao.getTipoProducto());
	 	   } 
	 	   
	 	  tipoProducto.getItems().addAll(aux);
	     
	    } 

	public void llenarComboBox1() {
		Session session;
		tipoPactualizar.getItems().removeAll(tipoPactualizar.getItems());
	 	  factory = Conexion.getConexion(); 
	 	 session = factory.openSession();
	 	   ObservableList<String> aux = FXCollections.observableArrayList();
	 	  Criteria crit =
	        		 session.createCriteria(TipoProducto.class);
	        List listTipoProducto1 = crit.list(); 
	 	   for(Iterator iterator =
	 			   		listTipoProducto1.iterator(); iterator.hasNext();) {
	 		   TipoProducto dao = (TipoProducto) iterator.next();
	 		   aux.add(dao.getId()+"-"+dao.getTipoProducto());
	 	   } 
	 	   
	 	  tipoPactualizar.getItems().addAll(aux);
	     
	    }
}

