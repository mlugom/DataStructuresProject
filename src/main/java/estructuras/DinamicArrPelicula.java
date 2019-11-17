/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import clases.Pelicula;
import java.lang.reflect.Array;

/**
 *
 * @author manuel
 */
public class DinamicArrPelicula {
    private Pelicula[] arreglo;

    public DinamicArrPelicula() {
        this.arreglo = new Pelicula[2];
    }

    public Pelicula[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Pelicula[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public int size(){
        int i = 0;
        while(this.arreglo[i] != null){
            i++;
        }
        return i;
    }
    
    private boolean full(){
        return this.size() == this.arreglo.length-1;
    }
    
    public void add(Pelicula cosa){
        if(!this.full()){
            this.arreglo[this.size()] = cosa;
        }else{
            Pelicula[] arrAux = new Pelicula[this.arreglo.length*2];
            for (int i = 0; i < this.size(); i++) {
                arrAux[i] = this.arreglo[i];
            }
            this.arreglo = arrAux;
            arrAux = null;
            this.arreglo[this.size()] = cosa;
        }
    }
    
    public Pelicula get(int i){
        return this.arreglo[i];
    }
    
    public void set(Pelicula element, int i){
        this.arreglo[i] = element;
    }
    
    public void sort(){
        for (int i = 0; i < this.size()-1; i++) {
            for(int j = 0; j < this.size()-1; j++){
                if(this.get(j).getPuntuacion() > this.get(j+1).getPuntuacion()){
                    Pelicula aux = this.get(j);
                    this.arreglo[j] = this.get(j+1);
                    this.arreglo[j+1] = aux;
                }
            }
        }
    }
    
    public void remove(int i){
        for(int j = i; j < this.size()-1; j++){
            this.arreglo[j] = this.arreglo[j+1];
        }
    }
}
