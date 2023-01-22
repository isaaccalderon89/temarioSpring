package aumento.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoAumento
 */
@WebServlet("/SaludoAumento")
public class SaludoAumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoAumento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><center>");
		for(int i=6;i>=1;i--) {
			out.println("<h>"+i+">Bienvenido a Servlet</h"+i+">");
		}
		out.println("</center></body></html>");
		/*
		 * Si observamos el código anterior, observamos como se utiliza la ariable de control for para la construccion de la etiqueta 
		 * <hx> y así generar seis cabeceras, desde la <h6> a la <h1>. 
		 */
	}

}
