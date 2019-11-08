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
public class DinamicArr<T> {
    private Object[] arreglo;

    public DinamicArr() {
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
    
    
    public void remove(int i){
        for(int j = i; j < this.size()-1; j++){
            this.arreglo[j] = this.arreglo[j+1];
        }
    }
    
    public boolean isEmpty(){
        return this.size()== 0;
    }
}
