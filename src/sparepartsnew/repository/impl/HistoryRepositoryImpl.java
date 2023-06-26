/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sparepartsnew.db.DatabaseConnection;
import sparepartsnew.model.History;
import sparepartsnew.model.Operation;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Users;
import sparepartsnew.repository.GenericRepository;
import sparepartsnew.service.impl.ModulServiceImpl;
import sparepartsnew.service.impl.UsersServiceImpl;

/**
 *
 * @author Marko HP
 */
public class HistoryRepositoryImpl implements GenericRepository<History, Users, Long, Sort> {

private ModulServiceImpl modulRepo;
private UsersServiceImpl userRepo;

    @Override
    public List<History> getAll(Sort sort) throws Exception {
        List<History> histories=new ArrayList<>();
        modulRepo = new ModulServiceImpl();
        userRepo = new UsersServiceImpl();
        try {  
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query="SELECT * FROM history ORDER BY "+String.valueOf(sort);
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()){
              History history = new History();
              history.setIdHistory(rs.getLong("id"));
              history.setModul(modulRepo.getById(rs.getLong("modul_id")));
              history.setUser(userRepo.getById(rs.getString("username")));
              history.setOperation(Operation.valueOf(rs.getString("operation")));              
              Date dateSql =  rs.getDate("date_time");
              LocalDate date=Instant.ofEpochMilli(dateSql.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
              history.setDate(date);
              histories.add(history);
            }
            rs.close();
            statement.close();
      }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error with getting modules"+e.getMessage());
        }
        return histories;
    }

    @Override
    public void edit(History t, Users e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(History t, Users e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(History t, Users e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public History getById(Long s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
    }
    

