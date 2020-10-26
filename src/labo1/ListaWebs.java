package labo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;

public class ListaWebs {
    private HashMap <String, Web> lH;
    private ArrayList <Web> lW;
    

    public ListaWebs() {
        this.lH = new HashMap<String, Web>();
        this.lW = new ArrayList<Web>();
    }

    public void anadirWeb(String pLink, Web pWeb) {
        this.lH.put(pLink, pWeb);
        this.lW.add(this.lH.get(pLink));
    }

    public boolean contains(String s) {
        return this.lH.containsKey(s) ;
    }

    public void borrarWeb(String s, Web pWeb) {
        this.lH.remove(s);
        this.lW.remove(pWeb);
    }

    public void eliminarDeListaEnlazadas(String s, Web pWeb) {
        for (int i = 0; i < this.getTamaino(); i++) {
            if (this.lW.get(i).getListaEnlazadas().contains(s)) {
                this.lW.get(i).borrarDeListaEnlazadas(s, pWeb);
            }
        }
    }

    public ArrayList<Web> getArrayWebs() {
        return this.lW;
    } 

    public void escribir(File pArchivo) {
        try{
            FileWriter escribir = new FileWriter(pArchivo,true);
            for (int i = 0; i< this.lW.size(); i++) {
                String linea = this.lW.get(i).getLink() + " " + this.lW.get(i).getIndex();
                escribir.write(linea);
                escribir.write("\n");
            }
            escribir.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public Web getWebIndice(int pIndex) {
        return this.lW.get(pIndex);
    }

    public Web getWebLink(String pLink) {
        return this.lH.get(pLink);
    }

    public int getTamaino() {
        return this.lW.size();
    }

    public void set(int pInd, Web pWeb) {
        this.lW.set(pInd, pWeb);
    }
}
