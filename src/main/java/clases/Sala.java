/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.*;
import estructuras.*;
/**
 *
 * @author Manuel Esteban
 */
public class Sala {
   private int horaFuncion;
   private Cola <Funcion> funciones;
   private int numSala;

    public Sala(int numSala) {
        this.funciones = new Cola<>();
        this.numSala = numSala;
        this.horaFuncion = 9;
    }
    public Cola <Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(Cola<Funcion> funciones) {
        this.funciones = funciones;
    }


    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }
    
    public void addFuncion(Pelicula pelicula, Fecha fecha){
        if(this.horaFuncion <= 21){
            Funcion funcion = new Funcion(pelicula, fecha, this.horaFuncion, this);
            this.funciones.add(funcion);
            this.horaFuncion+=3;            
        }else{
            System.out.println("Salas no disponibles");
        }
    }
    
    public Funcion despacharFuncion(){
        return funciones.poll();
    }
    
    public void vaciarSala(){
        this.funciones = new Cola<>();
    }

    public int getHoraFuncion() {
        return horaFuncion;
    }

    public void setHoraFuncion(int horaFuncion) {
        this.horaFuncion = horaFuncion;
    }
    
    
}
