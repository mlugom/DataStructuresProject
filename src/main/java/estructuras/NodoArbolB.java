/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author mlugom
 */
public class NodoArbolB<T extends Comparable<?super T>> {
    private T key;
    private NodoArbolB<T> left;
    private NodoArbolB<T> right;

    public NodoArbolB(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public NodoArbolB() {
        this.key = null;
        this.left = null;
        this.right = null;
    }

    public NodoArbolB(T key, NodoArbolB<T> left, NodoArbolB<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public NodoArbolB<T> getLeft() {
        return left;
    }

    public NodoArbolB<T> getRight() {
        return right;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setLeft(NodoArbolB<T> left) {
        this.left = left;
    }

    public void setRight(NodoArbolB<T> right) {
        this.right = right;
    }
    
    
    
    
    
    
}
