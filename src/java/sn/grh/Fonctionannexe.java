/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.grh;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author fallougalass
 */
@Entity
@Table(name = "fonctionannexe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fonctionannexe.findAll", query = "SELECT f FROM Fonctionannexe f")
    , @NamedQuery(name = "Fonctionannexe.findById", query = "SELECT f FROM Fonctionannexe f WHERE f.id = :id")
    , @NamedQuery(name = "Fonctionannexe.findByLibelle", query = "SELECT f FROM Fonctionannexe f WHERE f.libelle = :libelle")
    , @NamedQuery(name = "Fonctionannexe.findByDuree", query = "SELECT f FROM Fonctionannexe f WHERE f.duree = :duree")})
public class Fonctionannexe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duree")
    private int duree;
    @OneToMany(mappedBy = "fonctionAnnexe")
    private List<Servir> servirList;

    public Fonctionannexe() {
    }

    public Fonctionannexe(Integer id) {
        this.id = id;
    }

    public Fonctionannexe(Integer id, String libelle, int duree) {
        this.id = id;
        this.libelle = libelle;
        this.duree = duree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @XmlTransient
    public List<Servir> getServirList() {
        return servirList;
    }

    public void setServirList(List<Servir> servirList) {
        this.servirList = servirList;
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
        if (!(object instanceof Fonctionannexe)) {
            return false;
        }
        Fonctionannexe other = (Fonctionannexe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.grh.Fonctionannexe[ id=" + id + " ]";
    }
    
}
