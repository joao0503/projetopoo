package model.BO;

import java.sql.SQLException;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;

public interface BaseBO<VO> {
	public void cadastrar(VO vo) throws InserirException;
	public void remover(VO vo) throws InserirException, NaoEncontradoException;
	public void atualizar(VO vo) throws InserirException;
	public VO buscarPorId(VO vo) throws NaoEncontradoException;
	//public List<VO> listarTodos() throws SQLException;
	public List<?> listarTodos() throws SQLException;
}
