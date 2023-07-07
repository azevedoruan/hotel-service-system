package view;

import java.util.Scanner;

public abstract class Tela {

	public void cabecalho() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\n==================== HOTEL SERVICE v1.0 ====================\n");
	}
	
	public abstract void conteudo();
	
	public abstract Tela selecionarOpcao(Scanner sc);
}
