package com.practice.coupling.tightcoupling;

public class Console {
    public static void main(String[] args) {
        MarioGame game= new MarioGame();
        GameRunner runner= new GameRunner(game);
        runner.runner();
    }
}
