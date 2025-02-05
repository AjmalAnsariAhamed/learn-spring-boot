package com.practice.coupling.loosecoupling;

public class Console {
    public static void main(String[] args) {
        MarioGame marioGame= new MarioGame();
        GameRunner runner= new GameRunner(marioGame);
        runner.runner();
        Contra contraGame= new Contra();
        GameRunner contraRunner=new GameRunner(contraGame);
        contraRunner.runner();
    }
}
