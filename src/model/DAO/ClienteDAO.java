package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.ClienteVO;

public class ClienteDAO extends PessoaDAO<ClienteVO> {

	@Override
	public void inserir(ClienteVO vo) {
		Connection con = getConnection();
		String sql = "insert into clientes (desconto, pessoa_id) values (?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, vo.getDesconto());
			ps.setLong(2, vo.getPessoaId());
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
    public void deletar(ClienteVO vo) {
        Connection con = getConnection();
        String sql = "delete from clientes where cliente_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, vo.getClienteId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    @Override
    public void alterar(ClienteVO vo) {
        Connection con = getConnection();
        String sql = "update clientes set desconto = ?, set pessoa_id = ? where cliente_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, vo.getDesconto());
            ps.setLong(2, vo.getPessoaId());
            ps.setLong(2, vo.getClienteId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public ClienteVO buscar(ClienteVO vo) {
    	super.buscar(vo);
        Connection con = getConnection();
        String sql = "select * from tb_clientes where cliente_id = ?";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getClienteId());
            rs = ps.executeQuery();
            if (rs.next()) {
                //ClienteVO cliente = new ClienteVO();
                vo.setDesconto(rs.getDouble("desconto"));
                vo.setClienteId(rs.getLong("cliente_id"));
                return vo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<ClienteVO> listar() {
        Connection con = getConnection();
        String sql = "select * from pessoas inner join clientes on pessoas.pessoa_id = clientes.pessoa_id";
        ResultSet rs = null;
        List<ClienteVO> clientes = new ArrayList<ClienteVO>();
        System.out.println(clientes);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteVO cliente = new ClienteVO();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setClienteId(rs.getLong("cliente_id"));
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
