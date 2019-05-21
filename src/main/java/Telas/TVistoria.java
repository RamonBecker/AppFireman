package Telas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TVistoria extends Application{
	private String usuario;
	private String cnpj;
	private Menu menu;
	private MenuItem menuItemVoltar;
	private MenuBar menuBar;
	private VBox vBox;

	
	public  TVistoria(String usuario) {
		this.usuario = usuario;
	}
	
	public TVistoria(String usuario, String cnpj) {
		this.usuario = usuario;
		this.cnpj = cnpj;
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(700, 500);
		

		// ADICIONANDO MENU
		menu = new Menu("Menu");
		menuItemVoltar = new MenuItem("Voltar");

		menu.getItems().add(menuItemVoltar);
		menuBar = new MenuBar();

		menuBar.getMenus().add(menu);
		vBox = new VBox(1, menuBar);
		vBox.setPrefSize(700, 40);
		
		
		pane.getChildren().add(vBox);
		stage.setScene(scene);
		stage.show();
	}
	
}
