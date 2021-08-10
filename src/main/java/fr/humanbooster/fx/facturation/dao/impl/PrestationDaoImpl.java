package fr.humanbooster.fx.facturation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.dao.ConnexionBdd;
import fr.humanbooster.fx.facturation.dao.Requetes;
import fr.humanbooster.fx.facturation.dao.PrestationDao;

public class PrestationDaoImpl implements PrestationDao {
    
    private Connection connection;
    
    public PrestationDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Prestation create(Prestation prestation) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_PRESTATION, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, prestation.getNom());
        ps.setFloat(2, prestation.getMontant());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            prestation.setId(rs.getLong(1));
        }
        
        return prestation;

    }
    
    @Override
    public List<Prestation> findAll() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_PRESTATIONS);
        ResultSet rs = ps.executeQuery();
    
        List<Prestation> prestation = new ArrayList<>();
    
        while (rs.next()) {
            Long id = rs.getLong("id");
            String nom = rs.getString("nom");
            Float montant = rs.getFloat("montant");
        
            prestation.add(new Prestation(id, nom, montant));
        }
        return prestation;
    }
    
    @Override
    public Prestation findOne(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_PRESTATION_PAR_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
    
        Prestation prestation = null;
    
        if (rs.next()) {
        	prestation = new Prestation();
            prestation.setId(rs.getLong("id"));
            prestation.setNom(rs.getString("nom"));
            prestation.setMontant(rs.getFloat("montant"));        
        }
        return prestation;

    }
        
}