/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;
import clases.*;

/**
 *
 * @author Estudiante
 */
public class HashTable {
    private int size;
    private int numberOfKeys;
    private ListaEncadenada<Usuario>[] arreglo;
    private int a;
    private int b;
    private int p;

    public HashTable(int size, int p) {
        this.size = size;
        this.numberOfKeys = 0;
        this.arreglo = new ListaEncadenada[size];
        this.a = (int) Math.random()*(p-2) +1;
        this.b = (int) Math.random()*(p-1);
        this.p = p;
    }
    
    public int hashFunction(int dato){
        return ((a*dato+b)%p)%size;
    }
    
    public boolean hasKey(int dato){
        ListaEncadenada<Usuario> lista = arreglo[hashFunction(dato)];
        NodoLista<Usuario> it = lista.getHead().getNext();
        while(it != null){
            if(dato == it.getKey().getDocumento()){
                return true;
            }
            it = it.getNext();
        }
        return false;
    }
    
    public Usuario get(int dato){
        ListaEncadenada<Usuario> lista = arreglo[hashFunction(dato)];
        NodoLista<Usuario> it = lista.getHead().getNext();
        while(it != null){
            if(dato == it.getKey().getDocumento()){
                return it.getKey();
            }
            it = it.getNext();
        }
        return null;
    }
    
    public void insert(Usuario usuario){
        ListaEncadenada<Usuario> lista = arreglo[hashFunction(usuario.getDocumento())];
        lista.pushBack(usuario);
        numberOfKeys++;
    }
    
    public void remove(Usuario dato){
        if(hasKey(dato.getDocumento())){
            ListaEncadenada<Usuario> lista = arreglo[hashFunction(dato.getDocumento())];
            lista.remove(dato);
        }
    }
    
    public void rehash(HashTable t){
        double loadFactor = size/numberOfKeys;
        if(loadFactor > 0.9){
            HashTable tabla = new HashTable(size*2, p);
            for(int i = 0; i < arreglo.length; i++){
                ListaEncadenada<Usuario> lista = arreglo[i];
                NodoLista<Usuario> it = lista.getHead().getNext();
                while(it != null){
                    tabla.insert(it.getKey());
                    it = it.getNext();
                }
            }
            t = tabla;
        }
    }
}
