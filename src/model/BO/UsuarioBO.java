package model.BO;

import java.sql.SQLException;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.UsuarioDAO;
import model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> implements BaseBO<VO> {
	static private UsuarioDAO<UsuarioVO> usuarioDAO = new UsuarioDAO<UsuarioVO>();

	@Override
	public void cadastrar(VO vo) throws InserirException {
		try {
			UsuarioVO usuario = new UsuarioVO();
			usuario = usuarioDAO.buscarPorNomeDeUsuario(vo);
			if(usuario == null) {
				throw new InserirException("Não foi possível cadastrar o usuário "
						+ "porque o nome de usuário já existe");
			} else {
				if(vo.getSenha().length() > 4) {
					usuarioDAO.inserir(vo);
				} else {
					throw new InserirException("Não foi possível cadastrar o usuário"
					+ "porque a senha só tem" + vo.getSenha().length() + " caracteres. A senha que ter mais que 4 caracteres.");
				}
			}
		} catch(SQLException e) {
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
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(VO vo) throws InserirException {
		try {
			UsuarioVO usuario = new UsuarioVO();
			usuario = usuarioDAO.buscar(vo);
			if(usuario != null) {
				usuarioDAO.alterar(vo);
			} else {
				throw new InserirException("Nada foi alterado porque o usuário não "
						+ "existe!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	public VO buscarPorId(VO vo) throws NaoEncontradoException {
	    if (vo instanceof UsuarioVO) {
	        UsuarioVO usuario = usuarioDAO.buscar(vo);
	        return (VO) usuario;
	    } else {
	        return null;
	    }
	}
	

	@Override
	public List<VO> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
