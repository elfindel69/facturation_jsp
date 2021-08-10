package fr.humanbooster.fx.facturation.services.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;
import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.dao.LigneFactureDao;
import fr.humanbooster.fx.facturation.dao.impl.LigneFactureDaoImpl;
import fr.humanbooster.fx.facturation.services.LigneFactureService;

public class LigneFactureServiceImpl implements LigneFactureService {
	
	private LigneFactureDao ligneFactureDao = new LigneFactureDaoImpl();

	@Override
	public LigneFacture ajouterLigneFacture(Facture facture, Prestation prestation, float quantite, float remise) {
		LigneFacture ligneFacture = new LigneFacture(facture, prestation, quantite, remise);
		
		try {
			return ligneFactureDao.create(ligneFacture);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LigneFacture> recupererLignesFacturesParFacture(Facture facture) {
		try {
			return ligneFactureDao.findByFacture(facture);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
