package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.VO.FuncionarioVO;
import model.VO.ServicoVO;

public class FuncionarioDAO extends UsuarioDAO<FuncionarioVO> {
	
	@Override
	public void inserir(FuncionarioVO vo) {
		super.inserir(vo);
		Connection con = getConnection();
		String sql = "insert into funcionarios (salario) values (?, ?)";
		try {
			// Ao user o super, vou aproveitar o pessoa_id da superclasse para ja 
			// usar aqui
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, vo.getSalario());
            
            int affectedRows = ps.executeUpdate();
            
            if(affectedRows == 0) {
            	throw new SQLException("Não foi possível inserir. Nenhuma linha alterada.");
            }
            
            // pegando o id gerado pelo banco de dados
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
            	vo.setFuncionarioId(generatedKeys.getLong(1));
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
    public void deletar(FuncionarioVO vo) {
        Connection con = getConnection();
        String sql = "delete from funcionarios where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getFuncionarioId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    @Override
    public void alterar(FuncionarioVO vo) {
        Connection con = getConnection();
        String sql = "update funcionarios set salario = ? where funcionario_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, vo.getSalario());
            ps.setLong(2, vo.getFuncionarioId());
            ps.setLong(3, vo.getUsuarioId());
            ps.setLong(4, vo.getPessoaId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }


    @Override
    public FuncionarioVO buscar(FuncionarioVO vo) {
    	super.buscar(vo);
        Connection con = getConnection();
        /*String sql = "select * from tb_pessoas join tb_usuarios on tb_pessoas.pessoa_id = "
        		+ "tb_usuarios.pessoa_id join tb_funcionarios on tb_pessoas.pessoa_id = "
        		+ "tb_funcionarios.pessoa_id where tb_pessoas.pessoa_id = ?";*/
        String sql = "select * from funcionarios";
        ResultSet rs = null;
        //FuncionarioVO func = new FuncionarioVO();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getPessoaId());
            rs = ps.executeQuery();
            if(rs.next()) {
            	vo.setNome(rs.getString("nome"));
            	vo.setCpf(rs.getString("cpf"));
            	vo.setEndereco(rs.getString("endereco"));
            	vo.setPessoaId(rs.getLong("pessoa_id"));
            	vo.setUsuario(rs.getString("usuario"));
            	vo.setSenha(rs.getString("senha"));
            	vo.setUsuarioId(rs.getLong("usuario_id"));
                // implementar a lista de servicos do funcionario, se for 
            	//interessante para manipular os servicos
            	vo.setFuncionarioId(rs.getLong("funcionario_id"));
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
        public List<FuncionarioVO> listar() {
            Connection con = getConnection();
            String sql = "select * from tb_pessoas inner join usuarios on pessoas.pessoa_id = "
                + "usuarios.pessoa_id inner join tb_funcionarios on pessoas.pessoa_id = "
                + "funcionarios.pessoa_id";
            ResultSet rs = null;
            List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    FuncionarioVO func = new FuncionarioVO();
                    func.setNome(rs.getString("nome"));
                    func.setCpf(rs.getString("cpf"));
                    func.setEndereco(rs.getString("endereco"));
                    func.setPessoaId(rs.getLong("pessoa_id"));
                    func.setUsuario(rs.getString("usuario"));
                    func.setSenha(rs.getString("senha"));
                    func.setUsuarioId(rs.getLong("usuario_id"));
                    // implementar a lista de servicos do funcionario, se for interessante para manipular
                    // os servicos
                    func.setFuncionarioId(rs.getLong("funcionario_id"));
                    // Ideia de cast
                    // usuarios.add((UsuarioVO));
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
    
    // adicionarServico/iniciarServico vai ser no BO, não aqui no DAO.
    public void adicionarServico(ServicoVO vo) {
        Connection con = getConnection();
        // vale a pena tabela de associação !?
        String sql = "update servicos set funcionario_id = ? where servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, vo.getFuncionarioId());
            //ps.setLong(2, vo.getServicoId());
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
