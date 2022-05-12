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
public class Fachada {
    
    private ControlUsuarios cu = new ControlUsuarios();
    private ControlMesas cm = new ControlMesas();
    private ControlClientes cc = new ControlClientes();
    private ControlServicio cs = new ControlServicio();
    
    
    private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    private Fachada() {
    }
    
}
