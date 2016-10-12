package com.example.robbie.cs3750slapjack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class CenterFragment extends Fragment {

    private ImageView cardPile;
    private HashMap cardMap;

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
                setCardImageOnPile(ga.game.getCenterPile().getBottomCard().toString());
            }
        });
        buildMap();
        return view;
    }

    public void setCardImageOnPile(String cardName)
    {
        String path = cardName;
        cardPile.setImageResource((int)cardMap.get(cardName));
    }

    public void buildMap()
    {
        cardMap = new HashMap<String,Integer>();
        cardMap.put("ace_clubs.png", R.drawable.ace_clubs);
        cardMap.put("ace_hearts.png", R.drawable.ace_hearts);
        cardMap.put("ace_spades.png", R.drawable.ace_spades);
        cardMap.put("ace_diamonds.png", R.drawable.ace_diamonds);

        cardMap.put("two_clubs.png", R.drawable.two_clubs);
        cardMap.put("two_hearts.png", R.drawable.two_hearts);
        cardMap.put("two_spades.png", R.drawable.two_spades);
        cardMap.put("two_diamonds.png", R.drawable.two_diamonds);

        cardMap.put("three_clubs.png", R.drawable.three_clubs);
        cardMap.put("three_hearts.png", R.drawable.three_hearts);
        cardMap.put("three_spades.png", R.drawable.three_spades);
        cardMap.put("three_diamonds.png", R.drawable.three_diamonds);

        cardMap.put("four_clubs.png", R.drawable.four_clubs);
        cardMap.put("four_hearts.png", R.drawable.four_hearts);
        cardMap.put("four_spades.png", R.drawable.four_spades);
        cardMap.put("four_diamonds.png", R.drawable.four_diamonds);

        cardMap.put("five_clubs.png", R.drawable.five_clubs);
        cardMap.put("five_hearts.png", R.drawable.five_hearts);
        cardMap.put("five_spades.png", R.drawable.five_spades);
        cardMap.put("five_diamonds.png", R.drawable.five_diamonds);

        cardMap.put("six_clubs.png", R.drawable.six_clubs);
        cardMap.put("six_hearts.png", R.drawable.six_hearts);
        cardMap.put("six_spades.png", R.drawable.six_spades);
        cardMap.put("six_diamonds.png", R.drawable.six_diamonds);

        cardMap.put("seven_clubs.png", R.drawable.seven_clubs);
        cardMap.put("seven_hearts.png", R.drawable.seven_hearts);
        cardMap.put("seven_spades.png", R.drawable.seven_spades);
        cardMap.put("seven_diamonds.png", R.drawable.seven_diamonds);

        cardMap.put("eight_clubs.png", R.drawable.eight_clubs);
        cardMap.put("eight_hearts.png", R.drawable.eight_hearts);
        cardMap.put("eight_spades.png", R.drawable.eight_spades);
        cardMap.put("eight_diamonds.png", R.drawable.eight_diamonds);

        cardMap.put("nine_clubs.png", R.drawable.nine_clubs);
        cardMap.put("nine_hearts.png", R.drawable.nine_hearts);
        cardMap.put("nine_spades.png", R.drawable.nine_spades);
        cardMap.put("nine_diamonds.png", R.drawable.nine_diamonds);

        cardMap.put("ten_clubs.png", R.drawable.ten_clubs);
        cardMap.put("ten_hearts.png", R.drawable.ten_hearts);
        cardMap.put("ten_spades.png", R.drawable.ten_spades);
        cardMap.put("ten_diamonds.png", R.drawable.ten_diamonds);

        cardMap.put("jack_clubs.png", R.drawable.jack);
        cardMap.put("jack_hearts.png", R.drawable.jack);
        cardMap.put("jack_spades.png", R.drawable.jack);
        cardMap.put("jack_diamonds.png", R.drawable.jack);

        cardMap.put("queen_clubs.png", R.drawable.queen_clubs);
        cardMap.put("queen_hearts.png", R.drawable.queen_hearts);
        cardMap.put("queen_spades.png", R.drawable.queen_spades);
        cardMap.put("queen_diamonds.png", R.drawable.queen_diamonds);

        cardMap.put("king_clubs.png", R.drawable.king_clubs);
        cardMap.put("king_hearts.png", R.drawable.king_hearts);
        cardMap.put("king_spades.png", R.drawable.king_spades);
        cardMap.put("king_diamonds.png", R.drawable.king_diamonds);
    }
}
