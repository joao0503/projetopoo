package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.VO.GerenteVO;

public class GerenteDAO extends UsuarioDAO<GerenteVO> {
	// Só pode ter 1 gerente, então não precisa inserir gerente
	@Override
	public void inserir(GerenteVO vo) {
		super.inserir(vo);
		Connection con = getConnection();
		String sql = "insert into funcionarios (salario, servico_id) values (?, ?)";

		try {
			// Ao user o super, vou aproveitar o pessoa_id da superclasse para ja 
			// usar aqui
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, vo.getBonus());
            
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows == 0) {
            	throw new SQLException("Não foi possível inserir. Nenhuma linha alterada.");
            }
            
            // pegando o id gerado pelo banco de dados
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
            	vo.setGerenteId(generatedKeys.getLong(1));
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

	
	// Não é necessária se deletar
    @Override
    public void deletar(GerenteVO ger) {
    	//if(ger.getEhGerente()) {
            Connection con = getConnection();
            String sql = "delete from tb_gerente where gerente_id = ?";
            try {
            	super.deletar(ger);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, ger.getGerenteId());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
    	//}
    }
	
    
    
    // Caso o gerente queira alterar seus dados
    @Override
    public void alterar(GerenteVO vo) {
    	//if(ger.getEhGerente()) {
            Connection con = getConnection();
            String sql = "update tb_gerente set salario = ? where gerente_id = ?";
            try {
            	super.alterar(vo);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, vo.getBonus());
                ps.setLong(2, vo.getGerenteId());
                ps.executeUpdate();
    			ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
    	//}
    }

    
    @Override
    public GerenteVO buscar(GerenteVO vo) {
    	super.buscar(vo);
        Connection con = getConnection();
        /*String sql = "select * from tb_pessoas inner join tb_usuarios on tb_pessoas.pessoa_id = "
        		+ "tb_usuarios.pessoa_id join tb_gerente on tb_pessoas.pessoa_id = "
        		+ "tb_gerente.pessoa_id where tb_pessoas.pessoa_id = ?";*/
        String sql = "select * from gerente";
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getPessoaId());
            rs = ps.executeQuery();
            if (rs.next()) {
            	vo.setBonus(rs.getDouble("bonus"));
                vo.setGerenteId(rs.getLong("gerente_id"));
                return vo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    

    // Não precisaria implementar listar, pois a aplicação só tem um gerente (poderia ter mais !?)
    @Override
    public List<GerenteVO> listar() {
        Connection con = getConnection();
        String sql = "select * from pessoas inner join tb_usuarios on "
        		+ "pessoas.pessoa_id = usuarios.pessoa_id join tb_gerente on "
        		+ "pessoas.pessoa_id = gerente.pessoa_id";
        ResultSet rs = null;
        List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                GerenteVO ger = new GerenteVO();
                ger.setNome(rs.getString("nome"));
                ger.setCpf(rs.getString("cpf"));
                ger.setEndereco(rs.getString("endereco"));
                ger.setPessoaId(rs.getLong("pessoa_id"));
                ger.setUsuario(rs.getString("usuario"));
                ger.setSenha(rs.getString("senha"));
                ger.setUsuarioId(rs.getLong("usuario_id"));
                //ger.setEhGerente(rs.getBoolean("eh_gerente"));
                ger.setGerenteId(rs.getLong("gerente_id"));
                gerentes.add(ger);
            }
            return gerentes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}
