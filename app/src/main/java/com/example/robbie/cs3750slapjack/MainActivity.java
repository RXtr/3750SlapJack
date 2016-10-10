package com.example.robbie.cs3750slapjack;

//comment

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.activity_main,new MenuFragment(),"MF").commit();
    }

    /**
     * Start the game by passing in ArrayList of
     * @param players
     *
     * Function called from MenuFragment's btnPlay onClickListener
     */
    public void startGame(ArrayList<String> players) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("playerList",players);
        startActivity(intent);
        //new SlapJackGame(players);
        //getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,new HandFragment(),"blah").commit();
    }
}
