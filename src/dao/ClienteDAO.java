package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;

public class ClienteDAO extends PessoaDAO<Cliente> {

	@Override
	public void inserir(Cliente entity) {

		// Ao user o super, vou aproveitar o id da superclasse para ja usar aqui
		super.inserir(entity);
		Connection con = getConnection();
		String sql = "insert into tb_clientes (pessoa_id) values (?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, entity.getPessoaId());
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
        String sql = "delete from tb_clientes where cliente_id = ?";
        try {
        	super.deletar(entity);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getClienteId());
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
        String sql = "update tb_clientes set pessoa_id where cliente_id = ?";
        try {
        	super.alterar(entity);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getPessoaId());
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
        String sql = "select * from tb_clientes where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getClienteId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setClienteId(rs.getLong("id"));
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
        String sql = "select * from tb_clientes";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setClienteId(rs.getLong("id"));
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
