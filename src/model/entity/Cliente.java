package model.entity;

import java.util.List;

public class Cliente extends Pessoa {
	private List<Automovel> automoveis;
	//private Long pessoaId;
	private Long clienteId;
	
	public Cliente(String nome, String endereco, String cpf, List<Automovel> automoveis, Long pessoaId,
			Long clienteId) {
		super(nome, cpf, endereco, pessoaId);
		setAutomoveis(automoveis);
		setClienteId(clienteId);
	}
	
	public Cliente() {}
	
	public List<Automovel> getAutomoveis() {
		return automoveis;
	}
	public void setAutomoveis(List<Automovel> automoveis) {
		if(!automoveis.isEmpty()) {
			this.automoveis = automoveis;
		} else {
			System.out.println("Automóvel inválido");
		}
	}
	
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		if(clienteId > 0) {
			this.clienteId = clienteId;
		}
	}
}