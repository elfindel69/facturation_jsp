package fr.humanbooster.fx.facturation.services.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.dao.PrestationDao;
import fr.humanbooster.fx.facturation.dao.impl.PrestationDaoImpl;
import fr.humanbooster.fx.facturation.services.PrestationService;

public class PrestationServiceImpl implements PrestationService {
	
	private PrestationDao prestationDao = new PrestationDaoImpl();

	@Override
	public Prestation ajouterPrestation(String nom, float montant) {
		Prestation prestation = new Prestation(nom, montant);
		
		try {
			return prestationDao.create(prestation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Prestation recupererPrestation(Long id) {
		try {
			return prestationDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Prestation> recupererPrestations() {
		try {
			return prestationDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
