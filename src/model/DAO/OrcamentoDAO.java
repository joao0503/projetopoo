package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.AutomovelVO;
import model.VO.OrcamentoVO;
import model.VO.PecaVO;
import model.VO.ServicoVO;

public class OrcamentoDAO extends BaseDAOImpl<OrcamentoVO>{

	@Override
    public void inserir(OrcamentoVO entity) {
		Connection con = getConnection();
		String sql = "insert into tb_orcamentos (servico_id, valor) values (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, entity.getServico().getServicoId());
			ps.setDouble(2, entity.getValor());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    @Override
    public void deletar(OrcamentoVO entity) {
        Connection con = getConnection();
        String sql = "delete from tb_orcamentos where orcamento_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getOrcamentoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    
    @Override
    public void alterar(OrcamentoVO entity) {
        Connection con = getConnection();
        String sql = "update tb_orcamentos set servico_id = ?, valor = ? where orcamento_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, entity.getServico().getServicoId());
			ps.setDouble(2, entity.getValor());
			ps.setDouble(3, entity.getOrcamentoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
       
    
    @Override
    public OrcamentoVO buscar(OrcamentoVO entity) {
        Connection con = getConnection();
        String sql = "select * from tb_orcamentos inner join tb_servicos on tb_orcamentos.servico_id = "
        		+ "tb_servicos.servico_id inner join tb_pecas on tb_servicos.servico_id = "
        		+ "tb_pecas.servico_id where tb_servicos.servico_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getServico().getServicoId());
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
                servico.setFuncionarioId(rs.getLong("funcionario_id"));
                servico.setClienteId(rs.getLong("cliente_id"));
                servico.setServicoId(rs.getLong("servico_id"));
                
                OrcamentoVO orcamen = new OrcamentoVO();
                orcamen.setServico(servico);
                orcamen.setValor(rs.getDouble("valor"));
                orcamen.setOrcamentoId(rs.getLong("orcamento_id"));
                return orcamen;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    @Override
    public List<OrcamentoVO> listar() {
        Connection con = getConnection();
        String sql = "select * from tb_orcamentos inner join tb_servicos on tb_orcamentos.orcamento_id = "
        		+ "tb_servicos.orcamento_id inner join tb_pecas on tb_servicos.orcamento_id = "
        		+ "tb_pecas.orcamento_id";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<OrcamentoVO> orcamentos = new ArrayList<>();
            while(rs.next()) {
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
                servico.setFuncionarioId(rs.getLong("funcionario_id"));
                servico.setClienteId(rs.getLong("cliente_id"));
                servico.setServicoId(rs.getLong("servico_id"));
                
                OrcamentoVO orcamen = new OrcamentoVO();
                orcamen.setServico(servico);
                orcamen.setValor(rs.getDouble("valor"));
                orcamen.setOrcamentoId(rs.getLong("orcamento_id"));
                orcamentos.add(orcamen);
            }
            return orcamentos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    public List<OrcamentoVO> listarOrcamentosPorVeiculo(AutomovelVO aut) {
        Connection con = getConnection();
        String sql = "select * from tb_orcamentos inner join tb_servicos on tb_orcamentos.automovel_id = "
        		+ "tb_servicos.automovel_id inner join tb_pecas on tb_servicos.automovel_id = "
        		+ "tb_pecas.automovel_id where tb_servicos.automovel_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, aut.getAutomovelId());
            ResultSet rs = ps.executeQuery();
            List<OrcamentoVO> orcamentos = new ArrayList<>();
            while(rs.next()) {
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
                servico.setFuncionarioId(rs.getLong("funcionario_id"));
                servico.setClienteId(rs.getLong("cliente_id"));
                servico.setServicoId(rs.getLong("servico_id"));
                
                OrcamentoVO orcamen = new OrcamentoVO();
                orcamen.setServico(servico);
                orcamen.setValor(rs.getDouble("valor"));
                orcamen.setOrcamentoId(rs.getLong("orcamento_id"));
                orcamentos.add(orcamen);
            }
            return orcamentos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    /*public Orcamento buscarPorAutomovel(Automovel automovel){
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_orcamento WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Orcamento orc = new Orcamento();
                orc.setPeca(rs.getString("peça"));
                orc.setServico(rs.getString("serviço"));
                // setter do período
                return orc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }*/


    // Modificar a parte do retorno da função
    //
    /*public Orcamento buscarPorCliente(Cliente cliente){
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_orcamento WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Orcamento orc = new Orcamento();
                orc.setPeca(rs.getString("peça"));
                orc.setServico(rs.getString("serviço"));
                // setter do período
                return orc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }*/

    // Modificar a parte do retorno da função
    //
    /*public Orcamento buscarPorPeriodo(Date periodo){
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_orcamento WHERE id = ?"; // alterar depois para encontrar o campo de data
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Orcamento orc = new Orcamento();
                orc.setPeca(rs.getString("peça"));
                orc.setPeca(rs.getString("serviço"));
                return orc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }*/
}