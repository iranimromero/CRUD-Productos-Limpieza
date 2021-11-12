package cl.iromero.dao;

import java.util.List;

import cl.iromero.model.Producto;


public interface IProductoDAO {

	public List<Producto> listarProducto ();
	public Producto buscarProducto(int idProducto);
	public Producto agregarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public boolean eliminarProducto(int idProducto);
}
