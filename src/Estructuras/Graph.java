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
    
    public void crearGrafo(ArrayList<Web> lista) {
        anadirAlHashMap(lista);
        llenarKeys(lista);
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
        //n = número de elementos en el ArrayList l
        //Coste O(n)
    }

    private void llenarKeys(ArrayList<Web> l) {
        keys = new String[tH.size()];
        for (String k: tH.keySet()) keys[tH.get(k)] = k;
        //n = número de elementos en el HashMap
        //Coste O(n)
    }

    private void llenarAdjList() {
        adjList = new ArrayList[keys.length];
        for (int i=0; i<keys.length; i++) {
            ListaWebs lW = CatalogoWeb.getCatalogoWeb().buscarWeb(keys[i]).getListaEnlazadas(); //Coste: O(1)
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; j<lW.getTamaino(); j++) {
                l.add(tH.get(lW.getWebIndice(j).getLink())); //Coste O(1)
            }
            adjList[i] = l;
        }
        //n = número de webs de ListaWebs
        //m = número de elementos en la Lista de enlazadas de una web
        //Coste: O(n*m/2)
    }

    public void print(){
        for (int i = 0; i < adjList.length; i++){
         System.out.print("Element: " + i + " " + keys[i] + " --> ");
         for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
         
         System.out.println();
        }
     }

     public boolean estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		
		int pos1 = tH.get(a1);
		int pos2 = tH.get(a2);
		boolean enc = false;
		boolean[] examinados = new boolean[tH.size()];

        for(int i = 0; i<adjList[pos1].size(); i++) {
            int elem = adjList[pos1].get(i);
            porExaminar.add(elem);
            examinados[elem] = true;
        }
        if (!porExaminar.isEmpty()) pos1 = porExaminar.element();

        while (!enc && !porExaminar.isEmpty()) {
            for(int i = 0; i<adjList[pos1].size(); i++) {
                int elem = adjList[pos1].get(i);
                if (examinados[elem] != true) {
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
		
        return enc;
    }
}
