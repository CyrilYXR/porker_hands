package poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHands {

    private List<Poker> pokers;
    private int level = 0;

    public PokerHands(List<Poker> pokers) {
        this.pokers = pokers;
    }

    public int getMaxPokerNumber(){
        return pokers.stream().mapToInt(Poker::getNumber).max().getAsInt();
    }

    public int getLevel() {
        Map<Integer, Integer> map = new HashMap<>();
        for(Poker poker : pokers){
            map.merge(poker.getNumber(), 1, (a, b) -> a + b);
        }
        if(map.size() == 4){
            level = 1;
        }
        return level;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(getClass() != obj.getClass()) return false;
        PokerHands pokerHands = (PokerHands) obj;
        List<Integer> thisPokers = this.pokers.stream().map(Poker::getNumber).collect(Collectors.toList());
        List<Integer> objPokers = pokerHands.pokers.stream().map(Poker::getNumber).collect(Collectors.toList());
        if(thisPokers.toString().equals(objPokers.toString())){
            return true;
        }
        return false;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    public void setPokers(List<Poker> pokers) {
        this.pokers = pokers;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
