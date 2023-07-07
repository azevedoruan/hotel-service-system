package modelo;

public class ClienteFisico extends Cliente {

	private String cpf;
	private ClienteJuridico empresaVinculo;

	public ClienteFisico() {}
	
	public ClienteFisico(String nome, String email, String telefone, String logradouro, String numero, String bairro,
			String cep, String cidade, String cpf, ClienteJuridico empresaVinculo) {
		super(nome, email, telefone, logradouro, numero, bairro, cep, cidade);
		this.cpf = cpf;
		this.setEmpresaVinculo(empresaVinculo);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ClienteJuridico getEmpresaVinculo() {
		return empresaVinculo;
	}

	public void setEmpresaVinculo(ClienteJuridico empresaVinculo) {
		this.empresaVinculo = empresaVinculo;
	}
}
