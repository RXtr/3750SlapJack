package com.example.robbie.cs3750slapjack;

import java.util.ArrayList;

/**
 * Created by Nick Marietti on 10/5/2016.
 */

public class SlapJackGame {

    /**
     * The list of players.
     */
    private ArrayList<Player> Players;

    private int Dealer;

    /**
     * The number of turns.
     */
    private int PlayerTurn;

    /**
     * The total number of players.
     */
    private int playerCount;

    /**
     * The center pile for placing cards.
     */
    private GroupOfCards centerPile;

    /**
     * The deck to deal cards from.
     */
    private Deck deck;

    public SlapJackGame(ArrayList<Player> _players){
        Players = _players;
        deck = new Deck();
        Deal();
        playerCount = _players.size();
        centerPile = new GroupOfCards();
    }

    /**
     * Default constructor for com.example.robbie.cs3750slapjack.SlapJackGame
     */
    public SlapJackGame()
    {
        Players = new ArrayList<>();
        deck = new Deck();
        Deal();
        playerCount = 0;
        centerPile = new GroupOfCards();
    }

    /**
     * Deal cards to all players.
     */
    public void Deal(){

       // playerHands = deck.NewHand(52/Players.size(), deck.getGroup(), Players.size());

        // Create hands for each player.
        for (int i = 0; i < playerCount; i++)
        {
            for (int j = 0; j < (Deck.DECK_SIZE / playerCount); j++)
                deck.giveCard(Players.get(i));
        }
        /*
        int handCount = 0;
        for (com.example.robbie.cs3750slapjack.Player player : Players) {
            player.NewHand(hands.get(handCount++));
        }
        */
    }

    /**
     * Transfer the center pile to whoever slapped first.
     * @param winner The player who won the slap.
     */
    public void awardCards(Player winner)
    {
        for (Card c : centerPile.getGroup())
            centerPile.giveCard(winner);
    }

    public boolean isAJack(Card c)
    {
        return (c.getValue().equals("JACK"));
    }

    public int getPlayerCount()
    {
        return playerCount;
    }

    public void setPlayerCount(int count)
    {
        playerCount = count;
    }

    public GroupOfCards getCenterPile()
    {
        return centerPile;
    }
}
