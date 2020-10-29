package labo1;

import java.io.*;
import java.util.*;

public class CatalogoWeb {
    private MapaWebs l;
    private static CatalogoWeb miCatalogoWeb = null;

    private CatalogoWeb() {
        this.l = new MapaWebs();
    }

    public static CatalogoWeb getCatalogoWeb() {

        if (CatalogoWeb.miCatalogoWeb == null) {
            CatalogoWeb.miCatalogoWeb = new CatalogoWeb();
        }

        return CatalogoWeb.miCatalogoWeb;
    }

    public void cargarWebs() {
        String archivoIndex = "index.txt";
        String archivoArc = "pld-arcs-1-N.txt";

        try{
            cargaIndex(archivoIndex);
            cargarArc(archivoArc);
        } catch (IOException e) {e.printStackTrace();}
    }

    public void cargaIndex(String s) throws IOException {
        Scanner entrada = new Scanner(new FileReader(s));
        String linea;
        Web w;
        while (entrada.hasNext()) {
            linea = entrada.nextLine();
            String[] datos = linea.split(" ");
            w = new Web(Integer.parseInt(datos[1]),datos[0]);
            this.l.anadirWeb(datos[0], w);
            this.anadirAPalabra(datos[0], this.l.getWebLink(datos[0]));
        }
    }

    public void cargarArc(String s) throws IOException{
        Scanner entrada = new Scanner(new FileReader(s));
        String linea;
        while (entrada.hasNext()) {
            linea = entrada.nextLine();
            String[] packWeb = linea.split(" ");
            Web w = this.l.getWebLink(packWeb[0]);
            
            for(int i = 2; i < packWeb.length; i++) {
                w.anadirAListaWebs(this.l.getWebIndice(Integer.parseInt(packWeb[i])));
            }
        }
    }

    private void anadirAPalabra(String pLink, Web pWeb) {
        int inic, fin;
        String subCadena = "";
        int cont = 3;
        while (!subCadena.equals(pLink)) {
            inic = 0;
            fin = cont;
            while(pLink.length() >= fin) {
                subCadena = pLink.substring(inic, fin);
                if (CatalogoPalabras.getCatalogoPalabras().contains(subCadena)) {
                    this.l.getWebLink(pLink).anadirAListaPalabras(CatalogoPalabras.getCatalogoPalabras().getPalabra(subCadena));
                    CatalogoPalabras.getCatalogoPalabras().anadirWeb(subCadena, pWeb);
                }
                fin++;
                inic++;
            }
            cont++;    
        }
    }

    public Web buscarWeb(String s) {
        //post: devuelve la Web asociada al link dado
        return this.l.getWebLink(s);
    }

    public void addWeb(String w) {
        //post: añade una web y comprueba si su link tiene alguna palabra que esté en CatálogoPalabras
        Web pWeb = new Web(this.l.getTamaino(), w);
        this.l.anadirWeb(pWeb.getLink(), pWeb);
        anadirAPalabra(w, this.l.getWebLink(pWeb.getLink()));
        
    }

    public ListaWebs enlacesSalientes(String s) {
        //post: devuelve la lista de webs enlazadas buscándola en el HashMap mediante su link
          if (this.l.contains(s)) {
            return this.l.getWebLink(s).getListaEnlazadas();
          } else {
              return null;
          }

    }

    public void borrarWeb(String s) {
        //post: borra una Web, en caso de que exista, de la ListaWebs de CatalogoWebs, de las listas de Webs enlazadas en la que esté esa web y de la ListaWebs
        //de las palabras 
        if (this.l.contains(s)) {
            Web w = this.l.getWebLink(s);
            ListaPalabras lP = this.l.getWebLink(s).getListaPalabras();
            this.l.borrarWeb(s, w);
            this.l.eliminarDeListaEnlazadas(w);
            lP.borrarPalabras(w);
        }
    }

    public MapaWebs webOrdenada() {
        //post: devuelve una copia ArrayList de webs ordenado por MergeSort
        ListaWebs lWebs = new ListaWebs();

        for (int i = 0; i < this.l.getTamaino(); i++) { //copiamos la lista
            lWebs.anadirWeb(this.l.getWebIndice(i));
        }
        return mergeSort(this.l);
    }

    private void mezcla(MapaWebs izq, MapaWebs der, MapaWebs l) {
        int izqInd = 0;
        int derInd = 0;
        int lInd = 0;

        while (izqInd < izq.getTamaino() && derInd < der.getTamaino()) {
            if ((izq.getWebIndice(izqInd).getLink().compareTo(der.getWebIndice(derInd).getLink())) < 0) {
                l.set(lInd, izq.getWebIndice(izqInd));
                izqInd++;
            } else {
                l.set(lInd, der.getWebIndice(derInd));
                derInd++;
            }
            lInd++;
        }
 
        MapaWebs resto;
        int restoInd;
        if (izqInd >= izq.getTamaino()) {
            resto = der;
            restoInd = derInd;
        } else {
            resto = izq;
            restoInd = izqInd;
        }
        for (int i=restoInd; i<resto.getTamaino(); i++) {
            l.set(lInd, resto.getWebIndice(i));
            lInd++;
        }
    }

    private MapaWebs mergeSort(MapaWebs l) {
       
        MapaWebs izq = new MapaWebs();
        MapaWebs der = new MapaWebs();
        int cent;
        if (l.getTamaino() == 1) {
            return l;
        } else {
            cent = l.getTamaino()/2;
            for (int i=0; i<cent; i++) {
                    izq.anadirWeb(l.getWebIndice(i).getLink(), l.getWebIndice(i));
            }
            for (int i=cent; i<l.getTamaino(); i++) {
                    der.anadirWeb(l.getWebIndice(i).getLink(),l.getWebIndice(i));
            }
            izq  = mergeSort(izq);
            der = mergeSort(der);
            mezcla(izq, der, l);
        } 
        return l;
    }

    public void guardarWebs() {
        //post: crea un fichero, si no existe, y añade las webs de la ListaWebs de CatalogoWeb 
        File archivo = new File("lista.txt");
        if (archivo.exists()) {
            archivo.delete();
        }
        this.l.escribir(archivo);
    }
    
}
