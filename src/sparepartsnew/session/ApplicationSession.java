/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.session;

import sparepartsnew.model.Users;

/**
 *
 * @author Marko HP
 */
public class ApplicationSession {
    
    private Users loginUser;
    private static ApplicationSession instance;
    
    private ApplicationSession(){
        
    }

    public ApplicationSession(Users loginUser) {
        this.loginUser = loginUser;
    }
    
    
    
    public static ApplicationSession getInstance() {
        if (instance==null)  
            instance= new ApplicationSession();
            
            return instance;
    }
    
    
}
