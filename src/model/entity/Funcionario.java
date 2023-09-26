package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Usuario {

	//private List<Cliente> clientesDoFuncionario;
	private boolean ehFuncionario;
	private ArrayList<Servico> servicosDoFuncionario;
	private Long funcionarioId;
	
    public Funcionario(List<Cliente> clientesDoFuncionario, String nome, String cpf, String endereco, 
    		String usuario, String senha, Long pessoaId, Long usuarioId, Long funcionarioId) {
        super(nome, cpf, endereco, usuario, senha, pessoaId, usuarioId);
        //setClientesDoFuncionario(clientesDoFuncionario);
        setFuncionarioId(funcionarioId);
    }

	public Funcionario() {}
	
	
	/*public List<Cliente> getClientesDoFuncionario() {
		return clientesDoFuncionario;
	}
	public void setClientesDoFuncionario(List<Cliente> clientesDoFuncionario) {
		if(clientesDoFuncionario != null && !clientesDoFuncionario.isEmpty()) {
			this.clientesDoFuncionario = clientesDoFuncionario;
		}
	}*/
	
	// improvisando login temporariamente
	public boolean getEhFuncionario() {
		return ehFuncionario;
	}
	public void setEhFuncionario(boolean autenti) {
		if(autenti) {
			this.ehFuncionario = autenti;
		}
	}
	
	
	public List<Servico> getServicosDoFuncionario() {
		return servicosDoFuncionario;
	}
	public void setServicosDoFuncionario(ArrayList<Servico> servicosDoFuncionario) {
		if(servicosDoFuncionario != null && !servicosDoFuncionario.isEmpty()) {
			this.servicosDoFuncionario = servicosDoFuncionario;
		}
	}
	
	

	public Long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(Long funcionarioId) {
		if(funcionarioId > 0 ) {
			this.funcionarioId = funcionarioId;
		}
	}
}