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
    private ArrayList<String> tipos = new ArrayList<String>();
    
    public void agregarCliente(Cliente c){
        clientes.add(c);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
}
