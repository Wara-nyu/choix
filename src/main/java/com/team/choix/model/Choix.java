package com.team.choix.model;


public class Choix {
	private String prenoms;
	private String seniors;
	private String juniors;
	
    public Choix(final String prenomsParDefautValue) {
        prenoms = prenomsParDefautValue;
    }
    
    public Choix() {
    }

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
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
