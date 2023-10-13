package model.VO;

import java.util.ArrayList;

public class FuncionarioVO extends UsuarioVO {
	private double salario;
	private ArrayList<ServicoVO> servicosDoFuncionario;
	private Long funcionarioId;
	
	
    public FuncionarioVO(String nome, String cpf, String endereco, String numeroCelular, Long pessoaId, 
			String usuario, String senha, String email, Integer tipoDeUsuario, Long usuarioId, 
			double salario, ArrayList<ServicoVO> servicosDoFuncionario, Long funcionarioId) {
        super(nome, cpf, endereco, numeroCelular, pessoaId, usuario, senha, email, tipoDeUsuario, 
        		usuarioId);
        //setClientesDoFuncionario(clientesDoFuncionario);
        setSalario(salario);
        setServicosDoFuncionario(servicosDoFuncionario);
        setFuncionarioId(funcionarioId);
    }
    
	public FuncionarioVO() {}
	
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		if(salario > 0) {
			this.salario = salario;
		}
	}
	
	
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
		//if(funcionarioId > 0 ) {
		this.funcionarioId = funcionarioId;
		//}
	}
}