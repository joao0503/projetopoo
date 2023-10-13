package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.GerenteDAO;
import model.DAO.UsuarioDAO;
import model.VO.GerenteVO;

public class GerenteBO extends UsuarioBO<GerenteVO> {
	static private GerenteDAO gerDAO = new GerenteDAO();
	static private UsuarioDAO<GerenteVO> usuDAO = new UsuarioDAO<GerenteVO>();

	@Override
	public void cadastrar(GerenteVO vo) throws InserirException {
		super.cadastrar(vo);
		GerenteVO usuario = new GerenteVO();
		usuario = usuDAO.buscar(vo);
		try {
			if(usuario != null) {
				gerDAO.inserir(vo);
			} else {
				throw new InserirException("Não foi possível cadastrar o gerente porque não existe"
						+ "um usuário com o id.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(GerenteVO vo) throws InserirException {
		try {
			// ao buscar com pessoaDAO, o vo que
			GerenteVO gerente = new GerenteVO();
			gerente = gerDAO.buscar(vo);
			if (gerente != null) {
				gerDAO.deletar(vo);
			} else {
				throw new InserirException("Não foi possível remover o gerente porque" 
			+ "não existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(GerenteVO vo) throws InserirException {
		try {
			super.atualizar(vo);
			GerenteVO gerente = new GerenteVO();
			gerente = gerDAO.buscar(vo);
			if (gerente != null) {
				gerDAO.alterar(vo);
			} else {
				throw new InserirException("Não foi possível alterar o gerente porque não "
						+ "existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public GerenteVO buscarPorId(GerenteVO vo) throws NaoEncontradoException {
		GerenteVO gerente = new GerenteVO();
		gerente = gerDAO.buscar(vo);
		return (GerenteVO) gerente;
	}

	@Override
	public List<GerenteVO> listarTodos() {
		List<GerenteVO> gerente = new ArrayList<GerenteVO>();
		gerente = gerDAO.listar();
		return gerente;
	}
}
