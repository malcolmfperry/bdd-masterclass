package com.drkiettran.petexamples.features.steps.serenity;

import com.drkiettran.petexamples.pages.AdoptionPage;
import com.drkiettran.petexamples.pages.PaymentPage;
import com.drkiettran.petexamples.pages.PetDetailPage;
import com.drkiettran.petexamples.pages.PetListingPage;
import com.drkiettran.petexamples.pages.PetShoppingCartPage;

import net.thucydides.core.annotations.Step;

public class AdopterSteps {

	private AdoptionPage adoptionPage;
	private PetListingPage petListingPage;
	private PetDetailPage petDetailPage;
	private PetShoppingCartPage petShoppingCartPage;
	private PaymentPage paymentPage;

	@Step
	public void goes_to_url(String url) {
		adoptionPage.openAt(url);
	}

	@Step
	public boolean searches_the_page_for(String pet) {
		return petListingPage.looksFor(pet);
	}

	@Step
	public void selects(String pet) {
		petListingPage.selects(pet);
	}

	@Step
	public boolean searches_next_page_button() {
		return petListingPage.searchesNextPage();
	}

	@Step
	public void clicks_next() {
		petListingPage.clicksNext();
	}

	@Step
	public void quits_adopting() {
	}

	@Step
	public void completes_the_adoption() {
		petShoppingCartPage.completesAdoption();
	}

	@Step
	public String searches_thank_you_note() {
		return adoptionPage.getThankYouNote();
	}

	@Step
	public void adopts(String pet) {
		petDetailPage.adopts();
	}

	@Step
	public void enters_payment_info(String name, String address, String email, String payType) throws Exception {
		paymentPage.fillsOut(name, address, email, payType);
	}

	@Step
	public void places_order() {
		paymentPage.placesOrder();
	}

}
