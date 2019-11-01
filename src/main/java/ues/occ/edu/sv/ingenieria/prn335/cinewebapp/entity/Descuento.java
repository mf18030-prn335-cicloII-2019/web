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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author melvin
 */
@Entity
@Table(name = "descuento", catalog = "cine", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d"),
    @NamedQuery(name = "Descuento.findByIdDescuento", query = "SELECT d FROM Descuento d WHERE d.idDescuento = :idDescuento"),
    @NamedQuery(name = "Descuento.findByPorcentaje", query = "SELECT d FROM Descuento d WHERE d.porcentaje = :porcentaje")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descuento", nullable = false)
    private Integer idDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje", nullable = false)
    private double porcentaje;
    @JoinColumn(name = "id_tipo_descuento", referencedColumnName = "id_tipo_descuento", nullable = false)
    @ManyToOne(optional = false)
    private TipoDescuento idTipoDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<Boleto> boletoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<Orden> ordenList;

    public Descuento() {
    }

    public Descuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Descuento(Integer idDescuento, double porcentaje) {
        this.idDescuento = idDescuento;
        this.porcentaje = porcentaje;
    }

    public Integer getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public TipoDescuento getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(TipoDescuento idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    @XmlTransient
    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
    }

    @XmlTransient
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescuento != null ? idDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.idDescuento == null && other.idDescuento != null) || (this.idDescuento != null && !this.idDescuento.equals(other.idDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.Descuento[ idDescuento=" + idDescuento + " ]";
    }
    
}
