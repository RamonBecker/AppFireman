package Entidades;

public abstract class Pessoa {
	private String nome;
	private Endereco endereco;

	
	public Pessoa(String nome) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException(Strings.nomeVazio);
		}

		this.nome = nome;
	}

	public Pessoa(String nome, Endereco endereco) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException(Strings.nomeVazio);
		}

		if (endereco == null) {
			throw new IllegalArgumentException(Strings.enderecoVazio);
		}
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException(Strings.nomeVazio);
		}
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException(Strings.enderecoVazio);
		}
		this.endereco = endereco;
	}

}
