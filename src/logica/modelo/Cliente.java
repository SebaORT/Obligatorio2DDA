/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.modelo.TipoCliente;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private int id ;
    private String nombre;
    private String email;
    private String tipo;
    private TipoCliente tipoCliente;

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public Cliente(int id,String nombre, String email,TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.id = id;
    }
    
    

}

