package dilemadoprisioneiro;
/*
 * Jogo.java
 *
 * Created on 2 de Junho de 2007, 18:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author 200120117
 */
public abstract class AlgoritmoGenetico {
    
    int rodadas;
    int populacao;
    Estrategia[] estrategias;
    Estrategia titForTat;
    RegistraEstatisticas registraEstatisticas;
    
    /** Creates a new instance of Jogo */
    public AlgoritmoGenetico(int _rodadas, int _populacao) {        
        this.rodadas = _rodadas;
        this.populacao = _populacao;     
    }    
    
    public void setEstrategiasAleatorias(Estrategia[] _estrategias) {
        this.estrategias = _estrategias;
    }
    
    public void setEstrategiaTitForTat(Estrategia _titForTat) {
        this.titForTat = _titForTat;
    }
    
    private void inicializaEstrategias(){
        for(int i=0;i<this.populacao;i++)
            this.estrategias[i] = new EstrategiaAleatoria();        
    }
    
    private double avaliaJogadas(char _jogada1, char _jogada2) {
        if (_jogada1=='A' && _jogada2=='A')
            return 1;
        if (_jogada1=='A' && _jogada2=='C')
            return 5;
        if (_jogada1=='C' && _jogada2=='A')
            return 0;
        if (_jogada1=='C' && _jogada2=='C')
            return 3;
        return 0;
    }
    
    protected abstract void cruza();
    
    private Estrategia[] getEstrategiasOrdenadas() {
        Estrategia[] estrategiasOrd = new Estrategia[this.populacao];
        estrategiasOrd = this.estrategias;
        
        for(int i=0;i<this.populacao;i++) {
            for(int j=i;j<this.populacao;j++) {
                if (estrategiasOrd[i].getPontuacao() < estrategiasOrd[j].getPontuacao()) {
                    Estrategia aux;
                    aux = estrategiasOrd[j];                    
                    estrategiasOrd[j] = estrategiasOrd[i];
                    estrategiasOrd[i] = aux;
                }
            }
        }
            
        return estrategiasOrd;
    }
    
    private void limpaPontuacaoEstrategias() {
        for(int i=0;i<this.populacao;i++) 
             this.estrategias[i].setPontuacao(0);
        
    }
    
    public void inicia() {
        //this.inicializaEstrategias();
        for (int k=0;k<this.rodadas;k++) {    
            this.limpaPontuacaoEstrategias();
            for(int i=0;i<this.populacao;i++) {
                for (int j=0;j<35;j++) {
                    double pontos = this.avaliaJogadas(
                                        this.estrategias[i].getJogada(j+1), 
                                        this.titForTat.getJogada(j+1));                    
                    this.estrategias[i].setPontuacao(
                                this.estrategias[i].getPontuacao()+pontos);
                }
            }
            this.estrategias = this.getEstrategiasOrdenadas();
            this.registraEstatisticas.registra(this.estrategias, k+1);
            this.cruza();            
        }
        this.registraEstatisticas.finaliza();
    }
}
