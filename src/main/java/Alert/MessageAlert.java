package Alert;

import Entidades.Strings;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageAlert {
	
	public static void messageLogin() {
		Alert mensagemAviso = new Alert(AlertType.WARNING);
		mensagemAviso.setTitle(Strings.aviso);
		mensagemAviso.setHeaderText(Strings.usuarioIncorreto + " ou " + Strings.senhaIncorreta);
		mensagemAviso.show();
	}
	
	public static void mensagemRealizadoSucesso(String mensagem) {
		Alert mensagemAlert = new Alert(AlertType.INFORMATION);
		mensagemAlert.setHeaderText(mensagem);
		mensagemAlert.show();
	}
	
	public static void mensagemErro(String mensagem) {
		Alert mensagemErro = new Alert(AlertType.ERROR);
		mensagemErro.setTitle(Strings.erro);
		mensagemErro.setHeaderText(mensagem);
		mensagemErro.show();;
	}
}
