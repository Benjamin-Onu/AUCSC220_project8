package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button instructions;
    Model game;
    /*
    We have 42 buttons to implement and in order to keep this file readable without having
    to add 42 lines of initializing buttons, I created a buttons class to initialize all
    the buttons.
     */
    Buttons gamePieces = new Buttons();
    Button[][] gameBoard = gamePieces.getBoard();
    Button column1BTN = findViewById(R.id.column1);
    Button column2BTN = findViewById(R.id.column2);
    Button column3BTN = findViewById(R.id.column3);
    Button column4BTN = findViewById(R.id.column4);
    Button column5BTN = findViewById(R.id.column5);
    Button column6BTN = findViewById(R.id.column6);
    Button column7BTN = findViewById(R.id.column7);
    Button backToHomepage = findViewById(R.id.home);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instructions = (Button) findViewById(R.id.instructions);
        instructions.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openInstructions();
            }


        });
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(MainActivity.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

    public void backToHomePage(View myView) {
        Intent myIntent;
        myIntent = new Intent(this, Homepage.class);
        startActivity(myIntent);
    }

}