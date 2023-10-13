package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.PessoaDAO;
import model.VO.PessoaVO;

public class PessoaBO<VO extends PessoaVO> implements BaseBO<VO>{
	static private PessoaDAO<PessoaVO> pessoaDAO = new PessoaDAO<PessoaVO>();
	
	@Override
	public void cadastrar(VO vo) throws InserirException {
		try {
			if(vo.getNome().isEmpty()) {
				throw new InserirException("Não foi possível cadastrar a pessoa "
						+ "porque o nome da pessoa está vazio");
			} else {
				PessoaVO pessoa = new PessoaVO();
				pessoa = pessoaDAO.buscarPorCPF(vo);
				if(pessoa == null) {
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
	public void remover(VO vo) throws InserirException {
		// talvez possamos usar deleção em cascata no bd para deltar tudo
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
	public void atualizar(VO vo) throws InserirException {
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
	public VO buscarPorId(VO vo) throws NaoEncontradoException {
		try {
			PessoaVO pessoa = new PessoaVO();
			pessoa = pessoaDAO.buscar(vo);
			return (VO) pessoa;
		} catch(Exception e) {
			throw new NaoEncontradoException("Pessoa com id " + vo.getPessoaId() 
			+" não foi encontrada no banco de dados");
		}
	}
	
	
	@Override
	public List<?> listarTodos() throws SQLException {
		List<?> pessoas = new ArrayList<PessoaVO>();
		pessoas = pessoaDAO.listar();
		return pessoas;
	}
}

