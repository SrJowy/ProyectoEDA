package Pruebas;

import Estructuras.UnorderedCircularLinkedList;

public class PruebaUnorderedCircularLinkedList {

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
        l.visualizarNodos();
    }

    public static void pruebaAddToFront(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba addToFront ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addToFront(2);
        l.addToFront(3);
        l.visualizarNodos();
    }

    public static void pruebaAddAfter(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba addAfter ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addAfter(3, 1);
        l.visualizarNodos();
        l.addAfter(2, 1);
        l.visualizarNodos();
    }

    public static void pruebaRemoveFirst(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeFirst ************");
        l.limpiarLista();
        l.addToFront(1);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
    }

    public static void pruebaRemoveLast(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeLast ************");
        l.limpiarLista();
        l.addToFront(1);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        l.removeLast();
        l.visualizarNodos();
    }

    public static void pruebaSize(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba size ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.addToRear(3);
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.removeFirst();
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.removeLast();
        l.visualizarNodos();
        System.out.println("Size: " + l.size());   
    }

    public static void pruebaContains(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba contains ************");
        l.limpiarLista();
        l.addToFront(1);
        l.visualizarNodos();
        System.out.println("1? - " + l.contains(1));
        l.addToFront(2);
        l.addToRear(3);
        l.visualizarNodos();
        System.out.println("3? - " + l.contains(3));
        System.out.println("4? - " + l.contains(4));
    }

    public static void pruebaFind(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba find ************");
        l.limpiarLista();
        l.addToFront(1);
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        l.addToFront(2);
        l.addToRear(3);
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println("3? - " + l.find(3));
        System.out.println("4? - " + l.find(4));
    }



}
