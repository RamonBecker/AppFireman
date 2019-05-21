package Entidades;

public class Empresa extends PessoaJuridica {

	private String telefone;

	public Empresa(String nome, Endereco endereco, String nomeFantasia) {
		super(nome, endereco, nomeFantasia);
	}

	public Empresa(String nome, Endereco endereco, String nomeFantasia, String telefone) {
		super(nome, endereco, nomeFantasia);
		if (telefone == null || telefone.isEmpty()) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}

	public Empresa(String nome, Endereco endereco, String nomeFantasia, String cnpj, String telefone) throws Exception {
		super(nome, endereco, nomeFantasia, cnpj);
		if (telefone == null || telefone.isEmpty()) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone == null || telefone.isEmpty()) {
			throw new IllegalArgumentException("O numero do telefone não pode ser negativo");
		}
		this.telefone = telefone;
	}

	
	
	
	public Empresa(String nome, String cnpj) throws Exception {
		super(nome, cnpj);
	}

	@Override
	public String toString() {
		return "Empresa [telefone=" + telefone + "]";
	}

}
