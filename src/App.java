import java.util.List;

import modelo.Quarto;
import repositorios.QuartoDAO;
import view.TelaPrincipal;

public class App {

	public static void main(String[] args) {
		
		TelaPrincipal mainScreen = new TelaPrincipal();
		QuartoDAO quartoDAO = new QuartoDAO();
		
		List<Quarto> quartos = quartoDAO.listarTodos();
		
		mainScreen.printBoasVindas();
		mainScreen.printListaDeQuartos(quartos);
		
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