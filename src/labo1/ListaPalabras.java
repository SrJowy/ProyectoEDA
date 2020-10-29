package labo1;

import java.util.ArrayList;

public class ListaPalabras {
    private ArrayList <Palabra> lP;

    public ListaPalabras() {
        this.lP = new ArrayList<Palabra>();
    }

    public void anadirALista(Palabra pPalabraO) {
        this.lP.add(pPalabraO);
    }

    public void borrarPalabras(Web pWeb) {
        for(int i = 0; i < this.lP.size(); i++) {
            this.lP.get(i).borrarWeb(pWeb);
        }
    }

}
