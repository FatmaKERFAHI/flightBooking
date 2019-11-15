package com.softeam.flight.entities;

public enum TypeVol {
	Affaire,
	Economique; 
	private String name = "";
	
	private TypeVol() {
	}
    private TypeVol(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
		

}

