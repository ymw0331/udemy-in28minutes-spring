package com.wayneyong.learnspringframework;

import game.GameRunner;
import game.PacMan;

public class App01GamingBasicJava {

	public static void main(String[] args) {

//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacMan(); // 1: Object Creation

		var gameRunner = new GameRunner(game);
		// 2: Object Creation + Wiring of Dependencies
		// Game is a Dependency

		gameRunner.run();

	}

}
