package fr.humanbooster.fx.facturation.services;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;

public interface FactureService {
	Facture ajouterFacture(Date dateCreation, Date dateEcheance, Client client);
	
	Facture recupererFacture(Long id);
	
	List<Facture> recupererFactures();
	
	List<Facture> recupererFactureParClient(Client client);
	
}
