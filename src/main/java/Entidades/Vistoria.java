package Entidades;

import Alert.MessageAlert;

public class Vistoria implements Taxa, Pagamento {

	private Empresa empresa;
	private String vistoriador;
	private double taxaHabitese;
	private double taxaFuncionamento;
	private double areaTotalEdificacao;
	private double areaVistoriada;
	private String status;
	private String motivoIndeferido;
	private String dataVistoria;

	public Vistoria(Empresa empresa, String vistoriador, double areaTotalEdificacao, double areaVistoriada,
			String status, String dataVistoria) {

		if (empresa == null) {
			throw new IllegalArgumentException(Strings.empresaVazio);
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
		this.empresa = empresa;
		this.vistoriador = vistoriador;
		this.areaTotalEdificacao = areaTotalEdificacao;
		this.areaVistoriada = areaVistoriada;
		this.status = status;
		this.dataVistoria = dataVistoria;
	}

	public Vistoria(Empresa empresa, String vistoriador, double areaTotalEdificacao, double areaVistoriada,
			String status, String motivoIndeferido, String dataVistoria) {

		if (empresa == null) {
			throw new IllegalArgumentException(Strings.empresaVazio);
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
		this.empresa = empresa;
		this.vistoriador = vistoriador;
		this.areaTotalEdificacao = areaTotalEdificacao;
		this.areaVistoriada = areaVistoriada;
		this.status = status;
		this.motivoIndeferido = motivoIndeferido;
		this.dataVistoria = dataVistoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		if (empresa == null) {
			throw new IllegalArgumentException(Strings.empresaVazio);
		}
		this.empresa = empresa;
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

	public void pagarBoleto(double valor, String data) {
	}

	public void taxaFuncionamento() {

		if (this.areaVistoriada > 100) {

			this.taxaFuncionamento = (this.areaVistoriada * 0.40);
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemTaxaGerada+" "+Strings.de+" "+Strings.funcionamento);
		} else {
			MessageAlert.mensagemRealizadoSucesso(
					Strings.mensagemTaxaMinima + " " + Strings.de + " " + Strings.funcionamento);
			this.taxaFuncionamento = 40;
		}
	}

	public void taxaHabitese() {

		taxaFuncionamento();

		if (this.areaTotalEdificacao > 100) {
			this.taxaHabitese = (this.areaTotalEdificacao * 0.69);
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemTaxaGerada+" "+Strings.de+" "+Strings.habitese);
		} else {
			this.areaTotalEdificacao = 69;
			MessageAlert
					.mensagemRealizadoSucesso(Strings.mensagemTaxaMinima + " " + Strings.de + " " + Strings.habitese);
		}
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

	@Override
	public String toString() {
		return "Vistoria [empresa=" + empresa + ", vistoriador=" + vistoriador + ", taxaHabitese=" + taxaHabitese
				+ ", taxaFuncionamento=" + taxaFuncionamento + ", areaTotalEdificacao=" + areaTotalEdificacao
				+ ", areaVistoriada=" + areaVistoriada + ", status=" + status + ", motivoIndeferido=" + motivoIndeferido
				+ ", dataVistoria=" + dataVistoria + "]";
	}
	
	
}
