/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Fachada;
import logica.excepciones.LogicException;
import logica.modelo.Cliente;
import logica.modelo.Mesa;
import logica.modelo.Mozo;
import logica.modelo.Pedido;
import logica.modelo.Producto;
import logica.modelo.Servicio;
import logica.modelo.Transferencia;
import logica.observador.Observable;
import logica.observador.Observador;
import mvc.IVistaAtencionMesa;

/**
 *
 * @author santi
 */
public class ControladorAtencionMesa implements Observador {

    private Mozo mozo;
    private IVistaAtencionMesa vista;

    public ControladorAtencionMesa(Mozo mozo, IVistaAtencionMesa vista) {
        this.mozo = mozo;
        this.vista = vista;
        inicializarVista();

        mozo.agregarObservador(this);

        Fachada.getInstancia().agregarObservador(this);

    }

    @Override
    public void actualizar(Object evento, Observable origen) {

        if (evento.equals(Mozo.eventos.pedidoPronto)) {
            Pedido pedido = mozo.getUltimoPedidoCambioEstado();
            vista.mostrarInfoPedidoListo(pedido);
        }
        
        //si un producto se queda sin stock la fachada avisa
        if (evento.equals(Mozo.eventos.actualizarProductos)) {
            vista.updateListaProductos(Fachada.getInstancia().getProductosConStock());
        }
        if (evento.equals(Mozo.eventos.actualizarServicio)) {
            Servicio servicio = mozo.getUltimoPedidoCambioEstado().getServicio();
            vista.updateServicioActual(servicio.getPedidosMesa());
            // hay sabes en que mesa se esta el usuario para sabes si actulizar el servicio o no
        }

        if (evento.equals(Mozo.eventos.transferenciaSolicitada)) {
            vista.solicitacionTransferencia(mozo.getTransferencia());
        }

        if (evento.equals(Mozo.eventos.transferenciaAceptada)) {
            vista.mostrarMensaje("Transferencia Aceptada!!");
            vista.initMesasUI(mozo.getMesas());
        }

        if (evento.equals(Mozo.eventos.transferenciaDenegada)) {
            vista.mostrarMensaje("Transferencia Rechazada!!");
        }

    }

    public void realizarTransferencia() {
        try {
            mozo.getTransferencia().trasferir();
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void avisarTransferenciaDenegada() {
        mozo.getTransferencia().avisarMozoOrigenDenegada();

    }

    private void inicializarVista() {

        ArrayList<Pedido> servicioActual = new ArrayList<>();
        vista.updateServicioActual(servicioActual);

        ArrayList<Mesa> mesasMozo = mozo.getMesas();
        vista.initMesasUI(mesasMozo);
        vista.updateListaProductos(Fachada.getInstancia().getProductosConStock());
        vista.initLabels(mozo);
    }

    public void AbrirMesa(Mesa m) {
        if (m != null) {
            try {
                m.abrirMesa();
                vista.setMesaAbierta(m);

            } catch (LogicException ex) {
                vista.mostrarExceptionError(ex);
            }
        }
        else {
             vista.mostrarAlerta("Seleccione una mesa");
        }
    }

    public void CerrarMesa(Mesa m) {
        try {
            m.cerrarMesa();
            vista.cerrarDialogoCerrarMesa();
            vista.setMesaCerrada(m);
            vista.updateServicioActual(m.getServicio().getPedidos());
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void UpdateServicioActual(Mesa m) {
        if (m.isAbierta()) {
            updateServicioActualMesa(m);
        } else {
            vista.updateServicioActual(new ArrayList<>());
        }
    }

    private void updateServicioActualMesa(Mesa m) {
        vista.updateServicioActual(m.getServicio().getPedidos());
    }

    public void agregarProductoAlServicio(Mesa m, Producto prod, int cantidad, String description) {
        try {
            if (m != null) {
                m.getServicio().crearPedido(prod, cantidad, description);
                updateServicioActualMesa(m);
                vista.mostrarMensaje("Producto agregado al servicio correctamente.");
            } else {
                vista.mostrarMensaje("Seleccione una mesa!");
            }
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void logout() {
        try {
            Fachada.getInstancia().logoutMozo(mozo);
            vista.cerrar();
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void calcularMontoServicio(Mesa mesaActual) {
        int montoServicio = mesaActual.getServicio().calcularServicio();
        vista.mostrarMontoServicio(montoServicio);
    }
    
    public void cargarDatosCliente(int idCliente,Mesa mesa){
        Cliente cliente = Fachada.getInstancia().getCliente(idCliente);
        try{
            mesa.getServicio().agregarCliente(cliente);
            String nombreCliente = cliente.getNombre();
            String beneficio = cliente.getTipoCliente().toString();
            float descuento = cliente.getTipoCliente().descuentoAplicado(mesa.getServicio());
            float montoPagar = cliente.getTipoCliente().montoAPagarConDescuento(mesa.getServicio());
            vista.cargarDatosCliente(nombreCliente,beneficio,descuento,montoPagar);
        } 
        catch (LogicException ex) {
                vista.cerraMesaMostrarMensaje(ex);
        }
    }
}
    


