/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package br.ejb;

import br.data.model.Jogador;
import br.data.model.Ranking;
import java.util.ArrayList;
import javax.ejb.Stateful;
import java.util.Random;

/**
 *
 * @author samsung
 */
@Stateful
public class EjbRanking {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private ArrayList<Ranking> lRanking;
    private final Random random = new Random();

    public EjbRanking() {
        lRanking = new ArrayList<>();
    }
    
    public ArrayList<Ranking> getAll(){
        return lRanking;
    }
    
    public void add(Jogador prod){
        boolean achou = false;
        for (Ranking ranking : lRanking) {
            if(ranking.getJogador().getId()==prod.getId()){
                ranking.setQuantidadePontos(ranking.getQuantidadePontos()+1);
                achou=true;
                break;
            }
        }
        if(!achou){
            Ranking ranking = new Ranking(prod, 1);
            lRanking.add(ranking);
        }               
    }
    
     public int calculo(Double num, Double num1) {
        return (int) (num + num1);
    }

    public int valAleatorio() {
        int i = random.nextInt(10);
        return i;
    }
}
