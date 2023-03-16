package com.msvsk.game.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player
{
    private int position;
    private Board board;
    private Dice dice;
    private MoveType lastMove;
    
    public Player(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        this.lastMove = MoveType.NORMAL;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public MoveType getLastMove() {
        return lastMove;
    }

    public void makeMove() throws IOException {
        System.out.println("\nPress any key to roll dice...");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
        int moveSteps = dice.roll();
        if(position + moveSteps > board.getFinalCell()) {
            // only move if not exceeding final cell
            return;
        }
        position += moveSteps;
        lastMove = MoveType.NORMAL;
        System.out.println("Moved to " + position);

        // check for snake/ladder
        if(board.hasSnake(position)) {
            int newPosition = board.getSnakeDestination(position);
            lastMove = MoveType.SNAKE;
            System.out.println("SNAKE!! at " + position + ", fell down to " + newPosition);
            position = newPosition;
        }
        else if(board.hasLadder(position)) {
            int newPosition = board.getLadderDestination(position);
            lastMove = MoveType.LADDER;
            System.out.println("LADDER!! at " + position + ", rose up to " + newPosition);
            position = newPosition;
        }
    }
}
