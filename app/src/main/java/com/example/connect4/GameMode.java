package com.example.connect4;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameMode extends AppCompatActivity {
    Button pVp;
    Button pVai;
    Button instructions;
    Button mute;
    private MediaPlayer mediaPlayer;
    private boolean isMuted = false;
    private static String gameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemode);
        instructions = (Button) findViewById(R.id.instructions);
        pVp = (Button) findViewById(R.id.pVp);
        pVai = (Button) findViewById(R.id.pVai);
        mute = findViewById(R.id.mute);

        instructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openInstructions();
            }

        });

        pVp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View x){
                //function for going to pVai page is inserted here
                gameMode = "HvH";
                Intent startGame = new Intent(GameMode.this, Gameplay.class);
                startActivity(startGame);
            }
        });

        pVai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View x){
                //function for going to pVai page is inserted here
                gameMode = "HvA";
                Intent startGame = new Intent(GameMode.this, GamePlayAI.class);
                startActivity(startGame);
            }
        });

        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMute();
            }
        });
    }

    public String getGameMode(){
        return gameMode;
    }
    private void openInstructions() {
        Intent popupInstructions = new Intent(GameMode.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

    private void toggleMute(){
        isMuted = !isMuted;
        if (mediaPlayer != null){
            if (isMuted){
                mediaPlayer.setVolume(0,0);
            }
            else {
                mediaPlayer.setVolume(1,1);
            }
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
