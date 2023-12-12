package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.media.MediaPlayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Button settings;
    Button instructions;//was formerly the rules button
    Button startBTN;
    private Model game = new Model();
    Button loadBTN;
    MediaPlayer mediaPlayer;
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
                mediaPlayer.start();
            }
        });

        loadBTN = (Button) findViewById(R.id.load);
        loadBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGameState();
            }
        });
        // Initialize MediaPlayer with the audio file in the res/raw directory
        mediaPlayer = MediaPlayer.create(this, R.raw.music_file);
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(MainActivity.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

    protected void loadGameState(){
        Context context = getApplicationContext();
        File file = new File(context.getFilesDir(), "loadGameCheck.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String previousGame = "true";
            // Convert the string to bytes and write to the file
            fos.write(previousGame.getBytes());
            // Close the FileOutputStream
            fos.close();
            Intent startGame = new Intent(MainActivity.this, Gameplay.class);
            startActivity(startGame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}