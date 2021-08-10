package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;

import fr.humanbooster.fx.facturation.services.ClientService;
import fr.humanbooster.fx.facturation.services.impl.ClientServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ajouterClients", loadOnStartup=1)
public class AjouterClientServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClientService clientService = new ClientServiceImpl();;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/ajouterClient.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		
		if(nom != null && !nom.isEmpty()) {
			clientService.ajouterClient(nom);
		}
		
		response.sendRedirect("index");
	}

}
