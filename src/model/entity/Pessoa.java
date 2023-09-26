package model.entity;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
	private Long pessoaId;
	
	public Pessoa(String nome, String cpf, String endereco, Long pessoaId) {
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setPessoaId(pessoaId);
	}
	public Pessoa() {}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
		}
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.length() >= 11 && cpf.length() <= 14) {
			this.cpf = cpf;
		} else {
			System.out.println("CPF inválido!");
		}
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.isEmpty()) {
			this.endereco = endereco;
		}
	}
	
	public Long getPessoaId() {
		return pessoaId;
	}
	
	public void setPessoaId(Long pessoaId) {
		if(pessoaId > 0) {
			this.pessoaId = pessoaId;
		}
	}
}
