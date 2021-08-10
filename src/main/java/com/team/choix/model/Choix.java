package com.team.choix.model;


public class Choix {
	private String seniors;
	private String juniors;
	private String list;
	
	public Choix(final String allSeniors, final String allJuniors) {
        seniors = allSeniors;
        juniors = allJuniors;
    }
    
    public Choix(final String laList) {
    	list = laList;
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
	
    public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

}
