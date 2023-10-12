package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.PecaVO;

public class PecaDAO extends BaseDAOImpl<PecaVO>{

	@Override
	public void inserir(PecaVO entity) {
		Connection con = getConnection();
		String sql = "insert into pecas (nome, quantidade_peca, fabricante, preco) values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getNome());
			ps.setInt(2, entity.getQuantidadePeca());
            ps.setString(3, entity.getFabricante());
            ps.setDouble(4, entity.getPreco());
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
    public void deletar(PecaVO entity) {
        Connection con = getConnection();
        String sql = "delete from pecas where peca_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getPecaId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    @Override
    public void alterar(PecaVO entity) {
        Connection con = getConnection();
        String sql = "update pecas set nome = ?, quantidade_peca = ?, fabricante = ?, preco = ? "
        		+ "where peca_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setInt(2, entity.getQuantidadePeca());
            ps.setString(3, entity.getFabricante());
            ps.setDouble(4, entity.getPreco());
            ps.setLong(5, entity.getPecaId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public PecaVO buscar(PecaVO entity) {
        Connection con = getConnection();
        String sql = "select * from pecas where peca_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getPecaId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PecaVO peca = new PecaVO();
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                peca.setPecaId(rs.getLong("peca_id"));
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
    public List<PecaVO> listar() {
        Connection con = getConnection();
        String sql = "select * from pecas";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<PecaVO> pecas = new ArrayList<PecaVO>();
            while (rs.next()) {
                PecaVO peca = new PecaVO();
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                peca.setPecaId(rs.getLong("peca_id"));
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
