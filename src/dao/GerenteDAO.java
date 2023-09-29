package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Gerente;

public class GerenteDAO extends UsuarioDAO<Gerente>{

	// Só pode ter 1 gerente, então não precisa inserir gerente
	@Override
	public void inserir(Gerente ger) {}

	
	// Não é necessária se deletar
    @Override
    public void deletar(Gerente ger) {
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
    public void alterar(Gerente ger) {
    	//if(ger.getEhGerente()) {
            Connection con = getConnection();
            String sql = "update tb_gerente set salario = ? where gerente_id = ?";
            try {
            	super.alterar(ger);
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

    
    @Override
    public Gerente buscar(Gerente entity) {
        Connection con = getConnection();
        String sql = "select * from tb_pessoas join tb_usuarios on tb_pessoas.pessoa_id = "
        		+ "tb_usuarios.pessoa_id join tb_gerente on tb_pessoas.pessoa_id = "
        		+ "tb_gerente.pessoa_id where tb_pessoas.pessoa_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getPessoaId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Gerente ger = new Gerente();
                ger.setNome(rs.getString("nome"));
                ger.setCpf(rs.getString("cpf"));
                ger.setEndereco(rs.getString("endereco"));
                ger.setPessoaId(rs.getLong("pessoa_id"));
                ger.setUsuario(rs.getString("usuario"));
                ger.setSenha(rs.getString("senha"));
                ger.setUsuarioId(rs.getLong("usuario_id"));
                //ger.setEhGerente(rs.getBoolean("eh_gerente"));
                ger.setGerenteId(rs.getLong("gerente_id"));
                return ger;
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
    public List<Gerente> listar() {
        Connection con = getConnection();
        String sql = "select * from tb_pessoas join tb_usuarios on tb_pessoas.pessoa_id = "
        		+ "tb_usuarios.pessoa_id join tb_gerente on tb_pessoas.pessoa_id = "
        		+ "tb_gerente.pessoa_id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
            if (rs.next()) {
                Gerente ger = new Gerente();
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
