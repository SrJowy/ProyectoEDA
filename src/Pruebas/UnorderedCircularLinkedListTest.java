package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertEquals("segundo",lista.last());
    }

    @Test
    public void addAfterTest() {
        UnorderedCircularLinkedList <String> lista = new UnorderedCircularLinkedList<>("lista");
        lista.addToFront("primero");
        lista.addAfter("segundo", "primero");
        assertEquals("segundo", lista.last());
        assertEquals("primero", lista.first());
        lista.addAfter("tercero", "primero");
        assertNotEquals("tercero", lista.first());
        assertNotEquals("tercero",lista.last());
    }

    public void removeFirstTest() {
        UnorderedCircularLinkedList <String> lista = new UnorderedCircularLinkedList<>("lista");
        lista.addToFront("primero");
        lista.addToFront("segundo");
        
    }
}
