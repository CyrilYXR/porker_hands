package poker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHands {

    private List<Poker> pokers;
    private int level = 0;

    private Map<Integer, Integer> numberMap = new HashMap<>();

    public PokerHands(List<Poker> pokers) {
        this.pokers = pokers;
        computeLevel();
    }

    public int getMaxPokerNumber(){
        return pokers.stream().filter(poker -> numberMap.get(poker.getNumber())==1)
                .mapToInt(Poker::getNumber)
                .max().getAsInt();
    }

    public int getLevel() {
        return level;
    }

    public int computeLevel(){
        for(Poker poker : pokers){
            numberMap.merge(poker.getNumber(), 1, (a, b) -> a + b);
        }
        List<Integer> valueList = numberMap.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
//        System.out.println(valueList);
        if(numberMap.size() == 4){  // one pair
            level = 1;
        }
        if(numberMap.size() == 3){
            if(valueList.get(0) == 2){  // two pairs
                level = 2;
            } else {  //three of a kind
                level = 3;
            }
        }
        if(numberMap.size() == 5){
            int max = pokers.stream().mapToInt(Poker::getNumber).max().getAsInt();
            int min = pokers.stream().mapToInt(Poker::getNumber).min().getAsInt();
            if(max - min == 4){   // straight
                level = 4;
            }
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

    public Map<Integer, Integer> getNumberMap() {
        return numberMap;
    }

    public void setNumberMap(Map<Integer, Integer> numberMap) {
        this.numberMap = numberMap;
    }
}
