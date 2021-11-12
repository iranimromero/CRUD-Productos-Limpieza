package cl.iromero.dao;

import java.util.ArrayList;
import java.util.List;

import cl.iromero.conexionDB.ProcesaConexionDB;
import cl.iromero.model.Categoria;
import cl.iromero.model.Producto;
import cl.iromero.model.ProductoCategoria;

public class ProductoCategoriaDAOImpl extends ProcesaConexionDB implements  IProductoCategoriaDAO{

	//instancio las implementaciones anteriores para establecer la relacion entre ellas
	private ICategoriaDAO categoriaDAO = new CategoriaDAOImpl();
	private	IProductoDAO productoDAO = new ProductoDAOImpl();
	
	@Override
	public List<ProductoCategoria> listarProductoCategoria() {
		//instancio una lista para guardar el resultado del metodo
		List<ProductoCategoria> listaProdCat = new ArrayList<>();
		
		//Listo los productos
		List<Producto> listaProducto = productoDAO.listarProducto();
		
		//Estructura for each para recorrer la lista de productos
		for (Producto producto : listaProducto) {
			//con
			Categoria categoria = categoriaDAO.buscarCategoria(producto.getIdCategoria()); 
			
			//instancio un objeto del tipo producto categoria para luego Seterarle los atributos de cada tabla
			ProductoCategoria productoCategoria = new ProductoCategoria();
			productoCategoria.setCategoria(categoria);
			productoCategoria.setProducto(producto);
			
			//agrego la "busqueda" a la lista de resultado
			listaProdCat.add(productoCategoria);
		}
		
		return listaProdCat;
		
	}
}
