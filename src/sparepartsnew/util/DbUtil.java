/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Marko HP
 */
public class DbUtil {
    
    private Properties properties;
    
    public DbUtil() throws FileNotFoundException, IOException {
        properties= new Properties();
        properties.load(new FileInputStream("db.properties"));
    }
    
    public String getURL() {        
        return properties.getProperty("url");        
    }
    public String getUser() {        
        return properties.getProperty("user");
    }
    public String getPassword() {        
        return properties.getProperty("password");
    }
    
    
    
    
}
