package view;

import java.util.Scanner;

import view.exceptions.TelaException;

public class TelaFazerReserva extends Tela {

	private int numQuartoSelecionado = 0;
	
	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Fazer Reserva\n");
	}
	
	@Override
	public void conteudo() {
		
		if (numQuartoSelecionado != 0) {
			System.out.println("Descreve quarto selecionado " + numQuartoSelecionado + "\n");
		} else {
			System.out.println("recebe uma data valida");
			System.out.println("lista disponibilidades de quartos na data referida\n");
		}
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		try {
			if (numQuartoSelecionado != 0) {
				
				System.out.println("Cliente ja cadastrado (s/n)?");
				sc.nextLine();
				char resp = sc.nextLine().charAt(0);
				
				if (resp == 's') {
					System.out.println("receber cpf ou cnpj cliente");
					
					System.out.println("verificar cpf");
					System.out.println("se cpf for valido, consultar cliente");
					System.out.println("preencher os dados do cliente na reserva");
					
					System.out.println("verificar cnpj");
					System.out.println("se cnpj for valido, consultar empresa");
					System.out.println("preencher os dados do funcionario da empresa na reserva");
				} else {
					System.out.println("Preencher os dados:");
					System.out.println("nome");
					System.out.println("telefone");
					System.out.println("quantidade de pessoas");
					System.out.println("data para check-in");
				}
				
				numQuartoSelecionado = 0;
				System.out.println("\nSelecione qualquer tecla para confirmar");
				sc.nextLine();
				return this;
			}
			System.out.println("Selecione um quarto DISPONIVEL:");
			System.out.println("0 -> Cancelar");
			int opcao = sc.nextInt();
			
			if (opcao == 0)
				return new TelaPrincipal();
			else if (opcao < 0 || opcao > 16)
				throw new TelaException("Erro de opcao. Valores validos vao de 0 a 16 apenas.");
			
			numQuartoSelecionado = opcao;
			return this;
			
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("\nSelecione qualquer tecla para confirmar");
			sc.nextLine();
			sc.nextLine();
			return this;
		}
	}
}
