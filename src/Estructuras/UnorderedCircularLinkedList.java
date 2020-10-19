package Estructuras;

import java.util.Iterator;

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
		Node<T> nodo = new Node<T>(elem);
		Node<T> act = last.next;
		boolean enc = false;
		T data;
		Iterator<T> itr = this.iterator();
		while (itr.hasNext() && !enc) {
			data = itr.next();
			if (data.equals(elem)) {
				enc = true;
			}
			act = act.next;
		}
		nodo.next = act.next;
		act.next = nodo;
	}

}
