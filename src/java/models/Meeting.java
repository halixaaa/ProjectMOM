/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bella
 */
@Entity
@Table(name = "MEETING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meeting.findAll", query = "SELECT m FROM Meeting m")
    , @NamedQuery(name = "Meeting.findById", query = "SELECT m FROM Meeting m WHERE m.id = :id")
    , @NamedQuery(name = "Meeting.findByName", query = "SELECT m FROM Meeting m WHERE m.name = :name")
    , @NamedQuery(name = "Meeting.findByProject", query = "SELECT m FROM Meeting m WHERE m.project = :project")
    , @NamedQuery(name = "Meeting.findByDates", query = "SELECT m FROM Meeting m WHERE m.dates = :dates")
    , @NamedQuery(name = "Meeting.findByTime", query = "SELECT m FROM Meeting m WHERE m.time = :time")
    , @NamedQuery(name = "Meeting.findByChairedby", query = "SELECT m FROM Meeting m WHERE m.chairedby = :chairedby")
    , @NamedQuery(name = "Meeting.findByType", query = "SELECT m FROM Meeting m WHERE m.type = :type")})
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "DATES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dates;
    @Column(name = "TIME")
    private String time;
    @Column(name = "CHAIREDBY")
    private String chairedby;
    @Column(name = "TYPE")
    private String type;
    @ManyToMany(mappedBy = "meetingList", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Mom> momList;

    public Meeting() {
    }

    public Meeting(BigDecimal id) {
        this.id = id;
    }

    public Meeting(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public Meeting(BigDecimal id, String name, String project, Date dates, String time, String chairedby, String type, Customer customer) {
        this.id=id;
        this.name=name;
        this.project=project;
        this.dates=dates;
        this.time=time;
        this.chairedby=chairedby;
        this.type=type;
        this.customer=customer;
    }

    public Meeting(String meeting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChairedby() {
        return chairedby;
    }

    public void setChairedby(String chairedby) {
        this.chairedby = chairedby;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @XmlTransient
    public List<Mom> getMomList() {
        return momList;
    }

    public void setMomList(List<Mom> momList) {
        this.momList = momList;
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
        if (!(object instanceof Meeting)) {
            return false;
        }
        Meeting other = (Meeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Meeting[ id=" + id + " ]";
    }
    
}
