/*
 * RegistraEstatisticas.java
 *
 * Created on 16 de Junho de 2007, 17:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dilemadoprisioneiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Henrique
 */
public class RegistraEstatisticas {
    
    private PrintWriter escreveArq;
    
    /** Creates a new instance of RegistraEstatisticas */
    public RegistraEstatisticas(String _nome) {
    	try {
            this.escreveArq = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/" + _nome + ".csv")));
	} catch(IOException e) {
            System.err.println(e);
        }
        this.escreveCabecalho();
    }
    
    public void registra(Estrategia[] _estrategias, int _rodada) {
        this.escreveLinha(_rodada, this.calculaMedia(_estrategias), _estrategias[0].getPontuacao(), _estrategias[_estrategias.length-1].getPontuacao(),_estrategias.length);
    }
    
    private void escreveLinha(int _rodada, double _media, double _melhorPontuacao, double _piorPontuacao, long _populacao) {
        this.escreveArq.println(_rodada + ";" + _media + ";" + _melhorPontuacao + ";" + _piorPontuacao + ";" + _populacao);
    }
    
    private void escreveCabecalho() {
        this.escreveArq.println("Rodada;Media;Melhor Pontuacao;Pior Pontuacao;Populacao");        
    }
    
    private double calculaMedia(Estrategia[] _estrategias) {
        double pontuacaoTotal = 0;
        for (int i = 0; i < _estrategias.length; i++)
           pontuacaoTotal += _estrategias[i].getPontuacao();
        return pontuacaoTotal/_estrategias.length;
    }
    
    public void finaliza() {
        this.escreveArq.close();
    }
    
}
