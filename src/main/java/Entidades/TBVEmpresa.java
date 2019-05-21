package Entidades;

import javafx.beans.property.SimpleStringProperty;

public class TBVEmpresa {
	private final SimpleStringProperty nome;
	private final SimpleStringProperty cnpj;
	
	public TBVEmpresa(String nome, String cnpj) {
		this.nome = new SimpleStringProperty(nome);
		this.cnpj = new SimpleStringProperty(cnpj);
	}

	public SimpleStringProperty getNome() {
		return nome;
	}

	public SimpleStringProperty getCnpj() {
		return cnpj;
	}
	
	
}	
