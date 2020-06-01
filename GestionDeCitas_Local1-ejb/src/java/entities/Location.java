/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Celia Navarro Pérez
 */
@Entity
@Table(name = "LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLocationid", query = "SELECT l FROM Location l WHERE l.locationid = :locationid")
    , @NamedQuery(name = "Location.findByFloor", query = "SELECT l FROM Location l WHERE l.floor = :floor")
    , @NamedQuery(name = "Location.findByRoom", query = "SELECT l FROM Location l WHERE l.room = :room")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATIONID")
    private Integer locationid;
    @Size(max = 10)
    @Column(name = "FLOOR")
    private String floor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROOM")
    private String room;
    @OneToMany(mappedBy = "locationidFk")
    private Collection<Appointment> appointmentCollection;

    public Location() {
    }

    public Location(Integer locationid) {
        this.locationid = locationid;
    }

    public Location(Integer locationid, String room) {
        this.locationid = locationid;
        this.room = room;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationid != null ? locationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationid == null && other.locationid != null) || (this.locationid != null && !this.locationid.equals(other.locationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Location[ locationid=" + locationid + " ]";
    }
    
}
