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
public class DoWhile extends Expresion {

    private ListaExpresiones expresiones;
    private ListaCondiciones condiciones;

    public DoWhile(ListaExpresiones expresiones, ListaCondiciones condiciones, int linea, int columna) {
        this.expresiones = expresiones;
        this.condiciones = condiciones;
        this.linea = linea;
        this.columna = columna;
        salida = "while True: \n" + expresiones.toString() + "if ( " + condiciones.toString() + " ):" + " \n break";
        this.id = getNewId();
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idExpresiones = getNewId();
        String idWhile = getNewId();
        sb.append(id).append("\n");
        if (expresiones != null && !expresiones.isEmpty()) {
            sb.append(id).append("->").append(idExpresiones).append("\n");
            for (Expresion expresion : expresiones) {
                if (!expresion.getGraph().isBlank() && !expresion.getGraph().isEmpty()) {
                    sb.append(idExpresiones).append("->").append(expresion.getGraph()).append("\n");
                }
            }
            sb.append(idExpresiones).append("[label =\"").append("Expresiones").append("\"];").append("\n");
        }
        if (condiciones != null) {
            sb.append(id).append("->").append(idWhile).append("\n");
            for (Condicion condicion : condiciones) {
                if (!condicion.getGraph().isBlank() && !condicion.getGraph().isEmpty()) {
                    sb.append(idWhile).append("->").append(condicion.getGraph()).append("\n");
                }
            }
            sb.append(idWhile).append("[label = \"").append("While").append("\"];").append("\n");
            sb.append(id).append("[label =\"").append("DO").append("\"];").append("\n");

        }
        return sb.toString();
    }

    public ListaExpresiones getExpresiones() {
        return expresiones;
    }

    public void setExpresiones(ListaExpresiones expresiones) {
        this.expresiones = expresiones;
    }

    public ListaCondiciones getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(ListaCondiciones condiciones) {
        this.condiciones = condiciones;
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
