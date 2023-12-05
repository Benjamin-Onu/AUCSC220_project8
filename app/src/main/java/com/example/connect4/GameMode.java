package com.example.connect4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameMode extends AppCompatActivity {
    Button pVp;
    Button pVai;
    Button instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode);
        instructions = (Button) findViewById(R.id.instructions);
        pVp = (Button) findViewById(R.id.pVp);
        pVai = (Button) findViewById(R.id.pVai);

        instructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openInstructions();
            }

        });

        pVp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
//function for going to pVp page is inserted here
                Intent startGame = new Intent(GameMode.this, Gameplay.class);
                startActivity(startGame);
            }
        });

                pVai.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View x){
//function for going to pVai page is inserted here
                        Intent startGame = new Intent(GameMode.this, GamePlayAI.class);
                        startActivity(startGame);
                    }
                });


    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(GameMode.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }




}
