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

        backToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Model.class, Homepage.class);
                startActivity(Intent intent);
            }
        });


    }
}