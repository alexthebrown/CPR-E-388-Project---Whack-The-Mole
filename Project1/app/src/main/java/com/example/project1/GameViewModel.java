package com.example.project1;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

/**
 *
 */
public class GameViewModel extends ViewModel {
    private MutableLiveData<Boolean> oneOne = new MutableLiveData<>();
    private MutableLiveData<Boolean> oneTwo = new MutableLiveData<>();
    private MutableLiveData<Boolean> oneThree = new MutableLiveData<>();

    private MutableLiveData<Boolean> twoOne = new MutableLiveData<>();
    private MutableLiveData<Boolean> twoTwo = new MutableLiveData<>();
    private MutableLiveData<Boolean> twoThree = new MutableLiveData<>();

    private MutableLiveData<Boolean> threeOne = new MutableLiveData<>();
    private MutableLiveData<Boolean> threeTwo = new MutableLiveData<>();
    private MutableLiveData<Boolean> threeThree = new MutableLiveData<>();

    private MutableLiveData<Boolean> fourOne = new MutableLiveData<>();
    private MutableLiveData<Boolean> fourTwo = new MutableLiveData<>();
    private MutableLiveData<Boolean> fourThree = new MutableLiveData<>();

    private MutableLiveData<Integer> score = new MutableLiveData<>();
    private MutableLiveData<Integer> fails = new MutableLiveData<>();

    private boolean gameStarted = false;

    private int spawnRate = 1000;
    private int checkRate = 5000;

    private boolean[] spawned = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false};

    /**
     * @author Alex Brown and Blake Hardy
     * Starts game, sets started flag to true, initializes all MutableLiveData variables.
     */
    public void start(){
        gameStarted = true;
        getOneOne().setValue(false);
        getOneTwo().setValue(false);
        getOneThree().setValue(false);

        getTwoOne().setValue(false);
        getTwoTwo().setValue(false);
        getTwoThree().setValue(false);

        getThreeOne().setValue(false);
        getThreeTwo().setValue(false);
        getThreeThree().setValue(false);

        getFourOne().setValue(false);
        getFourTwo().setValue(false);
        getFourThree().setValue(false);
        runGame();
    }

    /**
     * @author Alex Brown and Blake Hardy
     * Stops game by means of switching started flag.
     */
    public void endGame(){
        gameStarted = false;
    }

    /**
     * @author Alex Brown and Blake Hardy
     * Creates handler, and runs that handles the game functionality.
     * Random numbers to decide next spawn time and location. Calls spawnMole()
     */
    public void runGame(){
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run(){
//                Log.d("blah", "Yep its runnin");
                if(gameStarted){
                    Random rand = new Random();
                    int timeTillNext = rand.nextInt(3) * spawnRate;
                    int moleLocation = rand.nextInt(12) + 1;
//                    int moleLocation = 1;
                    spawnMole(moleLocation);
                    spawnRate -= 2;
                    handler.postDelayed(this, timeTillNext);
                }
            }
        });
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @param location
     * Sets the boolean related to each "mole hill" to true if it isn't already. Starts a "timer" before and checks to see that it has been set back to false by then. If not, increments failures/
     */
    public void spawnMole(int location){
//        Log.d("something", "Spawning at location: " + location);
        final Handler handler = new Handler();
        switch(location){
            case 1:
                if(oneOne.getValue() == (Boolean)false && !spawned[location]){
                    getOneOne().setValue(true);
                    spawned[location] = true;
                    Log.d("In Spawn location 1", "True");
                }
                break;
            case 2:
                if(oneTwo.getValue() == (Boolean)false && !spawned[location]){
                    getOneTwo().setValue(true);
                    spawned[location] = true;
                }
                break;
            case 3:
                if(oneThree.getValue() == (Boolean)false && !spawned[location]){
                    getOneThree().setValue(true);
                    spawned[location] = true;
                }
                break;
            case 4:
                if(twoOne.getValue() == (Boolean)false && !spawned[location]){
                    getTwoOne().setValue(true);
                    spawned[location] = true;
                }
                break;
            case 5:
                if(twoTwo.getValue() == (Boolean)false && !spawned[location]){
                    getTwoTwo().setValue(true);
                    spawned[location] = true;
                }
                break;
            case 6:
                if(twoThree.getValue() == (Boolean)false && !spawned[location]){
                getTwoThree().setValue(true);
                    spawned[location] = true;
            }
                break;
            case 7:
                if(threeOne.getValue() == (Boolean)false && !spawned[location]){
                getThreeOne().setValue(true);
                    spawned[location] = true;
            }
                break;
            case 8:
                if(threeTwo.getValue() == (Boolean)false && !spawned[location]){
                getThreeTwo().setValue(true);
                    spawned[location] = true;
            }
                break;
            case 9:
                if(threeThree.getValue() == (Boolean)false && !spawned[location]){
                getThreeThree().setValue(true);
                    spawned[location] = true;
            }
                break;
            case 10:
                if(fourOne.getValue() == (Boolean)false && !spawned[location]){
                getFourOne().setValue(true);
                    spawned[location] = true;
            }
                break;
            case 11:
                if(fourTwo.getValue() == (Boolean)false && !spawned[location]){
                getFourTwo().setValue(true);
                    spawned[location] = true;
            }
                break;
            case 12:
                if(fourThree.getValue() == (Boolean)false && !spawned[location]){
                getFourThree().setValue(true);
                    spawned[location] = true;
                }
                break;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(spawned[location]) {
                    switch (location) {
                        case 1:
                            if (oneOne.getValue() == (Boolean) true) {
                                getOneOne().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 2:
                            if (oneTwo.getValue() == (Boolean) true) {
                                getOneTwo().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 3:
                            if (oneThree.getValue() == (Boolean) true) {
                                getOneThree().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 4:
                            if (twoOne.getValue() == (Boolean) true) {
                                getTwoOne().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 5:
                            if (twoTwo.getValue() == (Boolean) true) {
                                getTwoTwo().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 6:
                            if (twoThree.getValue() == (Boolean) true) {
                                getTwoThree().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 7:
                            if (threeOne.getValue() == (Boolean) true) {
                                getThreeOne().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 8:
                            if (threeTwo.getValue() == (Boolean) true) {
                                getThreeTwo().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 9:
                            if (threeThree.getValue() == (Boolean) true) {
                                getThreeThree().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 10:
                            if (fourOne.getValue() == (Boolean) true) {
                                getFourOne().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 11:
                            if (fourTwo.getValue() == (Boolean) true) {
                                getFourTwo().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                        case 12:
                            if (fourThree.getValue() == (Boolean) true) {
                                getFourThree().setValue(false);
                                Integer currentFails = fails.getValue();
                                if(currentFails == null){
                                    currentFails = 0;
                                }
                                getFails().setValue(currentFails + 1);
                            }
                            break;
                    }
                    checkRate -= 4;
                    spawned[location] = false;
                }
            }

        },checkRate);
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @param location
     * Based on the location sent, sets the boolean for that location to false, and adds score to the player if the value was true when the function was called, ie. there was a mole there.
     */
    public void tapSquare(Integer location){
        switch(location) {
            case 1:
                if (oneOne.getValue() == (Boolean) true) {
                    getOneOne().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 2:
                if (oneTwo.getValue() == (Boolean) true) {
                    getOneTwo().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 3:
                if (oneThree.getValue() == (Boolean) true) {
                    getOneThree().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 4:
                if (twoOne.getValue() == (Boolean) true) {
                    getTwoOne().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 5:
                if (twoTwo.getValue() == (Boolean) true) {
                    getTwoTwo().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 6:
                if (twoThree.getValue() == (Boolean) true) {
                    getTwoThree().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 7:
                if (threeOne.getValue() == (Boolean) true) {
                    getThreeOne().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 8:
                if (threeTwo.getValue() == (Boolean) true) {
                    getThreeTwo().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 9:
                if (threeThree.getValue() == (Boolean) true) {
                    getThreeThree().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 10:
                if (fourOne.getValue() == (Boolean) true) {
                    getFourOne().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 11:
                if (fourTwo.getValue() == (Boolean) true) {
                    getFourTwo().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
            case 12:
                if (fourThree.getValue() == (Boolean) true) {
                    getFourThree().setValue(false);
                    Integer currentScore = score.getValue();
                    if(currentScore == null){
                        currentScore = 0;
                    }
                    getScore().setValue(currentScore + 500);
                }
                break;
        }
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @return oneOne
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getOneOne() {
        if (oneOne == null){
            oneOne = new MutableLiveData<>();
        }
        return oneOne;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return oneTwo
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getOneTwo() {
        if (oneTwo == null){
            oneTwo = new MutableLiveData<>();
        }
        return oneTwo;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return oneThree
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getOneThree() {
        if (oneThree == null){
            oneThree = new MutableLiveData<>();
        }
        return oneThree;
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @return twoOne
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getTwoOne() {
        if (twoOne == null){
            twoOne = new MutableLiveData<>();
        }
        return twoOne;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return twoTwo
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getTwoTwo() {
        if (twoTwo == null){
            twoTwo = new MutableLiveData<>();
        }
        return twoTwo;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return twoThree
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getTwoThree() {
        if (twoThree == null){
            twoThree = new MutableLiveData<>();
        }
        return twoThree;
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @return threeOne
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getThreeOne() {
        if (threeOne == null){
            threeOne = new MutableLiveData<>();
        }
        return threeOne;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return threeTwo
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getThreeTwo() {
        if (threeTwo == null){
            threeTwo = new MutableLiveData<>();
        }
        return threeTwo;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return threeThree
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getThreeThree() {
        if (threeThree == null){
            threeThree = new MutableLiveData<>();
        }
        return threeThree;
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @return fourOne
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getFourOne() {
        if (fourOne == null){
            fourOne = new MutableLiveData<>();
        }
        return fourOne;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return fourTwo
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getFourTwo() {
        if (fourTwo == null){
            fourTwo = new MutableLiveData<>();
        }
        return fourTwo;
    }
    /**
     * @author Alex Brown and Blake Hardy
     * @return fourThree
     * Returns Mutable Live Data pertaining to that mole on the grid.
     */
    public MutableLiveData<Boolean> getFourThree() {
        if (fourThree == null){
            fourThree = new MutableLiveData<>();
        }
        return fourThree;
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @return score
     * Returns Mutable Live Data pertaining to the player's score
     */
    public MutableLiveData<Integer> getScore() {
        if (score == null){
            score = new MutableLiveData<>();
        }
        return score;
    }

    /**
     * @author Alex Brown and Blake Hardy
     * @return fails
     * Returns Mutable Live Data pertaining to the failures incurred by the player.
     */
    public MutableLiveData<Integer> getFails() {
        if(fails == null){
            fails = new MutableLiveData<>();
        }
        return fails;
    }
}
