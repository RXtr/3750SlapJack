package com.example.robbie.cs3750slapjack;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    HandFragment[] playerBoards;
    SlapJackGame game;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d("Did this work", "Maybe4");
        SlapJackGame objReceived = (SlapJackGame)((ObjectWrapperForBinder)getIntent()
                .getExtras().getBinder("object_value")).getData();
        Log.d("Did this work", "received object=" + objReceived);

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
        //highlightPlayer(game.getSelectedPlayer());
    }

    public void highlightPlayer(int player)
    {
        if(player == 0) {
            playerBoards[0].highlight();
            playerBoards[4].removeHighlight();
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
            playerBoards[i].setPlayerLabel(players.get(i).getName().toString());
            playerBoards[i].setCardCountLabel(players.get(i).getHand().CardCount());
        }
    }
}
