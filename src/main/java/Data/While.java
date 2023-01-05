/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class While extends Expresion {

    private ListaExpresiones expresiones;
    private ListaCondiciones condiciones;
    String label = "While";
    
    public While(ListaExpresiones expresiones, ListaCondiciones condiciones, int linea, int columna) {
        this.expresiones = expresiones;
        this.condiciones = condiciones;
        this.linea = linea;
        this.columna = columna;
        this.id = getNewId();
    }
    
    @Override
    public String getGraph(){
        StringBuilder sb = new StringBuilder();
        String idExpresiones = getNewId();
        String idCondiciones = getNewId();
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
            sb.append(id).append("->").append(idCondiciones).append("\n");
            for (Condicion condicion : condiciones) {
                if (!condicion.getGraph().isBlank() && !condicion.getGraph().isEmpty()) {
                    sb.append(idCondiciones).append("->").append(condicion.getGraph()).append("\n");
                }
            }
            sb.append(idCondiciones).append("[label = \"").append("Condiciones").append("\"];").append("\n");
            sb.append(id).append("[label =\"").append("WHILE").append("\"];").append("\n");

        }
        
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("while ");
        if (condiciones != null) {
            sb.append(condiciones.toString()).append(" :").append("\n");
        }
        if (expresiones != null) {
            
            sb.append(expresiones.toString()).append("\n");
            
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
