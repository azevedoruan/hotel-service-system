package controle;

import java.util.List;

import database.DB;
import modelo.Quarto;
import repositorios.QuartoDAO;

public class ControladorHotel {

	private static ControladorHotel controladorHotelInstancia; // Singleton Pattern
	
	QuartoDAO quartoDAO;
	
	private ControladorHotel() {
		quartoDAO = new QuartoDAO(DB.getConnection());
	}
	
	public static synchronized ControladorHotel getInstancia() {
		if (controladorHotelInstancia == null)
			controladorHotelInstancia = new ControladorHotel();
		
		return controladorHotelInstancia;
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
