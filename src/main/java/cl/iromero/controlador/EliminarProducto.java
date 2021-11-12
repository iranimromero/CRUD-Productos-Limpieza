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
import cl.iromero.dao.IProductoCategoriaDAO;
import cl.iromero.dao.IProductoDAO;
import cl.iromero.dao.ProductoCategoriaDAOImpl;
import cl.iromero.dao.ProductoDAOImpl;
import cl.iromero.model.ProductoCategoria;


@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Instanciamos la clase
		//IProductoCategoriaDAO productoCategoriaDao = new ProductoCategoriaDAOImpl();
	
	//accedemos a la BBDD por medio de las clases
		IProductoDAO productoDao = new ProductoDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creo una lista y la lleno utilizando nuestro metodo de listar y la seteamos para enviar al JSP
		//List<ProductoCategoria> ListaProdCat = new ArrayList<ProductoCategoria>();
		//ListaProdCat = productoCategoriaDao.listarProductoCategoria();
		//request.setAttribute("ListaProdCat", ListaProdCat);
		int id = Integer.parseInt(request.getParameter("id"));
		//verifico que el id es valido
		if (id<=0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		request.setAttribute("id", id);
		request.getRequestDispatcher("EliminarProducto.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//verifico que el id es valido
		if (id<=0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		//ejecuto el metodo de eliminar
		productoDao.eliminarProducto(id);
		//nos quedamos en el metodo
		//doGet(request, response);
		//nos vamos a la pagina de inicio
		request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
	
		
	}

}
