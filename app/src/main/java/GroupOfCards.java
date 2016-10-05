import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class GroupOfCards {
    private Card[] cards;
    private int count;

    public GroupOfCards(int length, int startIndex, Card[] Deck){
        cards = new Card[length];
        System.arraycopy(Deck, startIndex, cards, startIndex, length);
    }
    public void Shuffle(){
        int index;
        Card temp;
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }
    public void NewDeck(){
        cards = new Card[52];

        Card.CardSuit[] suits = { Card.CardSuit.CLUBS, Card.CardSuit.DIAMONDS, Card.CardSuit.HEARTS, Card.CardSuit.SPADES };
        Card.CardValue[] values = { Card.CardValue.ACE, Card.CardValue.TWO, Card.CardValue.THREE, Card.CardValue.FOUR, Card.CardValue.FIVE,
                Card.CardValue.SIX, Card.CardValue.SEVEN, Card.CardValue.EIGHT, Card.CardValue.NINE, Card.CardValue.TEN,
                Card.CardValue.JACK, Card.CardValue.QUEEN, Card.CardValue.KING };

        int cardCount = 0;
        for(int i = 0; i < suits.length; i++)
            for(int j = 0; j < values.length; j++)
                // TO DO: Update to use the enum for card value.
                cards[cardCount++] = new Card(suits[i], values[j]);
    }

    public ArrayList<GroupOfCards> NewHand(int _handSize, Card[] Deck, int playerCount){
        ArrayList<GroupOfCards> Hands = new ArrayList<GroupOfCards>();
        for(int i = 0; i < playerCount; i++)
            Hands.add(new GroupOfCards(_handSize, playerCount*i+_handSize, Deck));
        return Hands;
    }

    public int CardCount(){
        return count;
    }
}
