package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Peca;
import model.entity.Servico;

public class ServicoDAO extends BaseDAOImpl<Servico> {

	@Override
	public void inserir(Servico serv) {
		Connection con = getConnection();
		String sql = "insert into tb_servicos (nome, valor, status, peca_id, funcionario_id, cliente_id"
				+ "servico_id values (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serv.getNome());
			ps.setDouble(2, serv.getValor());
            ps.setInt(3, serv.getStatus());
            ps.setLong(4, serv.getPeca().getPecaId());
            ps.setLong(5, serv.getFuncionarioId());
            ps.setLong(6, serv.getClienteId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    @Override
    public void deletar(Servico serv) {
        Connection con = getConnection();
        String sql = "delete from tb_servicos where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, serv.getServicoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
	
    
    @Override
    public void alterar(Servico serv) {
        Connection con = getConnection();
        String sql = "update tb_servicos set nome = ?, valor = ?, status = ?, peca_id = ?, "
        		+ "funcionario_id = ?, cliente_id where servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serv.getNome());
			ps.setDouble(2, serv.getValor());
            ps.setInt(3, serv.getStatus());
            ps.setLong(4, serv.getPeca().getPecaId());
            ps.setLong(5, serv.getFuncionarioId());
            ps.setLong(6, serv.getClienteId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    
    @Override
    public Servico buscar(Servico serv) {
        Connection con = getConnection();
        String sql = "select * from tb_servicos inner join tb_pecas on tb_servicos.servico_id = "
        		+ "tb_pecas.servico_id where tb_servicos.servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, serv.getServicoId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {  
                Peca peca = new Peca();
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                peca.setPecaId(rs.getLong("peca_id"));

            	Servico servicoBuscado = new Servico();
                servicoBuscado.setNome(rs.getString("nome"));
                servicoBuscado.setValor(rs.getInt("valor"));
                servicoBuscado.setStatus(rs.getInt("status"));
                servicoBuscado.setPeca(peca);
                servicoBuscado.setFuncionarioId(rs.getLong("funcionario_id"));
                servicoBuscado.setClienteId(rs.getLong("cliente_id"));
                servicoBuscado.setServicoId(rs.getLong("servico_id"));
                return servicoBuscado;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<Servico> listar() {
        Connection con = getConnection();
        String sql = "select * from tb_servicos union select * from tb_pecas";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Servico> servicos = new ArrayList<Servico>();
            while (rs.next()) {
                    Peca peca = new Peca();
                    peca.setNome(rs.getString("nome"));
                    peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                    peca.setFabricante(rs.getString("fabricante"));
                    peca.setPreco(rs.getDouble("preco"));
                    peca.setPecaId(rs.getLong("peca_id"));

                	Servico serv = new Servico();
                	serv.setNome(rs.getString("nome"));
                	serv.setValor(rs.getInt("valor"));
                	serv.setStatus(rs.getInt("status"));
                	serv.setPeca(peca);
                	serv.setFuncionarioId(rs.getLong("funcionario_id"));
                	serv.setClienteId(rs.getLong("cliente_id"));
                	serv.setServicoId(rs.getLong("servico_id"));
                	servicos.add(serv);
            }
            return servicos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    // Modificar a parte do retorno da função
    //
    /*public List<Servico> buscarPorNome(String nome){
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_servico WHERE nome = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Orcamento orc = new Orcamento();
                orc.setPeca(rs.getString("peça"));
                orc.setServico(rs.getString("serviço"));
                return orc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
	}*/
 //}
}
