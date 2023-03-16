package com.msvsk.game.utils;

import java.util.List;
import java.util.Map;

import com.msvsk.game.model.Board;
import com.msvsk.game.model.Player;

public class PrintBoardState 
{
    public static void print(Board board, List<Player> players) {
        System.out.println("\n-------- BOARD --------");
        System.out.println("\nSnake positions:");
        for(Map.Entry<Integer, Integer> entry : board.getSnakeMap().entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

        System.out.println("\nLadder positions:");
        for(Map.Entry<Integer, Integer> entry : board.getLadderMap().entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

        System.out.println("\nPlayer positions:");
        int count = 0;
        for(Player player : players) {
            System.out.println("Player" + count + " is at " + player.getPosition());
            count++;
        }
        System.out.println();
    }
}
