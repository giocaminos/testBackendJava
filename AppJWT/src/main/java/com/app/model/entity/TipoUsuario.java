package com.app.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author Gio
 */
@Entity
@Table(name = "tipo_usuario")
@XmlRootElement
public class TipoUsuario implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    @Size(max = 2147483647)
	    @Column(name = "nombre")
	    private String nombre;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoUsuario")
	    @JsonBackReference
	    private List<Usuario> usuarioList;
	    
	    public TipoUsuario() {
	    }

	    public TipoUsuario(Integer id) {
	        this.id = id;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    @XmlTransient
	    public List<Usuario> getUsuarioList() {
	        return usuarioList;
	    }

	    public void setUsuarioList(List<Usuario> usuarioList) {
	        this.usuarioList = usuarioList;
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
	        if (!(object instanceof TipoUsuario)) {
	            return false;
	        }
	        TipoUsuario other = (TipoUsuario) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.mycompany.mavenproject1.TipoUsuario[ id=" + id + " ]";
	    }
	    
	}
