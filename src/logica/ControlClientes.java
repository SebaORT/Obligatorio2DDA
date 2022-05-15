/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControlClientes {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public void agregarCliente(String nombre,String email){
        Cliente c = new Cliente(nombre,email);
        clientes.add(c);
    }
}
