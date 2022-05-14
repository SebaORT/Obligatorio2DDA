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
public class Cliente {
    static private int id = 1;
    private String nombre;
    private String email;
    private String tipo;

    private void validaTipo(String tipo){
        
    }

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", email=" + email + ", tipo=" + tipo + '}';
    }
    
    
    
    
    
}

