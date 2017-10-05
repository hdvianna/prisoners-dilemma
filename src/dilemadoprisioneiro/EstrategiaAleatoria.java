package dilemadoprisioneiro;
/*
 * EstrategiaAleatoria.java
 *
 * Created on 2 de Junho de 2007, 17:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.util.Random;

/**
 *
 * @author 200120117
 */
public class EstrategiaAleatoria extends Estrategia {
    public EstrategiaAleatoria() {
        super();
    }
    
    protected String getCodigo() {
        char[] codigo = new char[6];
        codigo[5] = super.getCodigoAleatorio();
        codigo[4] = super.getCodigoAleatorio();
        codigo[3] = super.getCodigoAleatorio();
        codigo[2] = super.getCodigoAleatorio();
        codigo[1] = super.getCodigoAleatorio();
        codigo[0] = super.getCodigoAleatorio();  
        return String.valueOf(codigo);
    }
    
    public char getJogada(int _rodada) {        
        int pos = (_rodada-1)*2;
        String jogada = this.estrategia.substring(pos,  pos+2);
        if (jogada.equals("CC"))
            return 'C';
        else if(jogada.equals("CA"))
            return 'A';
        else if(jogada.equals("AC"))
            return 'C';
        else
            return 'A';
    }
    
    public void geraEstrategia() {        
        for (int i=0; i < 70; i++) {
            if (this.estrategia != null)
                this.estrategia = this.estrategia + getCodigo();
            else
                this.estrategia = getCodigo();
        }
    }
}
