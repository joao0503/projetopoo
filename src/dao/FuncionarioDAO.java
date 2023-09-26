package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Funcionario;
import model.entity.Servico;

public class FuncionarioDAO extends UsuarioDAO<Funcionario> {
	

	@Override
	public void inserir(Funcionario entity) {

		Connection con = getConnection();
		String sql = "insert into tb_funcionarios (servico_id) values (?)";
		
		try {
			// Ao user o super, vou aproveitar o pessoa_id da superclasse para ja usar aqui
			super.inserir(entity);
			PreparedStatement ps = con.prepareStatement(sql);
			
			// tenho que ter o id do cliente e o id do servico

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
    public void deletar(Funcionario entity) {
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
    public void alterar(Funcionario entity) {
        Connection con = getConnection();
        
        String sql = "update tb_funcionarios set salario = ? where funcionario_id = ?";
        try {
        	super.alterar(entity);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getFuncionarioId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }


    @Override
    public Funcionario buscar(Funcionario entity) {
        Connection con = getConnection();
        String sql = "select * from tb_pessoas join tb_usuarios on tb_pessoas.pessoa_id = "
        		+ "tb_usuarios.pessoa_id join tb_funcionarios on tb_pessoas.pessoa_id = "
        		+ "tb_funcionarios.pessoa_id where tb_pessoas.pessoa_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getPessoaId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Funcionario func = new Funcionario();
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setEndereco(rs.getString("endereco"));
                func.setPessoaId(rs.getLong("pessoa_id"));
                func.setUsuario(rs.getString("usuario"));
                func.setSenha(rs.getString("senha"));
                func.setUsuarioId(rs.getLong("usuario_id"));
                func.setEhFuncionario(rs.getBoolean("eh_funcionario"));
                // implementar a lista de servicos do funcionario, se for interessante para manipular
                // os servicos
                func.setFuncionarioId(rs.getLong("funcionario_id"));
                return func;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    

    @Override
    public List<Funcionario> listar() {
        Connection con = getConnection();
        String sql = "select * from tb_pessoas join tb_usuarios on tb_pessoas.pessoa_id = "
        		+ "tb_usuarios.pessoa_id join tb_funcionarios on tb_pessoas.pessoa_id = "
        		+ "tb_funcionarios.pessoa_id";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setEndereco(rs.getString("endereco"));
                func.setPessoaId(rs.getLong("pessoa_id"));
                func.setUsuario(rs.getString("usuario"));
                func.setSenha(rs.getString("senha"));
                func.setUsuarioId(rs.getLong("usuario_id"));
                func.setEhFuncionario(rs.getBoolean("eh_funcionario"));
                // implementar a lista de servicos do funcionario, se for interessante para manipular
                // os servicos
                func.setFuncionarioId(rs.getLong("funcionario_id"));
                funcionarios.add(func);
            }
            return funcionarios;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    
    public void adicionarServicoFuncionario(Servico entity) {
        Connection con = getConnection();
        // vale a pena tabela de associação !?
        String sql = "update tb_funcionarios set servico_id = ? where funcionario_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getServicoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
		
    	
    	/* Vários serviços
    	 * int tam = funcio.getServicosDoFuncionario().size();
		for (int i = 0; i < tam; i++) {
			ps.setLong(1, funcio.getServicosDoFuncionario().get(i).getClienteId());
			ps.setLong(1, funcio.getServicosDoFuncionario().get(i).getServicoId());
		}*/
    }
    
    
}
