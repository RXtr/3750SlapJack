package com.example.robbie.cs3750slapjack;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class HandFragment extends Fragment {

    ImageButton icon;
    private TextView cardCount;
    private TextView playerName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hand, container, false);
        cardCount = (TextView) view.findViewById(R.id.CardCount);
        playerName = (TextView) view.findViewById(R.id.PlayerName);
        icon = (ImageButton) view.findViewById(R.id.imageButton);
        icon.getBackground().setColorFilter(getRandomColor(), PorterDuff.Mode.SRC_ATOP);


        return view;
    }

    public HandFragment() {

        // Required empty public constructor
    }

    public void highlight()
    {
        playerName.setTextColor(Color.rgb(252, 108, 178));
        playerName.setTypeface(null, Typeface.BOLD);
    }

    public void removeHighlight()
    {
        playerName.setTextColor(Color.BLACK);
        playerName.setTypeface(null, Typeface.NORMAL);
    }


    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public void setPlayerLabel(String name)
    {
        this.playerName.setText(name);
    }

    public void setCardCountLabel(int cards)
    {
        this.cardCount.setText(cards + "");
    }
}
