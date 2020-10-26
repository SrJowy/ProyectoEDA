package labo1;

public class Web {
    private ListaWebs lW;
    private ListaPalabras lP;
    private String link;
    private int index;

    public Web(int pIndex, String pLink) {
        this.lW = new ListaWebs();
        this.lP = new ListaPalabras();
        this.index = pIndex;
        this.link = pLink;
    }

    public ListaWebs getListaEnlazadas() {
        return this.lW;
    }

    public ListaPalabras getListaPalabras () {
        return this.lP;
    }

    public void anadirAListaWebs(Web pWeb) {
        this.lW.anadirWeb(pWeb.link, pWeb);
    }

    public String getLink() {
        return this.link;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void anadirAListaPalabras(String pPalabraS, Palabra pPalabraO) {
        this.lP.anadirALista(pPalabraS, pPalabraO);
    }

    public void borrarDeListaEnlazadas(String s, Web pWeb) {
        this.lW.borrarWeb(s, pWeb);
    }
}
