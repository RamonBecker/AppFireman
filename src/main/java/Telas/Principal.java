package Telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Principal extends Application{
		private String usuario;
		
		
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(600, 400);
		
		stage.setScene(scene);
		stage.show();
	}
}
