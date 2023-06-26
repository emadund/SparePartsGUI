/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sparepartsnew.repository;

import java.util.List;

/**
 *
 * @author Marko HP
 */
public interface GenericRepository<T, E, S, Q> {
    List<T> getAll(Q q) throws Exception;
    void edit(T t, E e) throws Exception;
    void delete(T t, E e) throws Exception;
    void add (T t, E e) throws Exception;
    T getById(S s) throws Exception;
    
    
}
