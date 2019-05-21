package Telas;

import Controladores.ControladorEmpresa;
import Entidades.Empresa;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TVistoria extends Application{
	private String usuario;
	private ControladorEmpresa controladorEmpresa;
	
	public TVistoria(String usuario, ControladorEmpresa empresa) {
		this.usuario = usuario;
		this.controladorEmpresa = empresa;
	}

	public TVistoria(String usuario) {
		this.usuario = usuario;
	}
	

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(700, 500);
		
		
		
		System.out.println(ControladorEmpresa.getInstance().getEmpresasCadastradas());
		
		stage.setHeight(500);
		stage.show();
		
	}
	
//	public ObservableList<Empresa> getEmpresa(){
//		ControladorEmpresa contEmpresa = new ControladorEmpresa();
//		ObservableList<Empresa> empresa = 
//		
//	}
}
