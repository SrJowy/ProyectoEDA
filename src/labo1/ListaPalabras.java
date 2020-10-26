package labo1;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaPalabras {
    
    private HashMap <String,Palabra> lH;
    private ArrayList <Palabra> lP;

    public ListaPalabras() {
        this.lH = new HashMap<String,Palabra>();
        this.lP = new ArrayList<Palabra>();
    }

    public void anadirALista(String pPalabraS, Palabra pPalabraO) {
        this.lH.put(pPalabraS, pPalabraO);
        this.lP.add(this.lH.get(pPalabraS));
    }

    public Palabra getPalabra(String s) {
        return this.lH.get(s);
    }

    public void borrarPalabras(Web pWeb) {
        for(int i = 0; i < this.lP.size(); i++) {
            this.lP.get(i).borrarWeb(pWeb);
        }
    }

    public boolean contains(String s) {
        return this.lH.containsKey(s);
    }

}
