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
public class If extends Expresion {

    private ListaCondiciones condiciones;
    private ListaExpresiones expresiones;
    private ListaExpresiones orElse;
    String label = "If";
    private boolean valor;
    private If oSiNo;

    public If(ListaCondiciones condiciones, ListaExpresiones expresiones, int linea, int columna) {
        this.condiciones = condiciones;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        id = getNewId();
    }

    public If(ListaCondiciones condiciones, ListaExpresiones expresiones, If oSiNo, boolean valor, int linea, int columna) {
        this.condiciones = condiciones;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        this.oSiNo = oSiNo;
        id = getNewId();

    }

    public If(ListaCondiciones condiciones, ListaExpresiones expresiones, ListaExpresiones orElse, int linea, int columna) {
        this.condiciones = condiciones;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        this.orElse = orElse;
        id = getNewId();

    }

    public String getGraph() {
        StringBuilder sb = new StringBuilder();

        String idCondiciones = getNewId();
        String idExpresiones = getNewId();
        String idElse = getNewId();
        String idOsino = getNewId();

        sb.append(id).append("\n");
        sb.append(id).append("[label = \"").append(label).append("\"];").append("\n");

        if (condiciones != null) {
            sb.append(id).append("->").append(idCondiciones).append("\n");
            for (Condicion condicion : condiciones) {
                if (!condicion.getGraph().isBlank() && !condicion.getGraph().isEmpty()) {
                    sb.append(idCondiciones).append("->").append(condicion.getGraph()).append("\n");
                }
            }
            sb.append(idCondiciones).append("[label = \"").append("Condiciones").append("\"];").append("\n");

        }
        if (expresiones != null) {
            sb.append(id).append("->").append(idExpresiones).append("\n");
            for (Expresion expresion : expresiones) {
                if (!expresion.getGraph().isBlank() && !expresion.getGraph().isEmpty()) {
                    sb.append(idExpresiones).append("->").append(expresion.getGraph()).append("\n");
                }
            }
            sb.append(idExpresiones).append("[label = \"").append("Expresiones").append("\"];").append("\n");

        }

        if (oSiNo != null && !oSiNo.getGraph().isBlank() && !oSiNo.getGraph().isEmpty()) {
            sb.append(id).append("->").append(idElse).append("\n");
            sb.append(idElse).append("->").append(oSiNo.getGraph()).append("\n");
            sb.append(idElse).append("[label = \"").append("Else").append("\"];").append("\n");

        }

        if (orElse != null) {
            sb.append(id).append("->").append(idOsino).append("\n");
            for (Expresion expresion : orElse) {
                if (!expresion.getGraph().isBlank() && !expresion.getGraph().isEmpty()) {
                    sb.append(idOsino).append("->").append(expresion.getGraph()).append("\n");
                }
            }
            sb.append(idOsino).append("[label = \"").append("Else").append("\"];").append("\n");

        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if ").append(condiciones.toString()).append(": \n");
        if (expresiones != null && !expresiones.isEmpty()) {

            sb.append(expresiones.toString());

        }
        if (oSiNo != null) {
            sb.append(Expresion.getTabs()).append("el").append(oSiNo.toString());
        }
        if (orElse != null) {
            //Expresion.cantTabs++;
            sb.append(Expresion.getTabs()).append("else").append("\n").append(orElse.toString());
            //Expresion.cantTabs--;
        }
        salida = sb.toString();
        return sb.toString();
    }

    public LinkedList<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(ListaCondiciones condiciones) {
        this.condiciones = condiciones;
    }

    public LinkedList<Expresion> getExpresiones() {
        return expresiones;
    }

    public void setExpresiones(ListaExpresiones expresiones) {
        this.expresiones = expresiones;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
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

    public LinkedList<Expresion> getOrElse() {
        return orElse;
    }

    public void setOrElse(ListaExpresiones orElse) {
        this.orElse = orElse;
    }

    public If getoSiNo() {
        return oSiNo;
    }

    public void setoSiNo(If oSiNo) {
        this.oSiNo = oSiNo;
    }

}
