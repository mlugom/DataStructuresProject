/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.lang.reflect.Array;

/**
 *
 * @author manuel
 */
public class DinamicArrInt<T extends Comparable<?super T>> {
    private Object[] arreglo;

    public DinamicArrInt() {
        this.arreglo = new Object[2];
    }

    public Object[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Object[] arreglo) {
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
    
    public void add(Object cosa){
        if(!this.full()){
            this.arreglo[this.size()] = cosa;
        }else{
            Object[] arrAux = new Object[this.arreglo.length*2];
            for (int i = 0; i < this.size(); i++) {
                arrAux[i] = this.arreglo[i];
            }
            this.arreglo = arrAux;
            arrAux = null;
            this.arreglo[this.size()] = cosa;
        }
    }
    
    public T get(int i){
        return (T)this.arreglo[i];
    }
    
    public void sort(){
        for (int i = 0; i < this.size()-1; i++) {
            for(int j = 0; j < this.size()-1; j++){
                if(this.get(j).compareTo(this.get(j+1)) > 0){
                    T aux = this.get(j);
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
