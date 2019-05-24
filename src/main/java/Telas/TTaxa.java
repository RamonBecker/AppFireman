package Telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TTaxa extends Application {
	private AnchorPane pane;
	private String usuario;

	public TTaxa(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void start(Stage stage) throws Exception {
		pane = new AnchorPane();
		pane.setPrefSize(700, 600);
		Scene scene = new Scene(pane);

		
		
		stage.setScene(scene);
		stage.show();
	}

}
