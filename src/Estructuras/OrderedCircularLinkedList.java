package Estructuras;
import Interfaces.OrderedListADT;
public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T>{
    
    public OrderedCircularLinkedList(String descr) {
		super(descr);
	}

    @Override
    public void add(T elem) {
        Node <T> nuevo = new Node<T>(elem);
        Node <T> act = last.next;
        Node <T> ant = last;
        boolean inic = true;

        while (act != last.next || inic) {
            inic = false;
            if (act.data.compareTo(nuevo.data) > 0) {
                if (ant.next == last.next) {
                    last = nuevo;
                }
                nuevo.next = act;
                ant.next = nuevo;
                count++;
            }
            ant = act;
            act = act.next;
        } 
    }

    @Override
    public void merge(OrderedCircularLinkedList<T> lista) {
        Node <T> act = lista.last.next;
        boolean inic = true;
        if(lista.last != null) {
            while (act == lista.last.next || inic) {
                inic = false;
                this.add(act.data);
                act = act.next;
            }
        }
    }

    
    
}
