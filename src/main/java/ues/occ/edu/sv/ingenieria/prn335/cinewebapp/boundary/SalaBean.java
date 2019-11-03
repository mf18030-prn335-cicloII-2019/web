/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cinewebapp.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
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

    public SalaBean(){
        
    }
    @Inject
    private SalaFacade facadesala;
    @Inject
    private SucursalFacade sucursalfacade;
    private List<Sucursal> sucursallist;
    @Inject
    private AsientoFacade asientofacade;
    private List<Asiento> asientolist;
    
    List<String> sala;
    protected String nome;
    protected int sucursal;
    
    @PostConstruct
    @Override
    public void iniciar(){
         relaciones();
        super.iniciar();
    }
    
    public void relaciones(){
        sala = new ArrayList();
        sucursallist = sucursalfacade.findAll();
            for (int item = 0; item <sucursallist.size(); item++) {
            sala.add(sucursallist.get(item).getNombre());
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
    
    @Override
    public void onRowSelect(SelectEvent event) {
        super.onRowSelect(event);
        this.nome = ((Sala) event.getObject()).getIdSucursal().getNombre();
    }
    
    
    @Override
    public void btnAgregarHandler(ActionEvent ae) {
        construir();
        getFacade().create(registro);
        sala.clear();
        sucursallist.clear();
        iniciar();
        this.acciones = Estado.NADA;
    }

    public void construir(){
        this.sucursal = sucursalfacade.sucursalNome(this.nome);
        registro.setIdSucursal(sucursalfacade.find(this.sucursal));
    } 
    
    @Override
    public void btnEditarHandler(ActionEvent ae) {
        construir();
        getFacade().edit(registro);
        sala.clear();
        sucursallist.clear();
        iniciar();
        this.acciones = Estado.NADA;
    }

    @Override
    public void btnCancelarHandler(ActionEvent ae) {
        sala.clear();
        sucursallist.clear();
        super.btnCancelarHandler(ae); 
    }

    public List<String> getSala() {
        return sala;
    }

    public void setSala(List<String> sala) {
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
