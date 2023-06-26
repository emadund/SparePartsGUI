/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.service.impl;

import java.util.List;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Location;
import sparepartsnew.model.Modul;
import sparepartsnew.model.Users;
import sparepartsnew.repository.impl.ModulRepositoryImpl;
import sparepartsnew.service.GenericService;


public class ModulServiceImpl implements GenericService<Modul, Users, Long, Sort>{
    
    private ModulRepositoryImpl modulRepository;
    
    public ModulServiceImpl() {
        modulRepository=new ModulRepositoryImpl();
    }    
    

    @Override
    public List<Modul> getAll(Sort sort) throws Exception {
        return modulRepository.getAll(sort);
        
    }

    @Override
    public void edit(Modul modul, Users user) throws Exception {
        for (Modul temp: modulRepository.getAll(Sort.id)) {
            if (temp.equals(modul)) {
                throw new Exception ("There is already module in DB");                
            }            
        }
        modulRepository.edit(modul, user);
    }

    @Override
    public void delete(Modul modul, Users user) throws Exception {
        modulRepository.delete(modul, user);
    }

    @Override
    public void add(Modul modul, Users user) throws Exception {
        for (Modul temp: modulRepository.getAll(Sort.id)) {
            if (temp.equals(modul)) {
                throw new Exception ("There is already module in DB");                
            }            
        }        
        modulRepository.add(modul, user);
    }

    @Override
    public Modul getById(Long id) throws Exception {
        return modulRepository.getById(id);
    }
    public List<Modul> viewByLocation (Location location) throws Exception {
        return modulRepository.viewByLocation(location);
    }
    
    
}
