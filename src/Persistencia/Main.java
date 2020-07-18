package Persistencia;
	
import Persistencia.View.ProductoController;
import Persistencia.View.RiegoController;
import Persistencia.View.TipoController;
import Persistencia.View.inicioController;
import Persistencia.View.loginController;
import Persistencia.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Stage stage;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		VentanaInicio();
	}
	
	public void VentanaInicio() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Login.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setTitle("GREEN NURSERY");
			this.stage = stage;
			stage.initOwner(primaryStage);
			stage.setScene(scene);
			//Conexion.getConexion();
			//stage.initModality(Modality.WINDOW_MODAL);
			loginController controler = loader.getController();
			controler.setMain(this);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void VentanaMenu() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Inicio.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageInicio = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageInicio;
			stageInicio.initOwner(primaryStage);
			stageInicio.setScene(scene);
			stageInicio.initModality(Modality.WINDOW_MODAL);
			inicioController controler = loader.getController();
			controler.setMain(this);
			stageInicio.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaRegistro() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Registro.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageRegistro = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageRegistro;
			stageRegistro.initOwner(primaryStage);
			stageRegistro.setScene(scene);
			stageRegistro.initModality(Modality.WINDOW_MODAL);
			inicioController controler = loader.getController();
			controler.setMain(this);
			stageRegistro.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void VentanaProducto() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Producto.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageProducto;
			stageProducto.initOwner(primaryStage);
			stageProducto.setScene(scene);
			stageProducto.initModality(Modality.WINDOW_MODAL);
			ProductoController controler = loader.getController();
			controler.setMain(this);
			stageProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaRiego() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Riego.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageRiego = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageRiego;
			stageRiego.initOwner(primaryStage);
			stageRiego.setScene(scene);
			stageRiego.initModality(Modality.WINDOW_MODAL);
			RiegoController controler = loader.getController();
			controler.setMain(this);
			stageRiego.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VentanaTipoProduto() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/TipoProducto.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageTipoProducto = new Stage();
			Scene scene = new Scene(root);
			this.stage = stageTipoProducto;
			stageTipoProducto.initOwner(primaryStage);
			stageTipoProducto.setScene(scene);
			stageTipoProducto.initModality(Modality.WINDOW_MODAL);
			TipoController controler = loader.getController();
			controler.setMain(this);
			stageTipoProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Stage getVentanaInicio() {
		return stage;
	}
	
	public Stage getVentanaMenu() {
		return stage;
	}
	
	public Stage getVentanaRegistro() {
		return stage;
	}
	
	public Stage getVentanaProducto() {
		return stage;
	}
	
	public Stage getVentanaRiego() {
		return stage;
	}
	
	public Stage getVentanaTipoProducto() {
		return stage;
	}
}
