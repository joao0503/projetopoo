package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Peca;

public class PecaDao extends BaseDaoImpl<Peca>{

	@Override
	public void inserir(Peca entity) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_peca (nome, quantidadePeca, fabricante, preco)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getNome());
			ps.setInt(2, entity.getQuantidadePeca());
            ps.setString(3, entity.getFabricante());
            ps.setDouble(4, entity.getPreco());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    @Override
    public void deletar(Peca entity) {
        Connection con = getConnection();
        String sql = "DELETE FROM tb_peca WHERE id = ?";
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
    public void alterar(Peca entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_peca SET nome = ?, quantidadePeca = ?, fabricante = ?, preco = ?, WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setInt(2, entity.getQuantidadePeca());
            ps.setString(3, entity.getFabricante());
            ps.setDouble(4, entity.getPreco());
            ps.setLong(5, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Peca buscar(Peca entity) {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_peca WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getLong("id"));
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidadePeca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                return peca;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<Peca> listar() {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_peca";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Peca> pecas = new ArrayList<>();
            while (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getLong("id"));
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidadePeca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                pecas.add(peca);
            }
            return pecas;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

}
