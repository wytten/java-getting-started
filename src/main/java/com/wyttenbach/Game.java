package com.wyttenbach;

import java.util.HashMap;

public class Game {
	private HashMap<Integer, Room> rooms = new HashMap<>();

	public void addRoom(Room room) {
		rooms.put(room.getNumber(), room);
	}
	
	public Room getRoom(int roomNum) {
		return rooms.get(roomNum);
	}
}
