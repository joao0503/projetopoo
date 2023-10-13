package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.VO.PessoaVO;

public class PessoaDAO<VO extends PessoaVO> extends BaseDAOImpl<VO> {

	@Override
	//public void inserir(Pessoa entity) {
	public void inserir(VO vo) {
		Connection con = getConnection();
		String sql = "insert into pessoas (nome, cpf, endereco, numero_celular)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, vo.getNome());
			ps.setString(2, vo.getCpf());
            ps.setString(3, vo.getEndereco());
            ps.setString(4, vo.getNumeroCelular());
            
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows == 0) {
            	throw new SQLException("Não foi possível inserir. Nenhuma linha alterada.");
            }
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
            	vo.setPessoaId(generatedKeys.getLong(1));
            } else {
            	throw new SQLException("A inserçao falhou. Nenhum id foi retornado.");
            }
			//ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    @Override
    //public void deletar(Pessoa entity) {
    public void deletar(VO vo) {
        Connection con = getConnection();
        String sql = "delete from pessoas where pessoa_id = ?";
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
    //public void alterar(Pessoa entity) {
    // c
    public void alterar(VO vo) {
        Connection con = getConnection();
        String sql = "update pessoas set nome = ?, cpf = ?, endereco = ?, "
        		+ "numero_celular = ? where pessoa_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNome());
            ps.setString(2, vo.getCpf());
            ps.setString(3, vo.getEndereco());
            ps.setString(4, vo.getNumeroCelular());
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
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "select * from pessoas where pessoa_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getPessoaId());
            rs = ps.executeQuery();
            if (rs.next()) {
                vo.setNome(rs.getString("nome"));
                vo.setCpf(rs.getString("cpf"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setNumeroCelular(rs.getString("numero_celular"));
                vo.setPessoaId(rs.getLong("pessoa_id"));
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
    public List<?> listar() {
        Connection con = getConnection();
        String sql = "select * from pessoas";
        Statement st;
        ResultSet rs = null;
        List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
        try {
            //PreparedStatement ps = con.prepareStatement(sql);
        	st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
            	PessoaVO pes = new PessoaVO();
            	pes.setNome(rs.getString("nome"));
            	pes.setCpf(rs.getString("cpf"));
            	pes.setEndereco(rs.getString("endereco"));
            	pes.setNumeroCelular(rs.getString("numero_celular"));
            	pes.setPessoaId(rs.getLong("pessoa_id"));
                pessoas.add(pes);
            }
            return pessoas;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    
    public VO buscarPorCPF(VO vo) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "select * from pessoas where cpf = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getCpf());
            rs = ps.executeQuery();
            if (rs.next()) {
                vo.setNome(rs.getString("nome"));
                vo.setCpf(rs.getString("cpf"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setNumeroCelular(rs.getString("numero_celular"));
                vo.setPessoaId(rs.getLong("pessoa_id"));
                return vo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}

