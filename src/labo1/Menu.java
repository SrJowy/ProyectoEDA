package labo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Estructuras.Graph;
import Estructuras.Par;
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

    private void imprimirLinkedList(LinkedList<String> l) {
        for(int i = 0; i<l.size();i++) {
            System.out.println(l.get(i));
        }
    }

    public void inicializarPrograma() {
        int n = -1;
        String url = " ";
        boolean carg = false;
        boolean grafoC = false;
        boolean pr = false;

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
            System.out.println("12 - Calcular un enlaces en un tiempo determinado");
            System.out.println("13 - Calcular el Page Rank");
            System.out.println("14 - Lista ordenada dada una palabra");
            System.out.println("15 - Lista ordenada dada dos palabras");
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
                        grafoC = true;
                    }
                    
                    break;
                }

                case 10: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        if (!grafoC) System.out.println("Por favor, carga antes el grafo");
                        else {
                            System.out.println();
                            System.out.println("Escribe el link de una web");
                            String s1 = reader.next();
                            System.out.println("Escribe el link de otra web");
                            String s2 = reader.next();
                            System.out.println();
                            LinkedList <String> l = g.estanConectados(s1, s2);
                            if (!l.isEmpty()) {
                                System.out.println("Las webs están conectadas");
                                System.out.println("<");
                                imprimirLinkedList(l);
                                System.out.println(">");
                            } else {
                                System.out.println("Las webs no están conectadas");
                            }
                        }
                        
                    }
                   
                    break;
                }

                case 11: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        if (!grafoC) System.out.println("Por favor, carga antes el grafo");
                        else {
                            System.out.println();
                            System.out.println("Imprimir grafo");
                            g.print();
                        }
                    }
                    
                    break;
                }

                case 12: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        if (!grafoC) System.out.println("Por favor, carga antes el grafo");
                        else {
                            StopWatch s = new StopWatch();
                            s.start();
                            System.out.println("Introduce el tiempo en segundos");
                            int time = reader.nextInt();
                            int i = 0;
                            int j = 0;
                            String s1 = g.devolverKeys()[j];
                            while(s.getElapsedTimeSecs() != time && j != g.devolverKeys().length) {
                                String s2 = g.devolverKeys()[i];
                                g.estanConectados(s1, s2);
                                i++;
                                if (i == g.devolverKeys().length)  {
                                    j++;
                                    s1 = g.devolverKeys()[j];
                                    i = 0;
                                }
                            }
                        s.stop();
                        System.out.println("Tiempo transcurrido" + s.getElapsedTimeSecs());
                        System.out.println("Número de enlaces calculados = " + i);
                        }
                        
                    }
                    break;

                }

                case 13: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        if (!grafoC) System.out.println("Por favor, carga antes el grafo");
                        else {
                            System.out.println("Se va a proceder a calcular el Page Rank");
                            g.calcularPR();
                            System.out.println();
                            System.out.println("Acción completada");
                            pr = true;
                        }
                    }
                    break;
                }

                case 14: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        if (!grafoC) System.out.println("Por favor, carga antes el grafo");
                        else {
                            if (!pr) System.out.println("Por favor, calcula el Page Rank antes");
                            else {
                                System.out.println("Introduce una palabra");
                                System.out.printf("--> ");
                                String palabra = reader.next();
                                System.out.println();
                                ArrayList<Par> l = g.buscar(palabra);
                                System.out.println("///////////Lista///////////");
                                g.imprimirListaPares(l);
                                System.out.println("///////////////////////////");
                            }
                        }
                    }
                    break; 
                }

                case 15: {
                    if (!carg) System.out.println("Por favor, carga antes las webs");
                    else {
                        if (!grafoC) System.out.println("Por favor, carga antes el grafo");
                        else {
                            if (!pr) System.out.println("Por favor, calcula el Page Rank antes");
                            else {
                                System.out.println("Introduce una palabra");
                                System.out.printf("--> ");
                                String p1 = reader.next();
                                System.out.println("Introduce una palabra");
                                System.out.printf("--> ");
                                String p2 = reader.next();
                                System.out.println();
                                ArrayList<Par> l = g.buscar(p1,p2);
                                System.out.println("///////////Lista///////////");
                                g.imprimirListaPares(l);
                                System.out.println("///////////////////////////");
                            }
                        }
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