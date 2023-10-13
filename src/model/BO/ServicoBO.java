package model.BO;

import java.sql.SQLException;

import model.DAO.ServicoDAO;
import model.VO.ServicoVO;

public class ServicoBO {
	static private ServicoDAO servDAO = new ServicoDAO();
	
	// pensar se vai ter status 1,2 e 3
	public void iniciarServico(ServicoVO serv) {
		// verificar se tem peça disponivel no banco de dados
	}
	public void finalizarServico(ServicoVO serv) throws SQLException {
			serv.setStatus(2);
			servDAO.alterar(serv);
	}
}
