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
public class ListaExpresiones extends LinkedList<Expresion>{
    public ListaExpresiones append(Expresion expresion){
        add(expresion);
        return this;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Expresion.cantTabs++;
        int muestra = Expresion.cantTabs;
        for (Expresion thi : this) {
            if (thi!=null) {
                sb.append(Expresion.getTabs()).append(thi.toString()).append("\n");
            }
        }
        Expresion.cantTabs--;
        return sb.toString();
    }
    
    public String toEspecial(){
        StringBuilder sb = new StringBuilder();
        int muestra = Expresion.cantTabs;
        for (Expresion thi : this) {
            if (thi!=null) {
                sb.append(thi.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
