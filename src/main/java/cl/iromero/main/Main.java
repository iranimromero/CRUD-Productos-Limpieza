package cl.iromero.main;

import java.util.List;

import cl.iromero.dao.CategoriaDAOImpl;
import cl.iromero.dao.ProductoDAOImpl;
import cl.iromero.model.Categoria;
import cl.iromero.model.Producto;

public class Main {

	public static void main(String[] args) {


		//Prueba metdos Categoria DAO
		CategoriaDAOImpl pruebaCategoriaDAO = new CategoriaDAOImpl();
		List<Categoria> listCategoria = pruebaCategoriaDAO.listarCategoria();
		System.out.println(listCategoria);
		
		System.out.println(pruebaCategoriaDAO.buscarCategoria(2));
		
		
		//Prueba metdos Producto DAO
		//ProductoDAOImpl pruebaProductoDAO = new ProductoDAOImpl();
		//Producto producto = new Producto(1,"Cloro",1000,"En gel",1);
		
		//pruebaProductoDAO.agregarProducto(producto);
		//List<Producto> listProducto = pruebaProductoDAO.listarProducto();
		
		//System.out.println(listProducto);
		
		//System.out.println(pruebaProductoDAO.buscarProducto(1));
		//System.out.println(listProducto);
		
		//pruebaProductoDAO.eliminarProducto(1);
		//List<Producto> listProducto2 = pruebaProductoDAO.listarProducto();
		//System.out.println("Eliminar ----------------------------------------------------");
		//System.out.println(listProducto2);
		
		//Prueba metdos Producto DAO
		
	}
}
