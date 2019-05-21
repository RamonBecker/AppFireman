package Telas;

import com.jfoenix.controls.JFXButton;

import Alert.MessageAlert;
import Controladores.ControladorImagem;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TPrincipal extends Application {
	private String usuario;
	private JFXButton btnCadastroEmpresa;
	private JFXButton btnCadastroVistoria;
	private Label labelCadastroEmpresa;
	private Label labelCadastroVistoria;
	private Menu menu;
	private MenuItem menuItemSair;
	private MenuBar menuBar;
	private VBox vBox;
	
	
	public TPrincipal(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void start(Stage stage) throws Exception {

		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(500, 400);

		// CRIANDO BUTTON CADASTRO DE EMPRESAS
		btnCadastroEmpresa = new JFXButton();
		btnCadastroEmpresa.setPrefSize(30, 30);
		// CARREGANDO IMAGEM

		ImageView imgCadastroEmpresa = new ImageView(
				ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoCadastroEmpresa));
		imgCadastroEmpresa.setFitHeight(70);
		imgCadastroEmpresa.setFitWidth(70);
		btnCadastroEmpresa.setGraphic(imgCadastroEmpresa);
		btnCadastroEmpresa.setLayoutX(83);
		btnCadastroEmpresa.setLayoutY(150);

		// CRIANDO LABEL Cadastro empresa
		labelCadastroEmpresa = new Label(Strings.btnCadastroEmpresas);
		labelCadastroEmpresa.setLayoutX(76);
		labelCadastroEmpresa.setLayoutY(235);

		// CRIANDO BUTTON CADASTRO VISTORIA
		btnCadastroVistoria = new JFXButton();

		// CARREGANDO IMAGEM
		ImageView imgCadastroVistoria = new ImageView(
				ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoCadastroVistoria));
		imgCadastroVistoria.setFitHeight(70);
		imgCadastroVistoria.setFitWidth(70);
		btnCadastroVistoria.setGraphic(imgCadastroVistoria);
		btnCadastroVistoria.setLayoutX(220);
		btnCadastroVistoria.setLayoutY(150);

		// CRIANDO LABEL Cadastro Vistoria
		labelCadastroVistoria = new Label(Strings.btnCadastroVistorias);
		labelCadastroVistoria.setLayoutX(230);
		labelCadastroVistoria.setLayoutY(235);

		// ADICIONANDO MENU
		 menu = new Menu("Menu");
		 menuItemSair = new MenuItem("Sair");

		menu.getItems().add(menuItemSair);
		 menuBar = new MenuBar();

		menuBar.getMenus().add(menu);
		vBox = new VBox(1, menuBar);
		vBox.setPrefSize(500, 40);

		// ADICIONANDO COMPONENTES NO PANE

		pane.getChildren().add(btnCadastroEmpresa);
		pane.getChildren().add(btnCadastroVistoria);
		pane.getChildren().add(labelCadastroEmpresa);
		pane.getChildren().add(labelCadastroVistoria);
		pane.getChildren().add(vBox);

		// AÇÕES DOS BOTÕES

		//AÇÃO DO BOTÃO EMPRESA
		acaoBotaoEmpresa(btnCadastroEmpresa, stage);
		
		// AÇÃO DO MENU SAIR
		menuItemSair.setOnAction(e -> sair(stage));

		
		//AÇAÕ BOTAO VISTORIA
		acaoBotaoVistoria(btnCadastroVistoria, stage);

	
		
		stage.setScene(scene);
		stage.show();
	}

	public void acaoBotaoEmpresa(JFXButton btnCadastroEmpresa, Stage stage) {

		btnCadastroEmpresa.setDefaultButton(false);
		btnCadastroEmpresa.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ENTER) {
				telaEmpresa(stage);
			}
		});

		btnCadastroEmpresa.setOnAction(e -> telaEmpresa(stage));

	}
	
	
	public void acaoBotaoVistoria(JFXButton btnCadastroVistoria, Stage stage) {

		btnCadastroVistoria.setDefaultButton(false);
		btnCadastroVistoria.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ENTER) {
				telaVistoria(stage);
			}
		});
		btnCadastroVistoria.setOnAction(e -> telaVistoria(stage));

	}

	private void telaEmpresa(Stage stage) {
		try {
			new TEmpresa(usuario).start(new Stage());
			stage.close();
		} catch (Exception e) {
			MessageAlert.mensagemErro(Strings.erroTela);
			;
			e.printStackTrace();
		}
	}
	
	private void telaVistoria(Stage stage) {
		
		try {
			
			new TVistoria(usuario).start(new Stage());
			stage.close();
		} catch (Exception e) {
			MessageAlert.mensagemErro(Strings.erroTela);
			e.printStackTrace();
		};
	}

	public void sair(Stage stage) {
		stage.close();
		MessageAlert.mensagemRealizadoSucesso(Strings.mensagemSair);
	}
}
