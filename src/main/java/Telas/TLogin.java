package Telas;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Alert.MessageAlert;
import Controladores.ControladorImagem;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TLogin extends Application {
	private JFXButton btnLogin;
	// private JavaFXImageBuilder
	private JFXTextField txfUsuario;
	private JFXPasswordField txfSenha;
	private Label lblUsuario;
	private Label lblSenha;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane);
		// Scene scene1 = new Scene(componentes);
		pane.setPrefSize(500, 400);

		// CRIANDO LABEL USUARIO
		lblUsuario = new Label();
		lblUsuario.setLayoutX(80);
		lblUsuario.setLayoutY(140);

		//Adicionando Imagem a label usuario
				
		ImageView imgUsuario = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoUsuario));
		
		imgUsuario.setFitHeight(50);
		imgUsuario.setFitWidth(50);
     	lblUsuario.setGraphic(imgUsuario);
		
		
		// CRIANDO LABEL SENHA
		lblSenha = new Label();
		lblSenha.setLayoutX(80);
		lblSenha.setLayoutY(200);
	
		//Adicionando Imagem a label senha
		
		ImageView imgSenha = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoSenha));
		imgSenha.setFitHeight(50);
		imgSenha.setFitWidth(50);
		lblSenha.setGraphic(imgSenha);
		
		// CRIANDO CAMPO DE TEXTO DE USUARIO

		txfUsuario = new JFXTextField();
		txfUsuario.setLayoutX(150);
		txfUsuario.setLayoutY(150);

		txfUsuario.setStyle(Strings.txfTexfieldJFX);
		// CRIANDO CAMPO DE TEXTO DE SENHA

		txfSenha = new JFXPasswordField();
		txfSenha.setLayoutX(150);
		txfSenha.setLayoutY(210);
		txfSenha.setStyle(Strings.txfTexfieldJFX);

		// ADICIONANDO IMAGEM
		
		ImageView imgView = new ImageView(ControladorImagem.carregarImagem(Strings.urlImagem, Strings.urlLogoLogin));
		imgView.setFitHeight(100);
		imgView.setFitWidth(100);
		imgView.setLayoutX(200);
		imgView.setLayoutY(10);

		// CRIANDO BUTTON ENTRAR
		btnLogin = new JFXButton(Strings.btnLogin);
		btnLogin.setLayoutX(190);
		btnLogin.setLayoutY(270);

		btnLogin.setStyle(Strings.btnStyle);

		btnLogin.setDefaultButton(true);
		btnLogin.setOnKeyPressed((KeyEvent t) -> {
			if(t.getCode() == KeyCode.ENTER) {
			   login(stage, txfUsuario, txfSenha);
			}
		});
		
		btnLogin.setOnAction(e -> login(stage, txfUsuario, txfSenha));

		// Adicionando componentes no Panes
		
		pane.getChildren().add(txfSenha);
		pane.getChildren().add(lblUsuario);
		pane.getChildren().add(lblSenha);
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txfUsuario);
		pane.getChildren().add(imgView);
		stage.setTitle(Strings.titleLogin);
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
		
	}

	private void login(Stage stage, JFXTextField usuario, JFXPasswordField senha) {

		if (usuario.getText().trim().equals("admin") && senha.getText().trim().equals("admin")) {
			try {
				new TPrincipal(usuario.getText().trim()).start(new Stage());
				stage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
			return;
		}

		if (!usuario.getText().trim().equals("admin") || senha.getText().trim().equals("admin")) {
			MessageAlert.messageLogin();
			usuario.setText("");
			senha.setText("");
			return;
		}
	}
}
