package dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<E> {
	public void inserir(E entity) throws SQLException;
	public void deletar(E entity) throws SQLException;
	public void alterar(E entity) throws SQLException;
	public E buscar(E entity) throws SQLException;
	public List<E> listar() throws SQLException;
}
