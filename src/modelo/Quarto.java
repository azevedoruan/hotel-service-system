package modelo;

import enums.StatusQuarto;

public class Quarto {
	
	private Integer numero;
	private StatusQuarto status;
	private String descricao;
	private int capacidadeMax;
	private Classificacao classificacao;
	
	public Quarto() {}
	
	public Quarto(Integer numero, StatusQuarto status, String descricao, int capacidadeMax, Classificacao classificacao) {
		super();
		this.numero = numero;
		this.status = status;
		this.descricao = descricao;
		this.capacidadeMax = capacidadeMax;
		this.classificacao = classificacao;
	}

	public Quarto(Integer numero, StatusQuarto status, int capacidadeMax, Classificacao classificacao) {
		super();
		this.numero = numero;
		this.status = status;
		this.capacidadeMax = capacidadeMax;
		this.classificacao = classificacao;
	}

	public StatusQuarto getStatus() {
		return status;
	}
	public void setStatus(StatusQuarto status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCapacidadeMax() {
		return capacidadeMax;
	}
	public void setCapacidadeMax(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}
	public Integer getNumero() {
		return numero;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
}
