/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.observador.Observable;

/**
 *
 * @author Usuario
 */
public class Usuario extends Observable{
    
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombreUsuario, String password, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }
    
    @Override
    public boolean equals(Object o){
        Usuario u = (Usuario) o;
        return u.getNombreUsuario().equalsIgnoreCase(nombreUsuario);
    }
    
    
    
    
    
}
