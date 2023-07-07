package servicos;

import java.util.List;

import database.DB;
import modelo.Quarto;
import repositorios.QuartoDAO;

public class QuartoServico {

	QuartoDAO quartoDAO;
	
	public QuartoServico() {
		if (quartoDAO == null)
			quartoDAO = new QuartoDAO(DB.getConnection());
	}
	
	public Quarto consultarQuartoPorNumero(Integer num) {
		return quartoDAO.encontrarPorNumero(num);
	}
	
	public List<Quarto> consultarTodosQuartosCadastrados() {
		return quartoDAO.encontrarTodos();
	}
	
	public int qtdeQuartosCadastrados() {
		return quartoDAO.encontrarTodos().size();
	}
}
