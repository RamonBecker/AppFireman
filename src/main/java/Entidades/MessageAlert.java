package Entidades;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageAlert {
	
	public static void messageLogin() {
		Alert mensagemAviso = new Alert(AlertType.WARNING);
		mensagemAviso.setTitle("WARNING");
		mensagemAviso.setHeaderText(Strings.usuarioIncorreto + " ou " + Strings.senhaIncorreta);
		mensagemAviso.showAndWait();
	}
}
