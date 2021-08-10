package fr.humanbooster.fx.facturation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;

public interface LigneFactureDao {

	public LigneFacture create(LigneFacture ligneFacture) throws SQLException;
	
	public List<LigneFacture> findByFacture(Facture facture) throws SQLException;
	
}
