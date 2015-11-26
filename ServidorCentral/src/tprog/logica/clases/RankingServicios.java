package tprog.logica.clases;

import java.util.ArrayList;

public class RankingServicios {
    private ArrayList<ItemRanking> ranking;
    
    public RankingServicios() {
        ranking = new ArrayList();
    }
    
    public ArrayList <ItemRanking> getRanking() {
        return ranking;
    }
    
    public void insertarItemOrdenado(ItemRanking item){
        if (item.getCantAccesos() != 0 
                && (ranking.size() < 10 || ranking.get(9).getCantAccesos() < item.getCantAccesos())) {
            boolean agregado = false;
            int indice = 0;
            while(!agregado && indice < ranking.size()) {
                if (ranking.get(indice).getCantAccesos() < item.getCantAccesos()){
                    ranking.add(indice, item);
                    agregado = true;
                } else if (ranking.get(indice).getCantAccesos() == item.getCantAccesos() 
                        && ranking.get(indice).getServicio().getIdServicio().compareTo(
                                item.getServicio().getIdServicio()) > 0) {
                    ranking.add(indice, item);
                    agregado = true;
                } else {
                    indice++;
                }
            }
            if (!agregado && indice == ranking.size() && ranking.size() < 10){
                ranking.add(indice, item);
            }
        }
    }
}
