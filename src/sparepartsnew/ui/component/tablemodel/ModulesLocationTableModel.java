/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.ui.component.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sparepartsnew.model.Location;
import sparepartsnew.model.Modul;
import sparepartsnew.service.impl.LocationServiceImpl;
import sparepartsnew.service.impl.ModulServiceImpl;

/**
 *
 * @author Marko HP
 */
public class ModulesLocationTableModel extends AbstractTableModel {
    private List<Modul> modules;
    Location location;

    public ModulesLocationTableModel(Location location) {
        this.location=location;
        prepare(location);
    }

    @Override
    public int getRowCount() {
        if (modules==null) return 0;
        return modules.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Modul modul = modules.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return modul.getLocation().toString();
            case 1:
                return modul.getName();
            case 2:
                return modul.getSn();
            case 3:
                return modul.getPn();
            case 4:
                return String.valueOf(modul.getMm());
            case 5:
                return modul.getType().toString();            
            case 6:
                return modul.getStatus().toString();                    
                
        }
        return "n/a";        
    }
     @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "location";
            case 1:
                return "name";
            case 2:
                return "S/N";
            case 3:
                return "P/N";
            case 4:
                return "MM";
            case 5:
                return "type";
            case 6:
                return "status";           
            default:
                break;
        }
        return "n/a";
    }

    private void prepare(Location location) {
        ModulServiceImpl module = new ModulServiceImpl();
        LocationServiceImpl locationRepo = new LocationServiceImpl();      
               
        try {
            modules = module.viewByLocation(location);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There has been an error: "+e.getMessage());
        }
        
    }
    
}
