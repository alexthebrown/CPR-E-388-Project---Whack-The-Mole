package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Alex Brown and Blake Hardy
 */
public class GameScreen extends AppCompatActivity {

    private ImageView escapedOne;
    private ImageView escapedTwo;
    private ImageView escapedThree;

    private ImageView moleOneOne;
    private ImageView moleOneTwo;
    private ImageView moleOneThree;

    private ImageView moleTwoOne;
    private ImageView moleTwoTwo;
    private ImageView moleTwoThree;

    private ImageView moleThreeOne;
    private ImageView moleThreeTwo;
    private ImageView moleThreeThree;

    private ImageView moleFourOne;
    private ImageView moleFourTwo;
    private ImageView moleFourThree;

    private TextView currentScore;
    private int theScore;
    private int theHighScore;
    private TextView highScore;

    private GameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent recieved = getIntent();
        int highScoreRecieved = recieved.getIntExtra("highScore", 0);
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);

        escapedOne = findViewById(R.id.escapedImage1);
        escapedTwo = findViewById(R.id.escapedImage2);
        escapedThree = findViewById(R.id.escapedImage3);

        currentScore = findViewById(R.id.score);
        highScore = findViewById(R.id.highScoreInGame);
        highScore.setText(""+highScoreRecieved);

        moleOneOne = findViewById(R.id.moleOneOne);
        moleOneTwo = findViewById(R.id.moleOneTwo);
        moleOneThree = findViewById(R.id.moleOneThree);
        moleTwoOne = findViewById(R.id.moleTwoOne);
        moleTwoTwo = findViewById(R.id.moleTwoTwo);
        moleTwoThree = findViewById(R.id.moleTwoThree);
        moleThreeOne = findViewById(R.id.moleThreeOne);
        moleThreeTwo = findViewById(R.id.moleThreeTwo);
        moleThreeThree = findViewById(R.id.moleThreeThree);
        moleFourOne = findViewById(R.id.moleFourOne);
        moleFourTwo = findViewById(R.id.moleFourTwo);
        moleFourThree = findViewById(R.id.moleFourThree);

        moleOneOne.setImageResource(R.drawable.hill);
        moleOneTwo.setImageResource(R.drawable.hill);
        moleOneThree.setImageResource(R.drawable.hill);
        moleTwoOne.setImageResource(R.drawable.hill);
        moleTwoTwo.setImageResource(R.drawable.hill);
        moleTwoThree.setImageResource(R.drawable.hill);
        moleThreeOne.setImageResource(R.drawable.hill);
        moleThreeTwo.setImageResource(R.drawable.hill);
        moleThreeThree.setImageResource(R.drawable.hill);
        moleFourOne.setImageResource(R.drawable.hill);
        moleFourTwo.setImageResource(R.drawable.hill);
        moleFourThree.setImageResource(R.drawable.hill);

        viewModel.start();

        moleOneOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(1);
            }
        });
        moleOneTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(2);
            }
        });
        moleOneThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(3);
            }
        });

        moleTwoOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(4);

            }
        });
        moleTwoTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(5);

            }
        });
        moleTwoThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(6);

            }
        });

        moleThreeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(7);

            }
        });
        moleThreeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(8);

            }
        });
        moleThreeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(9);
            }
        });

        moleFourOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(10);

            }
        });
        moleFourTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(11);

            }
        });
        moleFourThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.tapSquare(12);

            }
        });



        final Observer<Boolean> oneOneObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleOneOne.setImageResource(R.drawable.mole);
                }
                else{
                    moleOneOne.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> oneTwoObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleOneTwo.setImageResource(R.drawable.mole);
                }
                else{
                    moleOneTwo.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> oneThreeObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleOneThree.setImageResource(R.drawable.mole);
                }
                else{
                    moleOneThree.setImageResource(R.drawable.hill);
                }
            }
        };

        final Observer<Boolean> twoOneObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleTwoOne.setImageResource(R.drawable.mole);
                }
                else{
                    moleTwoOne.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> twoTwoObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleTwoTwo.setImageResource(R.drawable.mole);
                }
                else{
                    moleTwoTwo.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> twoThreeObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleTwoThree.setImageResource(R.drawable.mole);
                }
                else{
                    moleTwoThree.setImageResource(R.drawable.hill);
                }
            }
        };

        final Observer<Boolean> threeOneObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleThreeOne.setImageResource(R.drawable.mole);
                }
                else{
                    moleThreeOne.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> threeTwoObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleThreeTwo.setImageResource(R.drawable.mole);
                }
                else{
                    moleThreeTwo.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> threeThreeObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleThreeThree.setImageResource(R.drawable.mole);
                }
                else{
                    moleThreeThree.setImageResource(R.drawable.hill);
                }
            }
        };

        final Observer<Boolean> fourOneObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleFourOne.setImageResource(R.drawable.mole);
                }
                else{
                    moleFourOne.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> fourTwoObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleFourTwo.setImageResource(R.drawable.mole);
                }
                else{
                    moleFourTwo.setImageResource(R.drawable.hill);
                }
            }
        };
        final Observer<Boolean> fourThreeObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    moleFourThree.setImageResource(R.drawable.mole);
                }
                else{
                    moleFourThree.setImageResource(R.drawable.hill);
                }
            }
        };

        final Observer<Integer> scoreObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                currentScore.setText(String.format("%d", integer));
            }
        };

        final Observer<Integer> failObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(integer == 1){
                    escapedOne.setImageResource(R.drawable.x);
                } else if(integer == 2){
                    escapedTwo.setImageResource(R.drawable.x);
                } else if (integer == 3){
                    escapedThree.setImageResource(R.drawable.x);
                    viewModel.endGame();
                    Intent i = new Intent(GameScreen.this, MainActivity.class);
                    i.putExtra("finalScore", currentScore.getText());
                    startActivity(i);
                }
                else{

                }
            }
        };


        viewModel.getOneOne().observe(this, oneOneObserver);
        viewModel.getOneTwo().observe(this, oneTwoObserver);
        viewModel.getOneThree().observe(this, oneThreeObserver);

        viewModel.getTwoOne().observe(this, twoOneObserver);
        viewModel.getTwoTwo().observe(this, twoTwoObserver);
        viewModel.getTwoThree().observe(this, twoThreeObserver);

        viewModel.getThreeOne().observe(this, threeOneObserver);
        viewModel.getThreeTwo().observe(this, threeTwoObserver);
        viewModel.getThreeThree().observe(this, threeThreeObserver);

        viewModel.getFourOne().observe(this, fourOneObserver);
        viewModel.getFourTwo().observe(this, fourTwoObserver);
        viewModel.getFourThree().observe(this, fourThreeObserver);

        viewModel.getScore().observe(this, scoreObserver);
        viewModel.getFails().observe(this, failObserver);

    }
}