package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    //Button settings;
    Button instructions;//was formerly the rules button
    Button startBTN;
    Button undo;
    private Model game = new Model();
    private MovesStack movesStack = new MovesStack();
    String gameMode;
    String[] modes = {"HVH", "HVA"};
    RadioButton hvhBTN;
    RadioButton hvaBTN;
    /*
    While the game is still running
    Track the moves in a stack
    get the peek value then
    get the buttons clicked, enable the next button


    change the color of the previous button (create a change color method, black for player 1,
    white for player 2.

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = (Button) findViewById(R.id.instructions);


        instructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openInstructions();
            }

        });

        startBTN = (Button) findViewById(R.id.button);
        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GameMode = new Intent(MainActivity.this, GameMode.class);
                startActivity(GameMode);
            }
        });
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(MainActivity.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }


    protected void undoLastMove(){
        undo = (Button) findViewById(R.id.undo);
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.updateBoard(movesStack.deleteMove()[0], movesStack.deleteMove()[1], " ");
            }
        });

    }

}