package view;

import java.util.List;

import modelo.Quarto;

public class TelaPrincipal {

	public void printBoasVindas() {
		System.out.println("================== HOTEL SERVICE v1.0.0 ==================");
	}
	
	public void printListaDeQuartos(List<Quarto> lista) {
		System.out.println("Quartos");
		for (Quarto apto : lista) {
			System.out.println("Apto: " + apto.getNumero() + " " + apto.getStatus().toString());
		}
	}
}
