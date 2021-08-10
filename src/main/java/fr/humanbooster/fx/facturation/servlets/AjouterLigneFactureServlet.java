package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.services.FactureService;
import fr.humanbooster.fx.facturation.services.LigneFactureService;
import fr.humanbooster.fx.facturation.services.PrestationService;
import fr.humanbooster.fx.facturation.services.impl.FactureServiceImpl;
import fr.humanbooster.fx.facturation.services.impl.LigneFactureServiceImpl;
import fr.humanbooster.fx.facturation.services.impl.PrestationServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ajouterLigneFactures", loadOnStartup=1)
public class AjouterLigneFactureServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final FactureService factureService = new FactureServiceImpl();
	private static final LigneFactureService ligneFactureService = new LigneFactureServiceImpl();
	private static final PrestationService prestationService = new PrestationServiceImpl();

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		Facture facture = factureService.recupererFacture(id);
		if(facture !=null) {
			request.setAttribute("facture", facture);
		}
		List<Prestation> prestations = prestationService.recupererPrestations();
		request.setAttribute("prestations", prestations);
		request.getRequestDispatcher("WEB-INF/ajouterLigneFacture.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long factureId=Long.parseLong(request.getParameter("id"));
		Facture facture = null;
		if(factureId!=null) {
			facture = factureService.recupererFacture(factureId);
		}
		
		Long prestationId=Long.parseLong(request.getParameter("prestationId"));
		Prestation prestation = null;
		if(prestationId!=null) {
			prestation = prestationService.recupererPrestation(prestationId);
		}
		
		float quantite = Float.parseFloat(request.getParameter("quantite"));
		Float remise = Float.parseFloat(request.getParameter("remise"));
		
		
		ligneFactureService.ajouterLigneFacture(facture, prestation, quantite, remise);
	
		
		response.sendRedirect("index");
	}

}
