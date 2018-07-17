package com.drkiettran.examples.features;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.drkiettran.examples.automation.WebDriverHandler2;
import com.drkiettran.examples.model.PaymentInfo;
import com.drkiettran.examples.workflow.AdoptionStepsPOMStyle;

@RunWith(JUnit4.class)
public class AdoptPetsPOMStyle {
	private static final Logger logger = LogManager.getLogger(AdoptPetsPOMStyle.class);

	private static WebDriverHandler2 wdh;

	private String petName2bAdopted;
	private PaymentInfo paymentInfo;
	private String expectedNote;

	private AdoptionStepsPOMStyle adopter;

	@BeforeClass
	public static void createAndStartService() throws Exception {
		wdh = new WebDriverHandler2();
	}

	@AfterClass
	public static void stopService() {
		wdh.stopChromeDriverService();
	}

	@Before
	public void setUp() {
		adopter = new AdoptionStepsPOMStyle(wdh);
		adopter.visits(websiteUrl());
		loadsTestData();
		logger.info("Set up completes!");
	}

	private void loadsTestData() {
		petName2bAdopted = "Topsy";
		paymentInfo = new PaymentInfo("Check", "John Doe", "123 Main Street, New York, NY 12345", "jdoe@email.com");
		expectedNote = "Thank you for adopting a puppy!";
		logger.info("Load data completes!");
	}

	@After
	public void tearDown() {
		wdh.quit();
	}

	private String websiteUrl() {
		return System.getenv("PUPPY_WEBSITE");
	}

	@Test
	public void adoptPets_withOneExistingPet_getsThankYouNote() throws Exception {
		given_there_exists_a_pet_named(petName2bAdopted);
		when_I_adopt_the_pet_named(petName2bAdopted);
		and_I_pay_for_the_adoption_using(paymentInfo);
		then_I_should_receive_this_note(expectedNote);
	}

	private void then_I_should_receive_this_note(String expectedNote2) {
		String actualNote = adopter.receivesNote();
		assertThat(expectedNote, equalTo(actualNote));
		logger.info("Received: " + actualNote);
	}

	private void and_I_pay_for_the_adoption_using(PaymentInfo thePayInfo) {
		adopter.paysForTheAdoptionWith(thePayInfo);
		logger.info("The adoption is paid for!");
	}

	private void when_I_adopt_the_pet_named(String thePet) {
		adopter.viewsDetailsOf(thePet);
		adopter.adopts(thePet);
		adopter.completesTheAdoption();
		logger.info(thePet + " is adopted!");
	}

	private void given_there_exists_a_pet_named(String thePet) throws Exception {
		adopter.searchesPetByName(thePet);
		logger.info(thePet + " is found!");
	}

}
