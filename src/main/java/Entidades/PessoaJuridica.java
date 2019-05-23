package Entidades;

import Alert.MessageAlert;

public abstract class PessoaJuridica extends Pessoa {
	private String nomeFantasia;
	private String cnpj;
	

	public PessoaJuridica(String nome, String cnpj)  {
		super(nome);
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String nome, Endereco endereco, String nomeFantasia, String cnpj) throws Exception {
		super(nome, endereco);
		
		if (nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException(Strings.nomeFantasiaVazio);
		}
		
		if(cnpj.trim().length() == 14) {
			if(ValidadorDocumento.validarCNPJ(cnpj)) {
				MessageAlert.mensagemRealizadoSucesso(Strings.mensagemCNPJ);
				this.cnpj = cnpj;
			}else {
				throw new Exception(Strings.cnpjInvalido);
			}
		}
		
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public PessoaJuridica(String nome, String nomeFantasia, String cnpj) throws Exception {
		super(nome);
	
		if (nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException(Strings.nomeFantasiaVazio);
		}
		
		if(cnpj.trim().length() == 14) {
			if(ValidadorDocumento.validarCNPJ(cnpj)) {
				MessageAlert.mensagemRealizadoSucesso(Strings.mensagemCNPJ);
				this.cnpj = cnpj;
			}else {
				throw new Exception(Strings.cnpjInvalido);
			}
		}
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}
	
	public PessoaJuridica(String nome, Endereco endereco, String nomeFantasia) {
		super(nome, endereco);

		if (nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException(Strings.nomeFantasiaVazio);
		}
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		if (nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException(Strings.nomeFantasiaVazio);
		}
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) throws Exception {
		
		if(cnpj.trim().length() == 14) {
			if(ValidadorDocumento.validarCNPJ(cnpj)) {
				MessageAlert.mensagemRealizadoSucesso(Strings.mensagemCNPJ);
				this.cnpj = cnpj;
			}else {
				throw new Exception(Strings.cnpjInvalido);
			}
		}
		this.cnpj = cnpj;
	}
}
