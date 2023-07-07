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
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.dto.ClienteJuridicoDTO;

public class ClienteFisicoDAO {

	private Connection conn;

	public ClienteFisicoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<ClienteFisico> consultarTodos() {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			pst = conn.prepareStatement("SELECT C.*, F.cpf, C2.nome AS nomeEmpresa, C2.id AS idEmpresa "
					+ "FROM (PESSOA_FISICA F INNER JOIN CLIENTE C ON(F.idCliente = C.id)) "
					+ "LEFT OUTER JOIN CLIENTE C2 ON(F.idClienteJuridico = C2.id)");
			
			rs = pst.executeQuery();
			List<ClienteFisico> clientes = new ArrayList<>();
			Map<Integer, ClienteJuridicoDTO> empresas = new HashMap<>();
			
			while (rs.next()) {
				ClienteJuridicoDTO empresaDto = empresas.get(rs.getInt("idEmpresa"));
				if (empresaDto == null) {
					empresaDto = instantiateEmpresaDto(rs);
					empresas.put(empresaDto.getId(), empresaDto);
				}
				ClienteFisico cliente = instantiateClienteFisico(rs, empresaDto.getObjetoConvertido());
				clientes.add(cliente);
			}
			
			return clientes;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}
	}
	//TODO consultarPorCpf
	
	private ClienteJuridicoDTO instantiateEmpresaDto(ResultSet rs) throws SQLException {		
		ClienteJuridicoDTO cj = new ClienteJuridicoDTO();
		cj.setId(rs.getInt("idEmpresa"));
		cj.setNome(rs.getString("nomeEmpresa"));
		
		return cj;
	}
	
	private ClienteFisico instantiateClienteFisico(ResultSet rs, ClienteJuridico empresa) throws SQLException {
		ClienteFisico cf = new ClienteFisico();
		cf.setCpf(rs.getString("cpf"));
		cf.setNome(rs.getString("nome"));
		cf.setEmail(rs.getString("email"));
		cf.setLogradouro(rs.getString("logradouro"));
		cf.setNumero(rs.getString("numero"));
		cf.setBairro(rs.getString("bairro"));
		cf.setCep(rs.getString("cep"));
		cf.setCidade(rs.getString("cidade"));
		cf.setEmpresaVinculo(empresa);
		
		return cf;
	}
}
