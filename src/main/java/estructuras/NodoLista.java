/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Estudiante
 */
public class NodoLista<T> {
    private T key;
    private NodoLista<T> next;

    public NodoLista(T key) {
        this(key,null);
    }

    public NodoLista(T key, NodoLista<T> next) {
        this.key = key;
        this.next = next;
    }
    
    public NodoLista() {
        this(null,null);
    }

    public T getKey() {
        return key;
    }

    public NodoLista<T> getNext() {
        return next;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setNext(NodoLista<T> next) {
        this.next = next;
    }
}
