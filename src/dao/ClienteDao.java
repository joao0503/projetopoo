package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;

public class ClienteDao extends BaseDaoImpl<Cliente> {

	@Override
	public void inserir(Cliente entity) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_cliente (nome, endereco, cpf)"
				+ "values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getEndereco());
			ps.setString(3, entity.getCpf());
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
    public void deletar(Cliente entity) {
        Connection con = getConnection();
        String sql = "DELETE FROM tb_cliente WHERE id = ?";
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
    public void alterar(Cliente entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_cliente SET nome = ?, endereco = ?, cpf = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getEndereco());
            ps.setString(3, entity.getCpf());
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
    public Cliente buscar(Cliente entity) {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_cliente WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setId(rs.getLong("id"));
                //automovel.setProprietario(rs.getString("proprietario"));
                //automovel.setOrcamentoTotal(rs.getString("orcamentoTotal"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_cliente";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                //cliente.setAutomoveis(rs.getString("automoveis"));
                cliente.setId(rs.getLong("id"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}
