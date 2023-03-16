package com.msvsk.game.strategy;

import java.util.List;

import com.msvsk.game.model.Dice;
import com.msvsk.game.model.Player;
import com.msvsk.game.utils.BonusMoveStrategy;

public interface PlayerPickingStrategy {
    
    public int nextPlayer(List<Player> players, int curPlayer, Dice dice, BonusMoveStrategy bonusMoveStrategy);
}
