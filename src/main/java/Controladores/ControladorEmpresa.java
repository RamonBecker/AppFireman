package Controladores;

import java.util.ArrayList;
import java.util.Iterator;

import Alert.MessageAlert;
import Entidades.Empresa;
import Entidades.Strings;

public class ControladorEmpresa {
	private int posicao;
	private ArrayList<Empresa> empresasCadastradas;
	public static ControladorEmpresa controladorEmpresa;

	public ControladorEmpresa() {
		this.empresasCadastradas = new ArrayList<Empresa>();
	}

	public static synchronized ControladorEmpresa getInstance() {
		if (controladorEmpresa == null) {
			controladorEmpresa = new ControladorEmpresa();
		}

		return controladorEmpresa;

	}

	public void cadastrarEmpresa(Empresa empresa) {
		empresasCadastradas.add(empresa);
		MessageAlert.mensagemRealizadoSucesso(Strings.mensagemEmpresa);
	}

	public boolean buscarEmpresa(String nome) {
		int cont = 0;

		for (Empresa auxEmpresa : empresasCadastradas) {
			if (auxEmpresa.getNome().equals(nome)) {
				this.posicao = cont;
				return true;
			}
			cont++;
		}
		return false;
	}

	public ArrayList<Empresa> getEmpresasCadastradas() {
		return empresasCadastradas;
	}

	public int getPosicao() {
		return posicao;
	}
}
