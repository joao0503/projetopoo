package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.VO.FuncionarioVO;
import model.VO.GerenteVO;
import model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends PessoaDAO<VO>{
	
	@Override
	public void inserir(VO vo) {
		//super.inserir(vo);
		Connection con = getConnection();
		// adicionar tipo_id ou tipo_usuario como String ?!
		String sql = "insert into usuarios (nome_usuario, senha, email, tipo_id, "
				+ "pessoa_id) values (?, ?, ?, ?, ?)";
		
		try {
			// Ao user o super, vou aproveitar o pessoa_id da superclasse para ja 
			// usar aqui
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, vo.getUsuario());
			ps.setString(2, vo.getSenha());
			ps.setString(3, vo.getEmail());
			ps.setInt(4, vo.getTipoDeUsuario());
			ps.setLong(5, vo.getPessoaId());
			
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows == 0) {
            	throw new SQLException("Não foi possível inserir. Nenhuma linha alterada.");
            }
            
            // pegando o id gerado pelo banco de dados
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
            	vo.setUsuarioId(generatedKeys.getLong(4));
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
    public void deletar(VO vo) {
        Connection con = getConnection();
        //String sql = "delete from usuarios where usuario_id = ?";
        String sql = "delete from usuarios where pessoa_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getPessoaId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    @Override
    public void alterar(VO vo) {
        Connection con = getConnection();
        String sql = "update usuarios set usuario = ?, senha = ? where pessoa_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUsuario());
			ps.setString(2, vo.getSenha());
			ps.setString(3, vo.getEmail());
			ps.setInt(4, vo.getTipoDeUsuario());
			ps.setLong(5, vo.getPessoaId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    
    @Override
    public VO buscar(VO vo) {
    	super.buscar(vo);
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs = null;
        //String sql = "select * from pessoas inner join usuarios on pessoas.pessoa_id"
        //		+ " = usuarios.pessoa_id where pessoas.pessoa_id = ?";
        
        String sql = "select * from usuarios where pessoa_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getPessoaId());
            rs = ps.executeQuery();
        	if(rs.next()) {
        		//UsuarioVO usu = new UsuarioVO();
        		vo.setUsuario(rs.getString("nome_usuario"));
        		vo.setSenha(rs.getString("senha"));
        		vo.setEmail(rs.getString("email"));
        		vo.setUsuarioId(rs.getLong("usuario_id"));
        		vo.setPessoaId(rs.getLong("pessoa_id"));
        		vo.setTipoDeUsuario(rs.getInt("tipo_id"));
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
    //public List<UsuarioVO> listar() {
    public List<?> listar() {
        Connection con = getConnection();
        String sql = "select * from usuarios";
        Statement st;
        ResultSet rs = null;
        List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
        try {
            //PreparedStatement ps = con.prepareStatement(sql);
        	st = con.createStatement();
            rs = st.executeQuery(sql);
        	while(rs.next()) {
        		UsuarioVO usu = new UsuarioVO();
        		usu.setUsuario(rs.getString("nome_usuario"));
        		usu.setCpf(rs.getString("senha"));
        		usu.setEmail(rs.getString("email"));
        		usu.setUsuarioId(rs.getLong("usuario_id"));
        		usu.setPessoaId(rs.getLong("pessoa_id"));
        		usu.setTipoDeUsuario(rs.getInt("tipo_id"));
        		usuarios.add(usu);
        	}
        	return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    public UsuarioVO buscarPorNomeDeUsuario(UsuarioVO vo) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs = null;
        // inner join com tb_pessoas ?
        String sql = "select * from usuarios where nome_usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getUsuario());
            rs = ps.executeQuery();
        	if(rs.next()) {
        		//UsuarioVO usu = new UsuarioVO();
        		vo.setUsuario(rs.getString("nome_usuario"));
        		vo.setSenha(rs.getString("senha"));
        		vo.setEmail(rs.getString("email"));
        		vo.setUsuarioId(rs.getLong("usuario_id"));
        		vo.setPessoaId(rs.getLong("pessoa_id"));
        		vo.setTipoDeUsuario(rs.getInt("tipo_id"));
        		return vo;
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    // simulando autenticação
    public UsuarioVO autent(UsuarioVO usu) {
    	if(usu.getUsuario().equals("gerente") && usu.getSenha().equals("geren")) {
    		return new GerenteVO();
    	}
    	if(usu.getUsuario().equals("funcionario") 
    			&& usu.getSenha().equals("funcio")) {
    		return new FuncionarioVO();
    	}
    	return null;
    }
}
