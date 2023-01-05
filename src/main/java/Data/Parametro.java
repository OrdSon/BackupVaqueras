/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class Parametro extends Expresion {

    String nombre;
    String label = "Parametro";

    public Parametro(String nombre, String tipo, int linea, int columna) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
        id = "id"+(++Expresion.idCounter);
    }

    @Override
    public String toString() {
        return "var " + nombre;
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idTipo= "id"+(++Expresion.idCounter);        
        String idNombre = "id"+(++Expresion.idCounter);
        sb.append(id).append("\n");
        sb.append(id).append("->").append(idTipo).append("\n");
        sb.append(id).append("->").append(idNombre).append("\n");
        sb.append(id).append("[label = \"").append(label).append("\"];").append("\n");
        sb.append(idTipo).append("[label = \"").append(tipo).append("\"];").append("\n");
        sb.append(idNombre).append("[label = \"").append(nombre).append("\"];").append("\n");
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
