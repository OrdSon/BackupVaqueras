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
public class ListaValores extends LinkedList<Valor>{
    public ListaValores append(Valor valor){
        add(valor);
        return this;
    }
    
    public String toSpecialString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            if (i + 1 == size()) {
                builder.append(get(i).toString());
                break;
            }else{
                builder.append(get(i).toString()).append(", ");
            }
        }
        return  builder.toString();
    }
}
