/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "FOLLOWUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followup.findAll", query = "SELECT f FROM Followup f")
    , @NamedQuery(name = "Followup.findById", query = "SELECT f FROM Followup f WHERE f.id = :id")
    , @NamedQuery(name = "Followup.findByName", query = "SELECT f FROM Followup f WHERE f.name = :name")
    , @NamedQuery(name = "Followup.findByPic", query = "SELECT f FROM Followup f WHERE f.pic = :pic")
    , @NamedQuery(name = "Followup.findByTargetdate", query = "SELECT f FROM Followup f WHERE f.targetdate = :targetdate")
    , @NamedQuery(name = "Followup.findByNotes", query = "SELECT f FROM Followup f WHERE f.notes = :notes")})
public class Followup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PIC")
    private String pic;
    @Column(name = "TARGETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date targetdate;
    @Column(name = "NOTES")
    private String notes;
    @JoinColumn(name = "MOM", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mom mom;

    public Followup() {
    }

    public Followup(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getTargetdate() {
        return targetdate;
    }

    public void setTargetdate(Date targetdate) {
        this.targetdate = targetdate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Mom getMom() {
        return mom;
    }

    public void setMom(Mom mom) {
        this.mom = mom;
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
        if (!(object instanceof Followup)) {
            return false;
        }
        Followup other = (Followup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Followup[ id=" + id + " ]";
    }
    
}
