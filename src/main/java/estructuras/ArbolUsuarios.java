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
public class ArbolUsuarios {
    private NodoArbolUsuario root;

    public ArbolUsuarios(NodoArbolUsuario root) {
        this.root = root;
    }

    public ArbolUsuarios() {
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void makeEmpty(){
        makeEmpty(this.root);
    }
    
    private void makeEmpty(NodoArbolUsuario nodo){
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
    
    private NodoArbolUsuario insert(Usuario key, NodoArbolUsuario nodo){
        if(nodo == null){
            return new NodoArbolUsuario(key);
        }
        
        int compareResult = key.getDocumento()-nodo.getKey().getDocumento();
        if(compareResult < 0){
            nodo.setLeft(insert(key,nodo.getLeft()));
        }else if(compareResult > 0){
            nodo.setRight(insert(key,nodo.getRight()));
        }
        return nodo;
    }
    
    public void insert(Usuario key){
        root = insert(key,root);
    }
    
    private boolean contains(Usuario key, NodoArbolUsuario nodo){
        if(nodo == null){
            return false;
        }
        int compareResult = key.getDocumento()-nodo.getKey().getDocumento();
        if(compareResult < 0){
            return contains(key,nodo.getLeft());
        }else if(compareResult > 0){
            return contains(key,nodo.getRight());
        }else{
            return true;
        }
    }
    
    public boolean contains(int documento){
        Usuario key = new Usuario("",0,documento);
        return contains(key,root);
    }
    
    private NodoArbolUsuario findMin(NodoArbolUsuario nodo){
        if (nodo == null) {
            return null;
        } else if (nodo.getLeft() == null) {
            return nodo;
        } else {
            return findMin(nodo.getLeft());
        }
    }
    
    public NodoArbolUsuario findMin(){
        return findMin(root);
    }
    
    private NodoArbolUsuario findMax(NodoArbolUsuario nodo){
        if (nodo == null) {
            return null;
        } else if (nodo.getRight() == null) {
            return nodo;
        } else {
            return findMin(nodo.getRight());
        }
    }
    
    public NodoArbolUsuario findMax(){
        return findMax(root);
    }
    
    private NodoArbolUsuario remove(Usuario key, NodoArbolUsuario nodo){
        if(nodo == null){
            return nodo;
        }
        
        int compareResult = key.getDocumento()-nodo.getKey().getDocumento();
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
    
    public void remove(Usuario key){
        root = remove(key,root);
    }
    
    private int height(NodoArbolUsuario nodo){
        if(nodo == null)
            return -1;
        else
            return 1+Math.max(height(nodo.getLeft()), height(nodo.getRight()));
    }
}
