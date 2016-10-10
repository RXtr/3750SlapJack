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

    public void setPlayers(ArrayList<Player> value){Players = value;}
    public ArrayList<Player> getPlayers() { return Players; }

    private int Dealer;

    public void setDealer(int value){Dealer = value;}
    public int getDealer(){ return Dealer;}

    /**
     * The number of turns.
     */
    private int PlayerTurn;

    public void setPlayerTurn(int value){ PlayerTurn = value; }
    public int getPlayerTurn() { return PlayerTurn; }

    /**
     * The total number of players.
     */
    private int playerCount;

    /**
     * The center pile for placing cards.
     */
    private GroupOfCards centerPile;

    public void setCenterPile(GroupOfCards value){  centerPile = value; }

    /**
     * The deck to deal cards from.
     */
    private Deck deck;

    public void setDeck(Deck value){ deck = value; }
    public Deck getDeck(){ return deck; }

    /**
     * The list of the ones who slapped.
     * First one on the list gets the center pile cards.
     */
    private ArrayList<Player> slappers;

    public void setSlappers(ArrayList<Player> value) {  slappers = value; }
    public ArrayList<Player> getSlappers() { return slappers; }

    /**
     * The list of the players who are left with zero cards in hand.
     */
    private ArrayList<Player> losers;

    public void setLosers(ArrayList<Player> value) {  losers = value; }
    public ArrayList<Player> getLosers() { return losers; }

    /**
     * The index of the selected player.
     */
    private int selectedPlayer;

    public void setSelectedPlayer(int value) {  selectedPlayer = value; }
    public int getSelectedPlayer() { return selectedPlayer; }

    public SlapJackGame(ArrayList<Player> _players){
        Players = _players;
        deck = new Deck();
        Deal();
        playerCount = _players.size();
        centerPile = new GroupOfCards();
        slappers = new ArrayList<>();
        losers = new ArrayList<>();
        selectedPlayer = 0;
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
        selectedPlayer = 0;
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
        if (isAJack(centerPile.getBottomCard()) || isAPair())
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
        // Reset all the lists.
        losers.clear();
        slappers.clear();
        return winner;
    }

    /**
     * Cycles through the players.
     */
    public Player selectNextPlayer()
    {
        // If selectedPlayer is at the last player, the index is cycled back to first player.
        if (selectedPlayer >= Players.size() - 1)
        {
            selectedPlayer = 0;
        }
        else // Otherwise, move to the next player.
        {
            selectedPlayer++;
        }
        return Players.get(selectedPlayer);
    }

    /**
     * Determines if the card is a jack.
     * @param c The card to be determined if jack.
     * @return
     */
    public boolean isAJack(Card c)
    {
        return (c.getValue().equals("JACK"));
    }

    /**
     * Determines if the top card and the card below it are the same value.
     * @return
     */
    public boolean isAPair() {
        return (centerPile.getBottomCard().getValue()
        .equals(centerPile.getGroup().get(centerPile.CardCount()-2)));
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
