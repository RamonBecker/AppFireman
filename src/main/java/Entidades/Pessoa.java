package Entidades;


public abstract class Pessoa {
	private String nome;
	private Endereco endereco;
	private Documento documento;
	
	
	public Pessoa(String nome, Endereco endereco, Documento documento) {
		if(nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}
		
		if(endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio");
		}
		
		if(documento == null) {
			throw new IllegalArgumentException("O documento não pode ser vazio");
		}
		
		this.nome = nome;
		this.endereco = endereco;
		this.documento = documento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		if(endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio");
		}
		this.endereco = endereco;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		if(documento == null) {
			throw new IllegalArgumentException("O documento não pode ser vazio");
		}
		
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", documento=" + documento + "]";
	}
	
}
