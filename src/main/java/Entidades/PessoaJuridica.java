package Entidades;

public abstract class PessoaJuridica extends Pessoa{
	private String nomeFantasia;
	
	public PessoaJuridica(String nome, Endereco endereco, Documento documento, String nomeFantasia) {
		super(nome, endereco, documento);
		
		if(nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException("O nome fantasia não pode ser vazio");
		}
		
		
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		if(nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException("O nome fantasia não pode ser vazio");
		}
		this.nomeFantasia = nomeFantasia;
	}
	
}
