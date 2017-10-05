/*
 * Main.java
 *
 * Created on 16 de Junho de 2007, 12:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dilemadoprisioneiro;

/**
 *
 * @author Henrique
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        Estrategia estrategiaTitForTat1 = new EstrategiaTITFORTAT();
        Estrategia[] estrategiasAleatorias1 = GeradorEstrategiasAleatorias.getEstrategias(20);
        Estrategia estrategiaTitForTat2 = null;
        Estrategia[] estrategiasAleatorias2 = null;
        try {            
            estrategiaTitForTat2 = estrategiaTitForTat1.clone();
            estrategiasAleatorias2 = estrategiasAleatorias1.clone();             
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Iniciando execucao de algoritmo com corte de um ponto");
        AlgoritmoGeneticoUmPonto ag1p = new AlgoritmoGeneticoUmPonto(40, 20);
        ag1p.setEstrategiaTitForTat(estrategiaTitForTat1);
        ag1p.setEstrategiasAleatorias(estrategiasAleatorias1);
        ag1p.inicia();
        System.out.println("Execucao de algoritmo com corte de um ponto finalizada");
        
        System.out.println("Iniciando execucao de algoritmo com corte de dois pontos");
        AlgoritmoGeneticoDoisPontos ag2p = new AlgoritmoGeneticoDoisPontos(40, 20);
        ag2p.setEstrategiaTitForTat(estrategiaTitForTat2);
        ag2p.setEstrategiasAleatorias(estrategiasAleatorias2);
        ag2p.inicia();
        System.out.println("Execucao de algoritmo com corte de dois pontos finalizada");
        
        System.out.println("Execucao finalizada");
        
    }
    
}
