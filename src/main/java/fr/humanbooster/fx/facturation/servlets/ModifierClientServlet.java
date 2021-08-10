package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.services.ClientService;
import fr.humanbooster.fx.facturation.services.impl.ClientServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/modifierClients", loadOnStartup=1)
public class ModifierClientServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClientService clientService = new ClientServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		
		if(id!=null) {
			Client client = clientService.recupererClient(id);
			request.setAttribute("client", client);
		}
		request.getRequestDispatcher("WEB-INF/modifierClient.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		Long id = Long.parseLong(request.getParameter("id"));
		if(nom != null && !nom.isEmpty()) {
			clientService.mettreAJourClient(id, nom);
		}
		
		response.sendRedirect("index");
	}

}
