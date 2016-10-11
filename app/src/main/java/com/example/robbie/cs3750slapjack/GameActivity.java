package com.example.robbie.cs3750slapjack;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class GameActivity extends AppCompatActivity {

    HandFragment[] players;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Log.d("Did this work", "Maybe4");
        SlapJackGame objReceived = (SlapJackGame)((ObjectWrapperForBinder)getIntent()
                .getExtras().getBinder("object_value")).getData();
        Log.d("Did this work", "received object=" + objReceived);
        players = new HandFragment[objReceived.getPlayerCount()];
        if(objReceived.getPlayerCount() == 2) {
            players = new HandFragment[2];
            players[0] = new HandFragment();
            players[1] = new HandFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.topRight, players[0], "playerOne").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.bottomRight, players[1], "playerTwo").commit();

        }
        else {
            players = new HandFragment[4];
            players[0] = new HandFragment();
            players[1] = new HandFragment();
            players[2] = new HandFragment();
            players[3] = new HandFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.topLeft, players[0], "playerOne").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.topRight, players[1], "playerTwo").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.bottomLeft, players[2], "playerThree").commit();
            getSupportFragmentManager().beginTransaction().add(R.id.bottomRight, players[3], "playerFour").commit();

        }

        getSupportFragmentManager().beginTransaction().add(R.id.centerLayout, new CenterFragment(), "pileFragment").commit();

        //highlightPlayer(objReceived.getSelectedPlayer());


    }

    public void highlightPlayer(int player)
    {
        if(player == 0) {
            players[0].highlight();
            players[4].removeHighlight();
        }

        else if(player == 1){
            players[1].highlight();
            players[0].removeHighlight();
        }

        else if(player == 2){
            players[2].highlight();
            players[1].removeHighlight();
        }

        else{
            players[3].highlight();
            players[2].removeHighlight();
        }
    }
}
