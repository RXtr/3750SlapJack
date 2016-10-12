package com.example.robbie.cs3750slapjack;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    HandFragment[] playerBoards;
    SlapJackGame game;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        game = (SlapJackGame)((ObjectWrapperForBinder)getIntent()
                .getExtras().getBinder("object_value")).getData();

        if(game.getPlayerCount() == 2) {
            playerBoards = new HandFragment[2];
            playerBoards[0] = new HandFragment();
            playerBoards[1] = new HandFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.topRight, playerBoards[0], "playerOne").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.bottomRight, playerBoards[1], "playerTwo").commit();

        }
        else {
            playerBoards = new HandFragment[4];
            playerBoards[0] = new HandFragment();
            playerBoards[1] = new HandFragment();
            playerBoards[2] = new HandFragment();
            playerBoards[3] = new HandFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.topLeft, playerBoards[0], "playerOne").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.topRight, playerBoards[1], "playerTwo").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.bottomLeft, playerBoards[2], "playerThree").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.bottomRight, playerBoards[3], "playerFour").commit();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.centerLayout, new CenterFragment(), "pileFragment").commit();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPlayerBoards(game.getPlayers());
        highlightPlayer(game.getSelectedPlayer());
    }

    public void highlightPlayer(int player)
    {
        if(player == 0) {
            playerBoards[0].highlight();
            playerBoards[playerBoards.length - 1].removeHighlight();
        }

        else if(player == 1){
            playerBoards[1].highlight();
            playerBoards[0].removeHighlight();
        }

        else if(player == 2){
            playerBoards[2].highlight();
            playerBoards[1].removeHighlight();
        }

        else{
            playerBoards[3].highlight();
            playerBoards[2].removeHighlight();
        }
    }

    public void setPlayerBoards(ArrayList<Player> players)
    {
        for(int i = 0; i < players.size(); i++)
        {
            playerBoards[i].setPlayerLabel(players.get(i).getName());
            playerBoards[i].setCardCountLabel(players.get(i).CardCount());
            playerBoards[i].setSlapIndex(i);
        }
    }

    public Card playerTurn()
    {
        Player player = game.getPlayers().get(game.getSelectedPlayer());
        HandFragment fa;

        if(game.getSelectedPlayer() == 0)
            fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerOne");
        else if(game.getSelectedPlayer() == 1)
            fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerTwo");
        else if(game.getSelectedPlayer() == 2)
            fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerThree");
        else
            fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerFour");

        fa.setCardCountLabel(player.CardCount());

        game.selectNextPlayer();
        highlightPlayer(game.getSelectedPlayer());
        return player.placeCard(game.getCenterPile());
    }

    public void playerSlap(int slapIndex)
    {
        HandFragment fa;
        CenterFragment ca;

        if(game.getCenterPile().CardCount() == 0)
            return;

        Player slapper = game.getPlayers().get(slapIndex);
        game.setSlapper(slapper);

        if(game.isAJack(game.getCenterPile().getBottomCard()) || game.isAPair())
        {
            ca = (CenterFragment)getSupportFragmentManager().findFragmentByTag("pileFragment");
            game.awardCards(slapper);
            ca.showBlank();

        }
        else
        {
            slapper.giveCardsMisslap(game.getPlayers());
            if(slapper.CardCount() <= 0)
            {
                game.addToLosers(slapper);
                game.getPlayers().remove(slapper.getPlayerNumber());
                disablePlayer(slapper);
                if(game.getPlayers().size() == 1) {

                    Player winner = game.determineWinner();

                    //show winner
                    //stop everything
                }
            }
        }
        int playersLeft = game.getPlayers().size();

        // Update the card count labels for each player.
        for(int i = 0; i < playersLeft; i++)
        {
            int playerIndex = game.getPlayers().get(i).getPlayerNumber();

            if(playerIndex == 0) {
                fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerOne");
            }
            else if(playerIndex == 1) {
                fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerTwo");
            }
            else if(playerIndex == 2) {
                fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerThree");
            }
            else {
                fa = (HandFragment) getSupportFragmentManager().findFragmentByTag("playerFour");
            }

            //fa.setCardCountLabel(slapper.CardCount());
            fa.setCardCountLabel(game.getPlayers().get(i).CardCount());
        }
    }

    public void disablePlayer(Player loser)
    {
        playerBoards[loser.getPlayerNumber()].outOfGame();
    }

    public void scalaAnimation()
    {
        //AnimationUtils.LoadAnimation(this, R.anim.scale_anim);
    }



    public SlapJackGame getGame()
    {
        return game;
    }
}
