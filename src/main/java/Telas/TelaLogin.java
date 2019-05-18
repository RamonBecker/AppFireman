package Telas;

import java.io.FileInputStream;
import java.io.InputStream;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.fxml.builder.JavaFXImageBuilder;

import Entidades.Strings;
import Imagem.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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
		lblUsuario = new Label(Strings.lblUsuario + " : ");
		lblUsuario.setStyle("-fx-font: 14px Arial;");
		lblUsuario.setLayoutX(90);
		lblUsuario.setLayoutY(160);

		// CRIANDO LABEL SENHA
		lblSenha = new Label(Strings.lblSenha + " : ");
		lblSenha.setStyle("-fx-font: 14px Arial;");
		lblSenha.setLayoutX(90);
		lblSenha.setLayoutY(220);

		

		// CRIANDO CAMPO DE TEXTO DE USUARIO

		txfUsuario = new JFXTextField();
		txfUsuario.setLayoutX(150);
		txfUsuario.setLayoutY(150);
		txfUsuario.setStyle("-fx-font: 16px Arial;");

		// CRIANDO CAMPO DE TEXTO DE SENHA

		txfSenha = new JFXPasswordField();
		txfSenha.setLayoutX(150);
		txfSenha.setLayoutY(210);
		txfSenha.setStyle("-fx-font: 16px Arial;");

		// ADICIONANDO IMAGEM

		Image img = new Image(new FileInputStream("src/main/java/Imagem/Login.png"));

		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(100);
		imgView.setFitWidth(100);
		imgView.setLayoutX(200);
		imgView.setLayoutY(10);

		// CRIANDO BUTTON ENTRAR
				btnLogin = new JFXButton(Strings.login);
				btnLogin.setLayoutX(190);
				btnLogin.setLayoutY(270);

				btnLogin.setStyle("-fx-padding: 0.7em 0.57em;\r\n" + "    -fx-font-size: 14px;\r\n"
						+ "    -jfx-button-type: RAISED;\r\n" + "    -fx-background-color: rgb(77,102,204);\r\n"
						+ "    -fx-pref-width: 100;\r\n" + "    -fx-text-fill: WHITE;");
				
			btnLogin.setOnAction(e -> login(stage,txfUsuario.getText(), txfSenha.getText()));
		
		//Adicionando componentes no Pane
		pane.getChildren().add(txfSenha);
		pane.getChildren().add(lblUsuario);
		pane.getChildren().add(lblSenha);
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txfUsuario);
		pane.getChildren().add(imgView);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}
	
	private void login(Stage stage,String usuario, String senha) {
		
		if(usuario.trim().equals("admin") && senha.trim().equals("admin")) {
			try {
				new Principal().start(new Stage());
				stage.close();
			} catch (Exception e) {
				e.printStackTrace();
			};
			return;
		}
	
		if(!usuario.equals("admin") || senha.equals("admin")) {
			Alert mensagemAviso = new Alert(AlertType.WARNING);
			mensagemAviso.setTitle("WARNING");
			mensagemAviso.setHeaderText(Strings.usuarioIncorreto+" ou "+Strings.senhaIncorreta);
			mensagemAviso.showAndWait();
			return;
		}
	}
	

}
