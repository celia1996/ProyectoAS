/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Celia Navarro Pérez
 */
@Entity
@Table(name = "LOCATIONINFORMATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locationinformation.findAll", query = "SELECT l FROM Locationinformation l")
    , @NamedQuery(name = "Locationinformation.findByEmployeename", query = "SELECT l FROM Locationinformation l WHERE l.employeename = :employeename")
    , @NamedQuery(name = "Locationinformation.findByEmployeeid", query = "SELECT l FROM Locationinformation l WHERE l.employeeid = :employeeid")})
public class Locationinformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "EMPLOYEENAME")
    @Embedded
    @AttributeOverride( name = "employeeName", column = @Column(name = "EMPLOYEENAME"))
    private RoomInformation employeename;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private Integer employeeid;

    public Locationinformation() {
    }

    public Locationinformation(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public RoomInformation getEmployeename() {
        return employeename;
    }

    public void setEmployeename(RoomInformation employeename) {
        this.employeename = employeename;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locationinformation)) {
            return false;
        }
        Locationinformation other = (Locationinformation) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Locationinformation[ employeeid=" + employeeid + " ]";
    }
    
}
