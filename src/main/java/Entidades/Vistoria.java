package Entidades;

import Alert.MessageAlert;

public class Vistoria implements Taxa {

	private Empresa empresa;
	private String vistoriador;
	private double taxaVistoria;
	private double areaTotalEdificacao;
	private double areaVistoriada;

	public Vistoria(Empresa empresa, String vistoriador) {

		if (empresa == null) {
			throw new IllegalArgumentException("A empresa não pode ser vazio");
		}

		if (vistoriador.isEmpty() || vistoriador == null) {
			throw new IllegalArgumentException("O vistoriador não pode ser vazio");
		}

		this.empresa = empresa;
		this.vistoriador = vistoriador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		if (empresa == null) {
			throw new IllegalArgumentException("A empresa não pode ser vazio");
		}
		this.empresa = empresa;
	}

	public String getVistoriador() {
		return vistoriador;
	}

	public void setVistoriador(String vistoriador) {

		if (vistoriador.isEmpty() || vistoriador == null) {
			throw new IllegalArgumentException("O vistoriador não pode ser vazio");
		}
		this.vistoriador = vistoriador;
	}

	@Override
	public void pagarBoleto(double valor, String data) {

	}

	@Override
	public void taxaFuncionamento() {

		if (this.areaVistoriada > 100) {

			this.taxaVistoria = (this.areaVistoriada * 0.40);
		}else {
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemTaxaMinima+" "+Strings.de+" "+Strings.funcionamento);
			this.taxaVistoria = 40;
		}
	}

	@Override
	public void taxaHabitese() {
		if(this.areaTotalEdificacao > 100) {
			this.areaTotalEdificacao = (this.areaTotalEdificacao * 0.69);
		}else {
			this.areaTotalEdificacao = 69;
			MessageAlert.mensagemRealizadoSucesso(Strings.mensagemTaxaMinima+" "+Strings.de+" "+Strings.habitese);
		}
	}

	public double getTaxaVistoria() {
		return taxaVistoria;
	}

	public void setTaxaVistoria(double taxaVistoria) {
		if(taxaVistoria <= 0) {
			
		}
		this.taxaVistoria = taxaVistoria;
	}

	public double getAreaTotalEdificacao() {
		return areaTotalEdificacao;
	}

	public void setAreaTotalEdificacao(double areaTotalEdificacao) {
		this.areaTotalEdificacao = areaTotalEdificacao;
	}

	public double getAreaVistoriada() {
		return areaVistoriada;
	}

	public void setAreaVistoriada(double areaVistoriada) {
		this.areaVistoriada = areaVistoriada;
	}
	
	
}
