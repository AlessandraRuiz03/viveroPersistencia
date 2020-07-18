package Persistencia.View;

import java.util.Iterator;
import java.util.List;

import Persistencia.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Persistencia.View.DAOTipo;

public class TipoController {

	ObservableList<TipoProducto> tipoProduct = FXCollections.observableArrayList();
	DAOTipo tipo = new DAOTipo();
	
	private Main main;

    @FXML
    private TextField tipoProducto;

    @FXML
    private TextField idProductoE;

    @FXML
    private TableView<TipoProducto> TablaDatos;

    @FXML
    private TableColumn<TipoProducto, Integer> IDProducto;

    @FXML
    private TableColumn<TipoProducto, String> TipoProducto;

    @FXML
    private TextField tipoProductoAct;

    @FXML
    private TextField idTipoPAct;

    @FXML
    private Button registrar;

    @FXML
    private Button eliminar;

    @FXML
    private Button actualizar;

    @FXML
    private Button mostrarDatos;

    @FXML
    private Button RegresarTP;

    @FXML
    void ClickActualizar() {
    	String TipoProducto = tipoProductoAct.getText();
    	String Id = idTipoPAct.getText();
    	Integer ID = Integer.parseInt(Id);
    	System.out.println(TipoProducto);
    	
    	DAOTipo tipo = new DAOTipo();
    	tipo.updateTipo(ID,TipoProducto);

    }

    @FXML
    void ClickEliminar() {
    	String Id = idProductoE.getText();
    	Integer ID = Integer.parseInt(Id);
    	
    	DAOTipo tipo = new DAOTipo();
    	tipo.deleteTipo(ID);

    }

    @FXML
    void ClickMostrarDatos() {
    	tipoProduct.clear();
    	DAOTipo.listTipo();
    	CargarTabla();

    }
    
    public void CargarTabla() {
   	 List list = tipo.listTipo();
   	for (Iterator iterator = list.iterator(); iterator.hasNext();){
   			TipoProducto tipoA = (TipoProducto) iterator.next(); 
   			tipoProduct.add(tipoA);
   	}
   	IDProducto.setCellValueFactory(new PropertyValueFactory<>("Id"));
   	TipoProducto.setCellValueFactory(new PropertyValueFactory<>("TipoProducto"));
   	TablaDatos.setItems(tipoProduct);
   }

    @FXML
    void ClickRegresarTP() {
    	main.getVentanaTipoProducto().close();
    	main.VentanaMenu(); 
 
    }

    @FXML
    void Registro() {
    	String TipoProducto = tipoProducto.getText();

    	DAOTipo tipo = new DAOTipo();
    	tipo.addTipo(TipoProducto); 
    	

    }

	public void setMain(Main main) {
		this.main=main;
	}

}
