package com.example.robbie.cs3750slapjack;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    HandFragment[] playerBoards;
    SlapJackGame game;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
        if(game.getCenterPile().CardCount() == 0)
            return;

        Player slappee = game.getPlayers().get(slapIndex);
        game.setSlapper(slappee);

        if(game.isAJack(game.getCenterPile().getBottomCard()) || game.isAPair())
        {
            game.awardCards(slappee);
        }
        else
        {
            slappee.giveCardsMisslap(game.getPlayers());
            if(slappee.CardCount() <= 0)
            {
                game.addToLosers(slappee);
                game.getPlayers().remove(slappee.getPlayerNumber());
                disablePlayer(slappee);
                if(game.getPlayers().size() == 1) {

                    Player winner = game.determineWinner();

                    //show winner

                }
            }
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
}
