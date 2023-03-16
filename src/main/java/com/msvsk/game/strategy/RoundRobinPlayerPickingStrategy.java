package com.msvsk.game.strategy;

import java.util.List;

import com.msvsk.game.model.Dice;
import com.msvsk.game.model.Player;
import com.msvsk.game.utils.BonusMoveStrategy;

public class RoundRobinPlayerPickingStrategy implements PlayerPickingStrategy
{
    @Override
    public int nextPlayer(List<Player> players, int curPlayer, Dice dice, BonusMoveStrategy bonusMoveStrategy) {
        
        // check if current player has bonus move
        if(bonusMoveStrategy.hasBonusMove(players.get(curPlayer), dice)) {
            return curPlayer;
        }

        return (curPlayer + 1) % players.size();
    }
}
