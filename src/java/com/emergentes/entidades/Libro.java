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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByNumeroEjemplares", query = "SELECT l FROM Libro l WHERE l.numeroEjemplares = :numeroEjemplares")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLibro")
    private Integer idLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroEjemplares")
    private short numeroEjemplares;
    @JoinColumn(name = "idAutor", referencedColumnName = "idAutor")
    @ManyToOne(optional = false)
    private Autor idAutor;
    @JoinColumn(name = "idEditorial", referencedColumnName = "idEditorial")
    @ManyToOne(optional = false)
    private Editorial idEditorial;
    @JoinColumn(name = "idTema", referencedColumnName = "idTema")
    @ManyToOne(optional = false)
    private Tema idTema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibro")
    private Collection<Prestamo> prestamoCollection;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(Integer idLibro, String isbn, String titulo, short numeroEjemplares) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.numeroEjemplares = numeroEjemplares;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public short getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(short numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Tema getIdTema() {
        return idTema;
    }

    public void setIdTema(Tema idTema) {
        this.idTema = idTema;
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
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entidades.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
