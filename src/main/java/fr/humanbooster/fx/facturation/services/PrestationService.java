package fr.humanbooster.fx.facturation.services;

import java.util.List;

import fr.humanbooster.fx.facturation.business.Prestation;

public interface PrestationService {
	Prestation ajouterPrestation(String nom, float montant);
	
	Prestation recupererPrestation(Long id);
	
	List<Prestation> recupererPrestations();
	
}
