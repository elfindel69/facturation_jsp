package fr.humanbooster.fx.facturation.services.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.dao.ClientDao;
import fr.humanbooster.fx.facturation.dao.impl.ClientDaoImpl;
import fr.humanbooster.fx.facturation.services.ClientService;

public class ClientServiceImpl implements ClientService {
	private ClientDao clientDao = new ClientDaoImpl();
	@Override
	public Client ajouterClient(String nom) {
		Client client = new Client(nom);
		
		try {
			client = clientDao.create(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
	}

	@Override
	public Client recupererClient(Long id) {
		// TODO Auto-generated method stub
		try {
			return clientDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Client> recupererClients() {
		try {
			return clientDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Client mettreAJourClient(Long id, String nom) {
		Client client = new Client(id,nom);
		try {
			return clientDao.update(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerClient(Client client) {
		
		// TODO Auto-generated method stub
		try {
			return clientDao.delete(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
