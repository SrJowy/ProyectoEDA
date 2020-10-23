package Estructuras;
import Interfaces.OrderedListADT;
public class OrderedCircularLinkedList<T extends Comparable<T>> extends CircularLinkedList<T> implements OrderedListADT<T>{
    
    public OrderedCircularLinkedList(String descr) {
		super(descr);
	}

    @Override
    public void add(T elem) {
        Node <T> nuevo = new Node<T>(elem);
        if (last == null) { //No hay elementos en la lista
            last = nuevo;
            last.next = nuevo;
            count++;
        } else {
            if (last.next.data.compareTo(nuevo.data) > 0) { //El valor es menor que el contenido en primer lugar en la lista
                nuevo.next = last.next;
                last.next = nuevo;
                count++;
            } else {
                Node <T> act = last.next;
                Node <T> ant = last;
                boolean inic = true;
                while ((act.data.compareTo(nuevo.data) < 0) && (act != last.next || inic)) { //buscamos la posisicón a insertar
                    inic = false;
                    ant = act;
                    act = act.next;
                }
                if (act.data.compareTo(nuevo.data) < 0) { //El valor sigue siendo mayor, hay que insertar en última posición
                    nuevo.next = act;
                    ant.next = nuevo;
                    last = nuevo;
                    count++;
                } else { //El valor a insertar es menor que el valor de act, lo insertamos previamente a act
                    nuevo.next = act;
                    ant.next = nuevo;
                    count++;
                }
            }
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
