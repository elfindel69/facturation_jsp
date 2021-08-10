package fr.humanbooster.fx.facturation.servlets;

import java.io.IOException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;
import fr.humanbooster.fx.facturation.services.FactureService;
import fr.humanbooster.fx.facturation.services.LigneFactureService;
import fr.humanbooster.fx.facturation.services.impl.FactureServiceImpl;
import fr.humanbooster.fx.facturation.services.impl.LigneFactureServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/factures", loadOnStartup=1)
public class FactureServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final FactureService factureService = new FactureServiceImpl();
	private static final LigneFactureService ligneFactureService = new LigneFactureServiceImpl();
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		Facture facture = factureService.recupererFacture(id);
		if(facture !=null) {
			request.setAttribute("facture", facture);
		}
		List<LigneFacture> lignes = ligneFactureService.recupererLignesFacturesParFacture(facture);
		if(lignes != null) {
			request.setAttribute("lignes", lignes);
			float total = 0.0f;
			
			for(LigneFacture ligne : lignes) {
				total += (ligne.getPrestation().getMontant()*ligne.getQuantite())-ligne.getRemise();
			}
			
			request.setAttribute("total", total);
		}
		
		request.getRequestDispatcher("WEB-INF/factures.jsp").forward(request, response);
	}

}
