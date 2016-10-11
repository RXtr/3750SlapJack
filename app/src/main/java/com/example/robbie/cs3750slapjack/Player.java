package com.example.robbie.cs3750slapjack; /**
 * Created by Nick Marietti on 10/5/2016.
 */

import java.util.*;

public class Player extends GroupOfCards {
    private String name;
    private int playerNumber;

    public Player(String name, int playerNumber)
    {
        super();
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public void NewHand(GroupOfCards newhand){
        this.cards = newhand.getGroup();
    }

    public void placeCard(GroupOfCards pile)
    {
        this.giveCard(pile);
    }

    public String getName(){ return name; }

    public int getPlayerNumber() { return playerNumber; }

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
