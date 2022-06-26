/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.json;

import com.google.gson.Gson;
import controlador.tda.lista.ListaEnlazadaServices;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.persona.Persona;

/**
 *
 * @author kali
 */
public class JsonController {

    public void guardar(Object obj, String url) throws IOException {
        // TODO code application logic here

        /**
         * List<Usuario> personalist = new ArrayList<Usuario>();
         * personalist.add(u1);
        personalist.add(u2);
         */
        BufferedWriter bw = new BufferedWriter(new FileWriter(url));
        //user = new Usuario(1, "Pepe el Mago", "joanriofriob", "joanriofriob@yahoo.es", new Address(2, "Loja", "Apt.556", "Gonzanama", "s/n"), "07-2664-515", "joan.riofrio.com", new Position(2, -43.9509, -34.4618));

        //ListaEnlazadaServices<Persona> personasList = new ListaEnlazadaServices<>();
        //personasList.insertarAlFinal(p2);
        //personasList.insertarAlFinal(p3);
        Gson gson = new Gson();

        String json = gson.toJson(obj);
        System.out.println("Json a Guardar: \n" + json);
        bw.write(json);
        bw.close();

        System.out.println(json);
    }

    public ListaEnlazadaServices leer(String url) throws FileNotFoundException, IOException {
        String json = "";

        BufferedReader br = new BufferedReader(new FileReader(url));
        String linea = "";
        int i = 0;
        while ((linea = br.readLine()) != null) {
            json += linea;
        }
        br.close();

        System.out.println(json);

        Gson gson = new Gson();
        //Pelicula peli = gson.fromJson(json, Pelicula.class);
        ListaEnlazadaServices<Persona> listaPersonas = gson.fromJson(json, ListaEnlazadaServices.class);
        
        listaPersonas = obtenerObjetos(listaPersonas);
        
        //System.out.println(listaPersonas.obtenerDato(0).getCedula());
        return listaPersonas;
    }

    public Persona leerPersonaFile(String url) throws FileNotFoundException, IOException {
        String json = "";

        BufferedReader br = new BufferedReader(new FileReader(url));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            json += linea;
        }

        br.close();

        System.out.println(json);

        Gson gson = new Gson();
        //Pelicula peli = gson.fromJson(json, Pelicula.class);
        Persona listaPersonas = gson.fromJson(json, Persona.class);
        return listaPersonas;
    }

    public Persona leerPersonaObj(String json) throws FileNotFoundException, IOException {

        Gson gson = new Gson();
        //Pelicula peli = gson.fromJson(json, Pelicula.class);
        Persona listaPersonas = gson.fromJson(json, Persona.class);
        return listaPersonas;
    }

    private ListaEnlazadaServices obtenerObjetos(ListaEnlazadaServices<Persona> lista) throws FileNotFoundException, IOException { 
        Persona personaJson;
        ListaEnlazadaServices<Persona> listaPersonas = new ListaEnlazadaServices<>();
        
        for (int i = 0; i < lista.getSize(); i++) {
            String objetoPersona = String.valueOf(lista.obtenerDato(i));
            String replace = objetoPersona.replace('=', ':');
            replace = replace.replace(",", "\",\"");
            replace = replace.replace(":", "\":\"");
            replace = replace.replace("{", "{\"");
            replace = replace.replace("}", "\"}");
            replace = replace.replace(" ", "");
            
            personaJson = leerPersonaObj(replace);
            listaPersonas.insertarAlFinal(personaJson);
        }
        //Pelicula peli = gson.fromJson(json, Pelicula.class);
        

        //System.out.println(listaPersonas.obtenerDato(0).getCedula());
        return listaPersonas;
    }
}
