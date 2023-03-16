package com.msvsk.game.utils;

import com.msvsk.game.model.Dice;
import com.msvsk.game.model.Player;

public interface BonusMoveStrategy
{
    public boolean hasBonusMove(Player player, Dice dice);
}
