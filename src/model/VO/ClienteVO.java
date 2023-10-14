package model.VO;

import java.util.List;

public class ClienteVO extends PessoaVO {
	private List<AutomovelVO> automoveis;
	//private Long pessoaId;
	private double desconto;
	private Long clienteId;
	
	public ClienteVO(String nome, String endereco, String cpf, 
			List<AutomovelVO> automoveis, String numeroCelular, Long pessoaId,
			double desconto, Long clienteId) {
		super(nome, cpf, endereco, numeroCelular, pessoaId);
		setAutomoveis(automoveis);
		setDesconto(desconto);
		setClienteId(clienteId);
	}
	
	public ClienteVO() {}
	
	public List<AutomovelVO> getAutomoveis() {
		return automoveis;
	}
	public void setAutomoveis(List<AutomovelVO> automoveis) {
		if(!automoveis.isEmpty()) {
			this.automoveis = automoveis;
		} else {
			System.out.println("Automóvel inválido");
		}
	}
	
	
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		if(desconto > 0) {
			this.desconto = desconto;
		}
	}
	
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		//if(clienteId > 0) {
			this.clienteId = clienteId;
		//}
	}
}