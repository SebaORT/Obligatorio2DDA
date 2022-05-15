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

    void agregarServicio(ProcesadoraPedidos cocina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void agregarCliente(Cliente juan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void agregarMozo(Mozo pablo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void agregarGestor(Gestor alicia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void agregarMesa(Mesa mesa1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void agregarProducto(Producto hamburguesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
