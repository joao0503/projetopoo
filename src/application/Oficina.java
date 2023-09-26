package application;

import java.util.ArrayList;
import java.util.List;

import dao.PecaDAO;
import model.entity.Peca;

public class Oficina {

	public static void main(String[] args) {
		System.out.println("Oficina mecânica de Sr. Zezé");
		
		// Mostrando como testar o DAO:
		// Observação importante: Não mandei id na hora de inserir uma peça porque
		// configurei a tabela do banco de dados para incrementar o id automaticamente.
		// vocês vão ter que fazer essa config no de vocês também.
		
		// PecasDAO:
		// inserindo algumas peças no banco de dados
		Peca pe = new Peca("Motor", 5, "Ford", 1200.52, 0L);
		PecaDAO pdao = new PecaDAO();
		pdao.inserir(pe);
		
		Peca pe2 = new Peca("Pneu", 589, "BorrachaX", 129.75, 0L);
		pdao.inserir(pe2);
		
		Peca pe3 = new Peca("Retrovisor", 128, "Retrovy", 55.90, 0L);
		pdao.inserir(pe3);
		
		// mostrando as peças que estão no banco de dados
		List<Peca> pecas = new ArrayList<Peca>();
		pecas = pdao.listar();
		
    	System.out.println("As peças no banco de dados são: ");
    	for(Peca p : pecas) {
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
    	for(Peca p : pecas) {
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
    	for(Peca p : pecas) {
    		System.out.println(p.toString());
    	}
    	
    	// buscando por id, simulando:
    	Peca pecaTeste = new Peca();
    	pecaTeste.setPecaId(2L);
    	
    	Peca pecaBuscada = pdao.buscar(pecaTeste);
    	System.out.println("\nA peça buscada é: " + "\n" + pecaBuscada.toString());
    	
    	// listar todas já foi mostrada anteriormente
	}
}
