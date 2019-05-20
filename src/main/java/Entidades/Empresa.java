package Entidades;

public class Empresa extends PessoaJuridica{
	
	private String telefone;
	
	public Empresa(String nome, Endereco endereco, Documento documento, String nomeFantasia) {
		super(nome, endereco, documento, nomeFantasia);
	}

	public Empresa(String nome, Endereco endereco, Documento documento, String nomeFantasia,
			String telefone) {
		super(nome, endereco, documento, nomeFantasia);
		if(telefone == null || telefone.isEmpty()) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone == null || telefone.isEmpty()) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}
}
