package com.example.robbie.cs3750slapjack;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
                Card card;
                GameActivity ga = (GameActivity)getActivity();
                card = ga.playerTurn();
                Context context = cardPile.getContext();
                //needs the correct conext to work current does not.
                cardPile.setImageResource(GetImage(ga.getApplication(), card.toString()));
            }
        });
        return view;
    }
    public static int GetImage(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }
}
