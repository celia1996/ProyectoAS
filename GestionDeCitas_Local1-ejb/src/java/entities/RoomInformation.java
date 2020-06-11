/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Celia Navarro Pérez
 */
@Embeddable
public class RoomInformation {
    private String employeeName;

    public RoomInformation() {
    }

    public RoomInformation(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.employeeName);
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
        final RoomInformation other = (RoomInformation) obj;
        if (!Objects.equals(this.employeeName, other.employeeName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RoomInformation{" + "employeeName=" + employeeName + '}';
    }
    
    
    
}
