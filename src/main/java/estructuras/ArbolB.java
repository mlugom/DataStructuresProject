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
public class ArbolB <T extends Comparable<?super T>>{
    private NodoArbolB<T> root;

    public ArbolB(NodoArbolB<T> root) {
        this.root = root;
    }

    public ArbolB() {
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void makeEmpty(){
        makeEmpty(this.root);
    }
    
    private void makeEmpty(NodoArbolB nodo){
         if(nodo != null){
             if(nodo.getLeft() != null){
                 makeEmpty(nodo.getLeft());
             }
             if(nodo.getRight() != null){
                 makeEmpty(nodo.getRight());
             }
             nodo = null;
         }
    }
    
    private NodoArbolB<T> insert(T key, NodoArbolB<T> nodo){
        if(nodo == null){
            return new NodoArbolB<>(key);
        }
        
        int compareResult = key.compareTo(nodo.getKey());
        if(compareResult < 0){
            nodo.setLeft(insert(key,nodo.getLeft()));
        }else if(compareResult > 0){
            nodo.setRight(insert(key,nodo.getRight()));
        }
        return nodo;
    }
    
    public void insert(T key){
        root = insert(key,root);
    }
    
    private boolean contains(T key, NodoArbolB<T> nodo){
        if(nodo == null){
            return false;
        }
        int compareResult = key.compareTo(nodo.getKey());
        if(compareResult < 0){
            return contains(key,nodo.getLeft());
        }else if(compareResult > 0){
            return contains(key,nodo.getRight());
        }else{
            return true;
        }
    }
    
    public boolean contains(T key){
        return contains(key,root);
    }
    
    private NodoArbolB<T> findMin(NodoArbolB<T> nodo){
        if (nodo == null) {
            return null;
        } else if (nodo.getLeft() == null) {
            return nodo;
        } else {
            return findMin(nodo.getLeft());
        }
    }
    
    public NodoArbolB<T> findMin(){
        return findMin(root);
    }
    
    private NodoArbolB<T> findMax(NodoArbolB<T> nodo){
        if (nodo == null) {
            return null;
        } else if (nodo.getRight() == null) {
            return nodo;
        } else {
            return findMin(nodo.getRight());
        }
    }
    
    public NodoArbolB<T> findMax(){
        return findMax(root);
    }
    
    private NodoArbolB<T> remove(T key, NodoArbolB<T> nodo){
        if(nodo == null){
            return nodo;
        }
        
        int compareResult = key.compareTo(nodo.getKey());
        if(compareResult < 0){
            nodo.setLeft(remove(key,nodo.getLeft()));
        }else if(compareResult > 0){
            nodo.setRight(remove(key,nodo.getRight()));
        }else if(nodo.getLeft() != null && nodo.getRight() != null){
            nodo.setKey(findMin(nodo.getRight()).getKey());
            nodo.setRight(remove(key,nodo.getRight()));
        }else{
            if(nodo.getLeft() != null){
                nodo = nodo.getLeft();
            }else{
                nodo = nodo.getRight();
            }
        }
        return nodo;
    }
    
    public void remove(T key){
        root = remove(key,root);
    }
    
    private int height(NodoArbolB<T> nodo){
        if(nodo == null)
            return -1;
        else
            return 1+Math.max(height(nodo.getLeft()), height(nodo.getRight()));
    }
    
}
