package com.example.tictactoegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class Options extends AppCompatActivity {


    // private RadioButton easy_radiobutton;
    // private RadioButton medium_radiobutton;
    // private RadioButton hard_radiobutton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        initButton();
    }

    private void initButton() {

        RadioButton easy = findViewById(R.id.easy_radiobutton);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.EASY_DIF);
            }
        });

        RadioButton medium = findViewById(R.id.medium_radiobutton);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.MEDIUM_DIF);
            }
        });

        RadioButton hard = findViewById(R.id.hard_radiobutton);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.HARD_DIF);
            }
        });

        //switch (TicTacToy.getTnstance().getDifficulty())
        //  case TicTacToy


    }

}
