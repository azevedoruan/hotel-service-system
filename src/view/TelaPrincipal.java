package view;

import java.util.Scanner;

import view.exceptions.TelaException;

public class TelaPrincipal extends Tela {
	
	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Home\n");
	}
	
	@Override
	public void conteudo() {		
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		
		try {
			System.out.println("Selecione uma opção:");
			System.out.println("1 -> Consultas");
			System.out.println("2 -> Cadastros");
			System.out.println("3 -> Fazer reserva");
			System.out.println("4 -> Fazer check-in");
			System.out.println("5 -> Fazer check-out");
			System.out.println("0 -> Sair");
			int opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				return new TelaConsultas();
			case 2:
				return new TelaCadastros();
			case 3:
				return new TelaFazerReserva();
			case 4:
				return new TelaFazerCheckin();
			case 5:
				throw new TelaException("Opcao indisponivel");
			case 0:
				return null;
			default:
				throw new TelaException("Erro de opcao. Valores validos vao de 0 a 5 apenas.");
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