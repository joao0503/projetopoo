package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.PessoaDAO;
import model.VO.PessoaVO;

public class PessoaBO implements BaseBO<PessoaVO>{
	static private PessoaDAO<PessoaVO> pessoaDAO = new PessoaDAO<PessoaVO>();
	
	@Override
	public void cadastrar(PessoaVO vo) throws InserirException {
		try {
			if(vo.getNome().isEmpty()) {
				throw new InserirException("Não foi possível cadastrar a pessoa "
						+ "porque o nome da pessoa está vázio");
			} else {
				PessoaVO pessoa = new PessoaVO();
				pessoa = pessoaDAO.buscarPorCPF(vo);
				if(pessoa != null) {
					pessoaDAO.inserir(vo);
				} else {
					throw new InserirException("Não foi possível cadastrar porque já "
							+ "existe uma pessoa com esse cpf.");
				}
			}
		}
		catch(SQLException e) {
			// saber se esse lançamento realmente é válido
			throw new InserirException(e.getMessage());
		}
	}
	
	
	@Override
	public void remover(PessoaVO vo) throws InserirException {
		try {
			// ao buscar com pessoaDAO, o vo que
			PessoaVO pessoa = new PessoaVO();
			pessoa = pessoaDAO.buscar(vo);
			System.out.println("Pessoa é: " + pessoa);
			if(pessoa != null) {
				pessoaDAO.deletar(vo);
			} else {
				throw new InserirException("Não foi possível remover a pessoa porque"
						+ "não existe no banco de dados");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void atualizar(PessoaVO vo) {
		try {
			PessoaVO pessoa = new PessoaVO();
			pessoa = pessoaDAO.buscar(vo);
			System.out.println("Pessoa é: " + pessoa);
			if(pessoa != null) {
				pessoaDAO.alterar(vo);
			} else {
				throw new InserirException("Não foi possível alterar a pessoa porque"
						+ "não existe no banco de dados");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public PessoaVO buscarPorId(PessoaVO vo) throws NaoEncontradoException {
		PessoaVO pessoa = new PessoaVO();
		pessoa = pessoaDAO.buscar(vo);
		return pessoa;
	}
	
	
	@Override
	public List<?> listarTodos(){
		List<?> pessoas = new ArrayList<PessoaVO>();
		pessoas = pessoaDAO.listar();
		return pessoas;
	}
}

