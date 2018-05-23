package com.wyttenbach;

public interface GameRunner {
	GameStatus getStatus();
	GameStatus apply(String command);
}
