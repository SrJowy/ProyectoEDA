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
        pruebaAddToRear(l);
        pruebaAddToFront(l);
        pruebaAddAfter(l);
        pruebaRemoveFirst(l);
        pruebaRemoveLast(l);
        pruebaSize(l);
        pruebaContains(l);
        pruebaFind(l);
    }

    public static void pruebaAddToRear(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba addToRear ************");
        l.addToRear(1);
        l.addToRear(2);
        l.addToRear(3);
        visualizarNodos(l);
    }

    public static void pruebaAddToFront(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba addToFront ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addToFront(2);
        l.addToFront(3);
        visualizarNodos(l);
    }

    public static void pruebaAddAfter(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba addAfter ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addAfter(3, 1);
        visualizarNodos(l);
        l.addAfter(2, 1);
        visualizarNodos(l);
    }

    public static void pruebaRemoveFirst(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeFirst ************");
        l.limpiarLista();
        l.addToFront(1);
        visualizarNodos(l);
        l.removeFirst();
        visualizarNodos(l);
        l.addToFront(1);
        l.addToFront(2);
        visualizarNodos(l);
        l.removeFirst();
        visualizarNodos(l);
    }

    public static void pruebaRemoveLast(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeLast ************");
        l.limpiarLista();
        l.addToFront(1);
        visualizarNodos(l);
        l.removeFirst();
        visualizarNodos(l);
        l.addToFront(1);
        l.addToFront(2);
        visualizarNodos(l);
        l.removeLast();
        visualizarNodos(l);
    }

    public static void pruebaSize(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba size ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addToFront(2);
        visualizarNodos(l);
        System.out.println("Size: " + l.size());
        l.addToRear(3);
        visualizarNodos(l);
        System.out.println("Size: " + l.size());
        l.removeFirst();
        visualizarNodos(l);
        System.out.println("Size: " + l.size());
        l.removeLast();
        visualizarNodos(l);
        System.out.println("Size: " + l.size());   
    }

    public static void pruebaContains(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba contains ************");
        l.limpiarLista();
        l.addToFront(1);
        visualizarNodos(l);
        System.out.println("1? - " + l.contains(1));
        l.addToFront(2);
        l.addToRear(3);
        visualizarNodos(l);
        System.out.println("3? - " + l.contains(3));
        System.out.println("4? - " + l.contains(4));
    }

    public static void pruebaFind(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba find ************");
        l.limpiarLista();
        l.addToFront(1);
        visualizarNodos(l);
        System.out.println("1? - " + l.find(1));
        l.addToFront(2);
        l.addToRear(3);
        visualizarNodos(l);
        System.out.println("1? - " + l.find(1));
        System.out.println("3? - " + l.find(3));
        System.out.println("4? - " + l.find(4));
    }



}
