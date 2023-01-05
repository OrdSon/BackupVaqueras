/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class Error {
    private String cadena;
    private int linea;
    private int columna;
    String tipo ;
    String salida;
    String label = "Error";
    
    public Error(String cadena, String tipo,int linea, int columna) {
        this.cadena = cadena;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        salida = "Error "+tipo+" ; En linea "+linea+" Y columna"+columna;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Error{" + "cadena=" + cadena + ", linea=" + linea + ", columna=" + columna + ", tipo=" + tipo + '}';
    }


}
