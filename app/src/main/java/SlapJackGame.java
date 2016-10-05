import java.security.acl.Group;
import java.util.ArrayList;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class SlapJackGame {
    private ArrayList<Player> Players;
    private int Dealer;
    private int PlayerTurn;

    public SlapJackGame(ArrayList<Player> _players){
        Players = _players;
        Deal();
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
}
