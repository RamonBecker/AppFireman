package Entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Alert.MessageAlert;
import javafx.scene.image.Image;


public class ControladorImagem {	
	
	
	public static Image carregarImagem(String url, String arquivo) {	
		try {
			Image image = new Image(new FileInputStream(url+arquivo));
			return image;
		} catch (FileNotFoundException e) {
			MessageAlert.mensagemErro(Strings.erroImagem);
			e.printStackTrace();
			return null;
		}
	}
}
