package com.example.robbie.cs3750slapjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> playerName = intent.getExtras().getStringArrayList("playerList");
        Toast.makeText(this, "there are " + playerName.size() + " players", Toast.LENGTH_SHORT).show();



    }
}
