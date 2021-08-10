package fr.humanbooster.fx.facturation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.dao.ClientDao;
import fr.humanbooster.fx.facturation.dao.ConnexionBdd;
import fr.humanbooster.fx.facturation.dao.Requetes;

public class ClientDaoImpl implements ClientDao {
    
    private Connection connection;
    
    public ClientDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Client create(Client client) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_CLIENT, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, client.getNom());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            client.setId(rs.getLong(1));
        }
        
        return client;
    }
    
    @Override
    public List<Client> findAll() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_CLIENTS);
        ResultSet rs = ps.executeQuery();
        
        List<Client> clients = new ArrayList<>();
        
        while (rs.next()) {
            Long id = rs.getLong("id");
            String nom = rs.getString("nom");
            clients.add(new Client(id, nom));
        }
        return clients;
    }
    
    @Override
    public Client findOne(Long id) throws SQLException {
        String query = Requetes.RECUPERATION_CLIENT_PAR_ID;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        
        Client client = null;
        
        if (rs.next()) {
            client = new Client(rs.getString("nom"));
            client.setId(rs.getLong("id"));
        }
        return client;
    }

    @Override
    public Client update(Client client) throws SQLException {
    	
        PreparedStatement ps = connection.prepareStatement(Requetes.UPDATE_CLIENT);
        
        ps.setString(1, client.getNom());
        ps.setLong(2, client.getId());
        
        ps.executeUpdate();
        return client;
    }
    
    @Override
    public boolean delete(Client client) throws SQLException {
        
        boolean estPresent = false;
        
        if (findOne(client.getId()) != null){
            PreparedStatement ps = connection.prepareStatement(Requetes.DELETE_CLIENT);
            ps.setLong(1, client.getId());
            ps.executeUpdate();
            estPresent = true;
        }
    
        return estPresent;
    }
    
}