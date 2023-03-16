package com.msvsk.game.strategy;

import java.util.List;

import com.msvsk.game.model.Board;
import com.msvsk.game.model.Player;

public interface WinnerStrategy {
    
    public int checkAndReturnWinner(Board board, List<Player> players);
}
