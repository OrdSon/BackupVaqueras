/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import gt.edu.usac.compiler.TokenConstants;

/**
 *
 * @author OrdSon
 */
public class Return extends Expresion {

    //PENDIENTE DE IMPLEMENTAR LLAMADAS Y NUEVOS VALORES
    private Valor valor;
    private boolean conValor;
    String label = "Return";
    ListaValores lista;

    public Return(Valor valor, int linea, int columna) {
        this.conValor = false;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.id = getNewId();

    }

    public Return(int linea, int columna) {
        this.conValor = false;
        this.linea = linea;
        this.columna = columna;
        this.id = getNewId();
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idValor = getNewId();

        if (valor != null) {
            sb.append(id).append("\n");
            sb.append(id).append("->").append(idValor).append("\n");
            sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");
            sb.append(idValor).append("[label =\"").append(valor.toString()).append("\"];").append("\n");

        }
        return  sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("return");
        if (valor != null) {
            sb.append(valor.toString());
        }
        return sb.toString();
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public boolean isConValor() {
        return conValor;
    }

    public void setConValor(boolean conValor) {
        this.conValor = conValor;
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
