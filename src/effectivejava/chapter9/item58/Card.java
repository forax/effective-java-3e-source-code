package effectivejava.chapter9.item58;

import java.util.*;

public record Card(Suit suit, Rank rank) {

    // Can you spot the bug?
    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        var deck = new ArrayList<Card>();
        
        for (var suitIterator = suits.iterator(); suitIterator.hasNext(); )
            for (var rankIterator = ranks.iterator(); rankIterator.hasNext(); )
                deck.add(new Card(suitIterator.next(), rankIterator.next()));

//        // Preferred idiom for nested iteration on collections and arrays
//        for (var suit : suits)
//            for (var rank : ranks)
//                deck.add(new Card(suit, rank));
    }
}
