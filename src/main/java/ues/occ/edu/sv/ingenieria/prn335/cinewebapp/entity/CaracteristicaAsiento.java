/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author melvin
 */
@Entity
@Table(name = "caracteristica_asiento", catalog = "cine", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracteristicaAsiento.findAll", query = "SELECT c FROM CaracteristicaAsiento c"),
    @NamedQuery(name = "CaracteristicaAsiento.findByIdCaracteristica", query = "SELECT c FROM CaracteristicaAsiento c WHERE c.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "CaracteristicaAsiento.findIdByNombre", query = "SELECT c.idCaracteristica FROM CaracteristicaAsiento c WHERE c.caracteristica=:nombre"),
    @NamedQuery(name = "CaracteristicaAsiento.findByCaracteristica", query = "SELECT c FROM CaracteristicaAsiento c WHERE c.caracteristica = :caracteristica"),
    @NamedQuery(name = "CaracteristicaAsiento.findByDescripcion", query = "SELECT c FROM CaracteristicaAsiento c WHERE c.descripcion = :descripcion")})
public class CaracteristicaAsiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_caracteristica", nullable = false)
    private Integer idCaracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "caracteristica", nullable = false, length = 200)
    private String caracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicaAsiento")
    private List<AtributoAsiento> atributoAsientoList;

    public CaracteristicaAsiento() {
    }

    public CaracteristicaAsiento(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public CaracteristicaAsiento(Integer idCaracteristica, String caracteristica, String descripcion) {
        this.idCaracteristica = idCaracteristica;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<AtributoAsiento> getAtributoAsientoList() {
        return atributoAsientoList;
    }

    public void setAtributoAsientoList(List<AtributoAsiento> atributoAsientoList) {
        this.atributoAsientoList = atributoAsientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristica != null ? idCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicaAsiento)) {
            return false;
        }
        CaracteristicaAsiento other = (CaracteristicaAsiento) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.CaracteristicaAsiento[ idCaracteristica=" + idCaracteristica + " ]";
    }
    
}
