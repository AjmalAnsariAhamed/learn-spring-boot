package com.practice.coupling.loosecoupling;

public class GameRunner {
    private Game game;

    public GameRunner(Game game) {
        this.game = game;
    }
    public void runner(){
        game.run();
    }
}
