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
public class ListaParametros extends LinkedList<Parametro>{
    public ListaParametros append(Parametro parametro){
        add(parametro);
        return this;
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
        return  sb.toString();
    }
}
