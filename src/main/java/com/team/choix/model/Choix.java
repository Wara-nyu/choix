package com.team.choix.model;


public class Choix {
	private String prenoms;
	
    public Choix(final String prenomsParDefautValue) {
        prenoms = prenomsParDefautValue;
    }

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

}
