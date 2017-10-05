/*
 * GeradorEstrategiasAleatorias.java
 *
 * Created on 17 de Junho de 2007, 19:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dilemadoprisioneiro;

/**
 *
 * @author Henrique
 */
public class GeradorEstrategiasAleatorias {
    
    public static Estrategia[] getEstrategias(int _populacao){
        Estrategia[] estrategias;
        estrategias = new EstrategiaAleatoria[_populacao];
        for(int i=0;i<_populacao;i++)
            estrategias[i] = new EstrategiaAleatoria();
        return estrategias;
    }
    
}
