package Entidades;

public class Empresa extends PessoaJuridica{
	
	private int telefone;
	
	public Empresa(String nome, Endereco endereco, Documento documento, String nomeFantasia, String razaoSocial) {
		super(nome, endereco, documento, nomeFantasia, razaoSocial);
	}

	public Empresa(String nome, Endereco endereco, Documento documento, String nomeFantasia, String razaoSocial,
			int telefone) {
		super(nome, endereco, documento, nomeFantasia, razaoSocial);
		if(telefone < 0) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		if(telefone < 0) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}
}
