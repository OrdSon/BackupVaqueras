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
public class Funcion extends Expresion {

    String nombre;
    ListaParametros parametros;
    ListaExpresiones expresiones;
    String label = "Funcion";

    public Funcion(String tipoFuncion, String nombre, ListaParametros parametros, ListaExpresiones expresiones, int linea, int columna) {
        this.nombre = nombre;
        this.tipo = tipoFuncion;
        this.parametros = parametros;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
        id = "id"+(++Expresion.idCounter);
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idTipo = ++Expresion.idCounter + "";
        String idNombre = ++Expresion.idCounter + "";
        String idParams = ++Expresion.idCounter + "";
        String idExpresiones = ++Expresion.idCounter + "";

        sb.append(id).append("\n");
        sb.append(id).append("->").append(idTipo).append("\n");
        sb.append(id).append("->").append(idNombre).append("\n");
        sb.append(id).append("->").append(idParams).append("\n");
        sb.append(id).append("->").append(idExpresiones).append("\n");
        if (parametros != null && !parametros.isEmpty()) {
            for (Parametro parametro : parametros) {
                sb.append(idParams).append("->").append(parametro.getGraph()).append("\n");
            }
            sb.append(idParams).append("[label = \"").append("Parametros").append("\"];").append("\n");
        }
        if (expresiones != null && !expresiones.isEmpty()) {
            for (Expresion expresion : expresiones) {
                sb.append(idExpresiones).append("->").append(expresion.getGraph()).append("\n");
            }
            sb.append(idExpresiones).append("[label = \"").append("Expresiones").append("\"];").append("\n");
        }
        sb.append(id).append("[label = \"").append(label).append("\"];").append("\n");
        sb.append(idTipo).append("[label = \"Tipo: ").append(tipo).append("\"];").append("\n");
        sb.append(idNombre).append("[label = \"Nombre: ").append(nombre).append("\"];").append("\n");
        
        return sb.toString();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("def ").append(nombre).append("(");
        if (parametros != null && !parametros.isEmpty()) {
            sb.append(parametros.toString());
        }
        sb.append("):").append("\n");
        if (expresiones != null && !expresiones.isEmpty()) {
            sb.append(expresiones.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(ListaParametros parametros) {
        this.parametros = parametros;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
