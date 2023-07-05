package repositorios;

import java.sql.Connection;
import java.util.List;

import modelo.Quarto;

public class QuartoDAO {

	private Connection conn;
	
	public QuartoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void inserir(Quarto obj) {
		//TODO
	}
	
	public List<Quarto> listarTodos() {
		//TODO
		return null;
	}
}
