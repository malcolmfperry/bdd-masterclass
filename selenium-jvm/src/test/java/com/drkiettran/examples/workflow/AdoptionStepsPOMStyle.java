package com.drkiettran.examples.workflow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drkiettran.examples.automation.WebDriverHandler;
import com.drkiettran.examples.model.PaymentInfo;
import com.drkiettran.examples.pom.AdoptionPage;
import com.drkiettran.examples.pom.PaymentPage;
import com.drkiettran.examples.pom.PetDetailPage;
import com.drkiettran.examples.pom.PetListingPage;
import com.drkiettran.examples.pom.PetShoppingCartPage;

public class AdoptionStepsPOMStyle {
	private static final Logger logger = LogManager.getLogger(AdoptionStepsPOMStyle.class);
	private AdoptionPage adoptionPage;
	private PetListingPage petListingPage;
	private PetDetailPage petDetailPage;
	private PetShoppingCartPage petShoppingCartPage;
	private PaymentPage paymentPage;

	public AdoptionStepsPOMStyle() {
		adoptionPage = new AdoptionPage(WebDriverHandler.getRemoteWebDriver());
		petListingPage = new PetListingPage(WebDriverHandler.getRemoteWebDriver());
		petDetailPage = new PetDetailPage(WebDriverHandler.getRemoteWebDriver());
		petShoppingCartPage = new PetShoppingCartPage(WebDriverHandler.getRemoteWebDriver());
		paymentPage = new PaymentPage(WebDriverHandler.getRemoteWebDriver());
	}

	public void given_I_am_at_the_Puppy_Adoption_Agency() {
		String websiteURL = System.getenv("PUPPY_WEBSITE");
		adoptionPage.visit(websiteURL);
		logger.info("Opened website!");
	}

	public void visits(String websiteURL) {
		adoptionPage.visit(websiteURL);
		logger.info("Opened website!");
	}

	public void searchesPetByName(String petName) throws Exception {
		for (;;) {
			if (petListingPage.looksFor(petName).isFound()) {
				logger.info("Found " + petName);
				break;
			}

			if (petListingPage.looksForNextButton().isFound()) {
				petListingPage.clicksNext();
				logger.info("next page.");
				continue;
			}
			throw new Exception("The pet is not found!");
		}
	}

	public void viewsDetailsOf(String thePet) {
		petListingPage.viewsDetail(thePet);
	}

	public void adopts(String thePet) {
		petDetailPage.adopts(thePet);
	}

	public void completesTheAdoption() {
		petShoppingCartPage.complesAdoption();
	}

	public void paysForTheAdoptionWith(PaymentInfo payInfo) {
		paymentPage.placesOrder(payInfo.getPayType(), payInfo.getPayer(), payInfo.getPayerAddress(),
				payInfo.getPayerEmail());
	}

	public String receivesNote() {
		return adoptionPage.getsNote();
	}
}
