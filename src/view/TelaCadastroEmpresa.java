package view;

import java.util.Scanner;

public class TelaCadastroEmpresa extends Tela {

	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Cadastro de empresa\n");
	}
	
	@Override
	public void conteudo() {
		System.out.println("recebe dados da empresa");
		System.out.println("verifica existencia da empresa");
		System.out.println("se não existir, cadastra empresa");
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		System.out.println("\nPressione qualquer tecla para confirmar:");
		sc.nextLine();
		sc.nextLine();
		return new TelaPrincipal();
	}
}
