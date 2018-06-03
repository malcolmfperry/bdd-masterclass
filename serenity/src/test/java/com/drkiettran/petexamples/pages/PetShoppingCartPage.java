package com.drkiettran.petexamples.pages;

import org.openqa.selenium.WebElement;

import com.drkiettran.petexamples.model.PaymentInfo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PetShoppingCartPage extends PageObject {

	@FindBy (xpath = "//input[@value='Complete the Adoption']")
	private WebElement completeAdoptionButton;

	public void completesAdoption() {
		completeAdoptionButton.click();
	}

}
