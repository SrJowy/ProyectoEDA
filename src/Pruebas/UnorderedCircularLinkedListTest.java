package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Estructuras.UnorderedCircularLinkedList;

public class UnorderedCircularLinkedListTest {
    
    @Test
    public void addToFrontTest() {
        UnorderedCircularLinkedList <String> lista = new UnorderedCircularLinkedList<>("lista");
        lista.addToFront("primero");
        assertEquals("primero",lista.first());
        lista.addToFront("segundo");
        assertEquals("segundo",lista.first());
    }

    @Test
    public void addToRearTest() {
        UnorderedCircularLinkedList <String> lista = new UnorderedCircularLinkedList<>("lista");
        lista.addToRear("primero");
        assertEquals("primero",lista.first());
        lista.addToRear("segundo");
        assertEquals("primero",lista.first());
    }
}
