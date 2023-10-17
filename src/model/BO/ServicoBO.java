package model.BO;

import java.util.ArrayList;
import java.util.List;

import exception.InserirException;
import exception.NaoEncontradoException;
import model.DAO.PecaDAO;
import model.DAO.ServicoDAO;
import model.VO.PecaVO;
import model.VO.ServicoVO;

public class ServicoBO implements BaseBO<ServicoVO> {
	static private ServicoDAO servDAO = new ServicoDAO();
	static private PecaDAO pecDAO = new PecaDAO();

	@Override
	public void cadastrar(ServicoVO vo) throws InserirException {

		System.out.println("Nome do serviço no começo do servicoBO" + vo.getNome());
		System.out.println("Valor" + vo.getValor());
		// ServicoVO servico = new ServicoVO();
		// servico = servDAO.buscar(servico);
		try {
			PecaVO pecaa = new PecaVO();
			pecaa.setPecaId(vo.getPeca().getPecaId());
			System.out.println("\nPeca so 1: " + pecaa.getPecaId());

			pecaa = pecDAO.buscar(pecaa);
			System.out.println("\nPeca so 2: " + pecaa.getPecaId());
			System.out.println("\n Qtd da peca: " + pecaa.getQuantidadePeca());
			if (pecaa.getQuantidadePeca() > 0) {
				System.out.println("\nPeca so 3: " + pecaa.getPecaId());
				pecaa.setQuantidadePeca(pecaa.getQuantidadePeca() - 1);
				pecDAO.alterar(pecaa);
				try {
					System.out.println("Nome do serviço" + vo.getNome());
					servDAO.inserir(vo);
					System.out.println("Cadastrou o serviço meu consagrado");
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				throw new InserirException("Não foi possível cadastrar o serviço porque não tem"
						+ "a peça necessária para realizar o serviço");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(ServicoVO vo) throws InserirException {
		try {
			ServicoVO servico = new ServicoVO();
			servico = servDAO.buscar(vo);
			if (servico != null) {
				servDAO.deletar(vo);
			} else {
				throw new NaoEncontradoException(
						"Não foi possível deletar o serviço porque ele não " + "existe no banco de dados");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(ServicoVO vo) throws InserirException {
		try {
			ServicoVO servico = new ServicoVO();
			servico = servDAO.buscar(vo);
			if (servico != null) {
				servDAO.alterar(vo);
			} else {
				throw new InserirException(
						"Não foi possível alterar o serviço porque ele não " + "existe no banco de dados");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ServicoVO buscarPorId(ServicoVO vo) throws NaoEncontradoException {
		try {
			ServicoVO servico = new ServicoVO();
			servico = servDAO.buscar(vo);
			if(servico != null) {
				return servico;
			} else {
				throw new NaoEncontradoException("Serviço não encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ServicoVO> listarTodos() {
		try {
			List<ServicoVO> servicos = new ArrayList<ServicoVO>();
			servicos = servDAO.listar();
			if(servicos != null) {
				return servicos;
			} else {
				System.out.println("Os serviços estão f");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public void finalizarServico(ServicoVO vo) throws InserirException, NaoEncontradoException {
		try {
			ServicoVO servico = new ServicoVO();
			servico = servDAO.buscar(vo);
			if(servico != null) {
				if(vo.getStatus() == 1) {
					vo.setStatus(2);
					servDAO.finalizarServico(vo);
				} else {
					throw new InserirException("Não foi possível finalizar o serviço porque esse"
							+ "serviço não existe");
				}
			} else {
				throw new NaoEncontradoException("Serviço não encontrado");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}