package modelo;

import java.util.List;

public class Classificacao {
	
	private String descricao;
	private double precoPorHospede;
	private List<Quarto> quartos;
	
	public Classificacao() {}
	
	public Classificacao(String descricao, double precoPorHospede) {
		super();
		this.descricao = descricao;
		this.precoPorHospede = precoPorHospede;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoPorHospede() {
		return precoPorHospede;
	}

	public void setPrecoPorHospede(double precoPorHospede) {
		this.precoPorHospede = precoPorHospede;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}
	
	public void addQuarto(Quarto quarto) {
		quartos.add(quarto);
	}
}
