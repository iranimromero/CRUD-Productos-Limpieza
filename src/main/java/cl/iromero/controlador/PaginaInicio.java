package cl.iromero.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaginaInicio")
public class PaginaInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Llevamos la solicitus a la pagina JSP con el forwar entrego el request y el response de lo procesado en el servlet
		request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
	}



}
