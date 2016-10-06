package com.example.robbie.cs3750slapjack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


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
        View view = (View)inflater.inflate(R.layout.fragment_hand, container, false);
        icon = (ImageButton)view.findViewById(R.id.imageButton);
        icon.setImageResource(R.drawable.dark_brotherhood_hand);

        return view;
    }

}
