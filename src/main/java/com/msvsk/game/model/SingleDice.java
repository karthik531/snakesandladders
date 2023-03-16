package com.msvsk.game.model;

import java.util.Date;
import java.util.Random;

public class SingleDice implements Dice
{
    private Random rand;
    private int curValue;

    public int getCurValue() {
        return curValue;
    }

    public SingleDice() {
        rand = new Random(new Date().getTime());
    }

    @Override
    public int roll() {
        curValue = rand.nextInt(6) + 1;
        System.out.println("Dice value : " + curValue);
        return curValue;
    }

    @Override
    public int getMaxValue() {
        return 6;
    }
}
