
package Interfaces;
import Estructuras.OrderedCircularLinkedList;

public interface OrderedListADT<T extends Comparable<T>> extends ListADT<T> {
   public void add(T elem);
   public void merge(OrderedCircularLinkedList<T> lista);
}
