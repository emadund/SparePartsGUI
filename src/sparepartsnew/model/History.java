/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.model;


import java.time.LocalDate;

/**
 *
 * @author Marko HP
 */
public class History {
    private Long idHistory;
    private Modul modul;
    private Users user;
    private Operation operation;
    private LocalDate date;  

    public History() {
    }

    public History(Long idHistory, Modul modul, Users user, Operation operation, LocalDate date) {
        this.idHistory = idHistory;
        this.modul = modul;
        this.user = user;
        this.operation = operation;
        this.date = date;
    }

    public Long getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Long idHistory) {
        this.idHistory = idHistory;
    }

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    

}
