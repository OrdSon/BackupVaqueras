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
public class ListaCondiciones extends LinkedList<Condicion>{
    
    public ListaCondiciones append(Condicion condicion){
        add(condicion);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Condicion thi : this) {
            sb.append(thi.toString()).append(" ");
        }
        return sb.toString();
    }
    
    
}
