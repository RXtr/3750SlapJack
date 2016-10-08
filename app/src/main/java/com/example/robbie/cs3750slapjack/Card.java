package com.example.robbie.cs3750slapjack;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class Card {
    public enum CardSuit {

        CLUBS, DIAMONDS, HEARTS, SPADES;

        /**
         * Returns the value of this card suit as a formatted string.
         *
         * @return value of suit as string
         */
        public String toString() {
            if(this == CLUBS)
                return "clubs";
            if(this == DIAMONDS)
                return "diamonds";
            if(this == HEARTS)
                return "hearts";
            return "spades";
        }
    }
    public enum CardValue {

        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

        /**
         * Returns the value of this card as a formatted string.
         * @return value of card as a string
         */
        public String toString() {
            if(this == ACE)
                return "ace";
            if(this == TWO)
                return "2";
            if(this == THREE)
                return "3";
            if(this == FOUR)
                return "4";
            if(this == FIVE)
                return "5";
            if(this == SIX)
                return "6";
            if(this == SEVEN)
                return "7";
            if(this == EIGHT)
                return "8";
            if(this == NINE)
                return "9";
            if(this == TEN)
                return "10";
            if(this == JACK)
                return "jack";
            if(this == QUEEN)
                return "queen";
            return "king";
        }
    }
    private final CardSuit suit;
    private final CardValue value;

    public Card(CardSuit _suit, CardValue _value) {
        suit = _suit;
        value = _value;
    }

    /**
     * Returns the suit of this playing card.
     */
    public CardSuit getSuit() {
        return suit;
    }

    /**
     * Returns the value of this playing card.
     */
    public CardValue getValue() {
        return value;
    }

    /**
     * Returns a formatted string representation of this card (e.g., "ace of spades, "9 of hearts").
     *
     * @return formatted string
     */
    public String toString() {
        return value.toString() + " of " + suit.toString();
    }


    /** Returns true if the card represented by this object is equal to the
     * other card.
     *
     * @param other
     * @return true if this is equal to other
     */
    public boolean equals(Object other) {
        if(!(other instanceof Card))
            return false;

        Card rhs = (Card)other;

        // Note that enums may be compared with ==.
        return suit == rhs.suit && value == rhs.value;
    }

    /**
     * Implements Comparable interface, and returns a positive integer if
     * this is greater than other, a negative integer if this is less than other
     * or zero if they are equal.
     *
     * @return positive, negative, or zero integer
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Card other)
    {
        if (this.value.equals(other.value))
            return this.suit.compareTo(other.suit);

        if (this.value.equals(other.value) && this.suit.equals(other.suit))
            return 0;

        else
            return this.value.compareTo(other.value);
    }
}
