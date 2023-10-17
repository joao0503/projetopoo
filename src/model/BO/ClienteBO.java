package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.ClienteDAO;
import model.DAO.PessoaDAO;
import model.VO.ClienteVO;
import model.VO.PessoaVO;

public class ClienteBO extends PessoaBO<ClienteVO> {
	static private ClienteDAO cliDAO = new ClienteDAO();
	static private PessoaDAO<ClienteVO> pesDAO = new PessoaDAO<ClienteVO>();

	@Override
	public void cadastrar(ClienteVO vo) throws InserirException {
		super.cadastrar(vo);
		PessoaVO pessoa = new PessoaVO();
		pessoa = pesDAO.buscar(vo);
		try {
			if(pessoa != null) {
				cliDAO.inserir(vo);
			} else {
				throw new InserirException("Não foi possível cadastrar o cliente porque não existe"
						+ "uma pessoa com o id.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(ClienteVO vo) throws InserirException {
		super.remover(vo);
		try {
			// ao buscar com pessoaDAO, o vo que
			ClienteVO cliente = new ClienteVO();
			cliente = cliDAO.buscar(vo);
			if (cliente != null) {
				cliDAO.deletar(vo);
				super.remover(vo);
			} else {
				throw new InserirException("Não foi possível deletar o cliente porque" 
			+ "não existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(ClienteVO vo) throws InserirException {
		try {
			super.atualizar(vo);
			ClienteVO cliente = new ClienteVO();
			cliente = cliDAO.buscar(vo);
			if (cliente != null) {
				cliDAO.alterar(vo);
			} else {
				throw new InserirException("Não foi possível alterar o cliente porque não "
						+ "existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ClienteVO buscarPorId(ClienteVO vo) throws NaoEncontradoException {
		try {
			ClienteVO cliente = new ClienteVO();
			cliente = cliDAO.buscar(vo);
			if(cliente != null) {
				return cliente;
			} else {
				throw new NaoEncontradoException("Cliente não encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ClienteVO> listarTodos() {
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		clientes = cliDAO.listar();
		for(ClienteVO cli : clientes) {
			System.out.println("\nO clienteId aqui no listar do clienteBO é: " + cli.getClienteId());
		}
		return clientes;
	}
}
