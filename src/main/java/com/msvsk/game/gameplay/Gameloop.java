package com.msvsk.game.gameplay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.msvsk.game.utils.PrintBoardState;

public class Gameloop 
{
    private List<Player> players;
    private Board board;
    private Dice dice;
    PlayerPickingStrategy pickPlayer;
    WinnerStrategy winnerStrategy;
    BonusMoveStrategy bonusMoveStrategy;

    public Gameloop(List<Player> players, Board board, Dice dice, PlayerPickingStrategy pickPlayer, WinnerStrategy winnerStrategy, BonusMoveStrategy bonusMoveStrategy) {
        this.players = players;
        this.board = board;
        this.dice = dice;
        this.pickPlayer = pickPlayer;
        this.winnerStrategy = winnerStrategy;
        this.bonusMoveStrategy = bonusMoveStrategy;
    }

    public void playGame() throws InterruptedException, IOException {
        System.out.println("Loading Snakes & Ladders ...");
        Thread.sleep(3000);

        int curPlayerIdx = 0;

        while(true) {
            Player curPlayer = players.get(curPlayerIdx);
            System.out.println("\n----- Player" + curPlayerIdx + "'s turn -----");

            // make a move
            int oldPosition = curPlayer.getPosition();
            curPlayer.makeMove();
            System.out.println("\nPlayer" + curPlayerIdx + "  finally moved from " + oldPosition + " to " + curPlayer.getPosition());

            // check for winner
            int winner = winnerStrategy.checkAndReturnWinner(board, players);
            if(winner != -1) {
                System.out.println("Player" + winner + " WON the game !!");
                break;
            }

            // print board after the move
            PrintBoardState.print(board, players);

            // pick next player
            curPlayerIdx = pickPlayer.nextPlayer(players, curPlayerIdx, dice, bonusMoveStrategy);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // create board and dice
        Board board = new Board(9);
        board.insertSnake(7, 2);
        board.insertSnake(6, 1);
        board.insertLadder(2, 4);
        board.insertLadder(6, 8);
        Dice dice = new SingleDice();

        // create players
        Player player0 = new Player(board, dice);
        Player player1 = new Player(board, dice);
        List<Player> players = new ArrayList<>();
        players.add(player0);
        players.add(player1);

        // create strategies
        PlayerPickingStrategy pickingStrategy = new RoundRobinPlayerPickingStrategy();
        WinnerStrategy winnerStrategy = new DefaultWinnerStrategy();
        BonusMoveStrategy bonusMoveStrategy = new DefaultBonusMoveStrategy();

        // create gameloop
        Gameloop gameloop = new Gameloop(players, board, dice, pickingStrategy, winnerStrategy, bonusMoveStrategy);

        // play the game
        gameloop.playGame();
    }
}
