package view;

import java.util.Scanner;

import view.exceptions.TelaException;

public class TelaFazerCheckin extends Tela {

private int numQuartoSelecionado = 0;
	
	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Fazer checkin\n");
	}
	
	@Override
	public void conteudo() {
		
		if (numQuartoSelecionado != 0) {
			System.out.println("Descreve quarto selecionado " + numQuartoSelecionado + "\n");
		} else {
			System.out.println("lista disponibilidades de quartos na data atual\n");
		}
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		try {
			if (numQuartoSelecionado != 0) {
				
				System.out.println("receber cpf do cliente");
				
				System.out.println("verificar cpf");
				System.out.println("se cpf for valido, consultar cliente");
				System.out.println("se cliente ja e cadastrado, preencher datas no checkin e associalo ao cliente");
					
				System.out.println("se cliente não for cadastrado, cadastrar cliente");
				
				numQuartoSelecionado = 0;
				System.out.println("\nSelecione qualquer tecla para confirmar");
				sc.nextLine();
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
