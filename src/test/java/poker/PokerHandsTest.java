package poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerHandsTest {

    @Test
    public void should_return_first_win_when_high_card_case(){

        List<Poker> first = Arrays.asList(new Poker("4C"),new Poker("2D"),new Poker("3H"),new Poker("JS"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("3C"),new Poker("9D"), new Poker("6D"), new Poker("KS"), new Poker("8C"));

        String result = PokerHands.compete(first, second);
        Assert.assertEquals("first", result);

    }
}
