package com.drkiettran.examples.cukes.features;

import com.drkiettran.examples.automation.WebDriverHandler;
import com.drkiettran.examples.cukes.workflows.Adopter;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdoptPetSteps {
	

	private Adopter adopter;

	@Given("^the adoption agency has a pet named \"([^\"]*)\"$")
	public void the_adoption_agency_has_a_pet_named(String arg1) throws Throwable {
		adopter .visitsAdoptionAgency();
		
	}

	@When("^I adopt the pet \"([^\"]*)\"$")
	public void i_adopt_the_pet(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I pay for the adoption using \"([^\"]*)\" with PII as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_pay_for_the_adoption_using_with_PII_as(String arg1, String arg2, String arg3, String arg4)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I should receive this note \"([^\"]*)\"$")
	public void i_should_receive_this_note(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
