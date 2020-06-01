/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "APPOINTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
    , @NamedQuery(name = "Appointment.findByAppointmentid", query = "SELECT a FROM Appointment a WHERE a.appointmentid = :appointmentid")
    , @NamedQuery(name = "Appointment.findByDate", query = "SELECT a FROM Appointment a WHERE a.date = :date")
    , @NamedQuery(name = "Appointment.findByTime", query = "SELECT a FROM Appointment a WHERE a.time = :time")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPOINTMENTID")
    private Integer appointmentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DATE")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TIME")
    private String time;
    @JoinColumn(name = "CATEGORYID_FK", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Category categoryidFk;
    @JoinColumn(name = "EMPLOYEEID_FK", referencedColumnName = "EMPLOYEEID")
    @ManyToOne
    private Employee employeeidFk;
    @JoinColumn(name = "LOCATIONID_FK", referencedColumnName = "LOCATIONID")
    @ManyToOne
    private Location locationidFk;
    @JoinColumn(name = "SYSTEMUSERID_FK", referencedColumnName = "USERID")
    @ManyToOne
    private Systemuser systemuseridFk;

    public Appointment() {
    }

    public Appointment(Integer appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Appointment(Integer appointmentid, String date, String time) {
        this.appointmentid = appointmentid;
        this.date = date;
        this.time = time;
    }

    public Integer getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(Integer appointmentid) {
        this.appointmentid = appointmentid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Category getCategoryidFk() {
        return categoryidFk;
    }

    public void setCategoryidFk(Category categoryidFk) {
        this.categoryidFk = categoryidFk;
    }

    public Employee getEmployeeidFk() {
        return employeeidFk;
    }

    public void setEmployeeidFk(Employee employeeidFk) {
        this.employeeidFk = employeeidFk;
    }

    public Location getLocationidFk() {
        return locationidFk;
    }

    public void setLocationidFk(Location locationidFk) {
        this.locationidFk = locationidFk;
    }

    public Systemuser getSystemuseridFk() {
        return systemuseridFk;
    }

    public void setSystemuseridFk(Systemuser systemuseridFk) {
        this.systemuseridFk = systemuseridFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentid != null ? appointmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentid == null && other.appointmentid != null) || (this.appointmentid != null && !this.appointmentid.equals(other.appointmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Appointment[ appointmentid=" + appointmentid + " ]";
    }
    
}
