/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author OrdSon
 */
import java.util.LinkedList;

/**
 *
 * @author OrdSon
 */
public class Formatter {

    LinkedList<String[]> bloques = new LinkedList<>();

    public Formatter() {

    }

    public String[] Reformat(String[] lineas, int init, int max, int left, int right, int tabs) {
        int contadorTabs = tabs;
        int limiteIzquierda = left;
        int limiteDerecha = right;
        //Desde el limite interior hasta el fin de las lineas
        //Recoleccion de bloques
        for (int i = limiteIzquierda; i < lineas.length; i++) {
            if (init > max) {
                break;
            }
            String muestra = lineas[i];
            if (contarTabs(lineas[i]) == contadorTabs) {
                limiteIzquierda = i;
                limiteDerecha = findRighLimit(lineas, limiteIzquierda, contadorTabs);

                Formatter subFormatter = new Formatter();
                String[] nuevo = subFormatter.giveArray(lineas, limiteIzquierda, limiteDerecha);
                bloques.add(subFormatter.Reformat(nuevo, init + 1, max, limiteIzquierda, limiteDerecha, tabs + 1));

                limiteIzquierda = limiteDerecha;
                i=limiteDerecha;
            }

        }
        LinkedList<String> nuevasLineas = new LinkedList<>();
        if (bloques.isEmpty()) {
            String muestra = lineas[0];
            return lineas;
        }
        for (int i = bloques.size(); i >= 0; i--) {
            String[] temp = bloques.get(i);
            for (int j = 0; j < temp.length; j++) {
                String muestra =temp[i];
                nuevasLineas.add(temp[i]);
            }
        }
        System.out.println(nuevasLineas.toString());
        return (String[]) nuevasLineas.toArray();
    }

    public String[] giveArray(String[] lineas, int limiteIzquierda, int limiteDerecha) {
        int size = limiteDerecha - limiteIzquierda-1;
        String[] nuevo = new String[size];
        int contador = 0;
        for (int i = limiteIzquierda; i < limiteDerecha-1; i++) {
            String muestra = lineas[i];
            nuevo[contador] = lineas[i];
        }
        return nuevo;

    }

    public int findRighLimit(String[] lineas, int currLine, int contadorTabs) {
        int limiteDerecha = 0;
        for (int j = currLine + 1; j < lineas.length; j++) {
            if (contarTabs(lineas[j]) == contadorTabs) {
                limiteDerecha = j;
            }
        }
        return limiteDerecha;
    }

    public int contarTabs(String linea) {
        char[] caracteres = linea.toCharArray();
        int contador = 0;
        for (int j = 0; j < caracteres.length; j++) {
            if (caracteres[j] == '\t') {
                contador++;
            }
        }
        return contador;
    }

}
