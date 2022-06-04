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
public class Preferencial extends TipoCliente{

    @Override
    public float montoAPagarConDescuento(Servicio servicio) {
        float resultado = 0;
        for(Pedido p:servicio.getPedidos()){
            if(p.getProducto().getCodigo()!=Producto.CODIGO_AGUA_MINERAL){
                resultado += p.getMontoPedido();
            }
        }
        if(resultado>2000){
            resultado = (float) (resultado - resultado*0.05);
        }
        
        return resultado;
    }
    
    @Override
    public String toString() {
        return "Agua Mineral invitacion mas 5% en compras mayor a 2000";
    }
}
