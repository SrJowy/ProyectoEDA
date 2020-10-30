package Pruebas;

import Estructuras.OrderedCircularLinkedList;

public class PruebaOrderedCircularLinkedList {
    

    public static void main(String[] args)  {
			
        OrderedCircularLinkedList<Integer> l1 = new OrderedCircularLinkedList<Integer>("lista");
        pruebaAddInteger(l1);
        OrderedCircularLinkedList<Persona> l2 = new OrderedCircularLinkedList<Persona>("lista2");
        pruebaAddPersona(l2);
        OrderedCircularLinkedList<Integer> l3 = new OrderedCircularLinkedList<Integer>("lista3");
        pruebaMergeInteger(l1, l3);
        OrderedCircularLinkedList<Persona> l4 = new OrderedCircularLinkedList<Persona>("lista4");
        pruebaMergePersona(l2, l4);
        pruebaRemoveFirst(l1);
        pruebaRemoveLast(l1);
        pruebaRemove(l1);
        pruebaSize(l1);
        pruebaContains(l1);
        pruebaFind(l1);
    }

    public static void pruebaAddInteger(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba addInteger ************");
        l.add(1);
        l.add(3);
        l.add(6);
        l.add(5);
        l.add(7);
        l.add(9);
        l.add(0);
        l.add(20);
        l.visualizarNodos();
        System.out.println("Número de elementos " + l.size());
    }

    public static void pruebaAddPersona(OrderedCircularLinkedList<Persona> l2) {
        System.out.println("************ Prueba addPersona ************");
        l2.add(new Persona("jon", "1111"));
        l2.add(new Persona("ana", "7777"));
        l2.add(new Persona("amaia", "3333"));
        l2.add(new Persona("unai", "8888"));
        l2.add(new Persona("pedro", "2222"));
        l2.add(new Persona("olatz", "5555"));
        l2.visualizarNodos();
        System.out.println("Número de elementos " + l2.size());
    }

    public static void pruebaMergeInteger(OrderedCircularLinkedList <Integer> l1, OrderedCircularLinkedList <Integer> l2) {
        l1.limpiarLista();
        l2.limpiarLista();
        System.out.println("************ Prueba MergeInteger ************");
        System.out.println();
        System.out.println("Las dos listas están vacías");
        l1.merge(l2);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
        System.out.println();

        System.out.println("La lista parámetro no está vacía pero la lista sí");
        l2.add(2);
        l2.add(8);
        l2.add(10);
        l2.add(21);
        l2.add(-1);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
        l2.visualizarNodos();
        System.out.println("Número de elementos " + l2.size());
        l1.merge(l2);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());

        l1.limpiarLista();
        l2.limpiarLista();

        System.out.println("La lista parámetro está vacía pero la lista no");
        l1.add(1);
        l1.add(0);
        l1.add(4);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
        l2.visualizarNodos();
        System.out.println("Número de elementos " + l2.size());
        l1.merge(l2);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
        
        l1.limpiarLista();
        l2.limpiarLista();
        
        System.out.println("Ninguna de las dos listas están vacías");
        l2.add(2);
        l2.add(8);
        l2.add(10);
        l2.add(21);
        l2.add(-1);
        l1.add(1);
        l1.add(0);
        l1.add(4);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
        l2.visualizarNodos();
        System.out.println("Número de elementos " + l2.size());
        l1.merge(l2);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
    }

    public static void pruebaMergePersona(OrderedCircularLinkedList <Persona> l1, OrderedCircularLinkedList <Persona> l2) {
        System.out.println("************ Prueba MergePersona ************");
        l2.add(new Persona("juan", "9999"));
        l2.add(new Persona("ander", "6666"));
        l2.add(new Persona("maría", "4444"));
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
        l2.visualizarNodos();
        System.out.println("Número de elementos " + l2.size());
        l1.merge(l2);
        l1.visualizarNodos();
        System.out.println("Número de elementos " + l1.size());
    }

    public static void pruebaRemoveFirst(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeFirst ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.removeFirst();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo");
        l.add(1);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodos");
        l.add(1);
        l.add(2);
        l.visualizarNodos();
        l.removeFirst();
        l.visualizarNodos();
    }

    public static void pruebaRemoveLast(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba removeLast ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.removeLast();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo");
        l.add(1);
        l.visualizarNodos();
        l.removeLast();
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodos");
        l.add(1);
        l.add(2);
        l.visualizarNodos();
        l.removeLast();
        l.visualizarNodos();
    }

    public static void pruebaRemove(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba remove ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.remove(3);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo, el nodo está");
        l.add(1);
        l.visualizarNodos();
        l.remove(1);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de un solo nodo, el nodo no está");
        l.add(1);
        l.visualizarNodos();
        l.remove(5);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodo, el nodo está");
        l.add(1);
        l.add(2);
        l.visualizarNodos();
        l.remove(2);
        l.visualizarNodos();
        System.out.println();
        System.out.println("Lista de varios nodo, el nodo no está");
        l.add(1);
        l.add(2);
        l.visualizarNodos();
        l.remove(3);
        l.visualizarNodos();
    }

    public static void pruebaSize(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba size ************");
        l.limpiarLista();
        l.add(1);
        l.add(2);
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.add(3);
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.removeFirst();
        l.visualizarNodos();
        System.out.println("Size: " + l.size());
        l.removeLast();
        l.visualizarNodos();
        System.out.println("Size: " + l.size());   
    }

    public static void pruebaContains(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba contains ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.visualizarNodos();
        System.out.println("1? - " + l.contains(1));
        System.out.println();
        System.out.println("Lista de un elemento");
        l.add(1);
        l.visualizarNodos();
        System.out.println("1? - " + l.contains(1));
        System.out.println("2? - " +l.contains(2));
        System.out.println();
        System.out.println("Lista de varios elementos");
        l.add(2);
        l.add(3);
        l.visualizarNodos();
        System.out.println("3? - " + l.contains(3));
        System.out.println("4? - " + l.contains(4));
    }

    public static void pruebaFind(OrderedCircularLinkedList<Integer> l) {
        System.out.println("************ Prueba find ************");
        l.limpiarLista();
        System.out.println();
        System.out.println("Lista vacía");
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println();
        System.out.println("Lista de un solo elemento");
        l.add(1);
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println("2? - " + l.find(3));
        System.out.println();
        System.out.println("Lista de varios elementos");
        l.add(2);
        l.add(3);
        l.visualizarNodos();
        System.out.println("1? - " + l.find(1));
        System.out.println("3? - " + l.find(3));
        System.out.println("4? - " + l.find(4));
    }

}

