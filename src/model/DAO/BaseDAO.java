package model.DAO;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<VO> {
	public void inserir(VO entity) throws SQLException;
	public void deletar(VO entity) throws SQLException;
	public void alterar(VO entity) throws SQLException;
	public VO buscar(VO entity) throws SQLException;
	public List<?> listar() throws SQLException;
	
	/* ideia: Esse BaseDAO vai ser usado para as entidades do sistema como, pecas,
	 * automoveis, serviços, e vai existir outro BaseDAO chamado BasePersonDAO que 
	 * vai servir para Pessoas do sistema. Isso resolverá problemas na hora de 
	 * implementar interfaces e resolverá problemas de tipos de retornos, criando 
	 * esse DAO, será possível que toda a Camada DAO retorne sempre objetos já 
	 * instanciados, para que assim o BO fique legível e manipule facilmente
	 * as regras de negócio.
	*/
}
