package labo1;
import java.util.Scanner;

import Estructuras.UnorderedCircularLinkedList;


public class Menu {
    Scanner reader;

    public Menu() {
        this.reader = new Scanner(System.in);
    }

    private void imprimirLista(ListaWebs lW) {
        System.out.println("//////////////////// Lista //////////////////////");
        System.out.println("");
        for (int i = 0; i <lW.getTamaino(); i++) {
            System.out.println(lW.getWebIndice(i).getLink());
            System.out.println("");
        }
        System.out.println("/////////////////////////////////////////////////");
    }

    public void inicializarPrograma() {
        int n = -1;
        String url = " ";

        while (n != 0) {
            System.out.println("");
            System.out.println("Menu:");
            System.out.println("1 - Cargar archivos"); //1 min 11 s
            System.out.println("2 - Buscar una página web"); //0 s
            System.out.println("3 - Insertar una página web"); //0 s
            System.out.println("4 - Devolver páginas web enlazadas"); //0 s
            System.out.println("5 - Devolver las páginas webs que contienen una palabra");//0 s
            System.out.println("6 - Borrar una web"); //Depende de la web, 1 s
            System.out.println("7 - Guardar la lista de webs en ficheros"); //2 s
            System.out.println("8 - Obtener lista de páginas web ordenada"); //2 min 26 s
            System.out.println("0 - Salir del programa");
            System.out.println("");
            System.out.println("Introduce un valor");

            n = reader.nextInt();

            switch (n) {
                case 1: {
                    CatalogoPalabras.getCatalogoPalabras().cargarPalabras();
                    CatalogoWeb.getCatalogoWeb().cargarWebs();
                    System.out.println("");
                    System.out.println("Carga realizada");
                }
                case 2: {
                    System.out.println("");
                    System.out.println("Introduce el URL de una web");
                    url = reader.next();
                    Web w = CatalogoWeb.getCatalogoWeb().buscarWeb(url);
                    System.out.println("");
                    if (w != null) {
                        System.out.println(w.getIndex() + " | " + w.getLink());
                    } else {
                        System.out.println("No se ha encontrado esa web");
                    }
                    break;
                }

                case 3: {
                    System.out.println("");
                    System.out.println("Introduce el URL de una web");
                    url = reader.next();
                    CatalogoWeb.getCatalogoWeb().addWeb(url);
                    break;
                }

                case 4: {
                    System.out.println("");
                    System.out.println("Introduce el URL de una web");
                    url = reader.next();
                    ListaWebs lW = CatalogoWeb.getCatalogoWeb().enlacesSalientes(url);
                    System.out.println("");
                    this.imprimirLista(lW);
                    break;
                }

                case 5: {
                    System.out.println("");
                    System.out.println("Introduce una palabra");
                    url = reader.next();
                    UnorderedCircularLinkedList<Web> lW = CatalogoPalabras.getCatalogoPalabras().word2Webs(url);
                    break;
                }

                case 6: {
                    System.out.println("");
                    System.out.println("Introduce un URL");
                    url = reader.next();
                    CatalogoWeb.getCatalogoWeb().borrarWeb(url);
                    System.out.println("");
                    System.out.println("Se ha borrado correctamente");
                    break;
                }

                case 7: {
                    System.out.println("");
                    CatalogoWeb.getCatalogoWeb().guardarWebs();
                    System.out.println("");
                    System.out.println("Se han guardado los datos");
                    break;
                }

                case 8: {
                    System.out.println("");
                    ListaWebs lW = CatalogoWeb.getCatalogoWeb().webOrdenada();
                    this.imprimirLista(lW);
                    break;
                }

                case 0: break;    
            }
        }
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.inicializarPrograma();
    }
}
