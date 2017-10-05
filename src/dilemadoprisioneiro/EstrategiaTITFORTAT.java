package dilemadoprisioneiro;
/*
 * EstrategiaDilemaPrisioneiro.java
 *
 * Created on 2 de Junho de 2007, 17:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author 200120117
 */    
public class EstrategiaTITFORTAT extends EstrategiaAleatoria {
    public EstrategiaTITFORTAT() {
        super();
    }

    private char inverte(char _c, int _idx, int _pos) {
        double fator = Math.pow(2, _pos);            
        int idx = _idx+1;            
        if  (idx%fator==0)   {
            if(_c=='C')
                return 'A';
            else
                return 'C';
        } else
            return _c;            
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
    
    public final void geraEstrategia() {            
        char[] codigo = new char[6];
        codigo[5] = 'C';
        codigo[4] = 'C';
        codigo[3] = 'C';
        codigo[2] = 'C';
        codigo[1] = 'C';
        codigo[0] = 'C';
        for(int i = 0; i<64; i++) {            
            if (this.estrategia != null)
                this.estrategia = this.estrategia +  String.valueOf(codigo);
            else
                this.estrategia =  String.valueOf(codigo);
            codigo[5] = inverte(codigo[5], i, 5);
            codigo[4] = inverte(codigo[4], i, 4);
            codigo[3] = inverte(codigo[3], i, 3);
            codigo[2] = inverte(codigo[2], i, 2);
            codigo[1] = inverte(codigo[1], i, 1);
            codigo[0] = inverte(codigo[0], i, 0);
        }        
        for(int i = 64; i<70; i++) {            
            if (this.estrategia != null)
                this.estrategia = this.estrategia + super.getCodigo();
            else
                this.estrategia = super.getCodigo();
        }        
    }
}