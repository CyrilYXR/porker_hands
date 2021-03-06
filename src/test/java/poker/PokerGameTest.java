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

    @Test
    public void should_return_second_win_when_second_has_one_pair(){

        List<Poker> first = Arrays.asList(new Poker("4C"),new Poker("2D"),new Poker("3H"),new Poker("JS"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("3C"),new Poker("3D"), new Poker("6D"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }

    @Test
    public void should_return_first_win_when_both_has_same_pair_but_first_other_cards_is_bigger(){

        List<Poker> first = Arrays.asList(new Poker("3H"),new Poker("3S"),new Poker("4C"),new Poker("JS"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("3C"),new Poker("3D"), new Poker("6D"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }

    @Test
    public void should_return_second_win_when_both_has_one_pair_but_second_is_bigger(){

        List<Poker> first = Arrays.asList(new Poker("3C"),new Poker("3D"),new Poker("5H"),new Poker("JS"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("4C"),new Poker("4D"), new Poker("6D"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }

    @Test
    public void should_return_first_win_when_first_has_two_pairs(){

        List<Poker> first = Arrays.asList(new Poker("3C"),new Poker("3D"),new Poker("5H"),new Poker("5S"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("4C"),new Poker("4D"), new Poker("6D"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }

    @Test
    public void should_return_second_win_when_second_has_three_of_a_kind(){

        List<Poker> first = Arrays.asList(new Poker("3C"),new Poker("3D"),new Poker("5H"),new Poker("5S"),new Poker("AC"));
        List<Poker> second = Arrays.asList(new Poker("4C"),new Poker("4D"), new Poker("4S"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }

    @Test
    public void should_return_first_win_when_first_has_a_straight(){

        List<Poker> first = Arrays.asList(new Poker("2C"),new Poker("3D"),new Poker("4H"),new Poker("5S"),new Poker("6C"));
        List<Poker> second = Arrays.asList(new Poker("4C"),new Poker("4D"), new Poker("4S"), new Poker("KS"), new Poker("8C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }


    @Test
    public void should_return_second_win_when_both_has_a_straight_but_second_is_bigger(){

        List<Poker> first = Arrays.asList(new Poker("2C"),new Poker("3D"),new Poker("4H"),new Poker("5S"),new Poker("6C"));
        List<Poker> second = Arrays.asList(new Poker("7C"),new Poker("8D"),new Poker("9H"),new Poker("TS"),new Poker("JC"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }


    @Test
    public void should_return_first_win_when_first_has_a_flush(){

        List<Poker> first = Arrays.asList(new Poker("4C"),new Poker("7C"), new Poker("9C"), new Poker("KC"), new Poker("8C"));
        List<Poker> second = Arrays.asList(new Poker("2C"),new Poker("3D"),new Poker("4H"),new Poker("5S"),new Poker("6C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }

    @Test
    public void should_return_second_win_when_both_has_a_flush_but_second_is_bigger(){

        List<Poker> first = Arrays.asList(new Poker("4C"),new Poker("7C"), new Poker("9C"), new Poker("KC"), new Poker("8C"));
        List<Poker> second = Arrays.asList(new Poker("2H"),new Poker("3H"),new Poker("4H"),new Poker("5H"),new Poker("AH"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }

    @Test
    public void should_return_first_win_when_first_has_a_full_house(){

        List<Poker> first = Arrays.asList(new Poker("7C"),new Poker("7C"), new Poker("9S"), new Poker("9H"), new Poker("9C"));
        List<Poker> second = Arrays.asList(new Poker("2C"),new Poker("3D"),new Poker("4H"),new Poker("5S"),new Poker("6C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }

    @Test
    public void should_return_second_win_when_both_has_a_full_house_but_second_is_bigger(){

        List<Poker> first = Arrays.asList(new Poker("3H"),new Poker("3H"),new Poker("4H"),new Poker("4H"),new Poker("4H"));
        List<Poker> second = Arrays.asList(new Poker("7C"),new Poker("7C"), new Poker("9S"), new Poker("9H"), new Poker("9C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }

    @Test
    public void should_return_first_win_when_first_has_four_of_a_kind(){

        List<Poker> first = Arrays.asList(new Poker("7C"),new Poker("9D"), new Poker("9S"), new Poker("9H"), new Poker("9C"));
        List<Poker> second = Arrays.asList(new Poker("7C"),new Poker("7C"), new Poker("9S"), new Poker("9H"), new Poker("9C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }

    @Test
    public void should_return_second_win_when_second_has_straight_flush(){

        List<Poker> first = Arrays.asList(new Poker("7C"),new Poker("9D"), new Poker("9S"), new Poker("9H"), new Poker("9C"));
        List<Poker> second = Arrays.asList(new Poker("2C"),new Poker("3C"),new Poker("4C"),new Poker("5C"),new Poker("6C"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("second", result);

    }

    @Test
    public void should_return_first_win_when_their_poker_number_is_equal_but_first_is_straight_flush_and_second_is_straight(){

        List<Poker> first = Arrays.asList(new Poker("2C"),new Poker("3C"),new Poker("4C"),new Poker("5C"),new Poker("6C"));
        List<Poker> second = Arrays.asList(new Poker("2H"),new Poker("3S"),new Poker("4S"),new Poker("5D"),new Poker("6D"));

        String result = PokerGame.compete(first, second);
        Assert.assertEquals("first", result);

    }
}
