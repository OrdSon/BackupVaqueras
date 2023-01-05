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
//Posible herencia a Expresion
public class Valor {

    private String cadena;
    boolean entero;
    private double decimal;
    private String tipoValor;
    Llamada llamada;
    int linea;
    int columna;

    public Valor(String cadena, String tipoValor, int linea, int columna) {
        this.cadena = cadena;
        this.tipoValor = tipoValor;
        this.linea = linea;
        this.columna = columna;
        this.tipoValor = "cadena";
    }

    public Valor(Llamada llamada, String tipoValor, int linea, int columna) {
        this.llamada = llamada;
        this.tipoValor = tipoValor;
        this.linea = linea;
        this.columna = columna;
        this.tipoValor = "llamada";
    }

    public Valor(double decimal, int linea, int columna, boolean entero) {
        this.decimal = decimal;
        this.tipoValor = "doubleValue";
        this.linea = linea;
        this.columna = columna;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.tipoValor = "stringValue";
        this.cadena = cadena;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.tipoValor = "doubleValue";
        this.decimal = decimal;
    }

    public String getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(String tipoValor) {
        this.tipoValor = tipoValor;
    }

    @Override
    public String toString() {
        switch (tipoValor) {//PENDIENTE METODO PARA BUSCAR VALOR DE VARIABLE
            case "stringValue": {
                if (cadena != null) {
                    return cadena;
                }
            }
            case "doubleValue" :{
                return decimal + "";
            }

            case "intValue": {
                return (int) decimal + "";
            }
            default: {
                return cadena;
            }
        }
        //PENDIENTE METODO PARA BUSCAR VALOR DE VARIABLE
    }

}
