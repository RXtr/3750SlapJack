package com.example.robbie.cs3750slapjack;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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

    private ImageButton icon;
    private TextView cardCount;
    private TextView playerName;
    private int slapIndex;

    private SlapJackGame game;
    public HandFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hand, container, false);
        cardCount = (TextView) view.findViewById(R.id.CardCount);
        playerName = (TextView) view.findViewById(R.id.PlayerName);
        icon = (ImageButton) view.findViewById(R.id.imageButton);
        icon.getBackground().setColorFilter(getRandomColor(), PorterDuff.Mode.SRC_ATOP);

        /**
         * When the icon is clicked, the following things will happen:
         * Player who slapped will add itself to the slapper list,
         * Game will determine after a while who slapped first,
         * the first slapper will either be rewarded or penalized,
         * any losers will be disabled,
         * and game continues with next player.
         */
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity ga = (GameActivity)getActivity();
//                game = ga.getGame();
//                // Determine who slapped first.
//                game.determineGainOrLoss(game.getSlappers().get(0));
                ga.playerSlap(slapIndex);
            }
        });

        return view;
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

    public void setSlapIndex(int playerIndex)
    {
        slapIndex = playerIndex;
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    /**
     * Disables the player's displayed information.
     */
    public void outOfGame()
    {
        icon.setEnabled(false);
        cardCount.setEnabled(false);
        playerName.setEnabled(false);
        icon.setImageDrawable(Drawable.createFromPath("drawable/hand_disabled.png"));
        Drawable handDisabled = getResources().getDrawable(R.drawable.hand_disabled);
        icon.setImageDrawable(handDisabled);
    }

    /**
     * Sets the player's name.
     * @param name
     */
    public void setPlayerLabel(String name)
    {
        this.playerName.setText(name);
    }

    public void setCardCountLabel(int cards)
    {
        this.cardCount.setText(cards + "");
    }
}
