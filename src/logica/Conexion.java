/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import logica.modelo.Gestor;

/**
 *
 * @author Usuario
 */
class Conexion {
    
    private Gestor gestor;
    private Date fecha = new Date();

    public Conexion(Gestor usuario) {
        this.gestor = usuario;
    }

    public Gestor getUsuario() {
        return gestor;
    }

    public Date getFecha() {
        return fecha;
    }
 
}
