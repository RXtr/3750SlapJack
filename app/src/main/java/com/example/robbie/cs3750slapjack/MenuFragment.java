package com.example.robbie.cs3750slapjack;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    RadioButton         rdo2Players;
    RadioButton         rdo4Players;
    EditText            edtPlayer1;
    EditText            edtPlayer2;
    EditText            edtPlayer3;
    EditText            edtPlayer4;
    Button              btnPlay;
    LinearLayout        layoutPlayer1;
    LinearLayout        layoutPlayer2;
    LinearLayout        layoutPlayer3;
    LinearLayout        layoutPlayer4;
    private ArrayList<Player>   Players;

    public MenuFragment() {
        // Required empty public constructor
        Players = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View menuView = inflater.inflate(R.layout.fragment_menu, container, false);

        rdo2Players     = (RadioButton)     menuView.findViewById(R.id.rdo2Players);
        rdo4Players     = (RadioButton)     menuView.findViewById(R.id.rdo4Players);
        edtPlayer1      = (EditText)        menuView.findViewById(R.id.edtPlayer1);
        edtPlayer2      = (EditText)        menuView.findViewById(R.id.edtPlayer2);
        edtPlayer3      = (EditText)        menuView.findViewById(R.id.edtPlayer3);
        edtPlayer4      = (EditText)        menuView.findViewById(R.id.edtPlayer4);
        btnPlay         = (Button)          menuView.findViewById(R.id.btnPlay);
        layoutPlayer1   = (LinearLayout)    menuView.findViewById(R.id.layoutPlayer1);
        layoutPlayer2   = (LinearLayout)    menuView.findViewById(R.id.layoutPlayer2);
        layoutPlayer3   = (LinearLayout)    menuView.findViewById(R.id.layoutPlayer3);
        layoutPlayer4   = (LinearLayout)    menuView.findViewById(R.id.layoutPlayer4);

        /**
         * If 2-player mode is selected, display only first two name fields.
         */
        rdo2Players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setEnabled(true);
                layoutPlayer1.setVisibility(View.VISIBLE);
                layoutPlayer2.setVisibility(View.VISIBLE);
                layoutPlayer3.setVisibility(View.INVISIBLE);
                layoutPlayer4.setVisibility(View.INVISIBLE);
            }
        });

        /**
         * If 4-player mode is selected, display all name fields.
         */
        rdo4Players.setOnClickListener(new View.OnClickListener() { // If 4-player mode is selected,
            @Override                                               // show all 4 name fields.
            public void onClick(View v) {
                btnPlay.setEnabled(true);
                layoutPlayer1.setVisibility(View.VISIBLE);
                layoutPlayer2.setVisibility(View.VISIBLE);
                layoutPlayer3.setVisibility(View.VISIBLE);
                layoutPlayer4.setVisibility(View.VISIBLE);
            }
        });

        /**
         * Check which radio button is pressed, and pass the
         * @param Players ArrayList to strtGame method
         * in MainActivity
         */
        btnPlay.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v) {
                if (rdo2Players.isChecked()) {
                    String p1Name = edtPlayer1.getText().toString();
                    String p2Name = edtPlayer2.getText().toString();

                    if (p1Name.matches("") || p1Name.equals(""))
                        p1Name = "Player 1";
                    Players.add(0, new Player(p1Name, 0));
                    if (p2Name.matches("") || p2Name.equals(""))
                        p2Name = "Player 2";
                    Players.add(1, new Player(p2Name, 1));

                    MainActivity ma = (MainActivity) getActivity();
                    ma.startGame(Players);
                }

                else if (rdo4Players.isChecked()) {
                    String p1Name = edtPlayer1.getText().toString();
                    String p2Name = edtPlayer2.getText().toString();
                    String p3Name = edtPlayer3.getText().toString();
                    String p4Name = edtPlayer4.getText().toString();

                    if (p1Name.matches("") || p1Name.equals(""))
                        p1Name = "Player 1";
                    Players.add(0, new Player(p1Name, 0));
                    if (p2Name.matches("") || p2Name.equals(""))
                        p2Name = "Player 2";
                    Players.add(1, new Player(p2Name, 1));
                    if (p3Name.matches("") || p3Name.equals(""))
                        p3Name = "Player 3";
                    Players.add(2, new Player(p3Name, 2));
                    if (p4Name.matches("") || p4Name.equals(""))
                        p4Name = "Player 4";
                    Players.add(3, new Player(p4Name, 3));

                    MainActivity ma = (MainActivity) getActivity();
                    ma.startGame(Players);
                }
                else
                    Toast.makeText(getActivity(), "Select the number of players before playing.", Toast.LENGTH_SHORT).show();
            }
        });


        return menuView;
    }

}
