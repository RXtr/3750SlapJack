package com.example.robbie.cs3750slapjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class GroupOfCards {

    /**
     * The group of cards.
     */
    protected ArrayList<Card> cards;

    /**
     * The constructor for the group of cards.
     */
    public GroupOfCards(){
        //NewDeck();
        cards = new ArrayList<>();
    }

    /*
    public com.example.robbie.cs3750slapjack.GroupOfCards(int length, int startIndex, ArrayList<com.example.robbie.cs3750slapjack.Card> com.example.robbie.cs3750slapjack.Deck){
        cards = new ArrayList<com.example.robbie.cs3750slapjack.Card>(com.example.robbie.cs3750slapjack.Deck.subList(startIndex,startIndex+length));
    }
    */

    /**
     * Shuffles the group of cards.
     */
    public void Shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Creates a new deck.
     */
    /*
    public void NewDeck(){
        cards = new ArrayList<com.example.robbie.cs3750slapjack.Card>();

        int cardCount = 0;
        for (com.example.robbie.cs3750slapjack.Card.CardSuit suit : com.example.robbie.cs3750slapjack.Card.CardSuit.values()) {
            for (com.example.robbie.cs3750slapjack.Card.CardValue value : com.example.robbie.cs3750slapjack.Card.CardValue.values()) {
                cards.add(new com.example.robbie.cs3750slapjack.Card(suit, value));
            }
        }
    }
    */

    /**
     * Creates a new ahdn
     * @param _handSize
     * @param com.example.robbie.cs3750slapjack.Deck
     * @param playerCount
     * @return
     */
    /*
    public ArrayList<com.example.robbie.cs3750slapjack.GroupOfCards> NewHand(int _handSize, ArrayList<com.example.robbie.cs3750slapjack.Card> com.example.robbie.cs3750slapjack.Deck, int playerCount){
        ArrayList<com.example.robbie.cs3750slapjack.GroupOfCards> Hands = new ArrayList<com.example.robbie.cs3750slapjack.GroupOfCards>();
        for(int i = 0; i < playerCount; i++)
           // Hands.add(new com.example.robbie.cs3750slapjack.GroupOfCards(_handSize, playerCount*i+_handSize, com.example.robbie.cs3750slapjack.Deck));
        return Hands;
    }
    */

    /**
     * The helper method to give cards.
     * @param group The group of cards to which cards are given to.
     */
    public void giveCard(GroupOfCards group)
    {
        if (this.getGroup().size() > 0) {
            group.getGroup().add(this.getGroup().get(0));
            this.getGroup().remove(0);
        }
    }

    public int CardCount(){
        return cards.size();
    }

    public ArrayList<Card> getGroup(){
        return cards;
    }

    public Card getBottomCard() { return cards.get(CardCount()-1);}
}
