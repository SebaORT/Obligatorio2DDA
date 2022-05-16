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

    void agregarCliente(Cliente cliente) {
        cc.agregarCliente(cliente);
    }

    public void agregarMesa(Mesa m){
        cm.agregarMesa(m);
    }
    
    public void agregarProcesadora(ProcesadoraPedidos p){
        cs.agregarPorcesadoraPedidos(p);
    }
    
    public void agregarMozo(Mozo m){
        cu.agregarMozo(m);
    }
    
    public void agregarGestor(Gestor g){
        cu.agregarGestor(g);
       }
    
    public void agregarProducto(Producto producto){
        cs.agregarProducto(producto);
    }
    

    
}
