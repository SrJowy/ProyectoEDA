package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import labo1.CatalogoPalabras;
import labo1.CatalogoWeb;
import labo1.ListaPalabras;
import labo1.ListaWebs;
import labo1.Palabra;
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
        double[] pRAnt = new double[keys.length];
        for (int i = 0; i<pRAnt.length;i++) pRAnt[i] = 1.0/keys.length;  //Coste: O(n)
        double diff = 1.0;
        int iteracion = 0;
        double D = 0.85;
        double[] pRDes = new double[keys.length];
        while (diff > 0.0001) {
            pRDes = new double[keys.length];
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
            for (int y = 0; y<pRDes.length; y++) {
                pRDes[y] = pRDes[y] * D + ((1-D)/keys.length);
            }

            for (int i = 0; i<pRAnt.length; i++) {
                double valor = (pRAnt[i] - pRDes[i]);
                if (valor < 0) valor = -valor;
                diff += valor;
            }
            pRAnt = pRDes;
            System.out.println(iteracion);
        }
        for (int i = 0; i<pRDes.length; i++) {
            pR.put(keys[i], pRDes[i]);
        } 
    }

    public ArrayList<Par> buscar(String p) {
        UnorderedCircularLinkedList<Web> l = CatalogoPalabras.getCatalogoPalabras().getPalabra(p).getListaWebs();
        Iterator<Web> itr = l.iterator();
        ArrayList<Par> lista = new ArrayList<>();
        while (itr.hasNext()) {
            Web w = itr.next();
            Par par = new Par(w.getLink(),pR.get(w.getLink()));
            lista.add(par);
        }
        lista = mergeSort(lista);
        return lista; 
    }

    public ArrayList<Par> buscar(String p1, String p2) { /***************************************************/
        UnorderedCircularLinkedList<Web> l = CatalogoPalabras.getCatalogoPalabras().getPalabra(p1).getListaWebs();
        Iterator<Web> itr = l.iterator();
        ArrayList<Par> lista = new ArrayList<>();
        while (itr.hasNext()) {
            Web w = itr.next();
            if (w.getListaPalabras().esta(CatalogoPalabras.getCatalogoPalabras().getPalabra(p2))) {
                Par par = new Par(w.getLink(),pR.get(w.getLink()));
                lista.add(par);
            }
        }
        lista = mergeSort(lista);
        return lista; 
    }

    public void imprimirListaPares(ArrayList<Par> l) {
        for (int i = 0; i<l.size(); i++){
            System.out.printf(l.get(i).getWeb() + " --> " + "%.8f",l.get(i).getPageRank());
            System.out.println();
        } 
    }

    public void imprimirPR() {
        for (int i = 0; i<keys.length; i++) {
            System.out.println();
            System.out.printf(keys[i] + " --> "+ "%.8f",pR.get(keys[i]));
        }
    }

    private void mezcla(ArrayList<Par> izq, ArrayList<Par> der, ArrayList<Par> l) {
        int izqInd = 0;
        int derInd = 0;
        int lInd = 0;

        while (izqInd < izq.size() && derInd < der.size()) {
            if ((izq.get(izqInd).getPageRank().compareTo(der.get(derInd).getPageRank())) > 0) {
                l.set(lInd, izq.get(izqInd));
                izqInd++;
            } else {
                l.set(lInd, der.get(derInd));
                derInd++;
            }
            lInd++;
        }
 
        ArrayList<Par> resto;
        int restoInd;
        if (izqInd >= izq.size()) {
            resto = der;
            restoInd = derInd;
        } else {
            resto = izq;
            restoInd = izqInd;
        }
        for (int i=restoInd; i<resto.size(); i++) {
            l.set(lInd, resto.get(i));
            lInd++;
        }
    }

    private ArrayList<Par> mergeSort(ArrayList<Par> l) {
       
        ArrayList<Par> izq = new ArrayList<Par>();
        ArrayList<Par> der = new ArrayList<Par>();
        int cent;
        if (l.size() == 1) {
            return l;
        } else {
            cent = l.size()/2;
            for (int i=0; i<cent; i++) {
                    izq.add(l.get(i));
            }
            for (int i=cent; i<l.size(); i++) {
                    der.add(l.get(i));
            }
            izq  = mergeSort(izq);
            der = mergeSort(der);
            mezcla(izq, der, l);
        } 
        return l;
    }
    
}