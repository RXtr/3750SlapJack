package com.example.robbie.cs3750slapjack;


import android.graphics.Color;
import android.graphics.PorterDuff;
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
    TextView cardCount;
    TextView playerName;

    public HandFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_hand, container, false);
        icon = (ImageButton) view.findViewById(R.id.imageButton);
        icon.getBackground().setColorFilter(getRandomColor(), PorterDuff.Mode.SRC_ATOP);

        return view;
    }
    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
