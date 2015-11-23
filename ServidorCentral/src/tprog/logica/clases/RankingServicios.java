package tprog.logica.clases;

import java.util.ArrayList;

public class RankingServicios {
    ArrayList<ItemRanking> ranking;
    
    public RankingServicios() {
        ranking = new ArrayList();
        for (int i = 0; i < 10; i++)
            ranking.add(null);
    }
    
    public ArrayList <ItemRanking> getRanking(){
        return ranking;
    }
    
    public void insertarItemOrdenado(ItemRanking item){
        if (ranking.get(9) == null || ranking.get(9).getCantAccesos() < item.getCantAccesos()) {
            boolean agregado = false;
            int indice = 0;
            while(!agregado && indice < ranking.size()) {
                if (ranking.get(indice) != null
                        && ranking.get(indice).getCantAccesos() < item.getCantAccesos()){
                    ranking.add(indice, item);
                    agregado = true;
                } else if (ranking.get(indice) == null){
                    ranking.add(indice, item);
                    agregado = true;
                } else {
                    indice++;
                }
            }
            ranking.remove(10);
        }
    }
}
