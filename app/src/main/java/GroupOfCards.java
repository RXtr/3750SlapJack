import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class GroupOfCards {
    private ArrayList<Card> cards;

    public GroupOfCards(){
        NewDeck();
    }
    public GroupOfCards(int length, int startIndex, ArrayList<Card> Deck){
        cards = new ArrayList<Card>();
        System.arraycopy(Deck, startIndex, cards, startIndex, length);
    }
    public void Shuffle(){
        Collections.shuffle(cards);
    }
    public void NewDeck(){
        cards = new ArrayList<Card>();

        int cardCount = 0;
        for (Card.CardSuit suit : Card.CardSuit.values()) {
            for (Card.CardValue value : Card.CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<GroupOfCards> NewHand(int _handSize, ArrayList<Card> Deck, int playerCount){
        ArrayList<GroupOfCards> Hands = new ArrayList<GroupOfCards>();
        for(int i = 0; i < playerCount; i++)
            Hands.add(new GroupOfCards(_handSize, playerCount*i+_handSize, Deck));
        return Hands;
    }

    public int CardCount(){
        return cards.size();
    }

    public ArrayList<Card> getGroup(){
        return cards;
    }
}
