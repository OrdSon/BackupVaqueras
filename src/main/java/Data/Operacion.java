/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class Operacion extends Expresion{

    String signo;
    Valor valor;

    public Operacion( Valor valor) {
        this.valor = valor;
    }
    public Operacion(String signo, Valor valor) {
        this.signo = signo;
        this.valor = valor;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }
    
    
    
    
}
