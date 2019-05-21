package Telas;

import com.jfoenix.controls.JFXButton;

import Alert.MessageAlert;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TVistoria extends Application {
	private String usuario;
	private String cnpj;
	private Menu menu;
	private MenuItem menuItemVoltar;
	private MenuBar menuBar;
	private VBox vBox;
	private TextField txfNome;
	private TextField txfCnpj;
	private TextField txfRua;
	private TextField txfBairro;
	private TextField txfCidade;
	private TextField txfCep;
	private TextField txfNumero;
	private TextField txfAreaTotalEdificacao;
	private TextField txfAreaVistoriadaEdificacao;
	private Label lbNome;
	private Label lbCnpj;
	private Label lbRua;
	private Label lbBairro;
	private Label lbCidade;
	private Label lbCep;
	private Label lbNumero;
	private JFXButton btnBuscarEmpresa;

	public TVistoria(String usuario) {
		this.usuario = usuario;
	}
//
//	public TVistoria(String usuario, String cnpj) {
//		this.usuario = usuario;
//		this.cnpj = cnpj;
//	}

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

		// Criando Textfield nome

		txfNome = new TextField();
		txfNome.setLayoutX(60);
		txfNome.setLayoutY(100);
		// txfNome.setDisable(true);
		// CRIANDO LABEL NOME
		lbNome = new Label(Strings.lbNome + ":");
		lbNome.setLayoutX(22);
		lbNome.setLayoutY(100);

		// Criando Textfield CNPJ
		txfCnpj = new TextField();
		txfCnpj.setLayoutX(260);
		txfCnpj.setLayoutY(100);

		// CRIANDO LABEL CNPJ
		lbCnpj = new Label(Strings.lbCnpj + ":");
		lbCnpj.setLayoutX(230);
		lbCnpj.setLayoutY(100);

		
		
		//CRIANDO BUTTON
		btnBuscarEmpresa = new JFXButton(Strings.btnBuscarEmpresa);
		btnBuscarEmpresa.setLayoutX(250);
		btnBuscarEmpresa.setLayoutY(40);
		btnBuscarEmpresa.setStyle("-fx-padding: 0.7em 0.57em; -fx-font-size: 14px;-jfx-button-type: RAISED;-fx-background-color: rgb(155, 10, 7);-fx-pref-width: 200;-fx-text-fill: WHITE;");
		
		//ACAO DO MENU ITEM
		acaoMenuItemVoltar(menuItemVoltar, stage);

		//ACAO DA SCENE COM TECLA DE ATALHO
		scene.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ESCAPE) {
				voltar(stage);
			}
		});
	
		//ACAO DO BUTTON DE PESQUISAR EMPRESA
		acaoBotaoBuscar(btnBuscarEmpresa, stage);
		
		pane.getChildren().add(vBox);
		pane.getChildren().add(txfNome);
		pane.getChildren().add(txfCnpj);
		pane.getChildren().add(lbNome);
		pane.getChildren().add(lbCnpj);
		pane.getChildren().add(btnBuscarEmpresa);
		stage.setScene(scene);
		stage.show();
	}

	private void voltar(Stage stage) {
		try {
			new TPrincipal(usuario).start(new Stage());
			stage.close();
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemVoltarTelaPrincipal);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void acaoMenuItemVoltar(MenuItem menuItemVoltar, Stage stage) {
		menuItemVoltar.setOnAction(e -> voltar(stage));
	}
	
	private void acaoBotaoBuscar(JFXButton btnBuscarEmpresa, Stage stage) {
		btnBuscarEmpresa.setDefaultButton(false);
		btnBuscarEmpresa.setOnKeyPressed((KeyEvent t) ->{
			if(t.getCode() == KeyCode.ENTER) {
				telaPesquisaEmpresa(stage);
			}
		});
		
		btnBuscarEmpresa.setOnAction(e -> telaPesquisaEmpresa(stage));
	}

	private void telaPesquisaEmpresa(Stage stage) {
		try {
			new TPesquisaEmpresa(usuario).start(new Stage());
			stage.close();
		} catch (Exception e) {
			MessageAlert.mensagemErro(Strings.erroTela);
			e.printStackTrace();
		}

	}
}
