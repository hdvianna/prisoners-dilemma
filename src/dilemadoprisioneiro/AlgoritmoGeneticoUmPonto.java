package dilemadoprisioneiro;
/*
 * AlgoritmoGeneticoUmPonto.java
 *
 * Created on 11 de Junho de 2007, 19:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author 200120117
 */
public class AlgoritmoGeneticoUmPonto extends AlgoritmoGenetico{
    public AlgoritmoGeneticoUmPonto(int _rodadas, int _populacao) {        
        super(_rodadas, _populacao);
        super.registraEstatisticas = new RegistraEstatisticas("estatisticas_ag_um_ponto");
    }  
    
    private Estrategia cruzaEstrategias(Estrategia _e1, Estrategia _e2) {
        String codificacao1 = _e1.getCodificacao();
        String codificacao2 = _e2.getCodificacao();
        int pontoCorte = Math.round((codificacao1.length()-12)/2);
        String codificacaoNova = codificacao1.substring(0, pontoCorte) + 
                                    codificacao2.substring(pontoCorte);
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
