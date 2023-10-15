package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.AutomovelVO;
import model.VO.ClienteVO;

public class AutomovelDAO extends BaseDAOImpl<AutomovelVO>{
	
	
	@Override
	public void inserir(AutomovelVO vo) {
		Connection con = getConnection();
		
		String sql = "insert into automoveis (marca, modelo, ano_modelo, cor, placa, quilometragem, cliente_id)"
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getMarca());
			ps.setString(2, vo.getModelo());
			ps.setInt(3, vo.getAnoDoModelo());
			ps.setString(4, vo.getCor());
			ps.setString(5, vo.getPlaca());
			ps.setInt(6, vo.getQuilometragem());
			ps.setLong(7, vo.getClienteId());
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
    public void deletar(AutomovelVO vo) {
        Connection con = getConnection();
        String sql = "delete from automoveis where automovel_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getAutomovelId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    
    @Override
    public void alterar(AutomovelVO vo) {
        Connection con = getConnection();
        String sql = "update automoveis set marca = ?, modelo = ?, anoDoModelo = ?, cor = ?, placa = ?, quilometragem = ?, cliente_id = ? where automovel_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getMarca());
			ps.setString(2, vo.getModelo());
			ps.setInt(3, vo.getAnoDoModelo());
			ps.setString(4, vo.getCor());
			ps.setString(5, vo.getPlaca());
			ps.setInt(6, vo.getQuilometragem());
			ps.setLong(7, vo.getClienteId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    
    
    @Override
    public AutomovelVO buscar(AutomovelVO vo) {
        Connection con = getConnection();
        String sql = "select * from automoveis where automovel_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getAutomovelId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AutomovelVO automovel = new AutomovelVO();
                automovel.setMarca(rs.getString("marca"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setAnoDoModelo(rs.getInt("ano_do_modelo"));
                automovel.setCor(rs.getString("cor"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setQuilometragem(rs.getInt("quilometragem"));
                automovel.setAutomovelId(rs.getLong("automovel_id"));
                automovel.setClienteId(rs.getLong("cliente_id"));
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
    public List<AutomovelVO> listar() {
        Connection con = getConnection();
        String sql = "select * from automoveis";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<AutomovelVO> automoveis = new ArrayList<>();
            while (rs.next()) {
                AutomovelVO automovel = new AutomovelVO();
                automovel.setMarca(rs.getString("marca"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setAnoDoModelo(rs.getInt("ano_do_modelo"));
                automovel.setCor(rs.getString("cor"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setQuilometragem(rs.getInt("quilometragem"));
                automovel.setAutomovelId(rs.getLong("automovel_id"));
                automovel.setClienteId(rs.getLong("cliente_id"));
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
    
    
    public AutomovelVO buscarAutomovelPorPlaca(String placa) {
        Connection con = getConnection();
        String sql = "selct * from automoveis where placa = ?";
        AutomovelVO automovel = new AutomovelVO();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                automovel.setMarca(rs.getString("marca"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setAnoDoModelo(rs.getInt("ano_do_modelo"));
                automovel.setCor(rs.getString("cor"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setQuilometragem(rs.getInt("quilometragem"));
                automovel.setAutomovelId(rs.getLong("automovel_id"));
                automovel.setClienteId(rs.getLong("cliente_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return automovel;
    }
    
    
    public List<AutomovelVO> listarAutomoveisPorProprietario(ClienteVO cli) {
        Connection con = getConnection();
        String sql = "select * from automoveis where cliente_id = ?";
        
        List<AutomovelVO> automoveis = new ArrayList<AutomovelVO>();
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, cli.getClienteId());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                AutomovelVO automovel = new AutomovelVO();
                automovel.setMarca(rs.getString("marca"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setAnoDoModelo(rs.getInt("ano_do_modelo"));
                automovel.setCor(rs.getString("cor"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setQuilometragem(rs.getInt("quilometragem"));
                automovel.setAutomovelId(rs.getLong("automovel_id"));
                automovel.setClienteId(rs.getLong("cliente_id"));
                automoveis.add(automovel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    	return automoveis;
    }

}
