package src;

import java.util.List;

public class Cliente {
	private String nome;
	private String endereco;
	private String cpf;
	private List<Automovel> automoveis;

	public Cliente(String nome, String endereco, String cpf, 
			List<Automovel> automoveis) {
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setAutomoveis(automoveis);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
		
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco != null) {
			this.endereco = endereco;
		} else {
			System.out.println("Endereço inválido");
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		// É possível fazer um verificador de cpf existente, 
		//mas não sei se faz parte do escopo da disciplina
		if(cpf != null) {
			this.cpf = cpf;
		} else {
			System.out.println("CPF inválido");
		}
		
	}
	
	public List<Automovel> getAutomoveis() {
		return automoveis;
	}
	public void setAutomoveis(List<Automovel> automoveis) {
		// ainda não foi implementado o tratamento completo da lista
		// pois ainda não foi mostrado esse conteúdo na disciplina.
		// Ainda não está nessa etapa.
		if(automoveis != null) {
			this.automoveis = automoveis;
		} else {
			System.out.println("Automóvel inválido");
		}
	}
}