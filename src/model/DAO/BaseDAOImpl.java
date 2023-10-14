package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAOImpl<VO> implements BaseDAO<VO>{
	
	final static String URL = "jdbc:postgresql://localhost:5432/oficina_db";
	final static String USER = "postgres";
	final static String PASS = "admin";
	static Connection con = null ;
	
	public static Connection getConnection() {
		if(con == null) {
			try {
				con = DriverManager.getConnection(URL,USER,PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		else return con;
	}
	
	public static void closeConnection() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
		
	}
	
	public abstract void inserir(VO vo);
	public abstract void deletar(VO vo);
	public abstract void alterar(VO vo);
	public abstract VO buscar(VO vo);
	public abstract List<?> listar();
}
