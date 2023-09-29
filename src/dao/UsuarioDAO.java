package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entity.Funcionario;
import model.entity.Gerente;
import model.entity.Usuario;

public class UsuarioDAO<E extends Usuario> extends PessoaDAO<E>{
	
	@Override
	public void inserir(E entity) {
		//PessoaDAO dao = new PessoaDAO();
		//dao.inserir(entity);
		//dao.buscar(entity);
		
		Connection con = getConnection();
		String sql = "insert into tb_usuarios (usuario, senha, pessoa_id) "
				+ "values (?, ?, ?)";
		
		try {
			// Ao user o super, vou aproveitar o pessoa_id da superclasse para ja usar aqui
			super.inserir(entity);
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, entity.getUsuario());
			ps.setString(2, entity.getSenha());
			ps.setLong(3, entity.getPessoaId());
			
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows == 0) {
            	throw new SQLException("Não foi possível inserir. Nenhuma linha alterada.");
            }
            
            // pegando o id gerado pelo banco de dados
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
            	entity.setUsuarioId(generatedKeys.getLong(1));
            } else {
            	throw new SQLException("A inserçao falhou. Nenhum id foi retornado.");
            }
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}

	
    @Override
    public void deletar(E entity) {
        Connection con = getConnection();
        String sql = "delete from tb_usuarios where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getUsuarioId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    @Override
    public void alterar(E entity) {
        Connection con = getConnection();
        String sql = "update tb_usuarios set usuario = ?, senha = ?, pessoa_id = ? where usuario_id = ?";
        try {
        	super.alterar(entity);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getUsuario());
            ps.setString(2, entity.getSenha());
            ps.setLong(3, entity.getUsuarioId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public E buscar(E entity) {
    	return null;
    }
    
    
    public ResultSet buscarUsuario(E entity) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs = null;
        // inner join com tb_pessoas ?
        String sql = "select * from tb_usuarios where usuario_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getUsuarioId());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rs;
    }
    
    // A classe Pessao é abstrata, logo não pode ser instanciada, por isso o listar se tornou
    // listarPessoas, nela é retornado um ResultSet, não sendo necessário instanciar Pessoa.
    // O ResultSet retornado pode ser usado na aplicação para instanciar qual classe precisar.
    @Override
    public List<E> listar() {
    	return null;
    }
    
    
    // c
    public ResultSet listarUsuarios() {
        Connection con = getConnection();
        String sql = "select * from tb_usuarios";
        Statement st;
        ResultSet rs = null;
        try {
            //PreparedStatement ps = con.prepareStatement(sql);
        	st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rs;
    }
    
    // simulando autenticação
    public Usuario autent(Usuario usu) {
    	if(usu.getUsuario().equals("gerente") && usu.getSenha().equals("geren")) {
    		return new Gerente();
    	}
    	if(usu.getUsuario().equals("funcionario") 
    			&& usu.getSenha().equals("funcio")) {
    		return new Funcionario();
    	}
    	return null;
    }
}
