package Persistencia.View;

import Persistencia.Conexion;
import Persistencia.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {
	
	DAOUsuario usuario = new DAOUsuario();
	private Main main;
	
	 @FXML
	    private TextField correo;

	    @FXML
	    private PasswordField password;
	
	  @FXML
	    private Button inicio;

	    @FXML
	    private Button registro;

	
	
	    @FXML
	    void ClickInicio() {
	    	String Correo = correo.getText();
	    	String Password = password.getText();
	    	 
	    	usuario.verificarUsuarios(Correo, Password);
			if(usuario.verificarUsuarios(Correo, Password) == true) {
				Conexion.getConexion();
		    	main.getVentanaInicio().close();
		    	main.VentanaMenu();
			} else {
				Alert alert = new Alert (AlertType.INFORMATION);
				alert.setTitle("Auch:(");
				alert.setHeaderText("USUARIO ó CONTRASEÑA son INCORRECTAS");
				alert.setContentText("Verificar que sus datos sean CORRECTOS!!");
				alert.showAndWait();
			} 	
	    }
	 
	    @FXML
	    void ClickRegistro() {
	    	//main.getVentanaInicio().close();
	    	main.VentanaRegistro();
	    }

	 
	 
	 public void setMain(Main main) {
			this.main = main;
		}

}
