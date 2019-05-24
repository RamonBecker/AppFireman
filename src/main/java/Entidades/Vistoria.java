package Entidades;

import Alert.MessageAlert;

public class Vistoria implements Taxa, Pagamento {

	private String nome;
	private String cnpj;
	private Endereco endereco;
	private String vistoriador;
	private Double taxaHabitese;
	private Double taxaFuncionamento;
	private double areaTotalEdificacao;
	private double areaVistoriada;
	private String status;
	private String motivoIndeferido;
	private String dataVistoria;

	public Vistoria(String nome, String cnpj, Endereco endereco, String vistoriador, double areaTotalEdificacao,
			double areaVistoriada, String status, String dataVistoria) {

		if (endereco == null) {
			throw new IllegalArgumentException(Strings.enderecoVazio);
		}

		if (vistoriador.isEmpty() || vistoriador == null) {
			throw new IllegalArgumentException(Strings.vistoriadorVazio);
		}

		if (areaTotalEdificacao < 0) {
			throw new IllegalArgumentException(Strings.erroAreaTotalEdificacao);
		}

		if (areaVistoriada < 0) {
			throw new IllegalArgumentException(Strings.erroAreaVistoria);
		}

		if (status == null || status.isEmpty()) {
			throw new IllegalArgumentException(Strings.erroStatus);
		}

		if (dataVistoria.isEmpty() || dataVistoria == null) {
			throw new IllegalArgumentException(Strings.erroDataVazio);
		}

		taxaHabitese();
		this.endereco = endereco;
		this.vistoriador = vistoriador;
		this.areaTotalEdificacao = areaTotalEdificacao;
		this.areaVistoriada = areaVistoriada;
		this.status = status;
		this.dataVistoria = dataVistoria;
		this.cnpj = cnpj;
		this.nome = nome;
	}

	public Vistoria(String nome, String cnpj, Endereco endereco, String vistoriador, double areaTotalEdificacao,
			double areaVistoriada, String status, String motivoIndeferido, String dataVistoria) {

		if (endereco == null) {
			throw new IllegalArgumentException(Strings.enderecoVazio);
		}

		if (vistoriador.isEmpty() || vistoriador == null) {
			throw new IllegalArgumentException(Strings.vistoriadorVazio);
		}

		if (areaTotalEdificacao < 0) {
			throw new IllegalArgumentException(Strings.erroAreaTotalEdificacao);
		}

		if (areaVistoriada < 0) {
			throw new IllegalArgumentException(Strings.erroAreaVistoria);
		}

		if (status == null || status.isEmpty()) {
			throw new IllegalArgumentException(Strings.erroStatus);
		}

		if (motivoIndeferido.isEmpty() || motivoIndeferido == null) {
			throw new IllegalArgumentException(Strings.erroMotivo);
		}

		if (dataVistoria.isEmpty() || dataVistoria == null) {
			throw new IllegalArgumentException(Strings.erroDataVazio);
		}

		taxaHabitese();
		this.endereco = endereco;
		this.vistoriador = vistoriador;
		this.areaTotalEdificacao = areaTotalEdificacao;
		this.areaVistoriada = areaVistoriada;
		this.status = status;
		this.motivoIndeferido = motivoIndeferido;
		this.dataVistoria = dataVistoria;
		this.cnpj = cnpj;
		this.nome = nome;
	}

	public String getVistoriador() {
		return vistoriador;
	}

	public void setVistoriador(String vistoriador) {

		if (vistoriador.isEmpty() || vistoriador == null) {
			throw new IllegalArgumentException(Strings.vistoriadorVazio);
		}
		this.vistoriador = vistoriador;
	}

	public void taxaFuncionamento() {

		if (this.areaVistoriada > 100) {

			this.taxaFuncionamento = (this.areaVistoriada * 0.40);
			MessageAlert.mensagemRealizadoSucesso(
					Strings.mensagemTaxaGerada + " " + Strings.de + " " + Strings.funcionamento);
		} else {
			MessageAlert.mensagemRealizadoSucesso(
					Strings.mensagemTaxaMinima + " " + Strings.de + " " + Strings.funcionamento);
			this.taxaFuncionamento = 40.0;
		}
	}

	public void taxaHabitese() {

		taxaFuncionamento();

		if (this.areaTotalEdificacao > 100) {
			this.taxaHabitese = (this.areaTotalEdificacao * 0.69);
			MessageAlert
					.mensagemRealizadoSucesso(Strings.mensagemTaxaGerada + " " + Strings.de + " " + Strings.habitese);
		} else {
			this.taxaHabitese = 69.0;
			MessageAlert
					.mensagemRealizadoSucesso(Strings.mensagemTaxaMinima + " " + Strings.de + " " + Strings.habitese);
		}
	}

	public void pagarFuncionamento(double valor) {
		this.taxaFuncionamento = valor - taxaFuncionamento;
	}
	
	public void pagarHabitese(double valor) {
		this.taxaHabitese = valor - taxaHabitese;
	}
	
	
	
	public double getTaxaHabitese() {
		return taxaHabitese;
	}

	public double getTaxaFuncionamento() {
		return taxaFuncionamento;
	}

	public double getAreaTotalEdificacao() {
		return areaTotalEdificacao;
	}

	public void setAreaTotalEdificacao(double areaTotalEdificacao) {

		if (areaTotalEdificacao < 0) {
			throw new IllegalArgumentException(Strings.erroAreaTotalEdificacao);
		}

		this.areaTotalEdificacao = areaTotalEdificacao;
	}

	public double getAreaVistoriada() {
		return areaVistoriada;
	}

	public void setAreaVistoriada(double areaVistoriada) {
		if (areaVistoriada < 0) {
			throw new IllegalArgumentException(Strings.erroAreaVistoria);
		}
		this.areaVistoriada = areaVistoriada;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {

		if (status == null || status.isEmpty()) {
			throw new IllegalArgumentException(Strings.erroStatus);
		}

		this.status = status;
	}

	public String getMotivoIndeferido() {
		return motivoIndeferido;
	}

	public void setMotivoIndeferido(String motivoIndeferido) {

		if (motivoIndeferido.isEmpty() || motivoIndeferido == null) {
			throw new IllegalArgumentException(Strings.erroMotivo);
		}

		this.motivoIndeferido = motivoIndeferido;
	}

	public String getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(String dataVistoria) {
		if (dataVistoria.isEmpty() || dataVistoria == null) {
			throw new IllegalArgumentException(Strings.erroDataVazio);
		}
		this.dataVistoria = dataVistoria;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	
}
