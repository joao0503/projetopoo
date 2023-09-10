package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Servico;
import model.entity.Orcamento;

public class ServicoDao extends BaseDaoImpl<Servico>{


    public void inserir(Servico entity) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_servico (nome, valor, status)"
				+ "values (?,?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getNome());
			ps.setDouble(2, entity.getValor());
            ps.setInt(3, entity.getStatus());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    public void deletar(Servico entity) {
        Connection con = getConnection();
        String sql = "DELETE FROM tb_servico WHERE id = ?";
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
    public void alterar(Servico entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_servico SET nome = ?, valor = ?, status = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setDouble(2, entity.getValor());
            ps.setInt(3, entity.getStatus());
            ps.setLong(4, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    // Modificar a parte do retorno da função
    //
    public List<Servico> buscarPorNome(String nome){
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
	}
    
 }
