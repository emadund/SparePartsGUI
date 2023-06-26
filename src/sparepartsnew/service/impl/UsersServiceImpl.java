/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.service.impl;

import java.util.List;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Users;
import sparepartsnew.repository.impl.UsersRepositoryImpl;
import sparepartsnew.service.GenericService;

/**
 *
 * @author Marko HP
 */
public class UsersServiceImpl implements GenericService<Users, String, String, Sort>{   
    private UsersRepositoryImpl userRepository;

    public UsersServiceImpl() {
        userRepository = new UsersRepositoryImpl();
    }  
    
    public Users getAll (String email, String password) throws Exception {
        return userRepository.getAll(email, password);
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
       return userRepository.getById(username);
    }

   
    
}
