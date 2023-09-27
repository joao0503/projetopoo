package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Automovel;
import model.entity.Cliente;

public class AutomovelDAO extends BaseDAOImpl<Automovel>{
	
	
	@Override
	public void inserir(Automovel entity) {
		Connection con = getConnection();
		
		// teste aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		
		String sql = "insert into tb_automoveis (marca, modelo, ano_modelo, cor, placa, quilometragem, cliente_id)"
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getMarca());
			ps.setString(2, entity.getModelo());
			ps.setInt(3, entity.getAnoDoModelo());
			ps.setString(4, entity.getCor());
			ps.setString(5, entity.getPlaca());
			ps.setInt(6, entity.getQuilometragem());
			ps.setLong(7, entity.getClienteId());
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
    public void deletar(Automovel entity) {
        Connection con = getConnection();
        String comando = "delete from tb_automovel where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(comando);
            ps.setLong(1, entity.getAutomovelId());
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
        String sql = "update tb_automoveis set marca = ?, modelo = ?, anoDoModelo = ?, cor = ?, placa = ?, quilometragem = ?, cliente_id = ? where automovel_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getMarca());
			ps.setString(2, entity.getModelo());
			ps.setInt(3, entity.getAnoDoModelo());
			ps.setString(4, entity.getCor());
			ps.setString(5, entity.getPlaca());
			ps.setInt(6, entity.getQuilometragem());
			ps.setLong(7, entity.getClienteId());
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
        String sql = "select * from tb_automoveis where automovel_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getAutomovelId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Automovel automovel = new Automovel();
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
    public List<Automovel> listar() {
        Connection con = getConnection();
        String sql = "select * from tb_automoveis";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Automovel> automoveis = new ArrayList<>();
            while (rs.next()) {
                Automovel automovel = new Automovel();
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
    
    
    public Automovel buscarAutomovelPorPlaca(String placa) {
        Connection con = getConnection();
        String sql = "selct * from tb_automoveis where placa = ?";
        Automovel automovel = new Automovel();
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
    
    
    public List<Automovel> listarAutomoveisPorProprietario(Cliente cli) {
        Connection con = getConnection();
        String sql = "select * from tb_automoveis where cliente_id = ?";
        
        List<Automovel> automoveis = new ArrayList<Automovel>();
        
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, cli.getClienteId());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Automovel automovel = new Automovel();
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
