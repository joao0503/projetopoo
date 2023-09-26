package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entity.Pessoa;

public class PessoaDAO<E extends Pessoa> extends BaseDAOImpl<E> {

	@Override
	//public void inserir(Pessoa entity) {
	public void inserir(E entity) {
		Connection con = getConnection();
		String sql = "insert into tb_pessoas (nome, cpf, endereco)"
				+ "values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCpf());
            ps.setString(3, entity.getEndereco());
            
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows == 0) {
            	throw new SQLException("Não foi possível inserir. Nenhuma linha alterada.");
            }
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
            	entity.setPessoaId(generatedKeys.getLong(1));
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
    // c
    public void deletar(E entity) {
        Connection con = getConnection();
        String sql = "delete from tb_pessoas where pessoa_id = ?";
        try {
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
    //public void alterar(Pessoa entity) {
    // c
    public void alterar(E entity) {
        Connection con = getConnection();
        String sql = "update tb_pessoas set nome = ?, cpf = ?, endereco = ? where pessoa_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getCpf());
            ps.setString(3, entity.getEndereco());
            ps.setLong(4, entity.getPessoaId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    
    // A classe Pessao é abstrata, logo não pode ser instanciada, por isso o listar se tornou
    // listarPessoas, nela é retornado um ResultSet, não sendo necessário instanciar Pessoa.
    // verificar depois se vale a pena deixar a classe Pessoa como abstrata ou concreta
    // O ResultSet retornado pode ser usado na aplicação para instanciar qual classe precisar.
    @Override
    //public Pessoa buscar(Pessoa entity) {
    public E buscar(E entity) {
    	return null;
    }
    
    
    public ResultSet buscarPessoa(E entity) {
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "select * from tb_pessoas where pessoa_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getPessoaId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                entity.setNome(rs.getString("nome"));
                entity.setCpf(rs.getString("cpf"));
                entity.setEndereco(rs.getString("endereco"));
                entity.setPessoaId(rs.getLong("pessoa_id"));
                //return rs;
            }
            
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
    public ResultSet listarPessoas() {
        Connection con = getConnection();
        String sql = "select * from tb_pessoas";
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
}

