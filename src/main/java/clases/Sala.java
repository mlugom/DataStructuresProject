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
   private Asiento[][] asientos;

    public Sala(int numSala) {
        this.funciones = new Cola<>();
        this.numSala = numSala;
        this.asientos = new Asiento[3][7]; 
        this.horaFuncion = 9;
        for(int i=0;i<asientos.length;i++){
            for(int j=0;j<asientos[i].length;j++){
                asientos[i][j]= new Asiento((char)(i+65),j,true);
            }
        }
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

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
    
    public void addFuncion(Pelicula pelicula, Date fecha){
        if(this.horaFuncion <= 21){
            Funcion funcion = new Funcion(pelicula, fecha, this.horaFuncion, this);
            this.funciones.add(funcion);
        }else{
            System.out.println("Salas no disponibles");
        }
    }
    
    public Funcion despacharFuncion(){
        return funciones.poll();
    }
    
}
