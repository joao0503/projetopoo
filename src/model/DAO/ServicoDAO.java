package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.VO.PecaVO;
import model.VO.ServicoVO;

public class ServicoDAO extends BaseDAOImpl<ServicoVO> {

	/*SimpleDateFormat formData = new SimpleDateFormat("yyyy/MM/dd");
	
    LocalDate dataAtual = LocalDate.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String dataAtualString = dataAtual.format(formatador);*/
    
    LocalDate dataAtual = LocalDate.now();
    java.sql.Date dataSql = java.sql.Date.valueOf(dataAtual);
	
	@Override
	public void inserir(ServicoVO serv) throws ParseException {
		Connection con = getConnection();
		String sql = "insert into servicos (nome_servico, descricao, valor, status, peca_id, data_inicio, data_fim,"
				+ "funcionario_id, cliente_id, automovel_id) values (?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serv.getNome());
			ps.setString(2, serv.getDescricao());
			ps.setDouble(3, serv.getValor());
            ps.setInt(4, serv.getStatus());
            ps.setLong(5, serv.getPeca().getPecaId());
            //ps.setDate(6, new java.sql.Date(formData.parse(dataAtualString).getTime()));
            ps.setDate(6, dataSql);
            ps.setDate(7, null);
            ps.setLong(8, serv.getFuncionarioId());
            ps.setLong(9, serv.getClienteId());
            ps.setLong(10, serv.getAutomovelId());
            ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

    @Override
    public void deletar(ServicoVO serv) {
        Connection con = getConnection();
        String sql = "delete from servicos where servico_id = ?";
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
    public void alterar(ServicoVO serv) {
        Connection con = getConnection();
        String sql = "update servicos set nome_servico = ?, descricao = ?, valor = ?, "
        		+ "status = ?, peca_id = ?, funcionario_id = ?, cliente_id = ?, "
        		+ "automovel_id = ? where servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serv.getNome());
			ps.setString(2, serv.getDescricao());
			ps.setDouble(3, serv.getValor());
            ps.setInt(4, serv.getStatus());
            ps.setLong(5, serv.getPeca().getPecaId());
            //ps.setDate(6, serv.getDataInicio());
            //ps.setDate(7, serv.getDataFim());
            ps.setLong(6, serv.getFuncionarioId());
            ps.setLong(7, serv.getClienteId());
            ps.setLong(8, serv.getAutomovelId());
            ps.setLong(9, serv.getServicoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    
    @Override
    public ServicoVO buscar(ServicoVO serv) {
        Connection con = getConnection();
        String sql = "select * from servicos inner join pecas on servicos.peca_id = "
        		+ "pecas.peca_id where servicos.peca_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, serv.getPeca().getPecaId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {  
                PecaVO peca = new PecaVO();
                peca.setNome(rs.getString("nome"));
                peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setPreco(rs.getDouble("preco"));
                peca.setPecaId(rs.getLong("peca_id"));

            	ServicoVO servico = new ServicoVO();
            	servico.setNome(rs.getString("nome"));
            	servico.setValor(rs.getInt("valor"));
            	servico.setStatus(rs.getInt("status"));
            	servico.setPeca(peca);
            	servico.setDataInicio("data_inicio");
            	servico.setDataFim("data_fim");
            	servico.setFuncionarioId(rs.getLong("funcionario_id"));
            	servico.setClienteId(rs.getLong("cliente_id"));
            	servico.setServicoId(rs.getLong("servico_id"));
                return servico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<ServicoVO> listar() {
        Connection con = getConnection();
        //String sql = "select * from servicos union select * from tb_pecas";
        String sql = "select * from servicos inner join pecas";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<ServicoVO> servicos = new ArrayList<ServicoVO>();
            while (rs.next()) {
                    PecaVO peca = new PecaVO();
                    peca.setNome(rs.getString("nome"));
                    peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                    peca.setFabricante(rs.getString("fabricante"));
                    peca.setPreco(rs.getDouble("preco"));
                    peca.setPecaId(rs.getLong("peca_id"));

                    ServicoVO servico = new ServicoVO();
                    servico.setNome(rs.getString("nome"));
                    servico.setValor(rs.getInt("valor"));
                    servico.setStatus(rs.getInt("status"));
                    servico.setPeca(peca);
                    servico.setDataInicio("data_inicio");
                    servico.setDataFim("data_fim");
                    servico.setFuncionarioId(rs.getLong("funcionario_id"));
                    servico.setClienteId(rs.getLong("cliente_id"));
                    servico.setServicoId(rs.getLong("servico_id"));
            }
            return servicos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    
    public void finalizarServico(ServicoVO vo) {
        Connection con = getConnection();
        String sql = "update servicos set nome_servico = ?, descricao = ?, valor = ?, "
        		+ "status = ?, peca_id = ?, data_fim = ?, funcionario_id = ?, cliente_id = ?, "
        		+ "automovel_id = ? where servico_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getNome());
			ps.setString(2, vo.getDescricao());
			ps.setDouble(3, vo.getValor());
            ps.setInt(4, vo.getStatus());
            ps.setLong(5, vo.getPeca().getPecaId());
            //ps.setDate(6, serv.getDataInicio());
            ps.setDate(6, dataSql);
            ps.setLong(7, vo.getFuncionarioId());
            ps.setLong(8, vo.getClienteId());
            ps.setLong(9, vo.getAutomovelId());
            ps.setLong(10, vo.getServicoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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
