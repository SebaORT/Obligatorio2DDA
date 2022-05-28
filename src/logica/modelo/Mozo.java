/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.excepciones.LogicException;
import logica.modelo.Usuario;
import java.util.ArrayList;
import logica.excepciones.RestoException;

/**
 *
 * @author Usuario
 */
public class Mozo extends Usuario{

    private int telefono;
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private Transferencia transferencia;

    private final int MAX_MESAS = 5;
    private Pedido ultimoPedidoCambioEstado;

    public Mozo(String nombreUsuario, String password, String nombreCompleto, int telefono) {
        super(nombreUsuario, password, nombreCompleto);
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setServicio(ArrayList<Mesa> servicio) {
        this.mesas = servicio;
    }

    public boolean mesasCerradas() {
        int totMesas = this.mesas.size();
        int mesasCerradas = 0;
        for (Mesa m : mesas) {
            if (!m.isAbierta()) {
                mesasCerradas ++;
            }
        }
        if (mesasCerradas == totMesas) {
            return true;
        } else
            return false;
    }

    public void iniciarTransferencia(Mozo mozoDestino,Mozo mozoOrigen, Mesa mesa){
        transferencia = new Transferencia(mozoOrigen,mesa,mozoDestino);
        mozoDestino.setTransferencia(transferencia);
    }
    
    public void aceptarTransferencia() throws LogicException{
        transferencia.trasferir();
    }
    

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public void validar() {
    }

    public void agregarMesa(Mesa mesa) throws LogicException {
        if (mesas.size() >= MAX_MESAS) {
            throw new LogicException("El mozo ya tiene 5 mesas.");
        } else {
            mesas.add(mesa);
            mesa.setMozo(this);
        }
    }
    
    public enum eventos {pedidoCambioEstado};

    public Pedido getUltimoPedidoCambioEstado() {
        return ultimoPedidoCambioEstado;
    }
    
    
    public void pedidoCambioEstado(Pedido p) {
        this.ultimoPedidoCambioEstado = p;
        
        this.avisar(eventos.pedidoCambioEstado);
    }

    @Override
    public boolean equals(Object o) {
        Mozo m = (Mozo) o;
        return m.getNombreUsuario().equalsIgnoreCase(super.getNombreUsuario());
    }

    public void agregarProductoAlServicio(int indexMesaSeleccionada, Producto producto, int cantidad,
            String descripcion) throws LogicException {
        this.mesas.get(indexMesaSeleccionada).getServicio().crearPedido(producto, cantidad, descripcion);
    }

    public ArrayList<Pedido> obtenerPedidosServicio(int indexMesaSeleccionada) {
        return this.mesas.get(indexMesaSeleccionada).getServicio().getPedidos();

    }

    void sacarMesa(Mesa mesa) {
        mesas.remove(mesa);
    }

}
