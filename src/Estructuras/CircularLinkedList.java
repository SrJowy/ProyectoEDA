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
           count--;
           return n.data;
        } else {
            return null;
        }
    }

    @Override
    public T remove(T elem) {
        T elemEliminar = null;
        if (last != null) {
            Node <T> act = last.next;
            Node <T> ant = last;

            while (act != last) {
                if (act.data.equals(elem)) {
                    elemEliminar = act.data;
                    ant.next = act.next;
                    count--;
                }
                ant = act;
                act = act.next;
            }
            if (elemEliminar == null && act.data.equals(elem)) {
                if (size() > 1) {
                    last = ant;
                    ant.next = act.next;
                } else {
                    last = null;
                }
                count--;
            }
        }
        
        return elemEliminar;

    }

    public T first() {
        return (last.next.data);
    }

    public T last() {
        return (last.data);
    }

    public boolean contains(T elem) {
        return find(elem) != null;
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
        if (!enc) {
            data = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return (last==null);
    }

    public int size() {
        return count;
    }

    public Iterator<T> iterator() { 
        LinkedIterator<T> itr;
        if (last == null || last.next == null) {
            itr = new LinkedIterator<>(null,count);
        } else {
            itr = new LinkedIterator<>(last.next,count);
        }
        return itr;
    }

    public void limpiarLista() {
        last = null;
        count = 0;
    }

    public void visualizarNodos() {
        Iterator <T> itr = this.iterator();
        System.out.println();
        System.out.println("[");
        while (itr.hasNext()) {
            T valor = itr.next();
            System.out.println(valor);
        }
        System.out.println("]");
    }

    
}
