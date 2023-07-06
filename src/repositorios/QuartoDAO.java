package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DB;
import database.DbException;
import enums.StatusQuarto;
import modelo.Classificacao;
import modelo.Quarto;

public class QuartoDAO {

	private Connection conn;
	
	public QuartoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void inserir(Quarto obj) {
		
		PreparedStatement pst = null;
		
		try {
			conn.setAutoCommit(false);
			
			pst = conn.prepareStatement("INSERT INTO QUARTO"
					+ "(numero, fk_descClassificacao, statusQuarto, descricao, capacidadeMax)"
					+ "VALUES(?, ?, ?, ?, ?)");
			
			pst.setInt(1, obj.getNumero());
			pst.setString(2, obj.getClassificacao().getDescricao());
			pst.setString(3, obj.getStatus().toString());
			pst.setString(4, obj.getDescricao());
			pst.setInt(5, obj.getCapacidadeMax());
			
			int rowsAffected = pst.executeUpdate();
			
			if (rowsAffected == 0)
				throw new DbException("Unexpected error! No rows affected");
			
			conn.setAutoCommit(true);
			
		} catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back caused by " + e.getMessage());
			} catch(SQLException rollBackError) {
				throw new DbException("Error trying to rollback caused by " + rollBackError.getMessage());
			}
		} finally {
			DB.closeStatement(pst);
		}
	}
	
	public List<Quarto> encontrarTodos() {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			pst = conn.prepareStatement("SELECT Q.*, C.*"
					+ "FROM QUARTO Q INNER JOIN CLASSIFICACAO C ON(Q.fk_descClassificacao = C.descricao)"
					+ "ORDER BY Q.numero");
			
			rs = pst.executeQuery();
			List<Quarto> quartos = new ArrayList<>();
			Map<String, Classificacao> classificacoes = new HashMap<>();
			
			while (rs.next()) {
				Classificacao classe = classificacoes.get(rs.getString("descricao"));
				if (classe == null) {
					classe = instantiateClassificacao(rs);
					classificacoes.put(classe.getDescricao(), classe);
				}
				Quarto ap = instantiateQuarto(rs, classe);
				quartos.add(ap);
			}
			
			return quartos;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}
	}
	
	private Classificacao instantiateClassificacao(ResultSet rs) throws SQLException {
		Classificacao classe = new Classificacao();
		classe.setDescricao(rs.getString("descricao"));
		classe.setPrecoPorHospede(rs.getDouble("precoPorHospede"));
		
		return classe;
	}
	
	private Quarto instantiateQuarto(ResultSet rs, Classificacao classificacao) throws SQLException {
		
		StatusQuarto status = StatusQuarto.DISPONIVEL;
		
		if (rs.getBoolean("interditado"))
			status = StatusQuarto.INTERDITADO;
			
		Quarto newAp = new Quarto(rs.getInt("numero"),
				status,
				rs.getInt("capacidadeMax"),
				classificacao);
		
		return newAp;
	}
}
