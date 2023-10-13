package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.FuncionarioDAO;
import model.DAO.UsuarioDAO;
import model.VO.FuncionarioVO;
import model.VO.UsuarioVO;

public class FuncionarioBO extends UsuarioBO<FuncionarioVO> {
	static private FuncionarioDAO funcDAO = new FuncionarioDAO();
	static private UsuarioDAO<FuncionarioVO> usuDAO = new UsuarioDAO<FuncionarioVO>();

	@Override
	public void cadastrar(FuncionarioVO vo) throws InserirException {
		try {
			super.cadastrar(vo);
			
			UsuarioVO usuario = new UsuarioVO();
			usuario = usuDAO.buscar(vo);
			List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
			funcionarios = funcDAO.listar();
			if(usuario != null) {
				if(funcionarios.size() < 5) {
					funcDAO.inserir(vo);
				} else {
					throw new InserirException("Não foi possível cadastrar o funcionario porque"
							+ "não pode haver mais que 5 funcionários.");
				}
			} else {
				throw new InserirException("Não foi possível cadastrar o funcionario porque ele já"
						+ "existe.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(FuncionarioVO vo) throws InserirException {
		try {
			// ao buscar com pessoaDAO, o vo que
			FuncionarioVO funcionario = new FuncionarioVO();
			funcionario = funcDAO.buscar(vo);
			if (funcionario != null) {
				funcDAO.deletar(vo);
			} else {
				throw new InserirException("Não foi possível remover o funcionario porque" 
			+ "não existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(FuncionarioVO vo) throws InserirException {
		try {
			super.atualizar(vo);
			FuncionarioVO funcionario = new FuncionarioVO();
			funcionario = funcDAO.buscar(vo);
			if (funcionario != null) {
				funcDAO.alterar(vo);
			} else {
				throw new InserirException("Não foi possível alterar o funcionario porque não "
						+ "existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FuncionarioVO buscarPorId(FuncionarioVO vo) throws NaoEncontradoException {
		FuncionarioVO funcionario = new FuncionarioVO();
		funcionario = funcDAO.buscar(vo);
		return funcionario;
	}

	@Override
	public List<FuncionarioVO> listarTodos() {
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		funcionarios = funcDAO.listar();
		return funcionarios;
	}
}
