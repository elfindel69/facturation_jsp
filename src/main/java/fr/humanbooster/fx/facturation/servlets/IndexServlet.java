package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.services.ClientService;
import fr.humanbooster.fx.facturation.services.FactureService;
import fr.humanbooster.fx.facturation.services.impl.ClientServiceImpl;
import fr.humanbooster.fx.facturation.services.impl.FactureServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns="/index", loadOnStartup=1)
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ClientService clientService = new ClientServiceImpl();
	private static final FactureService factureService = new FactureServiceImpl();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = clientService.recupererClients();
		
		if(clients != null) {
			request.setAttribute("clients", clients);
		}
		
		List<Facture> factures = factureService.recupererFactures();
		
		if(factures != null) {
			request.setAttribute("factures", factures);
		}
		
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
