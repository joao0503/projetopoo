package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Automovel;
import model.entity.Cliente;
import model.entity.Orcamento;
import model.entity.Peca;
import model.entity.Servico;

public class OrcamentoDao extends BaseDaoImpl<Orcamento>{

    public void inserir(Orcamento entity) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_orcamento (peca, servico)"
				+ "values (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getPeca());
			ps.setString(2, entity.getServico());
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
    public void deletar(Orcamento entity) {
        Connection con = getConnection();
        String sql = "DELETE FROM tb_orcamento WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    @Override
    public void alterar(Orcamento entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_orcamento SET peca = ?, servico = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getPeca());
            ps.setString(2, entity.getServico());
            // setter do serviço
            ps.setLong(3, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public Orcamento buscarPorAutomovel(Automovel automovel){
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
    }


    // Modificar a parte do retorno da função
    //
    public Orcamento buscarPorCliente(Cliente cliente){
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
    }

    // Modificar a parte do retorno da função
    //
    public Orcamento buscarPorPeriodo(Date periodo){
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
    }
}