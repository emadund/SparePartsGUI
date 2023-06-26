/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.ui.component.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Location;
import sparepartsnew.repository.impl.LocationRepositoryImpl;

/**
 *
 * @author Marko HP
 */
public class LocationsTableModel extends AbstractTableModel {
    private List<Location> locations;
    private Sort sort;

    public LocationsTableModel(Sort sort) {
        this.sort=sort;
        prepare(sort);
    }

    @Override
    public int getRowCount() {
        if (locations==null) return 0;
        return locations.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Location location = locations.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return location.getSiteCode();
            case 1:
                return location.getName();
            case 2:
                return location.getType();
            case 3:
                return location.getAddress();
            case 4:
                return location.getLat();
            case 5:
                return location.getLon();
                              
                
        }
        return "n/a";        
    }
     @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "site code";
            case 1:
                return "name";
            case 2:
                return "type";
            case 3:
                return "address";
            case 4:
                return "lat";
            case 5:
                return "lon";            
            default:
                break;
        }
        return "n/a";
    }

    private void prepare(Sort sort) {
        LocationRepositoryImpl locationRep = new LocationRepositoryImpl();
        
        try {
            locations = locationRep.getAll(sort);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("There has been an error: "+e.getMessage());
        }
        
    }
    
}
