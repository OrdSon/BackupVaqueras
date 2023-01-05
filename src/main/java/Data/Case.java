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
public class Case extends Expresion {

    private Valor valor;
    private ListaExpresiones expresiones;
    boolean freno;
    private boolean Default;
    String label = "Case";

    public Case(Valor valor, ListaExpresiones expresiones, boolean freno, int linea, int columna) {
        this.valor = valor;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        this.freno = freno;
        id = getNewId();
    }

    public Case(boolean defecto, ListaExpresiones expresiones, int linea, int columna) {
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        this.Default = defecto;
        id = getNewId();
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public ListaExpresiones getExpresiones() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //PENDIENTE
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!Default) {
            sb.append(valor.toString()).append(":").append("\n");
            sb.append(sb.append(expresiones.toString()));
            if (freno) {
                sb.append(Expresion.getTabs()).append("break");
            }
        } else {
            sb.append("default :");
            sb.append(Expresion.getTabs()).append(expresiones.toString());

        }
        return sb.toString();
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idExpresiones = getNewId();
        String idValor = getNewId();

        sb.append(id).append("\n");
       
        if (valor != null) {
            sb.append(id).append("->").append(idValor).append("\n");
            sb.append(idValor).append("[label =\" Valor: ").append(valor.toString()).append("\"];").append("\n");

        }
        if (expresiones != null && !expresiones.isEmpty()) {
            sb.append(id).append("->").append(idExpresiones).append("\n");
            for (Expresion expresion : expresiones) {
                if (!expresion.getGraph().isBlank()&&!expresion.getGraph().isEmpty()) {
                    sb.append(idExpresiones).append("->").append(expresion.getGraph()).append("\n");
                }
            }
            sb.append(idExpresiones).append("[label =\"").append("Expresiones").append("\"];").append("\n");

        }

        sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");
        return sb.toString();
    }

}
