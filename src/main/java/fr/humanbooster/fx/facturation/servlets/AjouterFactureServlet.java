package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.services.ClientService;
import fr.humanbooster.fx.facturation.services.FactureService;
import fr.humanbooster.fx.facturation.services.impl.ClientServiceImpl;
import fr.humanbooster.fx.facturation.services.impl.FactureServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/ajouterFactures", loadOnStartup=1)
public class AjouterFactureServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ClientService clientService = new  ClientServiceImpl();
	private static final FactureService factureService = new FactureServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		Client client = clientService.recupererClient(id);
		if(client !=null) {
			request.setAttribute("client", client);
		}
		request.getRequestDispatcher("WEB-INF/ajouterFacture.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long clientId=Long.parseLong(request.getParameter("clientId"));
		Client client = null;
		if(clientId!=null) {
			client = clientService.recupererClient(clientId);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = null;
		try {
			dateCreation = formatter.parse(request.getParameter("dateCreation"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date dateExpiration = null;
		try {
			dateExpiration = formatter.parse(request.getParameter("dateExpiration"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		factureService.ajouterFacture(dateCreation, dateExpiration, client);
	
		
		response.sendRedirect("index");
	}

}
