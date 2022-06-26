/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.metodosOrdenacion.quickSort;

import controlador.tda.lista.ListaEnlazadaServices;
import modelo.persona.Persona;

/**
 *
 * @author Usuario iTC
 */
public class ordenarShell {

    public int[] shell(int[] arregloSinOrdenar) {
        int[] arreglo = darCopiaValores(arregloSinOrdenar);
        int n = arreglo.length;
        int salto = n;
        boolean ordenado;
        while (salto > 1) {
            salto = salto / 2;
            do {
                ordenado = true;
                for (int j = 0; j <= n - 1 - salto; j++) {
                    int k = j + salto;
                    if (arreglo[j] > arreglo[k]) {
                        int aux = arreglo[j];
                        arreglo[j] = arreglo[k];
                        arreglo[k] = aux;
                        ordenado = false;
                    }
                }
            } while (!ordenado);
        }
        return arreglo;
    }

    public int[] darCopiaValores(int[] arreglo) {
        int[] arregloNuevo = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            arregloNuevo[i] = arreglo[i];
        }
        return arregloNuevo;
    }
    
    public ListaEnlazadaServices<Persona> listaEnlzadashell(ListaEnlazadaServices<Persona> listSinOrdenar){
        ListaEnlazadaServices<Persona> list = CopiaValores(listSinOrdenar);
        int n = list.getSize();
        int salto = n;
        boolean ordenado;
        while (salto > 1) {
            
            salto = salto / 2;
            do {
                ordenado = true;
                for (int j = 0; j <= n - 1 - salto; j++) {
                    int k = j + salto;
                    if (list.obtenerDato(j).getNombre().compareTo(list.obtenerDato(k).getNombre()) < 0) {
                        Persona aux = list.obtenerDato(j);
                        list.insertar(list.obtenerDato(k), j);
                        list.insertar(aux, k);
                        ordenado = false;
                    }
                }
            } while (!ordenado);
        }
        return list;
    } 
    
    public ListaEnlazadaServices<Persona> CopiaValores(ListaEnlazadaServices<Persona> list){
        ListaEnlazadaServices<Persona> nuevaList  = list;
        return nuevaList;
    }
    public String[] ObtenerDatos(ListaEnlazadaServices<Persona> list){
        String[] datos = new String[list.getSize()];
        for (int i = 0; i < list.getSize(); i++) {
            datos[i] = list.obtenerDato(i).getNombre();
        }
        return datos;
    }
    
}
