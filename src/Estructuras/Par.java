package Estructuras;

public class Par {
    private String web;
    private Double pageRank;

    public Par(String w, Double pR) {
        web = w;
        pageRank = pR;
    }

    public String getWeb() {
        return web;
    }

    public Double getPageRank() {
        return pageRank;
    }
}