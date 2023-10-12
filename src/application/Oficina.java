package application;

import java.util.ArrayList;
import java.util.List;

import exception.NaoEncontradoException;
import model.BO.PessoaBO;
import model.BO.UsuarioBO;
import model.DAO.PecaDAO;
import model.VO.FuncionarioVO;
import model.VO.PecaVO;
import model.VO.PessoaVO;
import model.VO.UsuarioVO;

public class Oficina {

	public static void main(String[] args) throws NaoEncontradoException {
		System.out.println("Oficina mecânica de Sr. Zezé");
		
		// Mostrando como testar o DAO:
		// Observação importante: Não mandei id na hora de inserir uma peça porque
		// configurei a tabela do banco de dados para incrementar o id automaticamente.
		// vocês vão ter que fazer essa config no de vocês também.
		
		// PecasDAO:
		// inserindo algumas peças no banco de dados
		PecaVO pe = new PecaVO("Motor", 5, "Ford", 1200.52, 0L);
		PecaDAO pdao = new PecaDAO();
		pdao.inserir(pe);
		
		PecaVO pe2 = new PecaVO("Pneu", 589, "BorrachaX", 129.75, 0L);
		pdao.inserir(pe2);
		
		PecaVO pe3 = new PecaVO("Retrovisor", 128, "Retrovy", 55.90, 0L);
		pdao.inserir(pe3);
		
		// mostrando as peças que estão no banco de dados
		List<PecaVO> pecas = new ArrayList<PecaVO>();
		pecas = pdao.listar();
		
    	System.out.println("As peças no banco de dados são: ");
    	for(PecaVO p : pecas) {
    		System.out.println(p.toString());
    	}
    	
    	// deletando uma peca no banco de dados
    	pecas = pdao.listar();
    	
    	// pegando a peca1
    	pe = pecas.get(0);
    	System.out.println("O id de pe é: " + pe.getPecaId());
    	pdao.deletar(pe);
    	pecas = pdao.listar();

    	System.out.println("As peças no banco de dados depois de deletar uma delas são: ");
    	for(PecaVO p : pecas) {
    		System.out.println(p.toString());
    	}
    	
    	// alterando uma peca no banco de dados
    	pecas = pdao.listar();
    	
    	// pe é só pra aproveitar a peca ja instanciada
    	// pegando a peca2, lembrando que a peca 1 foi deletada, e por isso chamei o listar
    	// denovo
    	pe = pecas.get(0);
		pe.setNome("Retrovisor Alterado");
		pe.setQuantidadePeca(789);
		pe.setFabricante("Retrovy Alterado");
		pe.setPreco(191.80);
    	System.out.println("O id de pe é: " + pe.getPecaId());
    	
    	pdao.alterar(pe);
    	pecas = pdao.listar();
    	
    	System.out.println("As peças no banco de dados depois de alterar uma delas são: ");
    	for(PecaVO p : pecas) {
    		System.out.println(p.toString());
    	}
    	
    	// buscando por id, simulando:
    	PecaVO pecaTeste = new PecaVO();
    	pecaTeste.setPecaId(2L);
    	
    	PecaVO pecaBuscada = pdao.buscar(pecaTeste);
    	System.out.println("\nA peça buscada é: " + "\n" + pecaBuscada.toString());
    	
    	// listar todas já foi mostrada anteriormente
    	
    	// testando PessoaBO
    	PessoaBO pesBO = new PessoaBO();
    	PessoaVO pessoa = new PessoaVO();
    	pessoa.setPessoaId((long) 1);
    	pessoa = pesBO.buscarPorId(pessoa);
    	System.out.println("Dados da pessoa com id " + pessoa.getPessoaId() + ": \n" 
    			+ pessoa.toString() + "\n\n");
    	
    	// testando UsuarioBO do tipo UsuarioVO
    	UsuarioBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
    	UsuarioVO usuario = new UsuarioVO();
    	usuario.setPessoaId((long) 1);
    	usuario = usuBO.buscarPorId(usuario);
    	//System.out.println("Dados da pessoa: \n" + usuario.toString());
    	System.out.println("Dados do usuário com id " + usuario.getPessoaId() + ": \n" 
    			+ usuario.toString() + "\n\n");
    	
    	
    	// testando UsuarioBO do tipo FuncionarioVO
    	UsuarioBO<FuncionarioVO> usuFunBO = new UsuarioBO<FuncionarioVO>();
    	FuncionarioVO fun = new FuncionarioVO();
    	fun.setPessoaId((long) 1);
    	fun = usuFunBO.buscarPorId(fun);
    	//System.out.println("Dados da pessoa: \n" + usuario.toString());
    	System.out.println("Dados do usuário com id " + fun.getPessoaId() + ": \n" 
    			+ fun.toString());
	}
}
