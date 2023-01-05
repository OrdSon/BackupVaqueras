/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class Asignacion extends Expresion {

    String nombre;
    Valor valor;
    String label = "Asignacion";
    Llamada llamada;

    public Asignacion(String nombre, Valor valor, int linea, int columna) {
        this.nombre = nombre;
        this.valor = valor;
        this.nombre = nombre;
        this.columna = columna;
        id = "id" + (++Expresion.idCounter);
    }
    
    public Asignacion(String nombre, Llamada llamada, int linea, int columna) {
        this.nombre = nombre;
        this.llamada = llamada;
        this.nombre = nombre;
        this.columna = columna;
        id = "id" + (++Expresion.idCounter);
    }
    public Asignacion(String nombre, Valor valor,String signo, int linea, int columna) {
        this.nombre = nombre;
        this.valor = valor;
        this.nombre = nombre;
        this.columna = columna;
        id = "id" + (++Expresion.idCounter);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (valor != null && !valor.toString().isBlank()) {
            sb.append(nombre).append(" = ").append(valor.toString());
        } 
        return sb.toString();
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String id1 = getNewId();
        String id2 = getNewId();
        sb.append(id).append("->").append(id1).append("\n");
        sb.append(id).append("->").append(id2).append("\n");

        sb.append(id).append("[label=\"").append(label).append("\"];").append("\n");
        sb.append(id1).append("[label=\"").append(nombre).append("\"];").append("\n");
        if (this.valor != null) {
            sb.append(id2).append("[label=\"").append(valor.toString()).append("\"];").append("\n");
        }if(llamada != null){
            sb.append(id).append("->").append(llamada.getGraph());
        }
        return sb.toString();
    }

}
