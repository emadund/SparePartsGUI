/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.repository.impl;
import java.util.ArrayList;
import java.util.List;
import sparepartsnew.db.DatabaseConnection;
import sparepartsnew.model.Location;

import java.sql.*;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Users;
import sparepartsnew.repository.GenericRepository;

/**
 *
 * @author Marko HP
 */
public class LocationRepositoryImpl implements GenericRepository <Location, Users, String, Sort> {

    public LocationRepositoryImpl() {
    }

    @Override
    public List<Location> getAll(Sort sort) throws Exception {
        
        List<Location> locations = new ArrayList<>();
        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM locations ORDER BY "+String.valueOf(sort);
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            
            while (rs.next()) {
                Location location = new Location();
                location.setSiteCode(rs.getString("site_code"));
                location.setName(rs.getString("name"));
                location.setType(rs.getString("type"));
                location.setAddress(rs.getString("address"));
                location.setLat(rs.getString("lat"));
                location.setLon(rs.getString("lon"));
                locations.add(location);
                }
            rs.close();
            statement.close();
            
            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error with db with locations table: "+e.getMessage());
            
        }
        return locations;
    }

    @Override
    public void add(Location location, Users user) throws Exception {
        
        for (Location l: this.getAll(Sort.site_code)) {
            if (l.equals(location)) {
                throw new Exception ("That location already exists");
                }
            
            else {
                try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO locations VALUES (?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, location.getSiteCode());
            statement.setString(2, location.getName());
            statement.setString(3, location.getType());
            statement.setString(4, location.getAddress());
            statement.setString(5, location.getLat());
            statement.setString(6, location.getLon());
            statement.executeUpdate();
            statement.close();
            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error with db with locations table: "+e.getMessage());
            
        }
                
            }
        }
       
    }

    @Override
    public void edit(Location t, Users e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Location t, Users e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
   

    @Override
    public Location getById(String siteCode) throws Exception {
        Location location = new Location();
                
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM locations WHERE `site_code`=?;";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,siteCode);
            ResultSet rs = statement.executeQuery();           
            
            if (rs.next()) {
                
                location.setSiteCode(siteCode);
                location.setName(rs.getString("name"));
                location.setType(rs.getString("type"));
                location.setAddress(rs.getString("address"));
                location.setLat(rs.getString("lat"));
                location.setLon(rs.getString("lon"));                
                }
            rs.close();
            statement.close();            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There is no location under that site code, or problem with DB: "+e.getMessage());
        }
        return location;
    }
}
