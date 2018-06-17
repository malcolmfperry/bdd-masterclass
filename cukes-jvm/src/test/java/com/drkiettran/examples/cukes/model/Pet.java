package com.drkiettran.examples.cukes.model;

public class Pet {
	private String petName;
	private String shortDescription;
	private String description;
	private double fees;

	public Pet(String petName, String shortDescription, String description, double fees) {
		super();
		this.petName = petName;
		this.shortDescription = shortDescription;
		this.description = description;
		this.fees = fees;
	}

	public String getPetName() {
		return petName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public double getFees() {
		return fees;
	}
}
