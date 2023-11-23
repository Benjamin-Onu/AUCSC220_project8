package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
public class Homepage extends AppCompatActivity {
    //Button rules;
    //Button settings;


    /**
     * This function will run when the “view rule” button is clicked. There will be a textview
     * containing the rules that will be hidden and this function will enable that textview.
     */
    protected void displayRules(){

    }
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