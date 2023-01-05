/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class Comentario extends Expresion{
    String contenido;
    boolean multilinea;
    
    public Comentario(String contenido,boolean multilinea, int linea, int columna) {
        this.contenido = contenido;
        this.multilinea = multilinea;
        this.linea = linea;
        this.columna = columna;
    }
    
}
