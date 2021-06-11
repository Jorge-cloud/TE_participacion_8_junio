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
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findByIdSocio", query = "SELECT s FROM Socio s WHERE s.idSocio = :idSocio"),
    @NamedQuery(name = "Socio.findByNombreCompleto", query = "SELECT s FROM Socio s WHERE s.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Socio.findByDireccion", query = "SELECT s FROM Socio s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Socio.findByCorreo", query = "SELECT s FROM Socio s WHERE s.correo = :correo"),
    @NamedQuery(name = "Socio.findByTelefono", query = "SELECT s FROM Socio s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Socio.findByFoto", query = "SELECT s FROM Socio s WHERE s.foto = :foto")})
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSocio")
    private Integer idSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NombreCompleto")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 25)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Foto")
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSocio")
    private Collection<Prestamo> prestamoCollection;

    public Socio() {
    }

    public Socio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Socio(Integer idSocio, String nombreCompleto, String direccion, String telefono, String foto) {
        this.idSocio = idSocio;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.foto = foto;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSocio != null ? idSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Socio[ idSocio=" + idSocio + " ]";
    }
    
}
