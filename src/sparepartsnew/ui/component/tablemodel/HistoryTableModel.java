/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.ui.component.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sparepartsnew.model.Sort;
import sparepartsnew.model.History;
import sparepartsnew.repository.impl.HistoryRepositoryImpl;
import sparepartsnew.service.impl.ModulServiceImpl;

/**
 *
 * @author Marko HP
 */
public class HistoryTableModel extends AbstractTableModel {
    private List<History> histories;
    private ModulServiceImpl modulRepo;
    private Sort sort;

    public HistoryTableModel(Sort sort) {
        this.sort=sort;
        modulRepo = new ModulServiceImpl();
        prepare(sort);
    }

    @Override
    public int getRowCount() {
        if (histories==null) return 0;
        return histories.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        History history = histories.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return history.getIdHistory().toString();
            case 1:
                return String.valueOf(history.getModul().getId());
            case 2:
                return history.getUser().getUsername().toString();
            case 3:
                return String.valueOf(history.getOperation());
            case 4:
                return String.valueOf(history.getDate());
            
                
        }
        return "n/a";        
    }
     @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id history";
            case 1:
                return "id modul";
            case 2:
                return "username";
            case 3:
                return "operation";
            case 4:
                return "date_time";                       
            default:
                break;
        }
        return "n/a";
    }

    private void prepare(Sort sort) {
        HistoryRepositoryImpl historyRepo = new HistoryRepositoryImpl();
        
        try {
            histories = historyRepo.getAll(sort);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There has been an error: "+e.getMessage());
        }
        
    }
    
}
