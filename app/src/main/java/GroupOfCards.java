import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
    public GroupOfCards(int length, int startIndex, ArrayList<Card> Deck){
        cards = new ArrayList<Card>(Deck.subList(startIndex,startIndex+length));
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
        cards = new ArrayList<Card>();

        int cardCount = 0;
        for (Card.CardSuit suit : Card.CardSuit.values()) {
            for (Card.CardValue value : Card.CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }
    */

    /**
     * Creates a new ahdn
     * @param _handSize
     * @param Deck
     * @param playerCount
     * @return
     */
    /*
    public ArrayList<GroupOfCards> NewHand(int _handSize, ArrayList<Card> Deck, int playerCount){
        ArrayList<GroupOfCards> Hands = new ArrayList<GroupOfCards>();
        for(int i = 0; i < playerCount; i++)
           // Hands.add(new GroupOfCards(_handSize, playerCount*i+_handSize, Deck));
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
}
