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

    public Card placeCard(GroupOfCards pile)
    {
        return this.giveCard(pile);
    }

    public String getName(){ return Name; }

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

    /**
     * Activates when player slaps the center card.
     * Only takes effect if at least one card exists in center pile.
     * The player only adds itself to the list of slappers; the
     * distribution of cards is handled elsewhere.
     */
    public void slapCard(GroupOfCards centerPile, ArrayList<Player> slappers)
    {
        if (centerPile.CardCount() > 0)
        {
            slappers.add(this);
        }
    }


    public GroupOfCards getHand() {
        return this;
    }
}
