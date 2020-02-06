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
public class ListaEncadenada<T> {
    private NodoLista<T> head;
    private NodoLista<T> tail;

    public ListaEncadenada() {
        this.head = new NodoLista<>();
        this.tail = new NodoLista<>();
    }
    
    
    
    public boolean isEmpty(){
        return head.getNext() == null;
    }

    public void pushFront(T key){
        NodoLista<T> nodo = new NodoLista(key);
        if(isEmpty()){
            head.setNext(nodo);
            tail.setNext(nodo);
        }else{
            nodo.setNext(head.getNext());
            head.setNext(nodo);
        }
    }
    
    public void pushBack(T key){
        NodoLista<T> nodo = new NodoLista(key);
        if(isEmpty()){
            head.setNext(nodo);
            tail.setNext(nodo);
        }else{
            tail.getNext().setNext(nodo);
            tail.setNext(nodo);
        }
    }
    
    public void popBack(){
        if(isEmpty())
            System.out.println("Lista vacía");
        else{
            if(head.getNext()==tail.getNext()){
                head.setNext(null);
                tail.setNext(null);
            }else{
                NodoLista<T> nodoAux = head;
                while(nodoAux.getNext().getNext() != null){
                    nodoAux = nodoAux.getNext();
                }
                tail.setNext(nodoAux);
            }
        }
    }
    
    public void popFront(){
        if(isEmpty())
            System.out.println("Lista vacía");
        else{
            if(head.getNext() == tail.getNext()){
                head.setNext(null);
                tail.setNext(null);
            }else{
                head.setNext(head.getNext().getNext());
            }
        }
    }

    public void addAfter(T theElement, NodoLista<T> nodo){
        if(isEmpty()){
            System.out.println("Lista vacía");
        }else{
            NodoLista<T> nodoAux = new NodoLista<>(theElement);
            if(nodo.getNext() != null){
                nodoAux.setNext(nodo.getNext());
            }else{
                tail.setNext(nodoAux);
            }
            nodo.setNext(nodoAux);
        }
    }
    
    public boolean find(T key){
        if(isEmpty()){
            return false;
        }else{
            NodoLista<T> nodo = head;
            boolean respuesta = false;
            while(nodo.getNext() != null){
                if(nodo.getNext().getKey() == key)
                    respuesta = true;
                nodo = nodo.getNext();
            }
            return respuesta;
        }
    }

    public NodoLista<T> getHead() {
        return head;
    }

    public NodoLista<T> getTail() {
        return tail;
    }

    public void setHead(NodoLista<T> head) {
        this.head = head;
    }

    public void setTail(NodoLista<T> tail) {
        this.tail = tail;
    }
    
    public void remove(T key){
        if(!isEmpty()){
            NodoLista<T> nodo = head;
            while(nodo.getNext() != null){
                if(nodo.getNext().getKey() == key){
                    nodo.setNext(nodo.getNext().getNext());
                }
                nodo = nodo.getNext();
            }
        }
    }
}
