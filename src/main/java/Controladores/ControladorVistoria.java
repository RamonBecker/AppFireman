package Controladores;

import java.util.ArrayList;

import Alert.MessageAlert;
import Entidades.Strings;
import Entidades.Vistoria;

public class ControladorVistoria {

	private ArrayList<Vistoria> vistoria;
	public static ControladorVistoria controladorVistoria;

	public ControladorVistoria() {
		vistoria = new ArrayList<Vistoria>();
	}

	public static synchronized ControladorVistoria getInstance() {
		if (controladorVistoria == null) {
			controladorVistoria = new ControladorVistoria();
		}
		return controladorVistoria;

	}

	public void cadastrarVistoria(Vistoria vistoria) {
		this.vistoria.add(vistoria);
		MessageAlert.mensagemRealizadoSucesso(Strings.mensagemVistoriaCadastrada);
	}

	public ArrayList<Vistoria> getVistoria() {
		return vistoria;
	}

}
