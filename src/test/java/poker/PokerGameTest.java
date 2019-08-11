package poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerGameTest {

    @Test
    public void should_return_first_win_when_high_card_case(){

        List<Poker> first = Arrays.asList(new Poker("4C"),new Poker("2D"),new Poker("3H"),new Poker("JS"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("3C"),new Poker("9D"), new Poker("6D"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }

    @Test
    public void should_return_equal_when_equal_card_case(){

        List<Poker> first = Arrays.asList(new Poker("4C"),new Poker("2D"),new Poker("3H"),new Poker("JS"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("4H"),new Poker("2C"),new Poker("3D"),new Poker("JC"),new Poker("AD"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("equal", result);

    }
}
