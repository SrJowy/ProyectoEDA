package labo1;

import java.util.ArrayList;

public class ListaWebs {
    private ArrayList <Web> lW;
    
    public ListaWebs() {
        this.lW = new ArrayList<Web>();
    }

    public void anadirWeb(Web pWeb) {
        this.lW.add(pWeb);
    }

    public void borrarWeb(Web pWeb) {
        this.lW.remove(pWeb);
    } 

    public boolean contains(Web w) {
        return lW.contains(w);
    }

    public Web getWebIndice(int pIndex) {
        return this.lW.get(pIndex);
    }

    public int getTamaino() {
        return this.lW.size();
    }
}
