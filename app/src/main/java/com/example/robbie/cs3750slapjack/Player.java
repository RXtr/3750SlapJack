package com.example.robbie.cs3750slapjack; /**
 * Created by Nick Marietti on 10/5/2016.
 */

import java.util.*;

public class Player extends GroupOfCards {
    private String Name;

    public Player(String name)
    {
        super();
        Name = name;
    }

    public void NewHand(GroupOfCards newhand){
        this.cards = newhand.getGroup();
    }

    public void placeCard(GroupOfCards pile)
    {
        this.giveCard(pile);
    }

    /**
     * When the player misslaps.
     * @param players The group of players to whom a card is given to.
     */
    public void giveCardsMisslap(ArrayList<Player> players)
    {
        for (Player p : players)
        {
            this.giveCard(p.getHand());
        }
    }



    public GroupOfCards getHand() {
        return this;
    }
}
