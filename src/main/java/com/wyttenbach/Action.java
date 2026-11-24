package com.wyttenbach;

public class Action {
	private String name;
	private int number;
	
	public Action(String actionName, int actionNum) {
		name = actionName;
		number = actionNum;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}
	
}
