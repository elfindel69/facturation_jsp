package fr.humanbooster.fx.facturation.services.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.dao.FactureDao;
import fr.humanbooster.fx.facturation.dao.impl.FactureDaoImpl;
import fr.humanbooster.fx.facturation.services.FactureService;

public class FactureServiceImpl implements FactureService {
	
	private FactureDao factureDao = new FactureDaoImpl();
	@Override
	public Facture ajouterFacture(Date dateCreation, Date dateEcheance, Client client) {
		Facture facture = new Facture(dateCreation, dateEcheance, client);
		
		try {
			return factureDao.create(facture);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Facture recupererFacture(Long id) {
		try {
			return factureDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Facture> recupererFactures() {
		try {
			return factureDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Facture> recupererFactureParClient(Client client) {
		try {
			return factureDao.findByClient(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
