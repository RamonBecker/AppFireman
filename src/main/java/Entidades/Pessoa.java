package Entidades;

public abstract class Pessoa {
	private String nome;
	private Endereco endereco;

	
	public Pessoa(String nome) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}

		this.nome = nome;
	}

	public Pessoa(String nome, Endereco endereco) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}

		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio");
		}
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio");
		}
		this.endereco = endereco;
	}


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco+ "]";
	}

}
