/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.grh;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "typeabsence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeabsence.findAll", query = "SELECT t FROM Typeabsence t")
    , @NamedQuery(name = "Typeabsence.findById", query = "SELECT t FROM Typeabsence t WHERE t.id = :id")
    , @NamedQuery(name = "Typeabsence.findByCode", query = "SELECT t FROM Typeabsence t WHERE t.code = :code")
    , @NamedQuery(name = "Typeabsence.findByLibelle", query = "SELECT t FROM Typeabsence t WHERE t.libelle = :libelle")})
public class Typeabsence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeAbsence")
    private List<Absencetypeemploye> absencetypeemployeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeAbsence")
    private List<Absence> absenceList;

    public Typeabsence() {
    }

    public Typeabsence(Integer id) {
        this.id = id;
    }

    public Typeabsence(Integer id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Absencetypeemploye> getAbsencetypeemployeList() {
        return absencetypeemployeList;
    }

    public void setAbsencetypeemployeList(List<Absencetypeemploye> absencetypeemployeList) {
        this.absencetypeemployeList = absencetypeemployeList;
    }

    @XmlTransient
    public List<Absence> getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(List<Absence> absenceList) {
        this.absenceList = absenceList;
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
        if (!(object instanceof Typeabsence)) {
            return false;
        }
        Typeabsence other = (Typeabsence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.grh.Typeabsence[ id=" + id + " ]";
    }
    
}