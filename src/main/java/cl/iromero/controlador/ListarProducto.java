package cl.iromero.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.iromero.dao.IProductoCategoriaDAO;
import cl.iromero.dao.ProductoCategoriaDAOImpl;
import cl.iromero.model.ProductoCategoria;

@WebServlet("/ListarProducto")
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//instanciamos la clase para conexion con la base de datos
	IProductoCategoriaDAO productoCategoriaDAO = new ProductoCategoriaDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Extraemos la info de la base de datos con el uso del objeto instanciado y sus metodos
		List<ProductoCategoria> listaProdCat   = productoCategoriaDAO.listarProductoCategoria();
		
		//pasamos la lista a la siguiente entidad Servlet o jsp
		request.setAttribute("listaProdCat", listaProdCat);
		request.getRequestDispatcher("ListarProducto.jsp").forward(request, response);
	}
	

}
