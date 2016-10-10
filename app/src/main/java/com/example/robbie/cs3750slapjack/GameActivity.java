package com.example.robbie.cs3750slapjack;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView text;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        text = (TextView)findViewById(R.id.textView);
        Log.d("Did this work", "Maybe4");
        SlapJackGame objReceived = (SlapJackGame)((ObjectWrapperForBinder)getIntent()
                .getExtras().getBinder("object_value")).getData();
        Log.d("Did this work", "received object=" + objReceived);
        if(objReceived.getPlayerCount() == 2){

        }
        else{

        }
        text.setText("Player count" + objReceived.getPlayerCount()  + "\n" + objReceived.getPlayers().get(0).getName()
            + " \n" + objReceived.getPlayers().get(1).getName());

    }
}
