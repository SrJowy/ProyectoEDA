package Estructuras;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {
    private Node<T> act;
    private Node<T> last;

    LinkedIterator(Node<T> pLast, Node<T> pFirst){
        act = pFirst;
        last = pLast;
    }
    public boolean hasNext() {
       return (act != last);
    }

    public T next(){
        if (!this.hasNext()){
            throw new NoSuchElementException();
        }
        T result = this.act.data;
        act = act.next;
        return result;
    }
}