package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Usuario;
import model.entity.Funcionario;

public class UsuarioDao extends BaseDaoImpl<Usuario>{

	@Override
	public void inserir(Usuario entity) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_usuario (usuario, senha)"
				+ "values (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getUsuario());
			ps.setString(2, entity.getSenha());
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
    public void deletar(Usuario entity) {
        Connection con = getConnection();
        String sql = "DELETE FROM tb_usuario WHERE id = ?";
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
    public void alterar(Usuario entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_usuario SET usuario = ?, senha = ?, WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getUsuario());
            ps.setString(2, entity.getSenha());
            ps.setLong(3, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Usuario buscar(Usuario entity) {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_usuario WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Funcionario();
                usuario.setId(rs.getLong("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<Usuario> listar() {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_usuario";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                Usuario usuario = new Funcionario();
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setId(rs.getLong("id"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

}
