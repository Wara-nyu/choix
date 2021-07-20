package com.team.choix.model;

public class Pair {
	String holder;
	String deputy;

	public Pair(String holder, String deputy) {
		super();
		this.holder = holder;
		this.deputy = deputy;
	}

	public Pair() {
	}
	
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public String getDeputy() {
		return deputy;
	}
	public void setDeputy(String deputy) {
		this.deputy = deputy;
	}
	
    @Override
    public String toString() {
    	return holder + ", " + deputy;
    }
}
