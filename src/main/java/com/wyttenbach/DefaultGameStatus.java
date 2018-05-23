package com.wyttenbach;

public class DefaultGameStatus implements GameStatus {

	private String description;
	private boolean running;
	private int exitStatus;

	public DefaultGameStatus(String description, boolean running, int exitStatus) {
		this.description = description;
		this.running = running;
		this.exitStatus = exitStatus;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return running;
	}

	@Override
	public int getExitStatus() {
		// TODO Auto-generated method stub
		return exitStatus;
	}

}
