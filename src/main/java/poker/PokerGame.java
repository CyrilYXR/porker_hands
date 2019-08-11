package poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PokerGame {

    private static final String FIRST = "first";
    private static final String SECOND = "second";
    private static final String EQUAL = "equal";


    public static String compete(List<Poker> first, List<Poker> second) {

        PokerHands pokerHands1 = new PokerHands(first);
        PokerHands pokerHands2 = new PokerHands(second);
        if(pokerHands1.equals(pokerHands2)){
            return EQUAL;
        }

        int level1 = pokerHands1.getLevel();
        int level2 = pokerHands2.getLevel();
        int maxPokerNumber1 = pokerHands1.getMaxPokerNumber();
        int maxPokerNumber2 = pokerHands2.getMaxPokerNumber();
        Map<Integer, Integer> numberMap1 = pokerHands1.getNumberMap();
        Map<Integer, Integer> numberMap2 = pokerHands2.getNumberMap();

        System.out.println("level1="+level1);
        System.out.println("level2="+level2);
        if(level1 == level2){
            if(level1 == 0 || level1 == 4) {
                return maxPokerNumber1 > maxPokerNumber2 ? FIRST : SECOND;
            }

            List<Integer> pairs1 = numberMap1.keySet().stream().filter(key -> numberMap1.get(key) >= 2).collect(Collectors.toList());
            List<Integer> pairs2 = numberMap2.keySet().stream().filter(key -> numberMap2.get(key) >= 2).collect(Collectors.toList());
            Integer pairSum1 = pairs1.stream().reduce((x, y) -> x + y).get();
            Integer pairSum2 = pairs2.stream().reduce((x, y) -> x + y).get();

            if(pairSum1.equals(pairSum2)){
                return maxPokerNumber1 > maxPokerNumber2 ? FIRST : SECOND;
            }
            return pairSum1 > pairSum2 ? FIRST : SECOND;
        }
        return level1 > level2 ? FIRST : SECOND;
    }
}
