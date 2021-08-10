package fr.humanbooster.fx.facturation.servlets;

import fr.humanbooster.fx.facturation.services.ClientService;
import fr.humanbooster.fx.facturation.services.PrestationService;
import fr.humanbooster.fx.facturation.services.impl.ClientServiceImpl;
import fr.humanbooster.fx.facturation.services.impl.PrestationServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(urlPatterns = { "/init"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientService clientService = new ClientServiceImpl();	
	private PrestationService prestationService = new PrestationServiceImpl();
	@Override
	public void init() {
		if(clientService.recupererClients().isEmpty()) {
			clientService.ajouterClient("Client 1");
			clientService.ajouterClient("Client 2");
		}
		
		if(prestationService.recupererPrestations().isEmpty()) {
			prestationService.ajouterPrestation("Prestation 1", 10.0f);
			prestationService.ajouterPrestation("Prestation 2", 20.0f);
		}
		
	}
}
