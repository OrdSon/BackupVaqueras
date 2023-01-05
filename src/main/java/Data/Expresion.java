/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import gt.edu.usac.compiler.TokenConstants;
import java.util.LinkedList;

/**
 *
 * @author OrdSon
 */
//SE SUPONE QUE NO TIENE QUE HACER NADA XDDDD
public class Expresion {

    int linea;
    int columna;
    String tipo;
    String salida;
    protected String id;
    public static LinkedList<String> errores = new LinkedList<>();

    static int cantTabs = 0;
    static int idCounter = 0;

    public static String getTabs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantTabs; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    public int getCantTabs() {
        return cantTabs;
    }

    public static void setCantTabs(int cantTabs) {
        Expresion.cantTabs = cantTabs;
    }

    String getGraph() {
        return "";
    }

    public void setId() {
        this.id = "id" + Expresion.idCounter;
        Expresion.idCounter++;
    }

    public void printId() {
        System.out.println(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewId() {
        return "id" + (++idCounter);
    }

}
