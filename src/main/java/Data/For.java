/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.LinkedList;

/**
 *
 * @author OrdSon
 */
public class For extends Expresion {

    private DeclaracionFor declaracion;
    String label = "For";
    //private String identificador;
    //private Asignacion asignacion;

    //private Condicion condicion;
    // private String cambio;
    private ListaExpresiones expresiones;

    public For(DeclaracionFor declaracion, ListaExpresiones expresiones, int linea, int columna) {
        this.declaracion = declaracion;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        Expresion.cantTabs++;
        this.id = getNewId();
        declaracion.setId(getNewId());
        salida = "for " + declaracion.toString() + "\n";
        salida += Expresion.getTabs() + expresiones.toString();
        Expresion.cantTabs--;
    }

    public String toString() {
        return salida;
    }

    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idExpresiones = getNewId();
        sb.append(id).append("\n");
        sb.append(id).append("->").append(declaracion.getGraph()).append("\n");
        sb.append(id).append("->").append(idExpresiones).append("\n");
        sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");
        if (expresiones != null) {
            for (Expresion expresion : expresiones) {
                if (!expresion.getGraph().isBlank() && !expresion.getGraph().isEmpty()) {
                    sb.append(idExpresiones).append("->").append(expresion.getGraph()).append("\n");
                }
            }
            sb.append(idExpresiones).append("[label =\"").append("Expresiones").append("\"];").append("\n");

        }
        return sb.toString();
    }

    public LinkedList<Expresion> getExpresiones() {
        return expresiones;
    }

    public void setExpresiones(ListaExpresiones expresiones) {
        this.expresiones = expresiones;
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

    public DeclaracionFor getDeclaracion() {
        return declaracion;
    }

    public void setDeclaracion(DeclaracionFor declaracion) {
        this.declaracion = declaracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
