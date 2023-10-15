package application;

import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.BO.ServicoBO;
import model.VO.PecaVO;
import model.VO.ServicoVO;

public class Oficina {

	public static void main(String[] args) throws NaoEncontradoException, InserirException {
		System.out.println("Oficina mecânica de Sr. Zezé");
		
		/*PecaVO pe = new PecaVO("Motor", 5, "Ford", 1200.52, 0L);
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
    	
    	
    	// testando BOs
    	// testando buscar de PessoaBO do tipo PessoaVO
    	PessoaBO<PessoaVO> pesBO = new PessoaBO<PessoaVO>();
    	PessoaVO pessoa = new PessoaVO();
    	pessoa.setPessoaId((long) 1);
    	pessoa = pesBO.buscarPorId(pessoa);
    	System.out.println("Dados da pessoa do tipo PessoaVO com id " + pessoa.getPessoaId() + ": \n" 
    			+ pessoa.toString() + "\n\n");
    	
    	// testando buscar de PessoaBO do tipo FuncionarioVO
    	PessoaBO<FuncionarioVO> pesBOFun = new PessoaBO<FuncionarioVO>();
    	FuncionarioVO fu = new FuncionarioVO();
    	fu.setPessoaId((long) 1);
    	fu = pesBOFun.buscarPorId(fu);
    	System.out.println("Dados da pessoa do tipo FuncionarioVO com id " + pessoa.getPessoaId() 
    	+ ": \n" 
    			+ fu.toString() + "\n\n");
    	
    	
    	// testando inserir de UsuarioBO
    	UsuarioBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
    	UsuarioVO usuarioo = new UsuarioVO("Mario teste inserir usu", "192.123.921-78",
    			"Rua test usu", "84 99912-2525", null, "usuarioboTesteee", "senhausubo", 
    			"usutesteee@gmail.com", (int) 2, null);
    	usuBO.cadastrar(usuarioo);
    	
    	
    	
    	// testando buscar de UsuarioBO do tipo UsuarioVO
    	UsuarioVO usuario = new UsuarioVO();
    	usuario.setPessoaId((long) 8);
    	usuario = usuBO.buscarPorId(usuario);
    	//System.out.println("Dados da pessoa: \n" + usuario.toString());
    	System.out.println("Dados do usuário do tipo UsuarioVO com id " + usuario.getPessoaId() + ": \n" 
    			+ usuario.toString() + "\n\n");
    	
    	
    	// testando buscar de UsuarioBO do tipo FuncionarioVO
    	UsuarioBO<FuncionarioVO> usuFunBO = new UsuarioBO<FuncionarioVO>();
    	FuncionarioVO fun = new FuncionarioVO();
    	fun.setPessoaId((long) 8);
    	fun = usuFunBO.buscarPorId(fun);
    	//System.out.println("Dados da pessoa: \n" + usuario.toString());
    	System.out.println("Dados do usuário do tipo FuncionarioVO com id " + fun.getPessoaId() + ": \n" 
    			+ fun.toString());
    	
    	ClienteBO cliBO = new ClienteBO();
    	List<ClienteVO> clientes = new ArrayList<ClienteVO>();
    	clientes = cliBO.listarTodos();
    	System.out.println("Alguns dados de listar cliente do bo: ");
    	for(ClienteVO cli : clientes) {
    		System.out.println("Nome: " + cli.getNome());
    		System.out.println("Desconto: " + cli.getDesconto());
    		System.out.println("pessoaId: " + cli.getClienteId());
    		System.out.println("pessoaId: " + cli.getPessoaId());
    	}
    	
    	List<AutomovelVO> automoveis = new ArrayList<AutomovelVO>();
    	AutomovelBO autoBO = new AutomovelBO();
    	automoveis = autoBO.listarTodos();
    	for(AutomovelVO cli : automoveis) {
    		System.out.println("Marca do automovel: " + cli.getMarca());
    		System.out.println("Modelo: " + cli.getModelo());
    	}
    	
    	// Vou testar o ServicoBO cadastrar
    	/*PecaVO peca = new PecaVO();
    	peca.setPecaId((long) 2);
    	ServicoVO servico = new ServicoVO();
    	// estou mandando a data com sting vazia porque o setter vai verificar se é vazio
    	// caso seja ele vai pegar a data atual e settar
    	
    	servico.setNome("Troca da embragemk");
    	servico.setDescricao("Melhor embreagem");
    	servico.setValor(585.15);
    	servico.setStatus(1);
    	servico.setPeca(peca);
    	//servico.setDataInicio("");
    	//System.out.println(servico.getDataInicio());
    	//servico.setDataFim(null);
    	//System.out.println(servico.getDataFim());
    	servico.setFuncionarioId((long) 2);
    	servico.setClienteId((long) 2);
    	servico.setAutomovelId((long) 1);
    	//servico.setServicoId(null);
    	//servico.getPeca().setPecaId((long) 1);
    	
    	ServicoBO servBO = new ServicoBO();
    	servBO.cadastrar(servico);*/
    	
    	/*servico.setServicoId((long) 3);
    	servico.setNome("Nome da pecinha alteradaaa aa a");
    	servBO.atualizar(servico);
    	
    	servico.setServicoId((long) 1);
    	servBO.remover(servico);
    	
    	servico.setServicoId((long) 3);
    	servBO.finalizarServico(servico);*/
    	
    	ServicoBO servBO = new ServicoBO();
    	List<ServicoVO> servicos = new ArrayList<ServicoVO>();
    	servicos = servBO.listarTodos();
    	for(ServicoVO se : servicos) {
    		System.out.println("Nomeee" + se.getNome());
    	}
    	
    	ServicoVO servv = new ServicoVO();
    	PecaVO peeca = new PecaVO();
    	peeca.setPecaId((long) 1);
    	servv.setPeca(peeca);
    	servv = servBO.buscarPorId(servv);
    	System.out.println("\nServiço buscado: \n" + servv.getNome() + "\n" 
    	+ servv.getPeca().getNome());
	}
}
