package poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PokerHands {


    public static String compete(List<Poker> first, List<Poker> second) {

        List<Integer> collectFirst = first.stream().map(Poker::getNumber).collect(Collectors.toList());
        List<Integer> collectSecond = second.stream().map(Poker::getNumber).collect(Collectors.toList());
        if(collectFirst.toString().equals(collectSecond.toString())){
            return "equal";
        }

        Integer maxOfFirst = first.stream().mapToInt(Poker::getNumber).max().getAsInt();
        Integer maxOfSecond = second.stream().mapToInt(Poker::getNumber).max().getAsInt();
        if(maxOfFirst > maxOfSecond){
            return "first";
        }
        return "second";
    }
}
