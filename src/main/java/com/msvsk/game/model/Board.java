package com.msvsk.game.model;

import java.util.HashMap;
import java.util.Map;

public class Board
{
    private final int finalCell;
    private Map<Integer, Integer> snakeMap;
    private Map<Integer, Integer> ladderMap;

    public Board(int finalCell) {
        this.finalCell = finalCell;
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
    }

    public Board(int finalCell, Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap) {
        this.finalCell = finalCell;
        this.snakeMap = new HashMap<>(snakeMap);
        this.ladderMap = new HashMap<>(ladderMap);
    }

    public Map<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    public Map<Integer, Integer> getLadderMap() {
        return ladderMap;
    }

    public int getFinalCell() {
        return finalCell;
    }

    public void insertSnake(int from, int to) {
        snakeMap.put(from, to);
    }
    public void removeSnake(int from) {
        snakeMap.remove(from);
    }

    public void insertLadder(int from, int to) {
        ladderMap.put(from, to);
    }
    public void removeLadder(int from) {
        ladderMap.remove(from);
    }

    public boolean hasSnake(int position) {
        return snakeMap.containsKey(position);
    }
    public boolean hasLadder(int position) {
        return ladderMap.containsKey(position);
    }

    public int getSnakeDestination(int position) {
        if(!hasSnake(position)) {
            return -1;
        }
        return snakeMap.get(position);
    }
    public int getLadderDestination(int position) {
        if(!hasLadder(position)) {
            return -1;
        }
        return ladderMap.get(position);
    }
}
