package main;

import IuEscritorio.IuStart;
import logica.DatosPrecargados;


public class Inicio {

     public static void main(String[] args) throws Exception {
        DatosPrecargados.cargar();
        IuStart start =  (new IuStart());
        start.setLocationRelativeTo(null);
        start.setVisible(true);
      } 
}
