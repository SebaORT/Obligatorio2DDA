/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.ProcesadoraPedidos;

/**
 *
 * @author Usuario
 */
public class Producto {
    private int codigo;
    private String nombre;
    private int precio;
    private int stock;
    private ProcesadoraPedidos unidadProcesadora;

    public Producto(int codigo, String nombre, int precio, int stock, ProcesadoraPedidos unidadProcesadora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.unidadProcesadora = unidadProcesadora;
    }

    public int getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio;
    }


    public boolean actulizarStock(int unidades){
        if(stock >= unidades){
            stock=-unidades;
            return true;
        }
        else return false;
    }
        
}
