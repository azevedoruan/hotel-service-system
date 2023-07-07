package view;

import java.util.List;
import java.util.Scanner;

import modelo.Quarto;
import servicos.QuartoServico;
import view.exceptions.TelaException;

public class TelaConsultaQuartos extends Tela {

	private QuartoServico servico;
	private int numQuartoSelecionado = 0;
	
	public TelaConsultaQuartos() {
		servico = new QuartoServico();
	}
	
	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Quartos\n");
	}
	
	@Override
	public void conteudo() {
		if (numQuartoSelecionado != 0) {
			
			Quarto apto = servico.consultarQuartoPorNumero(numQuartoSelecionado);
			System.out.println("Numero: " + apto.getNumero());
			System.out.println("Descricao: " + apto.getDescricao());
			System.out.println("Capacidade maxima: " + apto.getCapacidadeMax());
			System.out.println("Classificacao: " + apto.getClassificacao().getDescricao());
			System.out.println("Preco unitario: " + apto.getClassificacao().getPrecoPorHospede());
		}
		else {
			List<Quarto> aptos = servico.consultarTodosQuartosCadastrados();
			for (Quarto ap : aptos) {
				System.out.println("Apto: " + String.format("%02d", ap.getNumero()) + ", classificacao: " + ap.getClassificacao().getDescricao() + ", preco unitario: R$" + ap.getClassificacao().getPrecoPorHospede());
			}
		}
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		try {
			if (numQuartoSelecionado != 0) {
				System.out.println("Pressiona qualquer tecla para voltar");
				numQuartoSelecionado = 0;
				sc.nextLine();
				sc.nextLine();
				return this;
			}
			
			int qtdeApto = servico.qtdeQuartosCadastrados();
			System.out.println("Selecione um quarto:");
			System.out.println("0 -> Voltar");
			int opcao = sc.nextInt();
			if (opcao == 0)
				return new TelaPrincipal();
			else if (opcao < 0 || opcao > qtdeApto)
				throw new TelaException("Erro de opcao. Valores validos vao de 0 a " + qtdeApto + " apenas.");
			
			numQuartoSelecionado = opcao;
			return this;
			
		} catch(RuntimeException e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println("\nSelecione qualquer tecla para confirmar");
			sc.nextLine();
			sc.nextLine();
			return this;
		}
	}

}
