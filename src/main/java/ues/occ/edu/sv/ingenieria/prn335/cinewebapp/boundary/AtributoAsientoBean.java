/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinewebapp.boundary;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AbstractFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AtributoAsientoFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.Asiento;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.AtributoAsiento;

/**
 *
 * @author Vladimir
 */
@Named(value = "atributoasientobean")
@ViewScoped
public class AtributoAsientoBean extends BackingBean<AtributoAsiento> implements Serializable{

    @Inject
    private AtributoAsientoFacade facadeAtributoAsiento;
    
    @PostConstruct
    @Override
    public void iniciar(){
        super.iniciar();
    }
    
    @Override
    public Object clavePorDatos(AtributoAsiento objecto) {
        if (objecto != null) {
            return objecto.getAsiento().getIdAsiento();
        }
        return null;
    }

    @Override
    public AtributoAsiento datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            Integer buscar = new Integer(rowKey);
            for (AtributoAsiento at : this.List) {
                if (at.getAsiento().getIdAsiento().compareTo(buscar)==0) {
                    return at;
                }
            }
        }
        return null;
    }

     @Override
    public AtributoAsiento getRegistro(){
        if (this.registro == null) {
            this.registro = new AtributoAsiento();
        }
        return super.getRegistro();
    }
    
    @Override
    public LazyDataModel<AtributoAsiento> getModelo(){
        return super.getModelo();
    }

    
    
    @Override
    protected AbstractFacade<AtributoAsiento> getFacade() {
        return  facadeAtributoAsiento;
    }
    
}
