package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P2Win extends AppCompatActivity {
    private static final String WINNER = "app\\src\\main\\java\\com\\example\\connect4\\winners.txt";
    File myFile = new File(WINNER);
    String winner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWinner();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_win);

        TextView winText = findViewById(R.id.defaultMessage);
        winText.setText(winner.toUpperCase() + "WINS!");
        /*
        *
        * */

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*1), (int)(height*1));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
    }

    private void getWinner(){
        Scanner input;
        try{
            input = new Scanner(myFile);
            while(input.hasNextLine()){
                winner = input.nextLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR - File not found");
        }
    }
}
