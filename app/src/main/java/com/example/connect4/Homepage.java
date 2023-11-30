package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    //Button settings;
    Button instructions;//was formerly the rules button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        instructions = (Button) findViewById(R.id.instructions);
        instructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openInstructions();
            }

        });
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(Homepage.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

//    /**
//     * This function will run when the “view rule” button is clicked. There will be a textview
//     * containing the rules that will be hidden and this function will enable that textview.
//     */
//    protected void displayRules(){
//
//    }
    /**
     * This function will take the user to the game page for human vs human
     */
    protected void goToHHGamePage(){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    /**
     * This function will take the user to the game page for human vs AI
     */
    protected void goToHAGamePage(){

    }

}