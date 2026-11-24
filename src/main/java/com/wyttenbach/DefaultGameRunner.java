package com.wyttenbach;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultGameRunner implements GameRunner, InitializingBean {
	
	@Autowired
	private Game game;
	
	private Room room;
	
	private GameStatus status;

	@Override
	public GameStatus getStatus() {
		return status;
	}
	
	private void newGame() {
		newRoom(game.getRoom(0));
	}
	
	private void newRoom(Room room) {
		this.room = room;
		boolean running = true;
		int exitStatus = 0;
		for (Action action: room.getActions()) {
			if ("%exit".equals(action.getName())) {
				running = false;
				exitStatus = action.getNumber();
				break;
			} 
		}
		status = new DefaultGameStatus(room.getDescription(), running, exitStatus);
	}

	@Override
	public GameStatus apply(String cmd) {
		Action action = room.getAction(cmd);
		if (action != null) {
			room = game.getRoom(action.getNumber());
			newRoom(room);
		} else if ("%new".equals(cmd)) {
			newGame();
		}
		return status;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		newGame();
	}

}
