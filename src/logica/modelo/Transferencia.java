/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.excepciones.LogicException;
import logica.modelo.Mesa;
import logica.modelo.Mozo;

/**
 *
 * @author Usuario
 */
public class Transferencia {
    private Mozo mozoOrigen;
    private Mozo mozoDestino;
    private Mesa mesa;

    public Transferencia(Mozo mozoOrigen, Mesa mesa,Mozo mosoDestino) {
        this.mozoOrigen = mozoOrigen;
        this.mesa = mesa;
        this.mozoDestino = mosoDestino;
        
        this.mozoOrigen.setTransferencia(this);
        this.mozoDestino.setTransferencia(this);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Mozo getMozoDestino() {
        return mozoDestino;
    }

    public Mozo getMozoOrigen() {
        return mozoOrigen;
    }
    
    
    //3
    public void trasferir() throws LogicException{
        mozoOrigen.sacarMesa(mesa);
        mozoDestino.agregarMesa(mesa);
        mesa.agregarMozo(mozoDestino);
        
        avisarMozoOrigenAceptar();
    }

    
    //1
    public void avisarMozoDestino() {
        mozoDestino.avisar(Mozo.eventos.transferenciaSolicitada);
    }
    
    
    //2
    private void avisarMozoOrigenAceptar() {
        mozoOrigen.avisar(Mozo.eventos.transferenciaAceptada);
        mozoDestino.avisar(Mozo.eventos.transferenciaAceptada);

    }
    
    public void avisarMozoOrigenDenegada() {
        mozoOrigen.avisar(Mozo.eventos.transferenciaDenegada);

    }

}
