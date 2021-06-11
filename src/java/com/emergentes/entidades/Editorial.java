/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "editorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e"),
    @NamedQuery(name = "Editorial.findByIdEditorial", query = "SELECT e FROM Editorial e WHERE e.idEditorial = :idEditorial"),
    @NamedQuery(name = "Editorial.findByNombreEditorial", query = "SELECT e FROM Editorial e WHERE e.nombreEditorial = :nombreEditorial"),
    @NamedQuery(name = "Editorial.findByDireccion", query = "SELECT e FROM Editorial e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Editorial.findByTelefono", query = "SELECT e FROM Editorial e WHERE e.telefono = :telefono")})
public class Editorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEditorial")
    private Integer idEditorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NombreEditorial")
    private String nombreEditorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEditorial")
    private Collection<Libro> libroCollection;

    public Editorial() {
    }

    public Editorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Editorial(Integer idEditorial, String nombreEditorial, String direccion, String telefono) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditorial != null ? idEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.idEditorial == null && other.idEditorial != null) || (this.idEditorial != null && !this.idEditorial.equals(other.idEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Editorial[ idEditorial=" + idEditorial + " ]";
    }
    
}
