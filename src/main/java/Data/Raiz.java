/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author OrdSon
 */
public class Raiz {

    ListaExpresiones expresiones;

    public Raiz(ListaExpresiones expresiones) {
        this.expresiones = expresiones;
    }

    public String getGraph() {
        String text = "digraph G\n"
                + "{\n"
                +"graph [pad=\"0.5\", nodesep=\"1\", ranksep=\"2\"]"
                + "node[shape = rectangle] \n"
                + "node[style = filled] \n"
                + "node[fillcolor = \"#41e06c\"]\n"
                + "node[color=\"#9ce03d\"] \n"
                + "edge[color=\"#a66c4b\"] \n";
        try {
            for (Expresion expresion : expresiones) {

                text += "<RAIZ> -> " + expresion.getId() + "\n" + expresion.getGraph() + "\n";
            }
        } catch (NullPointerException e) {
            System.out.println("Error al procesar el arbol");
        }
        text += " }\n";
        dibujarArbol(text);
        return text;
    }
    
   
   private void escribirArbol(String contenido, String ruta){
       FileWriter fw;
       PrintWriter pw;
       
       try {
           fw = new FileWriter(ruta);
           pw = new PrintWriter(fw);
           pw.write(contenido);
           pw.close();
           fw.close();
       } catch (Exception e) {
           System.out.println(e);
       }   
   }
   
   private void dibujarArbol(String contenido){
       escribirArbol(contenido, "arbol.dot");
       ProcessBuilder pb = new ProcessBuilder("dot","-Tpng","-o","arbol.png","arbol.dot");
       pb.redirectErrorStream(true);
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(Raiz.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
}
