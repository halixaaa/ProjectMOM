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
@Table(name = "MOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mom.findAll", query = "SELECT m FROM Mom m")
    , @NamedQuery(name = "Mom.findById", query = "SELECT m FROM Mom m WHERE m.id = :id")
    , @NamedQuery(name = "Mom.findByMeetingdesc", query = "SELECT m FROM Mom m WHERE m.meetingdesc = :meetingdesc")})
public class Mom implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "MEETINGDESC")
    private String meetingdesc;
    @JoinColumn(name = "MEETING", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Meeting meeting;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;
    @OneToMany(mappedBy = "mom", fetch = FetchType.LAZY)
    private List<Followup> followupList;

    public Mom() {
    }

    public Mom(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMeetingdesc() {
        return meetingdesc;
    }

    public void setMeetingdesc(String meetingdesc) {
        this.meetingdesc = meetingdesc;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @XmlTransient
    public List<Followup> getFollowupList() {
        return followupList;
    }

    public void setFollowupList(List<Followup> followupList) {
        this.followupList = followupList;
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
        if (!(object instanceof Mom)) {
            return false;
        }
        Mom other = (Mom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mom[ id=" + id + " ]";
    }
    
}
