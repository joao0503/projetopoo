package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.AutomovelDAO;
import model.VO.AutomovelVO;
import model.VO.ClienteVO;

public class AutomovelBO implements BaseBO<AutomovelVO>{
	static private AutomovelDAO automovelDAO = new AutomovelDAO();

	@Override
	public void cadastrar(AutomovelVO vo) throws InserirException {
		try {
			List<AutomovelVO> automoveis = new ArrayList<AutomovelVO>();

			ClienteVO teste = new ClienteVO();
			teste = vo.getCliente();
			automoveis = automovelDAO.listarAutomoveisPorProprietario(teste);

			//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
			//erro bem aqui caralho buceta cu porra porra porra caralho

			System.out.println("Nome do cliente do karalho buveta: " + teste.getNome());

			for (AutomovelVO item : automoveis){
				if (item.getPlaca().equals(vo.getPlaca())){
					throw new InserirException("Não foi possível cadastrar o automovel porque ele "
						+ "já existe");
				}
				else{
					automovelDAO.inserir(vo);
				}
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

	public List<AutomovelVO> buscarPorCliente(ClienteVO cliente){
		try{
			List<AutomovelVO> automoveisDoCliente = new ArrayList<AutomovelVO>();
			automoveisDoCliente = automovelDAO.listarAutomoveisPorProprietario(cliente);
			return automoveisDoCliente;
		} catch (Exception e){
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
