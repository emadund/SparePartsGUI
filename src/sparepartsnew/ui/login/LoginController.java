/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.ui.login;

import sparepartsnew.model.Users;
import java.sql.*;
import sparepartsnew.db.DatabaseConnection;
import sparepartsnew.model.Privilege;

/**
 *
 * @author Marko HP
 */
public class LoginController {
    private static LoginController instance;
    
    private  LoginController () {
        
    }
    
    public static LoginController getInstance() {
        if (instance==null) {
            instance=new LoginController();
        }
        return instance;
    }
    
    public Users login (String email, String password) throws SQLException {
        
        try {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        
        String query = "SELECT * FROM users WHERE email=? AND password=?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,email);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();        
        
        if (rs.next()) 
        { 
             System.out.println("You are logged with e-mail: "+email );
             return this.getCurrentUser(rs);
                       
        
        }
        
        else {System.out.println("Not logged");
        return null;        
        }
        
    }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Email and/or password is wrong: "+e.getMessage());
            return null;
        }   
    
}

    private Users getCurrentUser(ResultSet rs) {
       Users user = new Users();
       try {
           user.setEmail(rs.getString("email"));
           user.setPassword(rs.getString("password"));
           user.setFull_name(rs.getString("full_name"));
           user.setPrivilege(Privilege.valueOf(rs.getString("privileges")));
           user.setUsername(rs.getString("username"));    
           
                      
       }
       catch (Exception e) {
            e.printStackTrace();
            System.out.println("Email and/or password is wrong"+e.getMessage());
           return null; 
        }
       return user;     
       }
}
