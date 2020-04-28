package Cards;

import java.util.Arrays;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
