package model.entity;

public class Automovel {
	private String marca;
	private String cor;
	private String placa;
	// Provavelmente devemos definir o ano como tipo Date posteriormente,
	// quando for configurado os tipos no banco de dados
	//private Integer ano;
	private Integer quilometragem;
	private Cliente proprietario;
	private Orcamento orcamentoTotal;
	private Long id;
	// Implementar servicoesEmAndamento quando a classe estiver
	// feita
	//private List<Servico> servicosEmAndamento;
	
	public Automovel(String marca, String cor, String placa, 
			Integer ano, Integer quilometragem, Cliente proprietario, 
			Orcamento orcamentoTotal, Long id) {
		setMarca(marca);
		setCor(cor);
		setPlaca(placa);
		//setAno(ano);
		setQuilometragem(quilometragem);
		setProprietario(proprietario);
		setOrcamentoTotal(orcamentoTotal);
		setId(id);
	}
	
	public Automovel() {
		
	}
	
	/*public Automovel(String marca, Integer ano) {
		setMarca(marca);
		setAno(ano);
	}*/
	
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
	
	/*public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();
      
        System.out.println("Ano atual: " + anoAtual);
        
		if(ano > 0 && ano <= anoAtual) {
			this.ano = ano;
		} else {
			System.out.println("Ano do automóvel inválido");
		}
	}*/
	
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
	
	public Cliente getProprietario() {
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
	}
	
	public Orcamento getOrcamentoTotal() {
		return orcamentoTotal;
	}
	public void setOrcamentoTotal(Orcamento orcamentoTotal) {
		if(orcamentoTotal != null) {
				this.orcamentoTotal = orcamentoTotal;
		}
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		if(id > 0) {
			this.id = id;
		}
		
	}
}
