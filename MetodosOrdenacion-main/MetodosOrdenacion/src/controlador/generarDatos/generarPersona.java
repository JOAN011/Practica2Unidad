/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.generarDatos;

import controlador.generarDatos.enums.Apellido;
import controlador.generarDatos.enums.Nombre;
import controlador.tda.lista.ListaEnlazadaServices;
import modelo.persona.Persona;

/**
 *
 * @author kali
 */
public class generarPersona {

    int id = 1;
    
    public Persona generar(){
        return new Persona(generarId(), generarNombre(), generarCedula(), generarTelf());
    }
    
    public ListaEnlazadaServices<Persona> generarLista(ListaEnlazadaServices<Persona> list, int Cantidad){
        for (int i = 0; i < Cantidad; i++) {
            list.insertarAlFinal(generar());
        }
        return list;
    }
    
    private int generarId(){
        return id++;
    }
    
    private String generarTelf(){
        String telf = "09";
        for (int i = 0; i < 8; i++) {
            telf = telf + String.valueOf(random(9));
        }
        return telf;
    }
    
    private String generarCedula(){
        String cedula = "11";
        for (int i = 0; i < 8; i++) {
            cedula = cedula + String.valueOf(random(9));
        }
        return cedula;
    }

    private String generarNombre() {
        Nombre[] nombre = Nombre.values();
        Apellido[] apellido = Apellido.values();
        String nombreCompleto = null;
        
        nombreCompleto = nombre[random(100)] + " " + apellido[random(100)];

        return nombreCompleto;
    }

    private int random(int limit) {
        return (int) (Math.random() * (limit + 1));
    }
}
