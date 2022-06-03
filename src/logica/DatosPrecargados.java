/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.modelo.ProcesadoraPedidos;
import logica.modelo.Cliente;
import logica.excepciones.LogicException;
import logica.modelo.Comun;
import logica.modelo.DeLaCasa;
import logica.modelo.Mozo;
import logica.modelo.Gestor;
import logica.modelo.Mesa;
import logica.modelo.Preferencial;
import logica.modelo.Producto;

/**
 *
 * @author santi
 */
public class DatosPrecargados {

        public static void cargar() throws LogicException {

                Fachada logica = Fachada.getInstancia();

                ProcesadoraPedidos cocina = new ProcesadoraPedidos("cocina");
                ProcesadoraPedidos bar = new ProcesadoraPedidos("bar");

                logica.agregarProcesadora(cocina);
                logica.agregarProcesadora(bar);

                Producto hamburguesa = new Producto(1111, "hamburguesa", 340, 25, cocina);
                Producto pizzeta = new Producto(2222, "pizzeta", 280, 40, cocina);
                Producto ensalada = new Producto(3333, "ensalada", 240, 30, cocina);
                Producto espagueti = new Producto(4444, "espagueti", 300, 32, cocina);
                Producto whiskey = new Producto(5555, "whiskey", 100, 15, bar);
                Producto vodka = new Producto(6666, "vodka", 130, 17, bar);
                Producto martini = new Producto(7777, "martini", 120, 14, bar);
                Producto cafe = new Producto(8888, "cafe", 80, 1000, bar);
                Producto aguaMineral = new Producto(9999, "agua mineral", 90, 1000, bar);

                logica.agregarProducto(hamburguesa);
                logica.agregarProducto(pizzeta);
                logica.agregarProducto(ensalada);
                logica.agregarProducto(espagueti);
                logica.agregarProducto(whiskey);
                logica.agregarProducto(vodka);
                logica.agregarProducto(martini);
                logica.agregarProducto(cafe);
                logica.agregarProducto(aguaMineral);
                
                Comun comun = new Comun();
                DeLaCasa deLaCasa = new DeLaCasa();
                Preferencial preferecnial = new Preferencial();

                Cliente juan = new Cliente(1,"Juan", "juan@gmail.com",comun);
                Cliente ana = new Cliente(2,"ana", "ana@gmail.com",deLaCasa);
                Cliente mario = new Cliente(3,"mario", "Mario@gmail.com",preferecnial);

                logica.agregarCliente(juan);
                logica.agregarCliente(ana);
                logica.agregarCliente(mario);

                Mozo mozo1 = new Mozo("mozo", "123", "pablo castro", 12345678);
                Mozo mozo2 = new Mozo("anna", "123", "anna paula", 56781234);
                Mozo mozo3 = new Mozo("mat", "123", "matias ramon", 13572468);

                logica.agregarMozo(mozo1);
                logica.agregarMozo(mozo2);
                logica.agregarMozo(mozo3);

                Gestor gestor1 = new Gestor("gestor", "123", "alicia juarez");
                Gestor gestor2 = new Gestor("ant", "123", "antonio rodriguez");
                Gestor gestor3 = new Gestor("flor", "123", "florencia martines");

                logica.agregarGestor(gestor1);
                logica.agregarGestor(gestor2);
                logica.agregarGestor(gestor3);

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

                mozo1.agregarMesa(mesa1);
                mozo1.agregarMesa(mesa2);
                mozo1.agregarMesa(mesa3);
                mozo2.agregarMesa(mesa4);
                mozo2.agregarMesa(mesa5);
                mozo2.agregarMesa(mesa6);
                mozo3.agregarMesa(mesa7);
                mozo3.agregarMesa(mesa8);
                mozo3.agregarMesa(mesa9);

                mesa1.abrirMesa();
                mesa1.getServicio().crearPedido(hamburguesa, 2, "cocidas");
                mesa4.abrirMesa();
                //mesa4.getServicio().crearPedido(vodka, 2, "con hielo");

                // prueba
                // mesa1.agregarCliente(ana);------------------------------------------------
                //mesa1.abrirMesa();

                //mozo1.agregarMesa(mesa1);
                //mozo1.agregarMesa(mesa2);

        }

}
