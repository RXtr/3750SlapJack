package com.example.robbie.cs3750slapjack;

import java.util.ArrayList;

/**
 * Created by Nick Marietti on 10/5/2016.
 */


/**
 * This class is a controller for the UI.
 * Methods here are either called upon user interaction with the game,
 * or assists the ones called.
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

    /**
     * The list of the ones who slapped.
     * First one on the list gets the center pile cards.
     */
    private ArrayList<Player> slappers;

    /**
     * The list of the players who are left with zero cards in hand.
     */
    private ArrayList<Player> losers;

    public SlapJackGame(ArrayList<Player> _players){
        Players = _players;
        deck = new Deck();
        Deal();
        playerCount = _players.size();
        centerPile = new GroupOfCards();
        slappers = new ArrayList<>();
        losers = new ArrayList<>();
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
        slappers = new ArrayList<>();
        losers = new ArrayList<>();
    }

    /**
     * Deal cards to all players.
     */
    private void Deal(){

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
     * After the first slapper is determined,
     * determine whether the card the player slapped was
     * a jack or not, and apply the consequences.
     * @param firstSlapper the first player in slappers
     */
    public void determineGainOrLoss(Player firstSlapper)
    {
        if (isAJack(centerPile.getBottomCard()))
        {
            awardCards(firstSlapper);
        }
        else // if player misslaps
        {
            firstSlapper.giveCardsMisslap(Players);
        }
        // Then clear the list of slappers.
        slappers.clear();
    }

    /**
     * Transfer the center pile to whoever slapped first.
     * @param slapWinner The player who won the slap.
     */
    public void awardCards(Player slapWinner)
    {
        for (Card c : centerPile.getGroup())
            centerPile.giveCard(slapWinner);
    }

    /**
     * Remove the loser player from the list of players
     * and add to the losers list.
     * @param p The loser player
     */
    public void addToLosers(Player p)
    {
        if (p.CardCount() <= 0)
        {
            losers.add(p);
            Players.remove(p);
        }
    }

    /**
     * The winner is the last player left in the Players list.
     */
    public Player determineWinner()
    {
        Player winner = null;
        if (Players.size() == 1)
        {
            winner = Players.get(0);
        }
        return winner;
    }

    /**
     * Determines if the card is a jack.
     * @param c
     * @return
     */
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
