package com.drkiettran.petexamples.features.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.petexamples.features.steps.serenity.AdopterSteps;
import com.drkiettran.petexamples.model.PaymentInfo;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AdoptPetsStepDefinitions {
	private static Logger logger = LoggerFactory.getLogger(AdoptPetsStepDefinitions.class);

	@Steps
	private AdopterSteps adopter;

	private String url;

	@Given("^I am at Puppy Adoption Agency website \"([^\"]*)\"$")
	public void i_am_at_Puppy_Adoption_Agency_website(String url) throws Exception {
		logger.info("***: open web browser with", url);
		this.url = url;
		adopter.goes_to_url(url);
	}

	@When("^I adopt these pets:$")
	public void i_adopt_these_pets(List<String> pets) throws Exception {
		pets.stream().forEach(pet -> {
			logger.info("***: search web page for " + pet);
			adopter.goes_to_url(url);

			for (;;) {
				boolean foundPet = adopter.searches_the_page_for(pet);

				if (foundPet) {
					logger.info("***: found ", pet);
					adopter.selects(pet);
					adopter.adopts(pet);
					break;
				} else {
					boolean foundNextButton = adopter.searches_next_page_button();
					if (foundNextButton) {
						logger.info("***: next page ...");
						adopter.clicks_next();
					} else {
						logger.info("***: ", pet, "not found!");
						adopter.quits_adopting();
						break;
					}
				}
			}
		});
	}

	@When("^I pay for the adoption with:$")
	public void i_pay_for_the_adoption_with(List<PaymentInfo> payInfoList) throws Exception {
		adopter.completes_the_adoption();
		adopter.enters_payment_info(payInfoList.get(0));
		adopter.places_order();
	}

	@Then("^I should see a message \"([^\"]*)\"$")
	public void i_should_see_a_message(String expectedThankyouNote) throws Exception {
		String actualThankyouNote = adopter.searches_thank_you_note();
		assertThat(actualThankyouNote, is(expectedThankyouNote));
	}
}
