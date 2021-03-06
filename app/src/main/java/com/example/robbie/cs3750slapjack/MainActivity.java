package com.example.robbie.cs3750slapjack;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //MenuFragment startup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startup = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.activity_main,new MenuFragment(),"MF").commit();
    }

    /**
     * Start the game by passing in ArrayList of
     * @param players
     *
     * Function called from MenuFragment's btnPlay onClickListener
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void startGame(ArrayList<Player> players) {

        SlapJackGame objSent = new SlapJackGame(players);
        Bundle bundle = new Bundle();
        bundle.putBinder("object_value", new ObjectWrapperForBinder(objSent));
        startActivity(new Intent(this, GameActivity.class).putExtras(bundle));
        //restartSetUp();
        Log.d("does this work", "original object=" + objSent);
    }

    /*public void restartSetUp(){
        //startup.removePlayers();
    }*/
}
