/*
 * AlgoritmoGeneticoDoisPontos.java
 *
 * Created on 18 de Junho de 2007, 21:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dilemadoprisioneiro;

/**
 *
 * @author Henrique
 */
public class AlgoritmoGeneticoDoisPontos extends AlgoritmoGenetico{
    
    /** Creates a new instance of AlgoritmoGeneticoDoisPontos */
    public AlgoritmoGeneticoDoisPontos(int _rodadas, int _populacao) {        
        super(_rodadas, _populacao);
        super.registraEstatisticas = new RegistraEstatisticas("estatisticas_ag_dois_pontos");
    }  
    
      
   private Estrategia cruzaEstrategias(Estrategia _e1, Estrategia _e2) {
        String codificacao1 = _e1.getCodificacao();
        String codificacao2 = _e2.getCodificacao();
        int pontoCorte1 = Math.round((codificacao1.length()-12)/4);
        int pontoCorte2 = pontoCorte1 * 2;
        String parte1Codificacao1 = codificacao1.substring(0, pontoCorte1);
        String parte3Codificacao2 = codificacao2.substring(pontoCorte2);
        String parte2Codificacao2 = codificacao2.substring(pontoCorte1, pontoCorte2);           
        String codificacaoNova = parte3Codificacao2 + parte1Codificacao1 +  parte2Codificacao2;
        Estrategia estrategiaResultado = new EstrategiaAleatoria();
        estrategiaResultado.setCodificacao(codificacaoNova);
        return estrategiaResultado;
        
    }
    
    protected void cruza(){
        int div = Math.round(this.populacao/2);
        for (int i=0; i < div; i++) {
            Estrategia e1 = this.estrategias[i];
            Estrategia e2 = this.estrategias[i+div];            
            Estrategia cruza = this.cruzaEstrategias(e1, e2);
            cruza.muta();
            this.estrategias[i+div] = cruza;
        }        
    }
}
