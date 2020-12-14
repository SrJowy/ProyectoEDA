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
    private HashMap<String,Double> pR;

    public Graph() {
        tH = new HashMap<>();
        pR = new HashMap<>();
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

    public void calcularPR() {
        double[] pRAnt = new double[adjList.length];
        System.out.println(1/pRAnt.length);
        for (int i = 0; i<pRAnt.length;i++) pRAnt[i] = 1.0/pRAnt.length;  //Coste: O(n)
        double diff = 0.0;
        int iteracion = 0;
        double D = 0.85;
        double[] pRDes = new double[adjList.length];
        while (diff > 0.0001) {
            pRDes = new double[adjList.length];
            diff = 0.0;
            int ind = 0;
            iteracion++;
            for (ArrayList<Integer> x: adjList) {
                double cant = pRAnt[ind]/x.size();
                for (int i = 0; i<x.size(); i++) {
                    pRDes[x.get(i)] += cant;
                }
                ind++;
            }
            for (double y: pRDes) {
                y = y * D + ((1-D)/adjList.length);
            }

            for (int i = 0; i<pRAnt.length; i++) {
                double valor = (pRAnt[i] - pRDes[i]);
                if (valor < 0) valor = -valor;
                diff += valor;
            }
            pRAnt = pRDes;
        }
        for (int i = 0; i<pRDes.length; i++) {
            pR.put(keys[i], pRDes[i]);
        }
    }

    public void imprimirPR() {
        for (int i = 0; i<keys.length; i++) {
            System.out.println(keys[i] + " --> ");
            System.out.printf("%.5f",pR.get(keys[i]));
        }
    }
    
}
