package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAOImpl<E> implements BaseDAO<E>{
	
	final static String URL = "jdbc:postgresql://localhost:5432/oficina_db";
	final static String USER = "postgres";
	final static String PASS = "123";
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
	
	public abstract void inserir(E entity);

	public abstract void deletar(E entity) ;

	public abstract void alterar(E entity);

	public abstract E buscar(E entity);

	public abstract List<E> listar();
	
}