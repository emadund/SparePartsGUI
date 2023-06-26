/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparepartsnew.model;

import java.util.Objects;

/**
 *
 * @author Marko HP
 */
public class Modul {
    private Long id;
    private String name;
    private String sn;
    private String pn;
    private int mm;
    private Type type;
    private Location location;
    private Status status;

    public Modul(Long id, String name, String sn, String pn, int mm, Type type, Location location, Status status) {
        this.id = id;
        this.name = name;
        this.sn = sn;
        this.pn = pn;
        this.mm = mm;
        this.type = type;
        this.location = location;
        this.status = status;
    }

    public Modul() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Modul{" + "id=" + id + ", name=" + name + ", sn=" + sn + ", pn=" + pn + ", mm=" + mm + ", type=" + type + ", location=" + location + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modul other = (Modul) obj;
        if (this.mm != other.mm) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.sn, other.sn)) {
            return false;
        }
        return Objects.equals(this.pn, other.pn);
    }
    

   
    
    
    
}
