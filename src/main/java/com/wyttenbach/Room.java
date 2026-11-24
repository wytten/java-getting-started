package com.wyttenbach;

import java.util.HashSet;
import java.util.Set;

public class Room {
	private int num;
	private String desc;
	private Set<Action> actions;
	
	public Room(int roomNum, String roomDesc) {
		num = roomNum;
		desc = roomDesc;
		actions = new HashSet<>();
	}
	
	public void addAction(Action action) {
		actions.add(action);
	}
	
	public int getNumber() {
		return num;
	}
	
	public String getDescription() {
		return desc;
	}

	public Set<Action> getActions() {
		return actions;
	}
	
	public Action getAction(String desc) {
		Action target = null;
		for (Action action : actions) {
			if (desc.equalsIgnoreCase(action.getName())) {
				target = action;
				break;
			}
		}
		return target;
	}
}
