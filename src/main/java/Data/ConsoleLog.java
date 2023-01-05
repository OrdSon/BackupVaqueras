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
/*PENDIENTE DE IMPLEMENTAR*/
public class ConsoleLog extends Expresion {

    ListaValores valores;

    public ConsoleLog(ListaValores valores, int linea, int columna) {
        this.valores = valores;
        this.linea = linea;
        this.columna = columna;
        String label = "WRITELINE";
        id = getNewId();
    }

    @Override
    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("\n");
        if (valores != null) {
            for (Valor valor : valores) {
                String tempId = getNewId();
                sb.append(id).append("->").append(tempId).append("\n");
                sb.append(tempId).append("[label =\"").append(valor.toString()).append("\"];").append("\n");
            }
        }
        sb.append(id).append("[label =\"").append("WRITELINE").append("\"];").append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("print(");
        for (Valor valore : valores) {
            sb.append(valore.toString());
        }
        sb.append(")");
        return sb.toString();

    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Valor valore : valores) {
            sb.append(valore.toString());
        }
        return sb.toString();
    }

}
