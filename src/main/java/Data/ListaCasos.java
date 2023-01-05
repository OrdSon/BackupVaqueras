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
public class ListaCasos extends LinkedList<Case>{
    public ListaCasos append(Case caso){
        add(caso);
        return this;
    }
    
    public String toString(){
        Expresion.cantTabs++;
        StringBuilder sb = new StringBuilder();
        for (Case thi : this) {
            sb.append(Expresion.getTabs()).append(thi.toString());
        }
        Expresion.cantTabs--;
        sb.append("\n");
        return sb.toString();
    }
    
}
