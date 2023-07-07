package view;

import java.util.Scanner;

import view.exceptions.TelaException;

public class TelaCadastros extends Tela {

	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Cadastros\n");
	}
	
	@Override
	public void conteudo() {
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		try {
			System.out.println("Selecione uma opção para cadastro:");
			System.out.println("1 -> Cliente");
			System.out.println("2 -> Empresa");
			System.out.println("3 -> Quarto");
			System.out.println("0 -> Voltar");
			int opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				return new TelaCadastroCliente();
			case 2:
				return new TelaCadastroEmpresa();
			case 3:
				throw new TelaException("Opcao indisponivel");
			case 0:
				return new TelaPrincipal();
			default:
				throw new TelaException("Erro de opcao. Valores validos vao de 0 a 3 apenas.");
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
