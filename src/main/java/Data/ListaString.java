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
//USADA PARA LISTAS DE IDENTIFICADORES
public class ListaString extends LinkedList<String>{
    public ListaString append(String cadena){
        add(cadena);
        return this;
    }
    
    @Override
    public String getFirst(){
        if (!isEmpty()) {
            return get(0);
        }
        return "no value on StringList";
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            if (i+1 == size()) {
                sb.append(get(i));
            }else{
                sb.append(get(i)).append(", ");
            }
        }
        return sb.toString();
    }
}
