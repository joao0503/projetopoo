package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.PecaDAO;
import model.VO.PecaVO;

public class PecaBO implements BaseBO<PecaVO>{
    static private PecaDAO pecaDAO = new PecaDAO();

    public void cadastrar(PecaVO vo) throws InserirException {
        if (vo.getNome().isEmpty()) {
            throw new InserirException("Não é possível adicionar uma peça com o nome vazio.");
        }
        if (vo.getQuantidadePeca() <= 0) {
            throw new InserirException("Por favor insira um número positivo de peças.");
        }
        if (vo.getFabricante().isEmpty()) {
            throw new InserirException("Por favor especifique o fabricante da peça.");
        }
        if (vo.getPreco() <= 0) {
            throw new InserirException("Por favor insira um preço positivo para a peça");
        }
        pecaDAO.inserir(vo);
    }

    @Override
    public void remover(PecaVO vo) throws NaoEncontradoException {
        try {
            PecaVO peca = new PecaVO();
            peca = pecaDAO.buscar(vo);
			System.out.println("Peça é: " + peca);
			if(peca != null) {
				pecaDAO.deletar(vo);
			} else {
				throw new InserirException("Não foi possível remover a peça porque"
						+ "não existe no banco de dados");
			}
        } catch(SQLException e) {
			e.printStackTrace();
        }
    }

    @Override
    public void atualizar(PecaVO vo) throws InserirException {
        try {
            PecaVO peca = new PecaVO();
            peca = pecaDAO.buscar(vo);
			System.out.println("Peça é: " + peca);
			if(peca != null) {
				pecaDAO.alterar(vo);
			} else {
				throw new InserirException("Não foi possível remover a peça porque"
						+ "não existe no banco de dados");
			}
        } catch(SQLException e) {
			e.printStackTrace();
        }
    }

    @Override
    public PecaVO buscarPorId(PecaVO vo) throws NaoEncontradoException {
        try {
			PecaVO peca = new PecaVO();
			peca = pecaDAO.buscar(vo);
			return (PecaVO) peca;
		} catch(Exception e) {
			throw new NaoEncontradoException("Pessoa com id " + vo.getPecaId() 
			+" não foi encontrada no banco de dados");
		}
    }

    @Override
    public List<?> listarTodos() throws SQLException {
        List<?> peca = new ArrayList<PecaVO>();
		peca = pecaDAO.listar();
		return peca;
    }
    
}
