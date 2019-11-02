/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinewebapp.boundary;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AbstractFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.AsientoFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.SalaFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.control.SucursalFacade;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.Asiento;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.Sala;
import ues.occ.edu.sv.ingenieria.prn335.cinewebapp.entity.Sucursal;


/**
 *
 * @author Vladimir
 */
@Named(value = "salabean")
@ViewScoped
public class SalaBean extends BackingBean<Sala> implements Serializable{

    @Inject
    private SalaFacade facadesala;
    @Inject
    private SucursalFacade sucursalfacade;
    private List<Sucursal> sucursallist;
    @Inject
    private AsientoFacade asientofacade;
    private List<Asiento> asientolist;
    
    @PostConstruct
    @Override
    public void iniciar(){
        super.iniciar();
        relaciones();
    }
    
    public void relaciones(){
        if (sucursalfacade != null && asientofacade != null) {
            sucursallist = sucursalfacade.findAll();
            asientolist = asientofacade.findAll();
        }else{
            sucursallist = Collections.EMPTY_LIST;
            asientolist = Collections.EMPTY_LIST;
        }
    }
    
    @Override
    public Object clavePorDatos(Sala objecto) {
        if (objecto != null) {
            return objecto.getIdSala();
        }
        return null;
    }

    @Override
    public Sala datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            Integer buscar = new Integer(rowKey);
            for (Sala s : this.List) {
                if (s.getIdSala().compareTo(buscar) == 0) {
                    return s;
                }
            }
        }
        return null;
    }

    
     @Override
    public Sala getRegistro(){
        if (this.registro == null) {
            this.registro = new Sala();
        }
        return super.getRegistro();
    }
    
    @Override
    public LazyDataModel<Sala> getModelo(){
        return super.getModelo();
    }

    public List<Sucursal> getSucursallist() {
        return sucursallist;
    }

    public List<Asiento> getAsientolist() {
        return asientolist;
    }
    
    
    @Override
    protected AbstractFacade<Sala> getFacade() {
        return facadesala;
    }
    
}
