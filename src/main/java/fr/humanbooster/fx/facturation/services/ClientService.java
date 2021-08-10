package fr.humanbooster.fx.facturation.services;

import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;

public interface ClientService {
	Client ajouterClient(String nom);
	
	Client recupererClient(Long id);
	
	List<Client> recupererClients();
	
	Client mettreAJourClient(Long id, String nom);
	
	boolean supprimerClient(Client client);
}
