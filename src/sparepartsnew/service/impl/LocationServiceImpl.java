/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.service.impl;

import java.util.List;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Location;
import sparepartsnew.model.Users;
import sparepartsnew.repository.impl.LocationRepositoryImpl;
import sparepartsnew.service.GenericService;

/**
 *
 * @author Marko HP
 */
public class LocationServiceImpl implements GenericService<Location, Users, String, Sort> {
    
    private LocationRepositoryImpl locationRepository;

    public LocationServiceImpl() {
        locationRepository =  new LocationRepositoryImpl();
    }   
    

    @Override
    public List<Location> getAll(Sort sort) throws Exception {
       return locationRepository.getAll(sort.site_code);
    }   
    

    @Override
    public void add(Location location, Users user) throws Exception {
        locationRepository.add(location, user);
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
    return locationRepository.getById(siteCode);
    }

    
    
    
}
