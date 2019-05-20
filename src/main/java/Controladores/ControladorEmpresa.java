package Controladores;

import java.util.ArrayList;

import Alert.MessageAlert;
import Entidades.Empresa;
import Entidades.Strings;

public class ControladorEmpresa {
	ArrayList<Empresa> empresasCadastradas;
	
	public void cadastrarEmpresa(Empresa empresa) {
		empresasCadastradas = new ArrayList<Empresa>();
		empresasCadastradas.add(empresa);
		MessageAlert.mensagemRealizadoSucesso(Strings.mensagemEmpresa);
	}
}
