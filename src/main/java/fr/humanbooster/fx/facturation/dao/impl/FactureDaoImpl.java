package fr.humanbooster.fx.facturation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.dao.ClientDao;
import fr.humanbooster.fx.facturation.dao.ConnexionBdd;
import fr.humanbooster.fx.facturation.dao.FactureDao;
import fr.humanbooster.fx.facturation.dao.Requetes;

public class FactureDaoImpl implements FactureDao {
    
    private Connection connection;
    private ClientDao clientDao;
    
    public FactureDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        clientDao = new ClientDaoImpl();
    }
    
    @Override
    public Facture create(Facture facture) throws SQLException {
    
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_FACTURE, Statement.RETURN_GENERATED_KEYS);
        ps.setTimestamp(1, new java.sql.Timestamp(facture.getDateCreation().getTime()));
        ps.setTimestamp(2, new java.sql.Timestamp(facture.getDateEcheance().getTime()));
        ps.setLong(3, facture.getClient().getId());

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            facture.setId(rs.getLong(1));
        }
        return facture;
    }
    
    @Override
    public List<Facture> findAll() throws SQLException {
        
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_FACTURES);
        ResultSet rs = ps.executeQuery();
    
        List<Facture> factures = new ArrayList<>();
    
        while (rs.next()) {
            Long id = rs.getLong("id");
            java.util.Date dateCreation = new java.sql.Timestamp(rs.getTimestamp("date_creation").getTime());
            java.util.Date dateEcheance = new java.sql.Timestamp(rs.getTimestamp("date_echeance").getTime());

            Client client = clientDao.findOne(rs.getLong("client_id"));
            
            factures.add(new Facture(id, dateCreation, dateEcheance, client));
        }
        
        return factures;
    }
    
    @Override
    public Facture findOne(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_FACTURE_PAR_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
    
        Facture facture = null;
    
        if (rs.next()) {
        	facture = new Facture(clientDao.findOne(rs.getLong("client_id")));
            facture.setId(rs.getLong("id"));
            java.util.Date dateCreation = new java.sql.Timestamp(rs.getTimestamp("date_creation").getTime());
            java.util.Date dateEcheance = new java.sql.Timestamp(rs.getTimestamp("date_echeance").getTime());
            facture.setDateCreation(dateCreation);
            facture.setDateEcheance(dateEcheance);
        }
        
        return facture;
    }

	@Override
	public List<Facture> findByClient(Client client) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_FACTURES_PAR_CLIENT);
        ps.setLong(1, client.getId());
        ResultSet rs = ps.executeQuery();
    
        List<Facture> factures = new ArrayList<>();
    
        while (rs.next()) {
            Long id = rs.getLong("id");
            java.util.Date dateCreation = new java.sql.Timestamp(rs.getTimestamp("date_creation").getTime());
            java.util.Date dateEcheance = new java.sql.Timestamp(rs.getTimestamp("date_echeance").getTime());
            
            factures.add(new Facture(id, dateCreation, dateEcheance, client));
        }
        
        return factures;
	}
        
}