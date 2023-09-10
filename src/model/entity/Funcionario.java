package model.entity;

public class Funcionario extends Usuario{
    private String nome;
    private String cpf;

    public Funcionario(String usuario, String senha) {
        super(usuario,senha);
		setNome(nome);
		setCpf(cpf);
    }

	public Funcionario(){}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.length() >= 11) {
			this.cpf = cpf;
		} else {
			System.out.println("CPF inválido");
		}
	}
    
    
}