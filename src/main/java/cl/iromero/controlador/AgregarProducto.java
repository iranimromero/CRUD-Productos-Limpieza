package cl.iromero.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.iromero.dao.CategoriaDAOImpl;
import cl.iromero.dao.ICategoriaDAO;
import cl.iromero.dao.IProductoDAO;
import cl.iromero.dao.ProductoDAOImpl;
import cl.iromero.model.Categoria;
import cl.iromero.model.Producto;


@WebServlet("/AgregarProducto")
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//accedemos a la BBDD por medio de las clases
	ProductoDAOImpl productoDao = new ProductoDAOImpl();
	ICategoriaDAO categoriaDao = new CategoriaDAOImpl();
	
	
	//Metodo DoGet retornara la lista de Agregar producto
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creo una lista de tipo Categoria y por medio del dao y su implementacion de listar obtengo las opciones disponibles en BBDD para acerlas llegar al usuario a traves del jsp
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias = categoriaDao.listarCategoria();
		request.setAttribute("listaCategorias", listaCategorias);
		//Pasamos a la vista 
		request.getRequestDispatcher("AgregarProducto.jsp").forward(request, response);
	}

	//Recibe los datos que vienen del FORMULARIO los combierte en un objeto producto para guardarlo en la BBDD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Para evitar errores con los caracteres con acentos
	
	
		//Instaciamos un objeto producto = //Extraemos la info a traves de request y le agregamos los datos
		Producto producto = new Producto();
		producto.setIdProducto(0);
		//producto.setIdProducto(idProducto);
		producto.setNombreProducto(request.getParameter("nombreProducto"));
		producto.setPrecioProducto(Integer.parseInt(request.getParameter("precioProducto")));
		producto.setDescripcionProducto(request.getParameter("descripcionProducto"));
		producto.setIdCategoria(Integer.parseInt(request.getParameter("categoriaProducto")));
		
		//utilizo el metodo Agregar producto (implementacion) y le envio el de
		Producto result = productoDao.agregarProducto(producto);
				
		if(result.equals(1)) {
			//Hay que colocar una vista para que el cliente pueda seguir interactuand con la pagina
			request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
	}

}
