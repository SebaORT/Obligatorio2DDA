/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import mvc.vista.VistaProcesadoraPedidos;
import java.util.ArrayList;
import logica.excepciones.LogicException;
import logica.modelo.Mozo;
import logica.modelo.Cliente;
import logica.modelo.Gestor;
import logica.modelo.Mesa;
import logica.modelo.Producto;
import logica.observador.Observador;

/**
 *
 * @author Usuario
 */
public class Fachada {

    private ControlUsuarios controlUsuario = new ControlUsuarios();
    private ControlMesas controlMesas = new ControlMesas();
    private ControlClientes controlClientes = new ControlClientes();
    private ControlServicio controlServicio = new ControlServicio();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    void agregarCliente(Cliente cliente) {
        controlClientes.agregarCliente(cliente);
    }

    public void agregarMesa(Mesa m) {
        controlMesas.agregarMesa(m);
    }

    public void agregarProcesadora(ProcesadoraPedidos p) {
        controlServicio.agregarPorcesadoraPedidos(p);
    }

    public void agregarMozo(Mozo m) {
        controlUsuario.agregarMozo(m);
    }

    public void agregarGestor(Gestor g) {
        controlUsuario.agregarGestor(g);
    }

    public void agregarProducto(Producto producto) {
        controlServicio.agregarProducto(producto);
    }

    public Mozo loginMozo(String u, String p) throws LogicException {
        return controlUsuario.loginMozo(u, p);
    }

    public Gestor loginGestor(String u, String p) throws LogicException {
        return controlUsuario.loginGestor(u, p);
    }

    public ArrayList<ProcesadoraPedidos> getProcesadoras() {
        return controlServicio.getProcesadoras();
    }

    public ArrayList<Producto> getProductosConStock() {
        return controlServicio.getProductosConStock();
    }

    public void logoutMozo(Mozo mozo) throws LogicException {
        controlUsuario.logoutMozo(mozo);
    }

}
