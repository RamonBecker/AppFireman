package Telas;

import java.io.FileInputStream;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Entidades.ControladorImagem;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Principal extends Application{
	private String usuario;
	private JFXButton btnCadastroEmpresa;
	private JFXButton btnCadastroVistoria;
	private JFXButton btnLogout;
	
		
	public Principal(String usuario) {
//		if(usuario.isEmpty() || usuario == null) {
//			throw new IllegalArgumentException("O usuario não pode ser vazio !");
//		}
			this.usuario = usuario;
		}
	public void setUsuario(String usuario) {
		if(usuario.isEmpty() || usuario == null) {
			throw new IllegalArgumentException("O usuario não pode ser vazio !");
		}
		this.usuario = usuario;
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(500, 500);
		
		//CRIANDO GROUP
		Group group = new Group();
		
		// CRIANDO BUTTON CADASTRO DE EMPRESAS
		btnCadastroEmpresa = new JFXButton(Strings.btnCadastroEmpresas);
		
		// CARREGANDO IMAGEM
	
		ImageView imgCadastroEmpresa = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoCadastroEmpresa));
		btnCadastroEmpresa.setGraphic(imgCadastroEmpresa);
		
		//CRIANDO BUTTON CADASTRO VISTORIA
		btnCadastroVistoria = new JFXButton(Strings.btnCadastroVistorias);
		
		// CARREGANDO IMAGEM
		ImageView imgCadastroVistoria = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoCadastroVistoria));
		btnCadastroVistoria.setGraphic(imgCadastroVistoria);
		//btnCadastroVistoria.setLayoutX(100);
		btnCadastroVistoria.setLayoutY(100);
		
		
		//CRIANDO BUTTON LOGOUT
		btnLogout = new JFXButton(Strings.btnLogout);
		// CARREGANDO IMAGEM
		ImageView imgLogout = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoSair));
		btnLogout.setGraphic(imgLogout);
		btnLogout.setLayoutY(200);
		
		// ADICIONANDO COMPONENTES NO GROUP
		group.getChildren().add(btnCadastroEmpresa);
		group.getChildren().add(btnCadastroVistoria);
		group.getChildren().add(btnLogout);
		group.setLayoutX(500);
		group.setLayoutY(30);
		
		// ADICIONANDO COMPONENTES NO PANE
		pane.getChildren().add(group);
		stage.setScene(scene);
		stage.show();
	}
}
