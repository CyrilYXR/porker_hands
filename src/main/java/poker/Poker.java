package poker;

import java.util.HashMap;
import java.util.Map;

public class Poker {

    private int number;
    private char type;

    public Poker(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('A',14);
        map.put('K',13);
        map.put('Q',12);
        map.put('J',11);
        map.put('T',10);

        if(s.charAt(0)>'9'){
            this.number = map.get(s.charAt(0));
        } else {
            this.number = s.charAt(0) - 48;
        }
        this.type = s.charAt(1);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
