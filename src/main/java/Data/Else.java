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
public class Else extends Expresion {

    LinkedList<Condicion> condiciones;
    LinkedList<Expresion> expresiones;
    Else oSiNo;

    public Else(LinkedList<Condicion> condiciones, LinkedList<Expresion> expresiones, int linea, int columna) {
        this.condiciones = condiciones;
        this.expresiones = expresiones;
        this.linea = linea;
        this.columna = columna;
    }

    public Else(LinkedList<Condicion> condiciones, LinkedList<Expresion> expresiones, Else oSiNo, int linea, int columna) {
        this.condiciones = condiciones;
        this.expresiones = expresiones;
        this.oSiNo = oSiNo;
        this.linea = linea;
        this.columna = columna;
    }

}
