package Telas;

import com.jfoenix.controls.JFXButton;

import Alert.MessageAlert;
import Entidades.ControladorImagem;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Principal extends Application {
	private String usuario;
	private JFXButton btnCadastroEmpresa;
	private JFXButton btnCadastroVistoria;
	private JFXButton btnLogout;
	private Label labelCadastroEmpresa;
	private Label labelCadastroVistoria;
	private Label labelSair;

	public Principal(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void start(Stage stage) throws Exception {

		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		pane.setPrefSize(600, 500);

		// CRIANDO BUTTON CADASTRO DE EMPRESAS
		btnCadastroEmpresa = new JFXButton();
		btnCadastroEmpresa.setPrefSize(30, 30);
		// CARREGANDO IMAGEM

		ImageView imgCadastroEmpresa = new ImageView(
				ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoCadastroEmpresa));
		imgCadastroEmpresa.setFitHeight(70);
		imgCadastroEmpresa.setFitWidth(70);
		btnCadastroEmpresa.setGraphic(imgCadastroEmpresa);
		btnCadastroEmpresa.setLayoutY(20);

		// CRIANDO LABEL Cadastro empresa
		labelCadastroEmpresa = new Label(Strings.btnCadastroEmpresas);
		labelCadastroEmpresa.setLayoutY(100);

		// CRIANDO BUTTON CADASTRO VISTORIA
		btnCadastroVistoria = new JFXButton();

		// CARREGANDO IMAGEM
		ImageView imgCadastroVistoria = new ImageView(
				ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoCadastroVistoria));
		imgCadastroVistoria.setFitHeight(70);
		imgCadastroVistoria.setFitWidth(70);
		btnCadastroVistoria.setGraphic(imgCadastroVistoria);
		btnCadastroVistoria.setLayoutX(100);
		btnCadastroVistoria.setLayoutY(20);

		// CRIANDO LABEL Cadastro Vistoria
		labelCadastroVistoria = new Label(Strings.btnCadastroVistorias);
		labelCadastroVistoria.setLayoutY(100);
		labelCadastroVistoria.setLayoutX(122);

		// CRIANDO BUTTON LOGOUT

		btnLogout = new JFXButton();

		// CARREGANDO IMAGEM
		ImageView imgLogout = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoSair));
		imgLogout.setFitHeight(70);
		imgLogout.setFitWidth(70);
		btnLogout.setGraphic(imgLogout);
		btnLogout.setLayoutX(180);
		btnLogout.setLayoutY(20);

		// CRIANDO LABEL Sair
		labelSair = new Label(Strings.urlLogoSair);

		// ADICIONANDO COMPONENTES NO PANE
		pane.getChildren().add(btnCadastroEmpresa);
		pane.getChildren().add(btnCadastroVistoria);
		pane.getChildren().add(btnLogout);
		pane.getChildren().add(labelCadastroEmpresa);
		pane.getChildren().add(labelCadastroVistoria);
		
		// AÇÕES DOS BOTÕES

		// BOTAO EMPRESA
		btnCadastroEmpresa.setDefaultButton(false);
		btnCadastroEmpresa.setOnKeyPressed((KeyEvent t) -> {
			if (t.getCode() == KeyCode.ENTER) {
				telaEmpresa(stage);
			}
		});
		
		
		btnCadastroEmpresa.setOnAction(e -> telaEmpresa(stage));

		stage.setScene(scene);
		stage.show();
	}

	private void telaEmpresa(Stage stage) {
		try {
			new TEmpresa(usuario).start(new Stage());
			// stage.close();
		} catch (Exception e) {
			MessageAlert.mensagemErro(Strings.erroTela);;
			e.printStackTrace();
		}
		;
	}
}
