package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.AutomovelDAO;
import model.VO.AutomovelVO;

public class AutomovelBO implements BaseBO<AutomovelVO>{
	static private AutomovelDAO automovelDAO = new AutomovelDAO();

	@Override
	public void cadastrar(AutomovelVO vo) throws InserirException {
		try {
			AutomovelVO automovel = new AutomovelVO();
			automovel = automovelDAO.buscar(vo);
			
			if(automovel == null) {
				if(!vo.getPlaca().isEmpty()) {
					automovelDAO.inserir(vo);
				} else {
					throw new InserirException("Não foi possível cadastrar o automovel porque a"
							+ "placa não pode ser vazia");
				}
			} else {
				throw new InserirException("Não foi possível cadastrar o automovel porque ele "
						+ "já existe");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(AutomovelVO vo) throws InserirException {
		try {
			// ao buscar com pessoaDAO, o vo que
			AutomovelVO automovel = new AutomovelVO();
			automovel = automovelDAO.buscar(vo);
			if (automovel != null) {
				automovelDAO.deletar(vo);
			} else {
				throw new InserirException("Não foi possível deletar o automovel porque" 
			+ "não existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(AutomovelVO vo) throws InserirException {
		try {
			AutomovelVO automovel = new AutomovelVO();
			automovel = automovelDAO.buscar(vo);
			if (automovel != null) {
				automovelDAO.alterar(vo);
			} else {
				throw new InserirException("Não foi possível alterar o cliente porque não "
						+ "existe no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AutomovelVO buscarPorId(AutomovelVO vo) throws NaoEncontradoException {
		try {
			AutomovelVO automovel = new AutomovelVO();
			automovel = automovelDAO.buscar(vo);
			return automovel;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AutomovelVO> listarTodos() {
		try {
			List<AutomovelVO> automoveis = new ArrayList<AutomovelVO>();
			automoveis = automovelDAO.listar();
			return automoveis;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
