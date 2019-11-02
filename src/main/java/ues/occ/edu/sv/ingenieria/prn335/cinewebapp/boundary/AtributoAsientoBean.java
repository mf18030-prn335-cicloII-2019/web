/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinewebapp.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AbstractFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AsientoFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AtributoAsientoFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.CaracteristicaAsientoFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.AtributoAsiento;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.CaracteristicaAsiento;

/**
 *
 * @author melvin
 */
@Named(value = "atributoAsientoBean")
@ViewScoped
public class AtributoAsientoBean extends BackingBean<AtributoAsiento> implements Serializable{
    public AtributoAsientoBean() {
    }
    @Inject
    private AtributoAsientoFacade atributoAsientoFacade;
    @Inject 
    private AsientoFacade asientoFacade;
    @Inject
    private CaracteristicaAsientoFacade caracteristicaAsientoFacade;
    private List<CaracteristicaAsiento> caracteristicaAsientoList;
    String formularioTab;
    
    @PostConstruct
    @Override
    public void iniciar(){
        iniciarRelaciones();
        formularioTab = "oculto";
        super.iniciar();
    }
    
    public void iniciarRelaciones(){
        caracteristicaAsientoList = new ArrayList<>();
        if(caracteristicaAsientoFacade != null){
            caracteristicaAsientoList = caracteristicaAsientoFacade.findAll();
        }else{
            caracteristicaAsientoList = Collections.EMPTY_LIST;
        }        
    }

    @Override
    public Object clavePorDatos(AtributoAsiento object) {
        if(object != null){
            return object.getAtributoAsientoPK();
        }
        return null;
    }

    @Override
    public AtributoAsiento datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            String buscar = rowKey;
            for (AtributoAsiento a : this.List) {
                if (a.getAtributoAsientoPK().toString().equals(buscar)) {
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    protected AbstractFacade<AtributoAsiento> getFacade() {
        return atributoAsientoFacade;
    }
    
    @Override
    public AtributoAsiento getRegistro(){
        if(registro == null){
            registro = new AtributoAsiento();
        }        
        return super.getRegistro();
    }
    
    @Override
    public LazyDataModel<AtributoAsiento> getModelo(){
        return super.getModelo();
    }
    
    @Override
    public void onRowSelect(SelectEvent event){
        registro = (AtributoAsiento) event.getObject();
        formularioTab = "activo";
    }

    public List<CaracteristicaAsiento> getCaracteristicaAsientoList() {
        return caracteristicaAsientoList;
    }

    public void setCaracteristicaAsientoList(List<CaracteristicaAsiento> caracteristicaAsientoList) {
        this.caracteristicaAsientoList = caracteristicaAsientoList;
    }

    public String getFormularioTab() {
        return formularioTab;
    }

    public void setFormularioTab(String formularioTab) {
        this.formularioTab = formularioTab;
    }
    
}
