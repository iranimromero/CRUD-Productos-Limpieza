package cl.iromero.controlador;

import java.io.IOException;
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


@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//accedemos a la BBDD por medio de las clases
	IProductoDAO productoDao = new ProductoDAOImpl();
	ICategoriaDAO categoriaDao = new CategoriaDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
				
		//VerificamosEn caso de que el id sea 0, vacio o distinto de numero
		if(idProducto <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		Producto producto = productoDao.buscarProducto(idProducto);
		//Verificamos que sea un objeto en la base datos
		if(idProducto == 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		//creo una lista de tipo Categoria y por medio del dao y su implementacion de listar 
		//obtengo las opciones disponibles en BBDD para acerlas llegar al usuario a traves del jsp
		List<Categoria> categorias = categoriaDao.listarCategoria();
		request.setAttribute("categorias", categorias);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Para evitar errores con los caracteres con acento
				request.setCharacterEncoding("UTF-8");
				//Extraemos la info a traves de request
				
				//obtener el  id de producto
				int idProducto = Integer.parseInt(request.getParameter("idProducto"));
				String nombreProducto = request.getParameter("nombreProducto");
				int precioProducto = Integer.parseInt(request.getParameter("precioProducto"));
				String descripcionProducto = request.getParameter("descripcionProducto");
				int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
				
				
				
				//Instaciamos un objeto producto y le agregamos los datos
				Producto producto = new Producto();
				producto.setIdProducto(idProducto);
				producto.setNombreProducto(nombreProducto);
				producto.setPrecioProducto(precioProducto);
				producto.setDescripcionProducto(descripcionProducto);
				
				//utiligo el metodo Agregar producto (implementacion) y le envio el de
				productoDao.agregarProducto(producto);
				
				//Hay que colocar una vista para que el cliente pueda seguir interactuand con la pagina
				request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);		
	}

}
