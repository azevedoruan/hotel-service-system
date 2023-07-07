package modelo.dto;

import modelo.ClienteJuridico;

public class ClienteJuridicoDTO {

	private Integer id;
	private String nome;
	private String cnpj;
	
	public ClienteJuridicoDTO() {}
	
	public ClienteJuridicoDTO(ClienteJuridico clienteJuridico) {
		this.id = clienteJuridico.getId();
		this.nome = clienteJuridico.getNome();
		this.cnpj = clienteJuridico.getCnpj();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public ClienteJuridico getObjetoConvertido() {
		ClienteJuridico cj = new ClienteJuridico(getNome(), getCnpj(), null, null, null, null, null, null, null, null);
		return cj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
