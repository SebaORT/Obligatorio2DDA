/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;

    public Usuario(String nombreUsuario, String password, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }
    
}
