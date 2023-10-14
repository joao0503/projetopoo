package model.BO;

import java.sql.SQLException;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.ServicoDAO;
import model.VO.ServicoVO;

public class ServicoBO implements BaseBO<ServicoVO>{
	static private ServicoDAO servDAO = new ServicoDAO();
	
	@Override
	public void cadastrar(ServicoVO vo) throws InserirException {
		ServicoVO servico = new ServicoVO();
		servico = servDAO.buscar(servico);
		if(servico == null) {
			servDAO.inserir(vo);
		} else {
			throw new InserirException("Não foi possível cadastrar o serviço porque ele já existe"
					+ "no banco de dados");
		}
	}
	@Override
	public void remover(ServicoVO vo) throws InserirException, NaoEncontradoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void atualizar(ServicoVO vo) throws InserirException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ServicoVO buscarPorId(ServicoVO vo) throws NaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<?> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	// pensar se vai ter status 1,2 e 3
	public void iniciarServico(ServicoVO serv) {
		// verificar se tem peça disponivel no banco de dados
	}
	public void finalizarServico(ServicoVO serv) throws SQLException {
			serv.setStatus(2);
			servDAO.alterar(serv);
	}
}
