package model.VO;

public class PecaVO {
	private String nome;
	private int quantidadePeca;
	private String fabricante;
	private double preco;
	private Long pecaId;
	
	public PecaVO(String nome, int quantidadePeca, String fabricante, 
			double preco, Long pecaId) {
		setNome(nome);
		setQuantidadePeca(quantidadePeca);
		setFabricante(fabricante);
		setPreco(preco);
		setPecaId(pecaId);
	}

	public PecaVO(){}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
	}
	
	public int getQuantidadePeca() {
		return quantidadePeca;
	}
	
	public void setQuantidadePeca(int quantidadePeca) {
		if(quantidadePeca > 0) {
			this.quantidadePeca = quantidadePeca;
		}
	}
	
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		if(fabricante != null) {
			this.fabricante = fabricante;
		} else {
			System.out.println("Fabricante inválido");
		}
	}
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		if(preco > 0) {
			this.preco = preco;
		} else {
			System.out.println("Preço inválido");
		}
	}
	public Long getPecaId() {
		return pecaId;
	}
	
	public void setPecaId(Long pecaId) {
		if(pecaId >= 0) {
			this.pecaId = pecaId;
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\n"
		+ "Quantidade de peças: " + getQuantidadePeca() + "\n"
		+ "Fabricante: " + getFabricante() + "\n"
	    + "Preço: " + getPreco() + "\n"
	    + "Id: " + getPecaId() + "\n";
	}
	
}
