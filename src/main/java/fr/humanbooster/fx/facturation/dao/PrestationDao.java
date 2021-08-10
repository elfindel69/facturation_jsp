package fr.humanbooster.fx.facturation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Prestation;

public interface PrestationDao {
    
    Prestation create(Prestation prestation) throws SQLException;
    
    List<Prestation> findAll() throws SQLException;
    
    Prestation findOne(Long id) throws SQLException;
        
}