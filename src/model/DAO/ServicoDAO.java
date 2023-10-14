package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.PecaVO;
import model.VO.ServicoVO;

public class ServicoDAO extends BaseDAOImpl<ServicoVO> {

    
	@Override
	public void inserir(ServicoVO serv) {
		Connection con = getConnection();
		String sql = "insert into tb_servicos (nome, valor, status, peca_id, dataInicio, dataFim, funcionario_id, cliente_id"
				+ "servico_id values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serv.getNome());
			ps.setDouble(2, serv.getValor());
            ps.setInt(3, serv.getStatus());
            ps.setLong(4, serv.getPeca().getPecaId());
            ps.setString(5, serv.getDataInicio());
            ps.setString(6, "");
            ps.setLong(7, serv.getFuncionarioId());
            ps.setLong(8, serv.getClienteId());
            ps.setLong(9, serv.getAutomovelId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    @Override
    public void deletar(ServicoVO serv) {
        Connection con = getConnection();
        String sql = "delete from servicos where servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, serv.getServicoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	

    @Override
    public void alterar(ServicoVO serv) {
        Connection con = getConnection();
        String sql = "update servicos set nome = ?, valor = ?, status = ?, peca_id = ?, "
        		+ "dataInicio = ?, dataFim = ?, funcionario_id = ?, cliente_id, automovel_id = ? where servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serv.getNome());
			ps.setDouble(2, serv.getValor());
            ps.setInt(3, serv.getStatus());
            ps.setLong(4, serv.getPeca().getPecaId());
            ps.setString(5, serv.getDataInicio());
            ps.setString(6, "");
            ps.setLong(7, serv.getFuncionarioId());
            ps.setLong(8, serv.getClienteId());
            ps.setLong(9, serv.getAutomovelId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    
    @Override
    public ServicoVO buscar(ServicoVO serv) {
        Connection con = getConnection();
        String sql = "select * from servicos inner join pecas on servicos.peca_id = "
        		+ "pecas.peca_id where servicos.peca_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, serv.getPeca().getPecaId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {  
                PecaVO peca = new PecaVO();
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                peca.setPecaId(rs.getLong("peca_id"));

            	ServicoVO servico = new ServicoVO();
            	servico.setNome(rs.getString("nome"));
            	servico.setValor(rs.getInt("valor"));
            	servico.setStatus(rs.getInt("status"));
            	servico.setPeca(peca);
            	servico.setDataInicio("dataInicio");
            	servico.setFuncionarioId(rs.getLong("funcionario_id"));
            	servico.setClienteId(rs.getLong("cliente_id"));
            	servico.setServicoId(rs.getLong("servico_id"));
                return servico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<ServicoVO> listar() {
        Connection con = getConnection();
        //String sql = "select * from servicos union select * from tb_pecas";
        String sql = "select * from servicos inner join pecas";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ServicoVO> servicos = new ArrayList<ServicoVO>();
            while (rs.next()) {
                    PecaVO peca = new PecaVO();
                    peca.setNome(rs.getString("nome"));
                    peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                    peca.setFabricante(rs.getString("fabricante"));
                    peca.setPreco(rs.getDouble("preco"));
                    peca.setPecaId(rs.getLong("peca_id"));

                	ServicoVO serv = new ServicoVO();
                	serv.setNome(rs.getString("nome"));
                	serv.setValor(rs.getInt("valor"));
                	serv.setStatus(rs.getInt("status"));
                	serv.setPeca(peca);
                	serv.setFuncionarioId(rs.getLong("funcionario_id"));
                	serv.setClienteId(rs.getLong("cliente_id"));
                	serv.setServicoId(rs.getLong("servico_id"));
                	servicos.add(serv);
            }
            return servicos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    // Modificar a parte do retorno da função
    //
    /*public List<Servico> buscarPorNome(String nome){
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_servico WHERE nome = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Orcamento orc = new Orcamento();
                orc.setPeca(rs.getString("peça"));
                orc.setServico(rs.getString("serviço"));
                return orc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
	}*/
 //}
}
