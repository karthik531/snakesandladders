package com.msvsk.game.utils;

import com.msvsk.game.model.Dice;
import com.msvsk.game.model.MoveType;
import com.msvsk.game.model.Player;

public class DefaultBonusMoveStrategy implements BonusMoveStrategy
{
    @Override
    public boolean hasBonusMove(Player player, Dice dice) {
        if(player.getLastMove() == MoveType.LADDER || dice.getCurValue() == dice.getMaxValue()) {
            return true;
        }
        return false;
    }
}
