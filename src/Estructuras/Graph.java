package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

    public String[] devolverKeys() {
        return keys;
    }
    
    public void crearGrafo(ArrayList<Web> lista) {
        anadirAlHashMap(lista);
        llenarKeys();
        llenarAdjList();
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
    }

    private void llenarKeys() {
        keys = new String[tH.size()];
        for (String k: tH.keySet()) keys[tH.get(k)] = k;
    }

    private void llenarAdjList() {
        adjList = new ArrayList[keys.length];
        for (int i=0; i<keys.length; i++) {
            ListaWebs lW = CatalogoWeb.getCatalogoWeb().buscarWeb(keys[i]).getListaEnlazadas();
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; j<lW.getTamaino(); j++) {
                l.add(tH.get(lW.getWebIndice(j).getLink())); 
            }
            adjList[i] = l;
        }
    }

    public void print(){
        for (int i = 0; i < adjList.length; i++){
         System.out.print("Element: " + i + " " + keys[i] + " --> ");
         for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
         
         System.out.println();
        }
     }

     public LinkedList<String> estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		
        int pos1 = tH.get(a1);
        int posInic = pos1;
		int pos2 = tH.get(a2);
		boolean enc = false;
        boolean[] examinados = new boolean[tH.size()];
        int[] camino = new int[tH.size()];
        LinkedList<String> devolver = new LinkedList<>();
        examinados[pos1] = true;

        for (int i = 0; i<camino.length; i++) {
            camino[i] = -1;
        }

        for(int i = 0; i<adjList[pos1].size(); i++) {
            int elem = adjList[pos1].get(i);
            camino[elem] = pos1;
            porExaminar.add(elem);
            examinados[elem] = true;
        }
        if (!porExaminar.isEmpty()) pos1 = porExaminar.element();

        while (!enc && !porExaminar.isEmpty()) {
            for(int i = 0; i<adjList[pos1].size(); i++) {
                int elem = adjList[pos1].get(i);
                if (examinados[elem] != true) {
                    camino[elem] = pos1;
                    porExaminar.add(elem);
                    examinados[elem] = true;
                } 
            }
            if (porExaminar.element() == pos2) enc = true;
            else {
                porExaminar.remove();
                if (!porExaminar.isEmpty())
                pos1 = porExaminar.element();
            }
        }
        if (enc) {
            boolean terminado = false;
            int i = pos2;
            devolver.addFirst(keys[pos2]);
            while (!terminado) {
                if (i == posInic) terminado = true;
                else {
                    devolver.addFirst(keys[camino[i]]);
                    i = camino[i];
                }
            }
        }
        
        return devolver;
    }
}
