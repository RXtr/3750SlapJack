package com.example.robbie.cs3750slapjack;

import java.util.*;
/**
 * Created by Eugene on 10/7/2016.
 */

public class Deck extends GroupOfCards {

    public static final int DECK_SIZE = 52;

    public Deck()
    {
        for (Card.CardSuit suit : Card.CardSuit.values()) {
            for (Card.CardValue value : Card.CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }

        Shuffle();
    }

    public ArrayList<Card> getDeck()
    {
        return super.getGroup();
    }
}
