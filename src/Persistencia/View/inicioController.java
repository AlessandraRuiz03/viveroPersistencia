package Persistencia.View;

import Persistencia.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class inicioController {
	DAOUsuario  usuario = new DAOUsuario();
	private Main main;

    @FXML
    private Button producto;

    @FXML
    private Button tipoProducto;

    @FXML
    private Button riego;

    @FXML
    private Button regresarM;

    @FXML
    private Button integrantes;
    
    @FXML
    private TextField correo;

    @FXML
    private Button Registrate;

    @FXML
    private PasswordField password;

    @FXML
    void ClickRegistrate() {
    	String Correo = correo.getText();
    	String Password = password.getText();
    	
    	usuario.addUsuario(Correo, Password);
    	

    }

    @FXML
    void ClickIntegrantes() {

    }

    @FXML
    void ClickProducto() {
    	main.getVentanaMenu().close();
    	main.VentanaProducto();
    	//ProductoController.llenarComboBox();

    }

    @FXML
    void ClickRegresarM() {
    	main.getVentanaMenu().close();
    	main.VentanaInicio();

    }

    @FXML
    void ClickRiego() {
    	main.getVentanaMenu().close();
    	main.VentanaRiego();

    }

    @FXML
    void ClickTipoProducto() {
    	main.getVentanaMenu().close();
    	main.VentanaTipoProduto();

    }



	public void setMain(Main main) {
		this.main = main;
		
	}

}
