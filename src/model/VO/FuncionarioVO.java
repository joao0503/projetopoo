package model.VO;

import java.util.ArrayList;

public class FuncionarioVO extends UsuarioVO {

	//private List<Cliente> clientesDoFuncionario;
	private double salario;
	//private boolean ehFuncionario;
	private ArrayList<ServicoVO> servicosDoFuncionario;
	private Long funcionarioId;
	
    public FuncionarioVO(double salario, ArrayList<ServicoVO> servicosDoFuncionario, String nome, 
    		String cpf, String endereco, String email, String usuario, String senha, 
    		Long pessoaId, Long usuarioId, String numeroCelular, Long funcionarioId) {
        super(nome, cpf, endereco, email, numeroCelular, usuario, pessoaId, senha, 
        		usuarioId);
        //setClientesDoFuncionario(clientesDoFuncionario);
        setSalario(salario);
        setServicosDoFuncionario(servicosDoFuncionario);
        setFuncionarioId(funcionarioId);
    }

	public FuncionarioVO() {}
	
	
	/*public List<Cliente> getClientesDoFuncionario() {
		return clientesDoFuncionario;
	}
	public void setClientesDoFuncionario(List<Cliente> clientesDoFuncionario) {
		if(clientesDoFuncionario != null && !clientesDoFuncionario.isEmpty()) {
			this.clientesDoFuncionario = clientesDoFuncionario;
		}
	}*/
	
	// improvisando login temporariamente
	
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		if(salario > 0) {
			this.salario = salario;
		}
	}
	
	
	/*public boolean getEhFuncionario() {
		return ehFuncionario;
	}
	public void setEhFuncionario(boolean autenti) {
		if(autenti) {
			this.ehFuncionario = autenti;
		}
	}*/
	
	
	public ArrayList<ServicoVO> getServicosDoFuncionario() {
		return servicosDoFuncionario;
	}
	public void setServicosDoFuncionario(ArrayList<ServicoVO> servicosDoFuncionario) {
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