package repositorios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enums.StatusQuarto;
import modelo.Classificacao;
import modelo.Quarto;

public class QuartoDAO {

	public List<Quarto> listarTodos() {
		Quarto apto1 = new Quarto(1, StatusQuarto.DISPONIVEL, 2, new Classificacao("Completo", 110.00));
		Quarto apto2 = new Quarto(2, StatusQuarto.DISPONIVEL, 1, new Classificacao("Completo", 110.00));
		List<Quarto> quartos = new ArrayList<>();
		quartos.addAll(Arrays.asList(apto1, apto2));
		
		return quartos;
	}
}
