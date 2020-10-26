package labo1;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Estructuras.UnorderedCircularLinkedList;

public class CatalogoPalabras {
    private ListaPalabras lP;
    private static CatalogoPalabras miCatalogoPalabras = null;

    private CatalogoPalabras() {
        this.lP = new ListaPalabras();
    }

    public static CatalogoPalabras getCatalogoPalabras(){

        if (CatalogoPalabras.miCatalogoPalabras == null) {
            CatalogoPalabras.miCatalogoPalabras = new CatalogoPalabras();
        }

        return CatalogoPalabras.miCatalogoPalabras;
    }

    public void cargarPalabras() {
        //post: carga las palabras del archivo words.txt
        String archivo = "words.txt" ;

        try{
            Scanner entrada = new Scanner(new FileReader(archivo));
            String linea;

            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                Palabra p = new Palabra(linea);
                this.lP.anadirALista(linea, p);
            }
        } catch (IOException e) {e.printStackTrace();}
    }

    public boolean contains(String s) {
        return this.lP.contains(s);
    }

    public Palabra getPalabra(String pPalabra) {
        return this.lP.getPalabra(pPalabra);
        
    }

    public void anadirWeb(String pPalabra, Web pWeb) {
        this.lP.getPalabra(pPalabra).anadirWeb(pWeb);
    }

    public UnorderedCircularLinkedList<Web> word2Webs(String s) {
        //post: si la palabra esta en la lista de palabras de CatalogoPalabras, devuelve su lista de Webs
        if (this.lP.contains(s)) {
            return this.lP.getPalabra(s).getListaWebs();
        } else {
            return null;
        }
    }   
}
