package Estructuras;

import java.util.Iterator;

import Interfaces.ListADT;

public class CircularLinkedList<T> implements ListADT<T>{

        protected Node<T> last;
        
        protected String descr;
        protected int count;

    public CircularLinkedList(String descr){
        this.count = 0;
        this.last = null;
        this.descr = descr;
    }
    
    public void setDescr(String nom) {
        this.descr = nom;
    }

    public String getDescr() {
        return this.descr;
    }

    public T removeFirst() {
        Node<T> aux;
        if (count > 1){
            aux = last.next;
            last.next=last.next.next;
            count--;
            return(aux.data);
        }
        else if (count == 1){
            aux=last;
            last=null;
            count--;
            return(aux.data);
        }
        else {return null;}   
    }

    public T removeLast() {
        Node<T> n;
        if (count == 1){
           n = last;
           last = null;
           count--;
           return n.data;
        } else if (count > 1) {
           Node<T> act = last.next;
           Node<T> ant = null;
           while (act != last) {
               ant = act;
               act = act.next;
           }
           ant.next = last.next;
           n = last;
           last = ant;
           return n.data;
        } else {
            return null;
        }
    }

    public T first() {
        return (last.next.data);
    }

    public T last() {
        return (last.data);
    }

    public boolean contains(T elem) {
        T data;
        boolean enc = false;
        Iterator<T> itr = this.iterator();
        while (itr.hasNext() && !enc){
            data = itr.next();
            if (data.equals(elem)) { //hay que utilizar el compare
                enc = true;
            }
        }
        return enc;
    }

    public T find(T elem) {
        boolean enc = false;
        T data = null;
        Iterator<T> itr = this.iterator();
        while (itr.hasNext() && !enc) {
            data = itr.next();
            if (data.equals(elem)) {
                enc = true;
            }
        }
        return data;
    }

    public boolean isEmpty() {
        if (last==null){return(true);}
        else {return false;}
    }

    public int size() {
        return count;
    }

    public Iterator<T> iterator() { 
        LinkedIterator<T> itr = new LinkedIterator<>(last, last.next);
        return itr;
    }
}
