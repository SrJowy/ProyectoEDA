package labo1;

import Estructuras.UnorderedCircularLinkedList;

public class Palabra {
    private String word;
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
