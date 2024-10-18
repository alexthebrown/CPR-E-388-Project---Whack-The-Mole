package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Alex Brown and Blake Hardy
 * Code for the main screen of the game.
 */
public class MainActivity extends AppCompatActivity {

    private Button startGame;
    private TextView highScore;
    private TextView lastScore;
    private int highScoreSaved = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences storedHighScore = getApplicationContext().getSharedPreferences("com.example.project1", Context.MODE_PRIVATE);
        highScoreSaved = storedHighScore.getInt("highScore", 0);
        SharedPreferences.Editor editor = storedHighScore.edit();
        startGame = findViewById(R.id.playButton);
        highScore = findViewById(R.id.highScore);
        lastScore = findViewById(R.id.lastScore);
        highScore.setText(""+highScoreSaved);
        Intent recieved = getIntent();
        String lastScoreRecieved = recieved.getStringExtra("finalScore");
        if(lastScoreRecieved != null){
            lastScore.setText(lastScoreRecieved);
            int convertLastScore = Integer.parseInt(lastScoreRecieved);
            if(convertLastScore > highScoreSaved){
                editor.putInt("highScore", convertLastScore);
                editor.apply();
                highScoreSaved = convertLastScore;
                highScore.setText(""+highScoreSaved);
            }
        }


        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchToGame = new Intent(MainActivity.this, GameScreen.class);
                switchToGame.putExtra("highScore", highScoreSaved);
                startActivity(switchToGame);
            }
        });
    }
}