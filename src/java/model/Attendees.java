/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "ATTENDEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendees.findAll", query = "SELECT a FROM Attendees a")
    , @NamedQuery(name = "Attendees.findById", query = "SELECT a FROM Attendees a WHERE a.id = :id")})
public class Attendees implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @OneToMany(mappedBy = "attendees", fetch = FetchType.LAZY)
    private List<Meeting> meetingList;
    @JoinColumn(name = "ATTENDID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer attendid;
    @JoinColumn(name = "ATTENDID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee attendid1;

    public Attendees() {
    }

    public Attendees(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @XmlTransient
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    public Customer getAttendid() {
        return attendid;
    }

    public void setAttendid(Customer attendid) {
        this.attendid = attendid;
    }

    public Employee getAttendid1() {
        return attendid1;
    }

    public void setAttendid1(Employee attendid1) {
        this.attendid1 = attendid1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendees)) {
            return false;
        }
        Attendees other = (Attendees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Attendees[ id=" + id + " ]";
    }
    
}
