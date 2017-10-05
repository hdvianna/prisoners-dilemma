package dilemadoprisioneiro;
/*
 * Estrategia.java
 *
 * Created on 2 de Junho de 2007, 17:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.lang.Math;
import java.util.Random;

/**
 *
 * @author 200120117
 */
public abstract class Estrategia extends Object implements Cloneable {

    protected String estrategia;        
    double pontucao;
    
    public Estrategia() {
        geraEstrategia();
    }
    
    protected char getCodigoAleatorio() {
        int irand = (int) (Math.random()*1000);
        if (irand%2==0)
            return 'A';
        else
            return 'C';                
    }
    
    public void setPontuacao(double _pontuacao) {
        this.pontucao = _pontuacao;
    }
    
    public double getPontuacao() {
        return this.pontucao;
    }
    
    public String getCodificacao() {
        return this.estrategia;
    }
    
    public void setCodificacao(String _estrategia) {
        this.estrategia = _estrategia;
    }
    
    public void muta() {
        int irand = (int) (Math.random()*100);
        char arrEstrategia[] = estrategia.toCharArray();
        arrEstrategia[irand] = this.getCodigoAleatorio();
        estrategia = new String(arrEstrategia);
    }
    
    public abstract char getJogada(int _rodada);
    
    protected abstract void geraEstrategia();
    
    public Estrategia clone() throws CloneNotSupportedException {
        return (Estrategia) super.clone();
    }

}
