package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Model game;
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
        game = new Model();
    }

    public void backToHomePage(View myView) {
        Intent myIntent;
        myIntent = new Intent(this, Homepage.class);
        startActivity(myIntent);
    }

    private void disableAll(){
        Button b00 = findViewById(R.id.b00);
        Button b01 = findViewById(R.id.button01);
        Button b02 = findViewById(R.id.button02);

        Button b10 = findViewById(R.id.button10);
        Button b11 = findViewById(R.id.button11);
        Button b12 = findViewById(R.id.button12);

        Button b20 = findViewById(R.id.button20);
        Button b21 = findViewById(R.id.button21);
        Button b22 = findViewById(R.id.button22);

        b00.setEnabled(false);
        b01.setEnabled(false);
        b02.setEnabled(false);

        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);

        b20.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);

    }


}