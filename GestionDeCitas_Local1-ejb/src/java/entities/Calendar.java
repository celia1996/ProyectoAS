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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Celia Navarro Pérez
 */
@Entity
@Table(name = "CALENDAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c")
    , @NamedQuery(name = "Calendar.findByCalendarid", query = "SELECT c FROM Calendar c WHERE c.calendarid = :calendarid")
    , @NamedQuery(name = "Calendar.findByUserid", query = "SELECT c FROM Calendar c WHERE c.userid = :userid")
    , @NamedQuery(name = "Calendar.findByAppointmentid", query = "SELECT c FROM Calendar c WHERE c.appointmentid = :appointmentid")
    , @NamedQuery(name = "Calendar.findByPhonenumber", query = "SELECT c FROM Calendar c WHERE c.phonenumber = :phonenumber")
    , @NamedQuery(name = "Calendar.findByPersonalid", query = "SELECT c FROM Calendar c WHERE c.personalid = :personalid")
    , @NamedQuery(name = "Calendar.findByAttendance", query = "SELECT c FROM Calendar c WHERE c.attendance = :attendance")})
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALENDARID")
    private Integer calendarid;
    @Column(name = "USERID")
    private Integer userid;
    @Column(name = "APPOINTMENTID")
    private Integer appointmentid;
    @Column(name = "PHONENUMBER")
    private Integer phonenumber;
    @Column(name = "PERSONALID")
    private Integer personalid;
    @Column(name = "ATTENDANCE")
    private Integer attendance;

    public Calendar() {
    }

    public Calendar(Integer calendarid, Integer userid, Integer appointmentid) {
        this.calendarid = calendarid;
        this.userid = userid;
        this.appointmentid = appointmentid;
    }

    public Calendar(Integer calendarid) {
        this.calendarid = calendarid;
    }

    public Integer getCalendarid() {
        return calendarid;
    }

    public void setCalendarid(Integer calendarid) {
        this.calendarid = calendarid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(Integer appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getPersonalid() {
        return personalid;
    }

    public void setPersonalid(Integer personalid) {
        this.personalid = personalid;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarid != null ? calendarid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.calendarid == null && other.calendarid != null) || (this.calendarid != null && !this.calendarid.equals(other.calendarid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Calendar[ calendarid=" + calendarid + " ]";
    }
    
}
