package Pruebas;

import Estructuras.OrderedCircularLinkedList;

import java.util.Iterator;

public class PruebaOrderedCircularLinkedList {
    public static void visualizarNodos(OrderedCircularLinkedList<Integer> l) {
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
			
        OrderedCircularLinkedList<Integer> l = new OrderedCircularLinkedList<Integer>("lista");
        l.add(1);
        l.add(3);
        l.add(6);
        l.add(5);
        l.add(7);
        l.add(9);
        l.add(0);
        l.add(20);

        
        System.out.print(" Lista ...............");
        visualizarNodos(l);
        System.out.println(" Num elementos: " + l.size());
                
        
        System.out.println("Prueba Find ...............");
        System.out.println("20? " + l.find(20));
        System.out.println("9? " + l.find(9));
        System.out.println("9? " + l.find(9));
        System.out.println("0? " + l.find(0));
        System.out.println("7? " + l.find(7));
        
        
        
        OrderedCircularLinkedList<Persona> l2 = new OrderedCircularLinkedList<Persona>("l2");
        l2.add(new Persona("jon", "1111"));
        l2.add(new Persona("ana", "7777"));
        l2.add(new Persona("amaia", "3333"));
        l2.add(new Persona("unai", "8888"));
        l2.add(new Persona("pedro", "2222"));
        l2.add(new Persona("olatz", "5555"));

        
        System.out.print(" Lista ...............");
        visualizarNodos(l);
        System.out.println(" Num elementos: " + l2.size());
                
        
        System.out.println("Prueba Find ...............");
        System.out.println("2222? " + l2.find(new Persona("", "2222")));
        System.out.println("5555? " + l2.find(new Persona("", "5555")));
        System.out.println("7777? " + l2.find(new Persona("", "7777")));	
        System.out.println("8888? " + l2.find(new Persona("", "8888")));	
        
        
}
}

