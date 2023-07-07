package view;

import java.util.Scanner;

public class TelaCadastroCliente extends Tela {

	@Override
	public void cabecalho() {
		super.cabecalho();
		System.out.println("Cadastro de cliente\n");
	}
	
	@Override
	public void conteudo() {
		System.out.println("recebe dados do cliente");
		System.out.println("verifica existencia de cliente");
		System.out.println("se não existir, cadastra cliente");
	}

	@Override
	public Tela selecionarOpcao(Scanner sc) {
		System.out.println("\nPressione qualquer tecla para confirmar:");
		sc.nextLine();
		sc.nextLine();
		return new TelaPrincipal();
	}
}