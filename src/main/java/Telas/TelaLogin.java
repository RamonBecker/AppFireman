package Telas;

import java.io.FileInputStream;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import Entidades.MessageAlert;
import Entidades.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaLogin extends Application {
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
		
		Image logoUsuario = new Image(new FileInputStream("src/main/java/Imagem/LogoUsuario.png"));

		ImageView imgUsuario = new ImageView(logoUsuario);
		imgUsuario.setFitHeight(50);
		imgUsuario.setFitWidth(50);
		lblUsuario.setGraphic(imgUsuario);
		
		
		// CRIANDO LABEL SENHA
		lblSenha = new Label();
		lblSenha.setLayoutX(80);
		lblSenha.setLayoutY(200);
	
		//Adicionando Imagem a label senha
		
		Image logoSenha = new Image(new FileInputStream("src/main/java/Imagem/LogoSenha.png"));

		ImageView imgSenha = new ImageView(logoSenha);
		imgSenha.setFitHeight(50);
		imgSenha.setFitWidth(50);
		lblSenha.setGraphic(imgSenha);
		
		// CRIANDO CAMPO DE TEXTO DE USUARIO

		txfUsuario = new JFXTextField();
		txfUsuario.setLayoutX(150);
		txfUsuario.setLayoutY(150);

		txfUsuario.setStyle("-jfx-focus-color: red;" + "-fx-font: 16px Arial;");
		// CRIANDO CAMPO DE TEXTO DE SENHA

		txfSenha = new JFXPasswordField();
		txfSenha.setLayoutX(150);
		txfSenha.setLayoutY(210);
		txfSenha.setStyle("-jfx-focus-color: red;" + "-fx-font: 16px Arial;");

		// ADICIONANDO IMAGEM

		Image logo = new Image(new FileInputStream("src/main/java/Imagem/Login.png"));

		ImageView imgView = new ImageView(logo);
		imgView.setFitHeight(100);
		imgView.setFitWidth(100);
		imgView.setLayoutX(200);
		imgView.setLayoutY(10);

		// CRIANDO BUTTON ENTRAR
		btnLogin = new JFXButton(Strings.login);
		btnLogin.setLayoutX(190);
		btnLogin.setLayoutY(270);

		btnLogin.setStyle("-fx-padding: 0.7em 0.57em;\r\n" + "    -fx-font-size: 14px;\r\n"
				+ "    -jfx-button-type: RAISED;\r\n" + "    -fx-background-color: rgb(155, 10, 7);\r\n"
				+ "    -fx-pref-width: 100;\r\n" + "    -fx-text-fill: WHITE;");

		btnLogin.setOnAction(e -> login(stage, txfUsuario, txfSenha));


		// Adicionando componentes no Panes
		
		pane.getChildren().add(txfSenha);
		pane.getChildren().add(lblUsuario);
		pane.getChildren().add(lblSenha);
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txfUsuario);
		pane.getChildren().add(imgView);
		stage.setTitle("Login");
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
	}

	private void login(Stage stage, JFXTextField usuario, JFXPasswordField senha) {

		if (usuario.getText().trim().equals("admin") && senha.getText().trim().equals("admin")) {
			try {
				new Principal(usuario.getText().trim()).start(new Stage());
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
