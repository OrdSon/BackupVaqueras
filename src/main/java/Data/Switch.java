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
public class Switch extends Expresion {

    ListaCasos cases;
    String identificador;
    ListaExpresiones expresiones;
    String label = "Switch";

    public Switch(String condicion, ListaCasos cases, ListaExpresiones expresiones, int linea, int columna) {
        this.cases = cases;
        this.identificador = condicion;
        this.linea = linea;
        this.columna = columna;
        this.expresiones = expresiones;
        id = getNewId();
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idCondicion = getNewId();
        String idCasos = getNewId();
        String idDefault = getNewId();

        sb.append(id).append("\n");
        sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");
        sb.append(id).append("->").append(idCondicion).append("\n");
        sb.append(idCondicion).append("[label =\"Condicion: ").append(identificador).append("\"];").append("\n");
        sb.append(id).append("->").append(idCasos).append("\n");
        sb.append(idCasos).append("[label =\"").append("Casos").append("\"];").append("\n");

        for (Case caso : cases) {
            sb.append(idCasos).append("->").append(caso.getGraph()).append("\n");
        }

        if (expresiones != null && !expresiones.isEmpty()) {
            sb.append(id).append("->").append(idDefault).append("\n");
            for (Expresion expresion : expresiones) {
                if (!expresion.getGraph().isBlank() && !expresion.getGraph().isEmpty()) {
                    sb.append(idDefault).append("->").append(expresion.getGraph()).append("\n");
                }
            }
        }

        sb.append(idDefault).append("[label =\"").append("Default").append("\"];").append("\n");

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("def switch (case, ").append(identificador).append("):").append("\n");
        sb.append(Expresion.getTabs()).append("switcher = {").append("\n");
        if (cases != null) {
            sb.append(cases.toString());
            sb.append("\n");
        }
        if (expresiones != null) {
            sb.append(Expresion.getTabs()).append(expresiones.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public ListaCasos getCases() {
        return cases;
    }

    public void setCases(ListaCasos cases) {
        this.cases = cases;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ListaExpresiones getExpresiones() {
        return expresiones;
    }

    public void setExpresiones(ListaExpresiones expresiones) {
        this.expresiones = expresiones;
    }

}
