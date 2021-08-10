package fr.humanbooster.fx.facturation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;

public interface ClientDao {
    
    Client create(Client client) throws SQLException;
    
    List<Client> findAll() throws SQLException;
    
    Client findOne(Long id) throws SQLException;

    Client update(Client client) throws SQLException;
    
    boolean delete(Client client) throws SQLException;

}