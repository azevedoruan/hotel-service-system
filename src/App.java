import java.util.Scanner;

import view.Tela;
import view.TelaPrincipal;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Tela tela = new TelaPrincipal();
		
		while(tela != null) {
			tela.cabecalho();
			tela.conteudo();
			tela = tela.selecionarOpcao(sc);
		}
	}
}