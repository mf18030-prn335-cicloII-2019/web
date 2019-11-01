/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author melvin
 */
@Entity
@Table(name = "atributo_asiento", catalog = "cine", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtributoAsiento.findAll", query = "SELECT a FROM AtributoAsiento a"),
    @NamedQuery(name = "AtributoAsiento.findByIdCaracteristica", query = "SELECT a FROM AtributoAsiento a WHERE a.atributoAsientoPK.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "AtributoAsiento.findByIdAsiento", query = "SELECT a FROM AtributoAsiento a WHERE a.atributoAsientoPK.idAsiento = :idAsiento")})
public class AtributoAsiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtributoAsientoPK atributoAsientoPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "valor", nullable = false, length = 65535)
    private String valor;
    @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asiento asiento;
    @JoinColumn(name = "id_caracteristica", referencedColumnName = "id_caracteristica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaracteristicaAsiento caracteristicaAsiento;

    public AtributoAsiento() {
    }

    public AtributoAsiento(AtributoAsientoPK atributoAsientoPK) {
        this.atributoAsientoPK = atributoAsientoPK;
    }

    public AtributoAsiento(AtributoAsientoPK atributoAsientoPK, String valor) {
        this.atributoAsientoPK = atributoAsientoPK;
        this.valor = valor;
    }

    public AtributoAsiento(int idCaracteristica, int idAsiento) {
        this.atributoAsientoPK = new AtributoAsientoPK(idCaracteristica, idAsiento);
    }

    public AtributoAsientoPK getAtributoAsientoPK() {
        return atributoAsientoPK;
    }

    public void setAtributoAsientoPK(AtributoAsientoPK atributoAsientoPK) {
        this.atributoAsientoPK = atributoAsientoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public CaracteristicaAsiento getCaracteristicaAsiento() {
        return caracteristicaAsiento;
    }

    public void setCaracteristicaAsiento(CaracteristicaAsiento caracteristicaAsiento) {
        this.caracteristicaAsiento = caracteristicaAsiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atributoAsientoPK != null ? atributoAsientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoAsiento)) {
            return false;
        }
        AtributoAsiento other = (AtributoAsiento) object;
        if ((this.atributoAsientoPK == null && other.atributoAsientoPK != null) || (this.atributoAsientoPK != null && !this.atributoAsientoPK.equals(other.atributoAsientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.AtributoAsiento[ atributoAsientoPK=" + atributoAsientoPK + " ]";
    }
    
}
