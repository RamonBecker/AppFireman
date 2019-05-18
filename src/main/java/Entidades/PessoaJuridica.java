package Entidades;

public abstract class PessoaJuridica extends Pessoa{
	private String nomeFantasia;
	private String razaoSocial;
	
	public PessoaJuridica(String nome, Endereco endereco, Documento documento, String nomeFantasia,
			String razaoSocial) {
		super(nome, endereco, documento);
		
		if(nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException("O nome fantasia não pode ser vazio");
		}
		
		
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		if(razaoSocial.isEmpty() || razaoSocial == null) {
			throw new IllegalArgumentException("A razão social não pode ser vazio");
		}
		this.razaoSocial = razaoSocial;
	}
	
	
}
