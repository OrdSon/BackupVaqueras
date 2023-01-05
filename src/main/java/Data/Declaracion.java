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
public class Declaracion extends Expresion {

    String nombre;
    ListaString identificadores;
    Valor valor;
    String label = "Declaracion";

    /**
     * Crea declaraciones del tipo: Tipo id1, id2, id3 ...idN = Valor;
     *
     * @param tipoValor
     * @param identificadores
     * @param valor
     * @param linea
     * @param columna
     */
    public Declaracion(String tipoValor, ListaString identificadores, Valor valor, int linea, int columna) {
        this.tipo = tipoValor;
        this.valor = valor;
        this.identificadores = identificadores;
        this.linea = linea;
        this.columna = columna;
        if (valor != null) {
            this.salida = "var  " + identificadores.toString() + " = " + valor.toString();
        } else {
            this.salida = "var  " + identificadores.toString();
        }
        this.id = "id" + (++Expresion.idCounter);
    }

    /**
     *
     * @param tipo
     * @param identificadores
     *
     * Crea declaracion del tipo: Tipo id1, id2, id3 ... idN;
     * @param linea
     * @param columna
     */
    public Declaracion(String tipo, ListaString identificadores, int linea, int columna) {
        this.tipo = tipo;
        this.identificadores = identificadores;
        this.linea = linea;
        this.columna = columna;
        this.salida = "var  " + identificadores.toString();
        this.id = "id" + (++Expresion.idCounter);

    }

    /**
     * Crea declaraciones del tipo: Tipo id1;
     *
     * @param tipoValor
     * @param nombre
     * @param linea
     * @param columna
     */
    public Declaracion(String tipoValor, String nombre, int linea, int columna) {
        this.tipo = tipoValor;
        this.nombre = nombre;
        this.linea = linea;
        this.columna = columna;
        this.salida = "var  " + nombre;
        this.id = "id" + (++Expresion.idCounter);

    }

    public Declaracion(String tipoValor, String nombre, Valor valor, int linea, int columna) {
        this.tipo = tipoValor;
        this.nombre = nombre;
        this.linea = linea;
        this.columna = columna;
        this.valor = valor;
        this.salida = "var  " + nombre;
        this.id = "id" + (++Expresion.idCounter);

    }

    @Override
    public String toString() {
        return salida;
    }

    public String toSpecialString() {
        StringBuilder sb = new StringBuilder();
        if (tipo != null && !tipo.isEmpty()) {
            sb.append(tipo).append(" ");
        }
        if (nombre != null && !nombre.isEmpty()) {
            sb.append(nombre).append(" ");
        } else if (identificadores != null) {
            sb.append(identificadores.toString());
        }
        if (valor != null) {
            sb.append(" = ").append(valor.toString());
        }
        sb.append(";  ").append("row: ").append(linea).append(" col:").append(columna);
        return sb.toString();

    }

    public String getTipoValor() {
        return tipo;
    }

    public void setTipoValor(String tipoValor) {
        this.tipo = tipoValor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<String> getIdentificadores() {
        return identificadores;
    }

    public void setIdentificadores(ListaString identificadores) {
        this.identificadores = identificadores;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
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

    public String getFirst() {
        if (identificadores != null) {
            return identificadores.getFirst();
        }
        return nombre;
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String idValor = "id" + (++Expresion.idCounter);
        sb.append(id).append("\n");
        if (identificadores != null) {
            for (String identificador : identificadores) {
                String idTemporal = "id" + (++Expresion.idCounter);
                sb.append(id).append("->").append(idTemporal).append("\n");
                sb.append(idTemporal).append("[label =\"").append(identificador).append("\"];").append("\n");
            }
        } else {
            String idTemporal = "id" + (++Expresion.idCounter);
            sb.append(id).append("->").append(idTemporal).append("\n");
            sb.append(idTemporal).append("[label =\"").append(nombre).append("\"];").append("\n");
        }
        sb.append(id).append("->").append(idValor).append("\n");
        sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");
        if (this.valor != null) {
            sb.append(idValor).append("[label =\"").append(valor.toString()).append("\"];").append("\n");
        }
        return sb.toString();
    }
}
