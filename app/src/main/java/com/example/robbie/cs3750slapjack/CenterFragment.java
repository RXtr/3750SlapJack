package com.example.robbie.cs3750slapjack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CenterFragment extends Fragment {

    ImageView cardPile;

    public CenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_center, container, false);

        cardPile = (ImageView) view.findViewById(R.id.cardPile);


        cardPile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity ga = (GameActivity)getActivity();
                ga.playerTurn();
            }
        });
        return view;
    }

}
