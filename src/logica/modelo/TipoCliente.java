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
public abstract class TipoCliente {
    
    public abstract float montoAPagarConDescuento(Servicio servicio);

    @Override
    public abstract String toString();

}
