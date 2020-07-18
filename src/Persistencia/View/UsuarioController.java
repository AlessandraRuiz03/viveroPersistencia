package Persistencia.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import Persistencia.View.DAOUsuario;

public class UsuarioController {

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
    	
    	DAOUsuario usuario = new DAOUsuario();
    	usuario.addUsuario(Correo, Password);

    }

}