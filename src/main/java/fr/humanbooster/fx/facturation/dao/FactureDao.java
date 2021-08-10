package fr.humanbooster.fx.facturation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;

public interface FactureDao {
    
    Facture create(Facture facture) throws SQLException;
    
    List<Facture> findAll() throws SQLException;
    
    Facture findOne(Long id) throws SQLException;

    List<Facture> findByClient(Client client) throws SQLException;

    
}
