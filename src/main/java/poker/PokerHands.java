package poker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHands {

    private List<Poker> pokers;
    private int level = LevelEnum.HIGH_CARD.getLevel();

    private Map<Integer, Integer> numberMap = new HashMap<>();

    public PokerHands(List<Poker> pokers) {
        this.pokers = pokers;
        computeLevel();
    }

    public int getMaxPokerNumberInNoRepeatCards(){

        List<Poker> filterPokers = pokers.stream().filter(poker -> numberMap.get(poker.getNumber()) == 1).collect(Collectors.toList());

        //如果两者都是full house的情况，则直接返回-1
        if(filterPokers.size() == 0){
            return -1;
        }
        return filterPokers.stream()
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
        if(numberMap.size() == 4){  // one pair
            level = LevelEnum.PAIR.getLevel();
        }
        if(numberMap.size() == 3){
            if(valueList.get(0) == 2){  // 最多重复次数是2, two pairs
                level = LevelEnum.TWO_PAIRS.getLevel();
            } else {  //最多重复次数是3, three of a kind
                level = LevelEnum.THREE_OF_A_KIND.getLevel();
            }
        }
        if(numberMap.size() == 5){
            int max = pokers.stream().mapToInt(Poker::getNumber).max().getAsInt();
            int min = pokers.stream().mapToInt(Poker::getNumber).min().getAsInt();
            if(max - min == 4){   // straight
                level = LevelEnum.STRAIGHT.getLevel();
            }
        }
        if(pokers.stream().map(Poker::getType).collect(Collectors.toSet()).size() == 1){  // 同花
            int max = pokers.stream().mapToInt(Poker::getNumber).max().getAsInt();
            int min = pokers.stream().mapToInt(Poker::getNumber).min().getAsInt();
            if(max - min == 4){   // 顺子
                level = LevelEnum.STRAIGHT_FLUSH.getLevel();   // straight flush
            } else {
                level = LevelEnum.FLUSH.getLevel();    //flush
            }
        }
        if(numberMap.size() == 2) {
            if(valueList.get(0) == 3) {  //最多重复次数是3且另外两张是pair, full house
                level = LevelEnum.FULL_HOUSE.getLevel();
            } else {
                level = LevelEnum.FOUR_OF_A_KIND.getLevel();  //最多重复次数是4, four of a kind
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
