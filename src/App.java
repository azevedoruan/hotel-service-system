import java.util.List;

import database.DB;
import modelo.Quarto;
import repositorios.QuartoDAO;
import view.TelaPrincipal;

public class App {

	public static void main(String[] args) {
		
		TelaPrincipal mainScreen = new TelaPrincipal();
		QuartoDAO quartoDAO = new QuartoDAO(DB.getConnection());
		
		List<Quarto> quartos = quartoDAO.encontrarTodos();
		
		mainScreen.printBoasVindas();
		mainScreen.listarQuartosComStatus(quartos);
		
		// tela principal
		// boas vindas
		// lista de quartos com status do momento
		// OPÇÕES:
		// consultar quartos
		// escolher quartos
		// cadastrar cliente
		// exit
	}
}