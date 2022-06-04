/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

/**
 *
 * @author Usuario
 */
public class Comun extends TipoCliente {

    @Override
    public float montoAPagarConDescuento(Servicio servicio) {
        float resultado = 0;
        for(Pedido p:servicio.getPedidos()){
            if(p.getProducto().getCodigo()!=Producto.CODIGO_CAFE){
                resultado += p.getMontoPedido();
            }
        }
        
        return resultado;
    }

    @Override
    public String toString() {
        return "Cafe invitacion";
    }
    
    
}
