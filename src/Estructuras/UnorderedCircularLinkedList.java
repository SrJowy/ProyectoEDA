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
			nodo.next = last.next.next;
		} else {
			last = nodo;	
		}
		last.next = nodo;
		
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
	}

	@Override
	public void addAfter(T elem, T target) {
		//pre: tiene que haber al menos un elemento en la lista
		Node<T> nodo = new Node<T>(elem);
		Node<T> act = last.next;
		while (act.data != target) {
			act = act.next;
		}
		if (act.next == last.next) {
			last = nodo;
		}
		nodo.next = act.next;
		act.next = nodo;
	}

}
