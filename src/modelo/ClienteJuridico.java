package modelo;

import java.util.List;

public class ClienteJuridico extends Cliente {

	private String cnpj;
	private String razaoSocial;
	private List<ClienteFisico> funcionariosVinculados;
	
	public ClienteJuridico(String nome, String email, String telefone, String logradouro, String numero, String bairro,
			String cep, String cidade, String cnpj, String razaoSocial) {
		super(nome, email, telefone, logradouro, numero, bairro, cep, cidade);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public List<ClienteFisico> getFuncionariosVinculados() {
		return funcionariosVinculados;
	}
	
	public void vincularFuncionario(ClienteFisico funcionario) {
		funcionariosVinculados.add(funcionario);
	}
}
