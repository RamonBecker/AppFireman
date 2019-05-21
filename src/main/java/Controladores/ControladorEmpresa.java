package Controladores;

import java.util.ArrayList;
import java.util.Iterator;

import Alert.MessageAlert;
import Entidades.Empresa;
import Entidades.Strings;

public class ControladorEmpresa {
	public  ArrayList<Empresa> empresasCadastradas;
	public static ControladorEmpresa controladorEmpresa;	
	public  ControladorEmpresa() {
		this.empresasCadastradas = new ArrayList<Empresa>();
	}
	
	public static synchronized ControladorEmpresa getInstance() {
		if(controladorEmpresa == null) {
			controladorEmpresa = new ControladorEmpresa();
		}
		
		return controladorEmpresa;
		
	}
	
	public  void cadastrarEmpresa(Empresa empresa) {
		empresasCadastradas.add(empresa);
		MessageAlert.mensagemRealizadoSucesso(Strings.mensagemEmpresa);
		System.out.println(empresasCadastradas);
	}

	public String buscarEmpresa(String empresa) {
		for (Empresa auxEmpresa : empresasCadastradas) {
			 if(auxEmpresa.getNome().equals(empresa)) {
				 return empresa;
			 }
		}
		return null;
	}
	
	public  ArrayList<Empresa> getEmpresasCadastradas() {
		return empresasCadastradas;
	}
}
