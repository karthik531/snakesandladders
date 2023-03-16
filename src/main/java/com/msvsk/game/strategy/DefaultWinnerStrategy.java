package com.msvsk.game.strategy;

import java.util.List;

import com.msvsk.game.model.Board;
import com.msvsk.game.model.Player;

public class DefaultWinnerStrategy implements WinnerStrategy
{
    @Override
    public int checkAndReturnWinner(Board board, List<Player> players) {
        int count = 0;
        for(Player player : players) {
            if(player.getPosition() == board.getFinalCell()) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
