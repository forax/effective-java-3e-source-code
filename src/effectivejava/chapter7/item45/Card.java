package effectivejava.chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

// Generating the Cartesian product of two lists using iteration and streams (Page 209)
public record Card(Suit suit, Rank rank) {
    public enum Suit { SPADE, HEART, DIAMOND, CLUB }
    public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
                       EIGHT, NINE, TEN, JACK, QUEEN, KING }

    @Override public String toString() {
        return rank + " of " + suit + "S";
    }


    private static final List<Card> NEW_DECK = newDeck();

    // Iterative Cartesian product computation
    private static List<Card> newDeck() {
        var result = new ArrayList<Card>();
        for (var suit : Suit.values())
            for (var rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

//    // Stream-based Cartesian product computation
//    private static List<Card> newDeck() {
//        return Stream.of(Suit.values())
//                .flatMap(suit ->
//                        Stream.of(Rank.values())
//                                .map(rank -> new Card(suit, rank)))
//                .collect(toList());
//    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }
}
