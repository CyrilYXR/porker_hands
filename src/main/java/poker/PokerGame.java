package poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

        int maxPokerNumber1 = pokerHands1.getMaxPokerNumber();
        int maxPokerNumber2 = pokerHands2.getMaxPokerNumber();

        int level1 = pokerHands1.getLevel();
        int level2 = pokerHands2.getLevel();

        if(level1 == level2){
            if(maxPokerNumber1 > maxPokerNumber2){
                return FIRST;
            }
        } else if(level1 > level2) {
            return FIRST;
        }
        return SECOND;
    }
}
