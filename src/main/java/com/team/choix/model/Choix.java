package com.team.choix.model;


public class Choix {
	private String seniors;
	private String juniors;
	
    public Choix(final String prenomsParDefautValue) {
        seniors = prenomsParDefautValue;
        juniors = prenomsParDefautValue;
    }
    
    public Choix() {
    }

	public String getSeniors() {
		return seniors;
	}

	public void setSeniors(String seniors) {
		this.seniors = seniors;
	}

	public String getJuniors() {
		return juniors;
	}

	public void setJuniors(String juniors) {
		this.juniors = juniors;
	}

}
