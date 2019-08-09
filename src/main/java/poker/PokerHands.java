package poker;

import java.util.Comparator;
import java.util.List;

public class PokerHands {


    public static String compete(List<Poker> first, List<Poker> second) {
        Integer maxOfFirst = first.stream().mapToInt(Poker::getNumber).max().getAsInt();
        Integer maxOfSecond = second.stream().mapToInt(Poker::getNumber).max().getAsInt();
        if(maxOfFirst > maxOfSecond){
            return "first";
        }
        return "second";
    }
}
