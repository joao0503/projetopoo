package model.VO;

public class PessoaVO {
	private String nome;
	private String cpf;
	private String endereco;
	private String numeroCelular;
	private Long pessoaId;
	
	public PessoaVO(String nome, String cpf, String endereco, String numeroCelular, 
			Long pessoaId) {
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setNumeroCelular(numeroCelular);
		setPessoaId(pessoaId);
	}
	public PessoaVO() {}
	
	
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
		//if(cpf.length() >= 11 && cpf.length() <= 14) {
			this.cpf = cpf;
		//} else {
			//System.out.println("CPF inválido!");
		//}
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.isEmpty()) {
			this.endereco = endereco;
		}
	}
	
	
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		//if(numeroCelular != null && !numeroCelular.isEmpty()) {
			this.numeroCelular = numeroCelular;
		//}
	}
	
	public Long getPessoaId() {
		return pessoaId;
	}
	
	public void setPessoaId(Long pessoaId) {
		//if(pessoaId > 0) {
			this.pessoaId = pessoaId;
		//}
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nCpf: " + getCpf() + "\nEndereco: " + getEndereco() 
		+ "\nNumero de Celular: " + getNumeroCelular() + "\nPessoaId: " + getPessoaId();
	}
}
