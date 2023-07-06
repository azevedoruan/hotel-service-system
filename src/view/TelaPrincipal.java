package view;

import java.util.List;

import modelo.Quarto;

public class TelaPrincipal {

	public void printBoasVindas() {
		System.out.println("================== HOTEL SERVICE v1.0.0 ==================");
	}
	
	public void listarQuartosComStatus(List<Quarto> lista) {
		System.out.println("QUARTOS");
		for (Quarto apto : lista) {
			System.out.println("Apto: " + String.format("%02d", apto.getNumero()) + " " + apto.getStatus().toString());
		}
	}
}
