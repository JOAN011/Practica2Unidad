/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.metodosOrdenacion.quickSort.ordenarShell;
import controlador.metodosOrdenacion.shell.ordenarQuicksort;

/**
 *
 * @author kali
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Nombre[] nombre = Nombre.values();
        //Apellido[] apellido = Apellido.values();
        //System.out.println(nombre[0] + "\n" + String.valueOf(nombre.length)+ "\n" +String.valueOf(apellido.length)+ "\n" +apellido[0]);
        //String valores = e.name().substring(3);
        //generarPersona generar = new generarPersona();
        int array[] = new int[]{2,3,6,7,5,8,1,0,4,9};
        array = new ordenarShell().shell(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

}
