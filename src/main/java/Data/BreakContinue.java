/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author OrdSon
 */
public class BreakContinue extends Expresion{
    private boolean freno;
    private boolean continuar;

    public boolean isFreno() {
        return freno;
    }

    public BreakContinue setFreno(boolean freno) {
        this.freno = freno;
        this.continuar = !freno;
        return this;
    }

    public boolean isContinuar() {
        return continuar;
    }

    public BreakContinue setContinuar(boolean continuar) {
        this.continuar = continuar;
        this.freno = !continuar;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (freno) {
            sb.append("break");
        }else{
            sb.append("continue");
        }
        return sb.toString();
    }

    
    
}
