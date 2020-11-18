package labo1;
import java.util.Scanner;

import Estructuras.Graph;
import Estructuras.UnorderedCircularLinkedList;


public class Menu {
    Scanner reader;
    Graph g;

    public Menu() {
        this.reader = new Scanner(System.in);
        this.g = new Graph();
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
        boolean carg = false;

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
            System.out.println("9 - Cargar datos al grafo");
            System.out.println("10 - Buscar webs enlazadas");
            System.out.println("11 - Imprimir el grafo");
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
                    carg = true;
                    break;
                }
                
                case 2: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
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
                    }
                    
                    break;
                }

                case 3: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println("");
                    System.out.println("Introduce el URL de una web");
                    url = reader.next();
                    CatalogoWeb.getCatalogoWeb().addWeb(url);
                    }
                    
                    break;
                }

                case 4: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println("");
                        System.out.println("Introduce el URL de una web");
                        url = reader.next();
                        ListaWebs lW = CatalogoWeb.getCatalogoWeb().enlacesSalientes(url);
                        System.out.println("");
                        this.imprimirLista(lW);
                    }
                    
                    break;
                }

                case 5: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println("");
                        System.out.println("Introduce una palabra");
                        url = reader.next();
                        UnorderedCircularLinkedList<Web> lW = CatalogoPalabras.getCatalogoPalabras().word2Webs(url);
                        lW.visualizarNodos();
                    }
                    
                    break;
                }

                case 6: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println("");
                        System.out.println("Introduce un URL");
                        url = reader.next();
                        CatalogoWeb.getCatalogoWeb().borrarWeb(url);
                        System.out.println("");
                        System.out.println("Se ha borrado correctamente");
                    }
                    
                    break;
                }

                case 7: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    System.out.println("");
                    CatalogoWeb.getCatalogoWeb().guardarWebs();
                    System.out.println("");
                    System.out.println("Se han guardado los datos");
                    break;
                }

                case 8: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println("");
                        CatalogoWeb.getCatalogoWeb().webOrdenada();
                        System.out.println("Se ha ordenado correctamente");
                    }
                    break;
                }

                case 9: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println();
                        CatalogoWeb.getCatalogoWeb().cargarGrafo(g);
                        System.out.println("Se han cargado los datos al grafo");
                    }
                    
                    break;
                }

                case 10: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println();
                        System.out.println("Escribe el link de una web");
                        String s1 = reader.next();
                        System.out.println("Escribe el link de otra web");
                        String s2 = reader.next();
                        System.out.println();
                        if (g.estanConectados(s1, s2)) {
                            System.out.println("Las webs están conectadas");
                        } else {
                            System.out.println("Las webs no están conectadas");
                        }
                    }
                   
                    break;
                }

                case 11: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        System.out.println();
                        System.out.println("Imprimir grafo");
                        g.print();
                    }
                    
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
