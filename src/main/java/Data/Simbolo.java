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
public class Simbolo {
    TokenConstants tipo;
    String nombre;
    Valor valor;
    int linea;
    int columna;

    public Simbolo(TokenConstants tipo, String nombre, Valor valor, int linea, int columna) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
    
}
