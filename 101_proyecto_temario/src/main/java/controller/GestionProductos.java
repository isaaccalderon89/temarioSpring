package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Producto;
import modelo.daos.IntProductos;
import modelo.daos.ProductosListImpl;

/**
 * Servlet implementation class GestionProductos
 */
@WebServlet(description = "tareas asociadas a productos", urlPatterns = { "/productos" })
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("entrando en productos en init");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "novedades":
			procNovedades(request,  response);
			break;
		case "alta":
			procAlta(request,  response);
			break;
		case "editar":
			procEditar( request,  response);
			break;
		case "eliminar":
			procEliminar(request,  response);
			break;
		default:
				System.out.println("opcion incorrecta : " + opcion);
			
		}
	}
	protected void procNovedades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("en novedades");
	}
	
	protected void procAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("en alta");
	}
	
	protected void procEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IntProductos iprod = new ProductosListImpl(); 
		Producto producto = iprod.findById(id);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("editarproducto.jsp").forward(request, response);
	}
	
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("en eliminar id : " +request.getParameter("id"));
	}
}
