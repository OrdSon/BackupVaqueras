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
public class ListaOperaciones extends LinkedList<Operacion> {
    public ListaOperaciones append(Operacion operacion){
        add(operacion);
        return this;
    }
}
