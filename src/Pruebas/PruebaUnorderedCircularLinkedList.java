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
        pruebaRemove(l);
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
        System.out.println();
        System.out.println("La lista tiene un solo elemento, pero target no está en la lista");
        l.addToFront(1);
        l.visualizarNodos();
        l.addAfter(3, 2);
        l.visualizarNodos();
        System.out.println();
        System.out.println("La lista tiene un solo elemento y es el target");
        l.visualizarNodos();
        l.addAfter(3, 1);
        l.visualizarNodos();
        System.out.println();
        System.out.println("La lista tiene varios elementos, pero target no está en la lista");
        l.visualizarNodos();
        l.addAfter(2, 4);
        l.visualizarNodos();
        System.out.println();
        System.out.println("La lista tiene varios elementos y target es el elemento al final de la lista");
        l.visualizarNodos();
        l.addAfter(2, 3);
        l.visualizarNodos();
        System.out.println();
        System.out.println("La lista tiene varios elementos y target es un elemento por el medio");
        l.visualizarNodos();
        l.addAfter(6, 3);
        l.visualizarNodos();
    }

    public static void pruebaRemoveFirst(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeFirst ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.removeFirst();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo");
        l.addToFront(1);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodos");
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
    }

    public static void pruebaRemoveLast(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeLast ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.removeLast();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo");
        l.addToFront(1);
        l.visualizarNodos();
        l.removeLast();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodos");
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        l.removeLast();
        l.visualizarNodos();
    }

    public static void pruebaRemove(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba remove ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.remove(3);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo, el nodo está");
        l.addToFront(1);
        l.visualizarNodos();
        l.remove(1);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo, el nodo no está");
        l.addToFront(1);
        l.visualizarNodos();
        l.remove(5);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodo, el nodo está");
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        l.remove(2);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodo, el nodo no está");
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        l.remove(3);
        l.visualizarNodos();
    }

    public static void pruebaSize(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba size ************");
        l.limpiarLista();
        l.addToFront(1);
        l.addToFront(2);
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.addToFront(3);
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
        System.out.println();
        System.out.println("Lista vacía");
        l.visualizarNodos();
        System.out.println("1? - " + l.contains(1));
        System.out.println();
        System.out.println("Lista de un elemento");
        l.addToFront(1);
        l.visualizarNodos();
        System.out.println("1? - " + l.contains(1));
        System.out.println("2? - " +l.contains(2));
        System.out.println();
        System.out.println("Lista de varios elementos");
        l.addToFront(2);
        l.addToFront(3);
        l.visualizarNodos();
        System.out.println("3? - " + l.contains(3));
        System.out.println("4? - " + l.contains(4));
    }

    public static void pruebaFind(UnorderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba find ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println();
        System.out.println("Lista de un solo elemento");
        l.addToFront(1);
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println("2? - " + l.find(3));
        System.out.println();
        System.out.println("Lista de varios elementos");
        l.addToFront(2);
        l.addToFront(3);
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println("3? - " + l.find(3));
        System.out.println("4? - " + l.find(4));
    }

}

