/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class DeclaracionFor {

    private Declaracion declaracion;
    private Condicion Condicion;
    String cambio;
    String salida;
    String label = "Condicion Ciclo";
    String id;

    public DeclaracionFor(Declaracion declaracion, Condicion condicion, String cambio) {
        this.declaracion = declaracion;
        this.Condicion = condicion;
        this.cambio = cambio;
        salida = declaracion.getFirst() + " in range(" + condicion.getIzq().toString() + ", " + condicion.getDer() + "):";

    }

    public String getGraph() {
        StringBuilder sb = new StringBuilder();
        String newId = "id" + (++Expresion.idCounter);
        sb.append(id).append("\n");
        sb.append(id).append("->").append(declaracion.getGraph()).append("\n");
        sb.append(id).append("->").append(Condicion.getGraph()).append("\n");
        sb.append(newId).append("[label =\"").append(cambio).append("\"];").append("\n");
        sb.append(id).append("->").append(newId).append("\n");
        sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return salida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Declaracion getDeclaracion() {
        return declaracion;
    }

    public void setDeclaracion(Declaracion declaracion) {
        this.declaracion = declaracion;
    }

    public Condicion getAsignacion() {
        return Condicion;
    }

    public void setAsignacion(Condicion Condicion) {
        this.Condicion = Condicion;
    }

    public Condicion getCondicion() {
        return Condicion;
    }

    public void setCondicion(Condicion Condicion) {
        this.Condicion = Condicion;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

}
