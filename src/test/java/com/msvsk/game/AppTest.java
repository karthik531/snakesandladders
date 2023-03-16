package com.msvsk.game;

import org.junit.jupiter.api.Test;

import com.msvsk.game.gameplay.Gameloop;
import com.msvsk.game.model.Board;
import com.msvsk.game.model.Dice;
import com.msvsk.game.model.Player;
import com.msvsk.game.model.SingleDice;
import com.msvsk.game.strategy.DefaultWinnerStrategy;
import com.msvsk.game.strategy.PlayerPickingStrategy;
import com.msvsk.game.strategy.RoundRobinPlayerPickingStrategy;
import com.msvsk.game.strategy.WinnerStrategy;
import com.msvsk.game.utils.BonusMoveStrategy;
import com.msvsk.game.utils.DefaultBonusMoveStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    void testApp() throws InterruptedException, IOException {
        

    }
}
