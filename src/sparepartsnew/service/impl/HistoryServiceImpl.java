/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.service.impl;

import java.util.List;
import sparepartsnew.model.Sort;
import sparepartsnew.model.History;
import sparepartsnew.model.Users;
import sparepartsnew.repository.impl.HistoryRepositoryImpl;
import sparepartsnew.service.GenericService;

/**
 *
 * @author Marko HP
 */
public class HistoryServiceImpl implements GenericService<History, Users, String, Sort> {
    private HistoryRepositoryImpl historyRepo;

    public HistoryServiceImpl() {
        historyRepo =  new HistoryRepositoryImpl();
    }

    @Override
    public List<History> getAll(Sort sort) throws Exception {
       
        return historyRepo.getAll(sort.id);
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
    public History getById(String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
    
    
}
