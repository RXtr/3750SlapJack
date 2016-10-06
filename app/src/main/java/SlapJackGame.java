import java.security.acl.Group;
import java.util.ArrayList;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class SlapJackGame {
    private ArrayList<Player> Players;
    private int Dealer;
    private int PlayerTurn;
    private GroupOfCards pile;

    public SlapJackGame(ArrayList<Player> _players){
        Players = _players;
        Deal();
    }

    public void playGame()
    {
        // Create the players.
        // Deal the cards.
        // players place their cards.
        // Slap the center pile.
        // Award the cards.
    }

    private void Deal(){
        ArrayList<GroupOfCards> hands;
        GroupOfCards deck = new GroupOfCards();
        hands = deck.NewHand(52/Players.size(), deck.getGroup(), Players.size());
        int handCount = 0;
        for (Player player : Players) {
            player.NewHand(hands.get(handCount++));
        }
    }



    /**
     * Transfer the center pile to whoever slapped first.
     * @param winner The player who won the slap.
     */
    private void awardCards(Player winner)
    {
        for (Card c : pile.getGroup()) {
            pile.giveCard(winner.getHand());
        }
    }

    private boolean isAJack(Card c)
    {
        return (c.getValue().equals("JACK"));
    }
}
