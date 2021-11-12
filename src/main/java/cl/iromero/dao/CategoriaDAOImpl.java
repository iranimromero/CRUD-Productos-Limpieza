package cl.iromero.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;



import cl.iromero.conexionDB.ProcesaConexionDB;
import cl.iromero.model.Categoria;

public class CategoriaDAOImpl extends ProcesaConexionDB implements ICategoriaDAO {

	//constructor vacio con la logica de conexion con la base de datos /DB /BBDD
	public CategoriaDAOImpl() {
		// TODO Auto-generated constructor stub
		
		Connection conn = obtenerConexion();
		//Connection conn = generaPoolConexion();
		//pdria llamar obtenerConexion metodo modificado para que sea SIMGLETON
	}
	
	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		
		String query ="SELECT * FROM categoria";
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			pstm = conn.prepareStatement(query); //se prepara la query
			rs = pstm.executeQuery(); //se ejecuta la query
			while (rs.next()) {
				Categoria categoria = new Categoria (rs.getInt("id_categoria"),rs.getString("nombre_categoria"));
				categorias.add(categoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}

	@Override
	public Categoria buscarCategoria(int idCategoria) {
		
		String query ="SELECT * FROM categoria WHERE id_categoria = " + idCategoria;
		
		try {
			pstm = conn.prepareStatement(query); //se prepara la query
			rs = pstm.executeQuery(); //se ejecuta la query
			Categoria categoria = new Categoria();
			
			//si el Result set rs tiene algo, lo setea
			if(rs.next()) {
				categoria.setIdCategoria(rs.getInt("id_categoria"));
				categoria.setNombreCategoria(rs.getString("nombre_categoria"));
				
			}
			return categoria;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
	}

}
