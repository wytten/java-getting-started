package com.wyttenbach;

import java.util.Scanner;

public class TestGameRunner {
	private Game game;
	
	public TestGameRunner(Game game) {
		this.game = game;
	}

	public int run() {
		int exitStatus = 0;
		Room room = game.getRoom(0);
	    Scanner sc = new Scanner(System.in);
	    boolean done = false;
		while(!done) {
			System.out.println(room.getDescription());
			for (Action action: room.getActions()) {
				if ("%exit".equals(action.getName())) {
					done = true;
					exitStatus = action.getNumber();
					break;
				} 
			}
			if (!done) {
				String cmd = sc.next();
				Action action = room.getAction(cmd);
				if (action != null) {
					room = game.getRoom(action.getNumber());
				}
			}
		}
		sc.close();
		return exitStatus;
	}
}
