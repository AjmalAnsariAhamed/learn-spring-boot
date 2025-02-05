package com.practice.coupling.tightcoupling;

public class GameRunner {
    private MarioGame game;

    public GameRunner(MarioGame game) {
        this.game = game;
    }
    public void runner(){
        game.run();
    }
}
