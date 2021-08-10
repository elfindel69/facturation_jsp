package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.services.ClientService;
import fr.humanbooster.fx.facturation.services.impl.ClientServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/supprimerClients", loadOnStartup=1)
public class SupprimerClientServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClientService clientService = new ClientServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idClient = Long.parseLong(request.getParameter("id"));
		Client client = clientService.recupererClient(idClient);
		
		if(client!= null) {
			clientService.supprimerClient(client);
		}
		
		response.sendRedirect("index");
	}

}
