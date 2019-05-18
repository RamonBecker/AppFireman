package Entidades;



public class Endereco {

	private String rua, bairro, cidade, estado, cep;
	private int numero;

	public Endereco(String rua, String bairro, String cidade, String estado, String cep, int numero) {

		if(rua.isEmpty() || rua == null) {
			throw new IllegalArgumentException("A rua não pode ser vazio !");
		}
		
		if(bairro.isEmpty() || bairro == null) {
			throw new IllegalArgumentException("O bairro não pode ser vazio !");
		}
		
		if(cidade.isEmpty() || cidade == null) {
			throw new IllegalArgumentException("A cidade não pode ser vazio !");
		}
		
		if(estado.isEmpty() || estado == null) {
			throw new IllegalArgumentException("O Estado não pode ser vazio !");
		}
		
		if(cep.isEmpty() || cep == null) {
			throw new IllegalArgumentException("O CEP não pode ser vazio !");
		}
		
		if(numero <= 0) {
			throw new IllegalArgumentException("O numero não pode ser negativo !");
		}
		
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {

		if(rua.isEmpty() || rua == null) {
			throw new IllegalArgumentException("A rua não pode ser vazio !");
		}
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if(bairro.isEmpty() || bairro == null) {
			throw new IllegalArgumentException("O bairro não pode ser vazio !");
		}
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if(cidade.isEmpty() || cidade == null) {
			throw new IllegalArgumentException("A cidade não pode ser vazio !");
		}
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		if(estado.isEmpty() || estado == null) {
			throw new IllegalArgumentException("O Estado não pode ser vazio !");
		}
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		if(cep.isEmpty() || cep == null) {
			throw new IllegalArgumentException("O CEP não pode ser vazio !");
		}
		this.cep = cep;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if(numero <= 0) {
			throw new IllegalArgumentException("O numero não pode ser negativo !");
		}
		this.numero = numero;
	}

}
