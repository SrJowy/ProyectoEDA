package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import labo1.CatalogoWeb;
import labo1.ListaWebs;
import labo1.Web;

public class Graph {
    private HashMap<String,Integer> tH;
    private String[] keys;
    private ArrayList<Integer>[] adjList;

    public Graph() {
        tH = new HashMap<>();
    }
    
    public void crearGrafo(ArrayList<Web> lista) {
        anadirAlHashMap(lista);
        llenarKeys(lista);
    }

    private void anadirAlHashMap(ArrayList<Web> l) {
        Web w = null;
        Iterator<Web> itr = l.iterator();
        int i = 0;

        while (itr.hasNext()) {
            w = itr.next();
            this.tH.put(w.getLink(), i);
            i++;
        }
        this.keys = new String[tH.size()];
    }

    private void llenarKeys(ArrayList<Web> l) {
        for (Web w: l) {
            int index = tH.get(w.getLink());
            keys[index] = w.getLink();
        }
    }

    private void llenarAdjList() {
        for (int i=0; i<keys.length; i++) {
            ListaWebs lW = CatalogoWeb.getCatalogoWeb().buscarWeb(keys[i]).getListaEnlazadas();
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; i<lW.getTamaino(); j++) {
                l.add(tH.get(lW.getWebIndice(j).getLink()));
            }
        }
    }
}
