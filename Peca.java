package Classes;

public class Peca {
	private String nome;
	private String serial;
	private String fabricante;
	private double preco;
	private String diretorioImagem;
	
	public Peca(String nome, String serial, String fabricante, 
			double preco, String diretorioImagem) {
		setNome(nome);
		setSerial(serial);
		setFabricante(fabricante);
		setPreco(preco);
		setDiretorioImagem(diretorioImagem);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
		
	}
	
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		if(serial != null) {
			this.serial = serial;
		} else {
			System.out.println("Serial inválido");
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
	
	
	public String getDiretorioImagem() {
		return diretorioImagem;
	}
	public void setDiretorioImagem(String diretorioImagem) {
		if(diretorioImagem != null) {
			this.diretorioImagem = diretorioImagem;
		} else {
			System.out.println("Diretório inválido");
		}
	}
}
