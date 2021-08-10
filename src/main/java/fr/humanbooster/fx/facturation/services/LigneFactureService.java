package fr.humanbooster.fx.facturation.services;

import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;
import fr.humanbooster.fx.facturation.business.Prestation;



public interface LigneFactureService {
	LigneFacture ajouterLigneFacture(Facture facture, Prestation prestation, float quantite, float remise);
	
	List<LigneFacture> recupererLignesFacturesParFacture(Facture facture);
}
