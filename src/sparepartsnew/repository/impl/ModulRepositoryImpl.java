/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.repository.impl;

import java.util.ArrayList;
import java.util.List;
import sparepartsnew.db.DatabaseConnection;
import sparepartsnew.model.Modul;
import java.sql.*;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Location;
import sparepartsnew.model.Status;
import sparepartsnew.model.Type;
import sparepartsnew.model.Users;
import sparepartsnew.repository.GenericRepository;
import sparepartsnew.service.impl.LocationServiceImpl;


/**
 *
 * @author Marko HP
 */
public class ModulRepositoryImpl implements GenericRepository<Modul, Users, Long, Sort> {

       private Users user;
       private LocationServiceImpl locationRepo;

    @Override
    public List<Modul> getAll(Sort sort) throws Exception {
      
          List<Modul> modules=new ArrayList<>();
          locationRepo = new LocationServiceImpl();
        try {  
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query="SELECT * FROM modules ORDER BY "+String.valueOf(sort);
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()){
              Modul modul = new Modul();
              modul.setId(rs.getLong("id"));
              modul.setSn(rs.getString("S/N"));
              modul.setPn(rs.getString("P/N"));
              modul.setName(rs.getString("name"));
              modul.setType(Type.valueOf(rs.getString("type")));
              modul.setStatus(Status.valueOf(rs.getString("status")));
              Location location = locationRepo.getById(rs.getString("location"));                      
              modul.setLocation(location);
              modul.setMm(rs.getInt("mm"));
              modules.add(modul);
            }
            rs.close();
            statement.close();
      }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error with getting modules"+e.getMessage());
        }
        return modules;
    }

    @Override
    public void edit(Modul modul, Users user) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "UPDATE `modules` SET `s/n`=?, `p/n`=?,`type`=?,`status`=?, `location`=? WHERE id="+modul.getId()+";";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, modul.getSn());
            statement.setString(2, modul.getPn());
            statement.setString(3, String.valueOf(modul.getType()));
            statement.setString(4, String.valueOf(modul.getStatus()));
            statement.setString(5, locationRepo.getById(modul.getLocation().getSiteCode()).toString());            
            statement.executeUpdate();
            String query2 = "INSERT INTO `history` VALUES (NULL, "+modul.getId()+",'"+user.getUsername()+"','Updated',now());";
            Statement statement2 =connection.createStatement();
            statement2.executeUpdate(query2);            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There has been an error: "+e.getMessage());
        }
       
    }

    @Override
    public void delete(Modul modul, Users user) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM `modules` WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(query);                       
            statement.setString(1, modul.getId().toString());
            statement.executeUpdate();
            String query2 = "INSERT INTO `history` VALUES (NULL, "+modul.getId()+",'"+user.getUsername()+"','Deleted',now());";
            Statement statement2 =connection.createStatement();
            statement2.executeUpdate(query2);            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There has been an error: "+e.getMessage());
        }
    }

    @Override
    public void add(Modul modul, Users user) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO `modules` VALUES (null, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);            
            String name = modul.getName();
            String sn = modul.getSn();
            String pn = modul.getPn();
            String mm = String.valueOf(modul.getMm());
            String type = modul.getType().toString();
            String status = modul.getStatus().toString();
            String location = modul.getLocation().getSiteCode();            
            statement.setString(1, name);
            statement.setString(2, sn);
            statement.setString(3, pn);
            statement.setString(4, mm);
            statement.setString(5, type);
            statement.setString(6, location);
            statement.setString(7, status);            
            statement.executeUpdate();
            
            String query2 = "SELECT `id` FROM `modules` WHERE name=? AND `s/n`=? AND `p/n`=? AND `type`=? AND `status`=? AND `location`=? AND mm=?;";
            PreparedStatement statement2=connection.prepareStatement(query2);
            statement2.setString(1, name);
            statement2.setString(2, sn);
            statement2.setString(3, pn);
            statement2.setString(4, type);
            statement2.setString(5, status);
            statement2.setString(6, location);
            statement2.setString(7, mm);
            ResultSet rs=statement2.executeQuery();
            if (rs.next()) {
            String rsS= rs.getString("id").toString();
            
            String query3 = "INSERT INTO `history` VALUES (NULL, '"+rsS+"','"+user.getUsername()+"','Created',now());";
            Statement statement3 =connection.createStatement();
            statement3.executeUpdate(query3);}
            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There has been an error: "+e.getMessage());
        }
    }   
  

    @Override
    public Modul getById(Long id) throws Exception {
        Modul modul = new Modul();
        locationRepo = new LocationServiceImpl();
                
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM `modules` WHERE `id`=?;";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,id.toString());
            ResultSet rs = statement.executeQuery();           
            
            if (rs.next()) {
                
                modul.setId(id);
                modul.setName(rs.getString("name"));
                modul.setSn(rs.getString("s/n"));
                modul.setPn(rs.getString("p/n"));
                modul.setMm(Integer.parseInt(rs.getString("mm")));
                modul.setType(Type.valueOf(rs.getString("type")));
                Location location = locationRepo.getById(rs.getString("location"));
                modul.setLocation(location);
                modul.setStatus(Status.valueOf(rs.getString("status")));                       
                }
            rs.close();
            statement.close();            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There is no module under that id, or problem with DB: "+e.getMessage());
        }
        return modul;
    }
    public List<Modul> viewByLocation (Location location) throws Exception {
        locationRepo = new LocationServiceImpl();
        List<Modul> modules = new ArrayList<>();
        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();        
            String query= "SELECT modules.`location`, modules.`name`, modules.`s/n`,"
                    + " modules.`p/n`, modules.`mm`, modules.`type`, modules.`status`"
                    + " FROM spareparts.modules JOIN spareparts.locations ON modules.`location`=locations.`site_code` WHERE modules.`location`=?"
                    + "ORDER BY modules.`location`;";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, location.getSiteCode());
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
            String siteCode = rs.getString("location");
            String name = rs.getString("name");
            String sn = rs.getString("s/n");
            String pn = rs.getString("p/n");
            int mm = Integer.parseInt(rs.getString("mm"));
            sparepartsnew.model.Type type = sparepartsnew.model.Type.valueOf(rs.getString("type"));
            sparepartsnew.model.Status status = sparepartsnew.model.Status.valueOf(rs.getString("status"));
            modules.add(new Modul(null, name, sn, pn, mm,type, locationRepo.getById(siteCode), status));          
        
    }
            rs.close();
            statement.close();
        }
            catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("There has been an error with displaying list of modules: "+e.getMessage());
                    }
            return modules;
        }
      
    
}
