/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import clases.*;

/**
 *
 * @author manuel
 */
public class HeapDouble {
    private DinamicArrPelicula arreglo;

    public HeapDouble() {
        arreglo = new DinamicArrPelicula();
        arreglo.add(new Pelicula("Está_mal", 0, 0, Double.MIN_VALUE));
    }

    public DinamicArrPelicula getArreglo() {
        return arreglo;
    }

    public void setArreglo(DinamicArrPelicula arreglo) {
        this.arreglo = arreglo;
    }
    
    public int parent(int indice){
        return indice/2;
    }
    
    public int leftChild(int indice){
        return 2*indice;
    }
    
    public int rightChild(int indice){
        return 2*indice+1;
    }
    
    public void siftUp(int i){
        
        boolean condicion = true;
        while(condicion){
            if(i > 1){
                if (arreglo.get(i) != null) {
                    if (this.arreglo.get(parent(i)).getPuntuacion() < this.arreglo.get(i).getPuntuacion()) {
                        Pelicula varaux = arreglo.get(parent(i));
                        arreglo.set(arreglo.get(i), parent(i));
                        arreglo.set(varaux, i);
                        i = parent(i);
                        condicion = true;
                    } else {
                        condicion = false;
                    }
                }
            }else{
                condicion = false;
            }
        }
    }
    
    public void siftDown(int i){
        int maxIndex = i;
        int l = leftChild(i);
        if(l <= size() && arreglo.get(l).getPuntuacion() > arreglo.get(maxIndex).getPuntuacion()){
            maxIndex = l;
        }
        int r = rightChild(i);
        if(r <= size() && arreglo.get(r).getPuntuacion() > arreglo.get(maxIndex).getPuntuacion()){
            maxIndex = r;
        }
        if(i != maxIndex){
            Pelicula varaux = arreglo.get(maxIndex);
            arreglo.set(arreglo.get(i), maxIndex);
            arreglo.set(varaux, i);
            siftDown(maxIndex);
        }
    }
    
    public void insert(Pelicula p){
        arreglo.add(p);
        siftUp(size());
    }
    
    public Pelicula extractMax(){
        Pelicula result = arreglo.get(1);
        arreglo.set(arreglo.get(size()), 1);
        arreglo.remove(size());
        siftDown(1);
        return result;
    }
    
    public void remove(int i){
        arreglo.set(new Pelicula("", 0, 0, Double.MAX_VALUE), i);
        siftUp(i);
        extractMax();
    }
    
    public void changePriority(int i, double p){
        double oldP = arreglo.get(i).getPuntuacion();
        arreglo.get(i).setPuntuacion(p);
        if(p > oldP){
            siftUp(i);
        }else{
            siftDown(i);
        }
    }
    
    public int size(){
        return this.arreglo.size()-1;
    }
    
    public boolean isEmpty(){
        return size() == 0;
    }
    public Pelicula get(int i){
        return arreglo.get(i);              
    }
}
