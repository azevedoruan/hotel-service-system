package controle;

import java.util.List;

import database.DB;
import modelo.ClienteFisico;
import modelo.Quarto;
import repositorios.ClienteFisicoDAO;
import repositorios.QuartoDAO;

public class ControladorHotel {

	private static ControladorHotel controladorHotelInstancia; // Singleton Pattern
	
	QuartoDAO quartoDAO;
	ClienteFisicoDAO clienteFisicoDAO;
	
	private ControladorHotel() {
		quartoDAO = new QuartoDAO(DB.getConnection());
		clienteFisicoDAO = new ClienteFisicoDAO(DB.getConnection());
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
	
	public List<ClienteFisico> consultarTodosClientesFisicosCadastrados() {
		return clienteFisicoDAO.consultarTodos();
	}
}
