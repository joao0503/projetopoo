package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.FuncionarioDAO;
import model.DAO.GerenteDAO;
import model.DAO.PessoaDAO;
import model.DAO.UsuarioDAO;
import model.VO.FuncionarioVO;
import model.VO.GerenteVO;
import model.VO.PessoaVO;
import model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> extends PessoaBO<VO> {
	static private UsuarioDAO<UsuarioVO> usuarioDAO = new UsuarioDAO<UsuarioVO>();
	static private PessoaDAO<UsuarioVO> pessoaDAO = new PessoaDAO<UsuarioVO>();
	static private GerenteDAO gerenteDAO = new GerenteDAO();
	static private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	@Override
	public void cadastrar(VO vo) throws InserirException {
		try {
			super.cadastrar(vo);
			PessoaVO pessoa = new PessoaVO();
			pessoa = pessoaDAO.buscar(vo);
			
			if(pessoa != null) {
				UsuarioVO usuario = new UsuarioVO();
				usuario = usuarioDAO.buscarPorNomeDeUsuario(vo);
				if(usuario != null) {
					throw new InserirException("Não foi possível cadastrar o usuário "
							+ "porque o nome de usuário já existe");
				} else {
					if(vo.getSenha().length() > 4) {
						usuarioDAO.inserir(vo);
						System.out.println("Usuário cadastrado com sucesso!");
					} else {
						throw new InserirException("Não foi possível cadastrar o usuário"
						+ "porque a senha só tem" + vo.getSenha().length() + " caracteres. A senha "
								+ "tem que ter mais que 4 caracteres.");
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(VO vo) throws InserirException {
		try {
			UsuarioVO usuario = new UsuarioVO();
			usuario = usuarioDAO.buscar(vo);
			if(usuario != null) {
				usuarioDAO.deletar(vo);
			} else {
				throw new InserirException("Nada foi removido porque o usuário não existe!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(VO vo) throws InserirException {
		try {
			super.atualizar(vo);
			UsuarioVO usuario = new UsuarioVO();
			usuario = usuarioDAO.buscar(vo);
			if(usuario != null) {
				usuarioDAO.alterar(vo);
			} else {
				throw new InserirException("Nada foi alterado porque o usuário não "
						+ "existe!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public VO buscarPorId(VO vo) throws NaoEncontradoException {
	    if (vo instanceof UsuarioVO) {
	        UsuarioVO usuario = usuarioDAO.buscar(vo);
	        return (VO) usuario;
	    } else {
	        return null;
	    }
	}
	

	@Override
	public List<?> listarTodos() throws SQLException {
		List<?> usuarios = new ArrayList<UsuarioVO>();
		usuarios = usuarioDAO.listar();
		return usuarios;
	}
	
	
	public UsuarioVO autenticar(String nomeUsuario, String senha) throws NaoEncontradoException {
		UsuarioVO usuario = new UsuarioVO();
		usuario = usuarioDAO.autenticar(nomeUsuario, senha);
		return usuario;
	}
}