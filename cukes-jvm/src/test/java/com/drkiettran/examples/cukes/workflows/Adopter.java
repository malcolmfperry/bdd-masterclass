package com.drkiettran.examples.cukes.workflows;

import com.drkiettran.examples.cukes.activities.Visit;

public class Adopter {

	private final Visit visit;

	public Adopter(Visit visit) {
		this.visit = visit;
	}

	public void visitsAdoptionAgency() {
		visit.goesToAdoptionAgency();
	}

}
