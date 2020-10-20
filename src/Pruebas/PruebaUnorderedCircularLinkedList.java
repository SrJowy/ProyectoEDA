package Pruebas;

import java.util.Iterator;

import Estructuras.UnorderedCircularLinkedList;

public class PruebaUnorderedCircularLinkedList {
    
    public static void visualizarNodos(UnorderedCircularLinkedList<Integer> l) {
        Iterator <Integer> itr = l.iterator();
        System.out.println();
        System.out.println("[");
        while (itr.hasNext()) {
            Integer num = itr.next();
            System.out.println(num);
        }
        System.out.println("]");
    }

    public static void main(String[] args)  {
		
		UnorderedCircularLinkedList<Integer> l = new UnorderedCircularLinkedList<>("lista");
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
        l.addToRear(20);
        l.addToFront(8);
		

		
        System.out.print(" Lista ......................");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
				
		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
        System.out.println("7? " + l.find(7));
        
        System.out.println("Prueba Contains ...........");
        System.out.println("8? " + l.contains(8));
        System.out.println("20? " + l.contains(20));
        System.out.println("7? " + l.contains(7));
        System.out.println("23? " + l.contains(23));

        System.out.println("Prueba RemoveLast .........");
        l.removeLast();
        visualizarNodos(l);
        UnorderedCircularLinkedList<Integer> l2 = new UnorderedCircularLinkedList<>("lista2");
        l2.addToFront(4);
        visualizarNodos(l2);
        l2.removeLast();
        visualizarNodos(l2);
        l2.addToRear(2);
        l2.addToRear(3);
        l2.addToRear(4);
        visualizarNodos(l2);
        l2.removeLast();
        visualizarNodos(l2);

        System.out.println("Prueba RemoveFirst ........");
        
    }

}
