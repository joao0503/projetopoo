package model.VO;

import java.time.LocalDate;

public class AutomovelVO {
	private String marca;
	private String modelo;
	private Integer anoDoModelo;
	private String cor;
	private String placa;
	private Integer quilometragem;
	private Long automovelId;
	private Long clienteId;
	
	public AutomovelVO(String marca, String modelo, Integer anoDoModelo, String cor, 
			String placa, Integer quilometragem, ClienteVO proprietario, 
			Long id, Long automovelId, Long clienteId) {
		setMarca(marca);
		setCor(cor);
		setPlaca(placa);
		setAnoDoModelo(anoDoModelo);
		setQuilometragem(quilometragem);
		//setProprietario(proprietario);
		//setOrcamentoTotal(orcamentoTotal);
		setAutomovelId(automovelId);
		setClienteId(clienteId);
		
	}
	
	public AutomovelVO() {
		
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca != null && !marca.isEmpty()) {
			this.marca = marca;
		} else {
			System.out.println("Marca do automóvel inválida");
		}
	}
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo != null && !modelo.isEmpty()) {
			this.modelo = modelo;
		}
	}
	
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		if(cor != null) {
			this.cor = cor;
		} else {
			System.out.println("Cor do automóvel inválida");
		}
	}
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		if(placa != null) {
			this.placa = placa;
		} else {
			System.out.println("Placa do automóvel inválida");
		}
	}
	
	
	public Integer getAnoDoModelo() {
		return anoDoModelo;
	}
	public void setAnoDoModelo(Integer anoDoModelo) {
        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();
      
        System.out.println("Ano atual: " + anoAtual);
        
		if(anoDoModelo > 0 && anoDoModelo <= anoAtual) {
			this.anoDoModelo = anoDoModelo;
		} else {
			System.out.println("Ano do automóvel inválido");
		}
	}
	
	
	public Integer getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(Integer quilometragem) {
		if(quilometragem > 0) {
			this.quilometragem = quilometragem;
		} else {
			System.out.println("Quilometragem do automóvel inválida");
		}
	}
	
	
	/*public Cliente getProprietario() {
		return proprietario;
	}
	public void setProprietario(Cliente proprietario) {
		// implementar posteriormente o proprietário de forma 
		//adequada considerando o uso do id, quando for usar banco
		// de dados.
		if(proprietario != null) {
			this.proprietario = proprietario;
		} else {
			System.out.println("Proprietário do automóvel inválido");
		}
	}*/
	
	/*public Orcamento getOrcamentoTotal() {
		return orcamentoTotal;
	}
	public void setOrcamentoTotal(Orcamento orcamentoTotal) {
		if(orcamentoTotal != null) {
				this.orcamentoTotal = orcamentoTotal;
		}
	}*/
	
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		if(clienteId > 0) {
			this.clienteId = clienteId;
		}
	}
	
	
	public Long getAutomovelId() {
		return automovelId;
	}
	public void setAutomovelId(Long automovelId) {
		if(automovelId > 0) {
			this.automovelId = automovelId;
		}
	}
}
