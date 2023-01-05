/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
//PENDIENTE DE IMPLEMENTAR METODO DE RESOLUCION
public class Condicion extends Expresion {

    private String valor; //True o false
    private boolean negado;
    private boolean simple;//solo tiene un valor
    String signoLogico;
    private String signo;
    private Valor izq;
    private Valor der;
    String salida;
    String label = "Condicion";

    public Condicion(String signo, Valor izq, Valor der, int linea, int columna) {
        this.signo = signo;
        this.izq = izq;
        this.der = der;
        this.linea = linea;
        this.columna = columna;
        this.simple = false;

        salida = izq + " " + signo + " " + der;
        id = getNewId();
    }

    public Condicion(Valor izq, boolean negado, int linea, int columna) {
        this.izq = izq;
        this.negado = negado;
        this.linea = linea;
        this.columna = columna;
        this.simple = true;
        id = getNewId();
    }

    public Condicion(String valor, boolean negado, int linea, int columna) {
        this.negado = negado;
        this.linea = linea;
        this.columna = columna;
        this.simple = true;
        this.valor = valor;
        if (negado) {
            salida = "!" + valor;
        } else {
            salida = valor;
        }
        id = getNewId();
    }

    @Override
    public String getGraph() {

        StringBuilder sb = new StringBuilder();
        String idSigno = getNewId();
        String idValorIzq = getNewId();
        String idValorDerecha = getNewId();
        String idSignoLogico = getNewId();

        sb.append(id).append("\n");
        sb.append(id).append("[label =\"").append(label).append("\"];").append("\n");

        if (signoLogico != null) {
            sb.append(id).append("->").append(idSignoLogico).append("\n");
            sb.append(idSignoLogico).append("[label =\"").append(signoLogico).append("\"];").append("\n");

        }
        if (izq != null) {
            sb.append(id).append("->").append(idValorIzq).append("\n");
            sb.append(idValorIzq).append("[label =\"").append(izq.toString()).append("\"];").append("\n");

        }
        if (signo != null) {
            sb.append(id).append("->").append(idSigno).append("\n");
            sb.append(idSigno).append("[label =\"").append(signo).append("\"];").append("\n");

        }
        if (der != null) {
            sb.append(id).append("->").append(idValorDerecha).append("\n");
            sb.append(idValorDerecha).append("[label =\"").append(der.toString()).append("\"];").append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        if (signoLogico != null && !signoLogico.isBlank() && !signoLogico.isEmpty()) {
            return signoLogico + " " + salida;
        }
        return salida;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isNegado() {
        return negado;
    }

    public void setNegado(boolean negado) {
        this.negado = negado;
    }

    public boolean isSimple() {
        return simple;
    }

    public void setSimple(boolean simple) {
        this.simple = simple;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public Valor getIzq() {
        return izq;
    }

    public void setIzq(Valor izq) {
        this.izq = izq;
    }

    public Valor getDer() {
        return der;
    }

    public void setDer(Valor der) {
        this.der = der;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSignoLogico() {
        return signoLogico;
    }

    public void setSignoLogico(String signoLogico) {
        this.signoLogico = signoLogico;
    }

}
