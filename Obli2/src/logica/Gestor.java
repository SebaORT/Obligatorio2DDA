/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Gestor extends Usuario{
    
    private Date fechaUltimoAcceso= new Date(); 

    public Gestor(String nombreUsuario, String password, String nombreCompleto) {
        super(nombreUsuario, password, nombreCompleto);
    }

    public void ultimoAcceso(){
        Date nuevaFecha = new Date();
        setFechaUltimoAcceso(nuevaFecha);
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }
    
    public void validar(){
    }

}


