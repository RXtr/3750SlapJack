/**
 * Created by Nick Marietti on 10/5/2016.
 */

import java.util.*;

public class Player {
    public String Name;
    private GroupOfCards Hand;

    public void NewHand(GroupOfCards newhand){
        Hand = newhand;
    }

    public void placeCard(GroupOfCards pile)
    {
        Hand.giveCard(pile);
    }

    /**
     * When the player misslaps.
     * @param players The group of players to whom a card is given to.
     */
    public void giveCardsMisslap(ArrayList<Player> players)
    {
        for (Player p : players)
        {
            Hand.giveCard(p.getHand());
        }
    }



    public GroupOfCards getHand() {
        return Hand;
    }
}
