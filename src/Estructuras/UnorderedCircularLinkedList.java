package Estructuras;

import Interfaces.UnorderedListADT;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {

	public UnorderedCircularLinkedList(String descr) {
		super(descr);
	}

	@Override
	public void addToFront(T elem) {
		Node<T> nodo = new Node<T>(elem);
		if (last != null) {
			nodo.next = last.next;
		} else {
			last = nodo;	
		}
		last.next = nodo;
		count++;
	}

	@Override
	public void addToRear(T elem) {
		Node <T> nodo = new Node<T>(elem);
		if (last != null) {
			nodo.next = last.next;
			last.next = nodo;
		} else {
			nodo.next = nodo;
		}
		last = nodo;
		count++;
	}

	@Override
	public void addAfter(T elem, T target) {
		//pre: tiene que haber al menos un elemento en la lista
		Node<T> nodo = new Node<T>(elem);
		Node<T> act = last.next;
		boolean inic = true;
		boolean enc = false;
		while (!enc && (act != last.next || inic)) {
			inic = false;
			act = act.next;
			if (act.data.equals(target)) {
				enc = true;
			}
		}
		if (enc) {
			if (act.next == last.next) {
				last = nodo;
			}
			nodo.next = act.next;
			act.next = nodo;
			count++;
		}
		
	}

}
