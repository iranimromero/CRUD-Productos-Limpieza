package cl.iromero.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.iromero.conexionDB.ProcesaConexionDB;
import cl.iromero.model.Producto;


public class ProductoDAOImpl extends ProcesaConexionDB implements IProductoDAO{

	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		String query ="SELECT * FROM producto";
		List<Producto> productos = new ArrayList<Producto>();
		try {
			pstm = conn.prepareStatement(query); //se prepara la query
			rs = pstm.executeQuery(); //se ejecuta la query
			while (rs.next()) {
				Producto producto = new Producto ();
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombreProducto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				productos.add(producto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	public cl.iromero.model.Producto buscarProducto(int idProducto) {
		Producto producto = new Producto();
		String query = "select * from producto where id_producto=?";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idProducto);//aqui seteo el parametro que recibo del metodo
			rs = pstm.executeQuery();   //executeQuery porque estamos haciendo consulta (SELECT)
			while (rs.next()) {
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombreProducto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return producto;
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		String query = "insert into producto values(producto_sec.NEXTVAL,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, producto.getNombreProducto());
			pstm.setInt(2, producto.getPrecioProducto());
			pstm.setString(3, producto.getDescripcionProducto());
			pstm.setInt(4, producto.getIdCategoria());
			int result = pstm.executeUpdate();//ejecuta una actualizacion en BBDD
			if(result==1) {
				System.out.println("Producto agregado Satisfactoriamente");
			}else {
				System.out.println("Producto no agregado");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		String query = "UPDATE producto SET nombre_producto =?, precio_producto=?,descripcion_producto=?,id_categoria=? WHERE id_producto=? ";
				//UPDATE categoria SET nombre_categoria = 'Articulo' WHERE id_categoria = 1;
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, producto.getNombreProducto());
			pstm.setInt(2, producto.getPrecioProducto());
			pstm.setString(3, producto.getDescripcionProducto());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getIdProducto());
			int result = pstm.executeUpdate();//ejecuta una actualizacion en BBDD EXECUTE porque estoy hacuendo cambios a la BBDD
			if(result==1) {
				System.out.println("Producto agregado Satisfactoriamente");
			}else {
				System.out.println("Producto no agregado");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public boolean eliminarProducto(int idProducto) {
		String query="delete from producto where id_producto=?";
        boolean resultado= false;
        try {
            pstm=conn.prepareStatement(query);
            pstm.setInt(1, idProducto); // aca asigno el Id de la query
            int result=pstm.executeUpdate(); //ejecucion de la query
            if(result ==1) { //verificacion del resultado
            	resultado= true;
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
	}

	

}
