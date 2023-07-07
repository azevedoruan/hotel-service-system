package view;

import java.util.Scanner;

import view.exceptions.TelaException;

public class TelaConsultas extends Tela{
	
	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Consultas\n");
	}
	
	@Override
	public void conteudo() {
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		try {
			System.out.println("Selecione uma opção para consultar:");
			System.out.println("1 -> Quartos");
			System.out.println("2 -> Clientes cadastrados");
			System.out.println("0 -> Voltar");
			int opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				return new TelaConsultaQuartos();
			case 2:
				return new TelaConsultaClientes();
			case 0:
				return new TelaPrincipal();
			default:
				throw new TelaException("Erro de opcao. Valores validos vao de 0 a 2 apenas.");
			}
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("\nSelecione qualquer tecla para confirmar");
			sc.nextLine();
			sc.nextLine();
			return this;
		}
	}
}
