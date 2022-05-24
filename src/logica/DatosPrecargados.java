/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.modelo.Mozo;
import logica.modelo.Gestor;
import logica.modelo.Mesa;
import logica.modelo.Producto;

/**
 *
 * @author santi
 */
public class DatosPrecargados {
    
    public static void cargar(){
        
        Fachada logica = Fachada.getInstancia();
        
        ProcesadoraPedidos cocina = new ProcesadoraPedidos("cocina");
        ProcesadoraPedidos bar = new ProcesadoraPedidos("bar");
        
        logica.agregarProcesadora(cocina);
        logica.agregarProcesadora(bar);
        
        Cliente juan = new Cliente("Juan", "juan@gmail.com");
        Cliente ana = new Cliente("ana","ana@gmail.com");
        Cliente mario = new Cliente("mario","Mario@gmail.com");
        
        logica.agregarCliente(juan);
        logica.agregarCliente(ana);
        logica.agregarCliente(mario);
        
        Mozo pablo = new Mozo("mozo", "123", "pablo castro", 12345678);
        Mozo anna = new Mozo("ann", "5678", "anna paula", 56781234); 
        Mozo matias = new Mozo("mat", "9090", "matias ramon", 13572468);      
        
        logica.agregarMozo(pablo);
        logica.agregarMozo(anna);
        logica.agregarMozo(matias);
        
        Gestor alicia = new Gestor("gestor", "123", "alicia juarez");
        Gestor antonio = new Gestor("ant", "4321", "antonio rodriguez");
        Gestor florencia = new Gestor("flor", "4321", "florencia martines");
        
        logica.agregarGestor(alicia);
        logica.agregarGestor(antonio);
        logica.agregarGestor(florencia);
        
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);
        Mesa mesa5 = new Mesa(5);
        Mesa mesa6 = new Mesa(6);
        Mesa mesa7 = new Mesa(7);
        Mesa mesa8 = new Mesa(8);
        Mesa mesa9 = new Mesa(9);
        
        logica.agregarMesa(mesa1);
        logica.agregarMesa(mesa2);
        logica.agregarMesa(mesa3);
        logica.agregarMesa(mesa4);
        logica.agregarMesa(mesa5);
        logica.agregarMesa(mesa6);
        logica.agregarMesa(mesa7);
        logica.agregarMesa(mesa8);
        logica.agregarMesa(mesa9);
        
        
        Producto hamburguesa = new Producto(1111, "hamburguesa", 340, 25, cocina);
        Producto pizzeta = new Producto(2222, "pizzeta", 280, 40, cocina);
        Producto ensalada = new Producto(3333, "ensalada", 240, 30, cocina);
        Producto espagueti = new Producto(4444, "espagueti", 300, 32, cocina);
        Producto whiskey = new Producto(5555, "whiskey", 100, 15, bar);
        Producto vodka = new Producto(6666, "vodka", 130, 17, bar);
        Producto martini = new Producto(7777, "martini", 120, 14, bar);
        
        logica.agregarProducto(hamburguesa);
        logica.agregarProducto(pizzeta);
        logica.agregarProducto(ensalada);
        logica.agregarProducto(espagueti);
        logica.agregarProducto(whiskey);
        logica.agregarProducto(vodka);
        logica.agregarProducto(martini);
        
        
    }
    
}
