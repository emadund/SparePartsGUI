/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.repository.impl;

import java.sql.*;
import java.util.List;
import sparepartsnew.model.Sort;
import sparepartsnew.db.DatabaseConnection;
import sparepartsnew.model.Privilege;
import sparepartsnew.model.Users;
import sparepartsnew.repository.GenericRepository;
import sparepartsnew.ui.login.LoginController;


/**
 *
 * @author Marko HP
 */
public class UsersRepositoryImpl implements GenericRepository<Users, String, String, Sort> {

    public Users getAll (String email, String password) throws Exception {
        try {            
            LoginController.getInstance().login(email, password);            
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception ("Wrong e-mail/password combination: "+e.getMessage());
        }
        return null;        
    }   

    @Override
    public List<Users> getAll(Sort sort) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Users t, String e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Users t, String e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Users t, String e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Users getById(String username) throws Exception {
       
        Users user = new Users();
        
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM `users` WHERE `username`=?;";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();           
            
            if (rs.next()) {
                
                user.setUsername(username);
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFull_name("full_name");
                user.setPrivilege(Privilege.valueOf(rs.getString("privileges")));                                    
                }
            rs.close();
            statement.close();            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There is no location under that site code, or problem with DB: "+e.getMessage());
        }
        return user;
    }
}
