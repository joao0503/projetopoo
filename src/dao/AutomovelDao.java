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

public class AutomovelDao extends BaseDaoImpl<Automovel>{

	@Override
	public void inserir(Automovel entity) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_automovel (marca, cor, placa, quilometragem, proprietario, orcamentoTotal)"
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getMarca());
			ps.setString(2, entity.getCor());
			ps.setString(3, entity.getPlaca());
			ps.setInt(4, entity.getQuilometragem());
			ps.setString(5, entity.getProprietario().getNome());
			ps.setDouble(6, entity.getOrcamentoTotal().getValor());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
			System.out.println("Chegou aqui!");
		}
		
	}

    @Override
    public void deletar(Automovel entity) {
        Connection con = getConnection();
        String comando = "DELETE FROM tb_automovel WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(comando);
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
    public void alterar(Automovel entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_automovel SET marca = ?, cor = ?, placa = ?, quilometragem = ?, proprietario = ?, orcamentoTotal = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getMarca());
            ps.setString(2, entity.getCor());
            ps.setString(3, entity.getPlaca());
            ps.setInt(4, entity.getQuilometragem());
            ps.setString(5, entity.getProprietario().getNome());
            ps.setDouble(5, entity.getOrcamentoTotal().getValor());
            ps.setLong(6, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Automovel buscar(Automovel entity) {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_automovel WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Automovel automovel = new Automovel();
                automovel.setId(rs.getLong("id"));
                automovel.setMarca(rs.getString("marca"));
                automovel.setCor(rs.getString("cor"));
                automovel.setPlaca(rs.getString("placa"));
                //automovel.setProprietario(rs.getString("proprietario"));
                //automovel.setOrcamentoTotal(rs.getString("orcamentoTotal"));
                
                return automovel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<Automovel> listar() {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_automovel";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Automovel> automoveis = new ArrayList<>();
            while (rs.next()) {
                Automovel automovel = new Automovel();
                automovel.setMarca(rs.getString("marca"));
                automovel.setCor(rs.getString("cor"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setQuilometragem(rs.getInt("quilometragem"));
                //automovel.setProprietario(rs.getString("proprietario"));
                //automovel.setOrcamentoTotal(rs.getString("orcamentoTotal"));
                automovel.setId(rs.getLong("id"));
                automoveis.add(automovel);
            }
            return automoveis;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

}
