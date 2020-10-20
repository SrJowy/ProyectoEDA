package Estructuras;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {
    private Node<T> first;
    private Node<T> act;
    private boolean inic;
    private int count;

    LinkedIterator(Node<T> pFirst, int pCount){
        first = pFirst;
        act = pFirst;
        inic = true;
        count = pCount;
    }
    public boolean hasNext() {
       if (count == 0 || (act == first && !inic)) {
           return false;
       }
       return true;
    }

    public T next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T result = act.data;
        inic = false;
        act = act.next;
        return result;
    }
}