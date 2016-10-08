package com.example.robbie.cs3750slapjack;

//comment
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

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
    public void startGame(ArrayList<Player> players) {
        new SlapJackGame(players);
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,new HandFragment(),"blah").commit();
    }
}
