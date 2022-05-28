/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.excepciones.LogicException;

/**
 *
 * @author Usuario
 */
public class Transferencia {
    private Mozo mozoOrigen;
    private Mozo mozoDestino;
    private Mesa mesa;

    public Transferencia(Mozo mozoOrigen, Mesa mesa) {
        this.mozoOrigen = mozoOrigen;
        this.mesa = mesa;
    }
    
    public void trasferir(Mozo mosoDestino) throws LogicException{
        this.mozoDestino = mozoDestino;
        mozoOrigen.sacarMesa(this.mesa);
        mozoDestino.agregarMesa(mesa);
        mesa.agregarMozo(mozoDestino);
    }

}
