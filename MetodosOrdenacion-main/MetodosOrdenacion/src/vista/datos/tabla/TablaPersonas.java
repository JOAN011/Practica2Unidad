/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.datos.tabla;

import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.persona.Persona;

/**
 *
 * @author kali
 */
public class TablaPersonas extends AbstractTableModel{

    private ListaEnlazadaServices<Persona> lista;
    
    public ListaEnlazadaServices<Persona> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazadaServices<Persona> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Cedula";
            case 3: return "Telefono";
            default: return null;
        }
    }
    
    @Override
    public Object getValueAt(int arg0, int arg1) {
        Persona persona = lista.obtenerDato(arg0);
        switch(arg1) {
            case 0: return (arg0+1);
            case 1: return persona.getNombre();
            case 2: return persona.getCedula();
            case 3: return persona.getTelefono();
            default: return null;
        }
    }
    
}
