package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Estructuras.UnorderedCircularLinkedList;

public class CatalogoPalabras {
    private HashMap<String,Palabra> mPalabras;
    private static CatalogoPalabras miCatalogoPalabras = null;

    private CatalogoPalabras() {
        this.mPalabras = new HashMap<>();
    }

    public static CatalogoPalabras getCatalogoPalabras(){

        if (CatalogoPalabras.miCatalogoPalabras == null) {
            CatalogoPalabras.miCatalogoPalabras = new CatalogoPalabras();
        }

        return CatalogoPalabras.miCatalogoPalabras;
    }

    public void cargarPalabras() {
        //post: carga las palabras del archivo words.txt
        String archivo = "C:/Users/joelb/OneDrive/Escritorio/workspace/labo2/words.txt" ;

        try{
            Scanner entrada = new Scanner(new FileReader(archivo));
            String linea;

            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                Palabra p = new Palabra(linea);
                this.mPalabras.put(linea, p);
            }
        } catch (IOException e) {e.printStackTrace();}
    }

    public boolean contains(String s) {
        return this.mPalabras.containsKey(s);
    }

    public Palabra getPalabra(String pPalabra) {
        return this.mPalabras.get(pPalabra);
        
    }

    public void anadirWeb(String pPalabra, Web pWeb) {
        this.getPalabra(pPalabra).anadirWeb(pWeb);
    }

    public UnorderedCircularLinkedList<Web> word2Webs(String s) {
        //post: si la palabra esta en la lista de palabras de CatalogoPalabras, devuelve su lista de Webs
        if (this.contains(s)) {
            return this.getPalabra(s).getListaWebs();
        } else {
            return null;
        }
    }   
}
