package labo1;

import Estructuras.UnorderedCircularLinkedList;

public class Palabra {          //Se han probado los métodos addToRear y remove en la clase PruebaUnorderedCircularLinkedList.
    private String word;        //También se han realizado una prueba con la clase menú y unos archivos reducidos con respecto a los de la práctica 1
    private UnorderedCircularLinkedList<Web> lW;

    public String getPalabra() {
        return word;
    }

    public Palabra(String pPalabra) {
        this.word = pPalabra;
        this.lW = new UnorderedCircularLinkedList<>("ListaWebs");
    }

    public UnorderedCircularLinkedList<Web> getListaWebs() {
        return this.lW;
    }

    public void anadirWeb(Web pWeb) {
        this.lW.addToFront(pWeb);
    }

    public void borrarWeb(Web pWeb) {
        this.lW.remove(pWeb);
        
    }
}
