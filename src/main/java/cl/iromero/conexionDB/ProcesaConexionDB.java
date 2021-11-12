package cl.iromero.conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProcesaConexionDB {

	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	
	//EJEMPLO DE CONEXION  SINGLETON sin uso de generaPoolConexion
	protected static void generaConexion() {
		String usr = "Posts";
		String pwd = "123456";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,usr,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//verifica si hay una conexion si hay la retorna sino la genera
	public static Connection obtenerConexion() {
		if(conn==null) {
			generaConexion();
		} 
		return conn;
	}
	
	//SINGLETON verifica que exista la conexion para no establecer una nueva
	protected Connection generaPoolConexion() {
		Context initContext;
		if (conn == null) {
			try {
				initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");
				try {
					conn = ds.getConnection();
							System.out.println("CREACION DE CONEXION CON GetConnection");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return conn;
		}else {
		System.out.println("Ya hay una conexion");
		return conn;
		}
	}
}
