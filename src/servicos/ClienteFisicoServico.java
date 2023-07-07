package servicos;

import java.util.List;

import database.DB;
import modelo.ClienteFisico;
import repositorios.ClienteFisicoDAO;

public class ClienteFisicoServico {

	ClienteFisicoDAO clienteFisicoDAO;
	
	public ClienteFisicoServico() {
		if (clienteFisicoDAO == null)
			clienteFisicoDAO = new ClienteFisicoDAO(DB.getConnection());
	}
	
	public List<ClienteFisico> consultarTodosClientesFisicosCadastrados() {
		return clienteFisicoDAO.consultarTodos();
	}
}
