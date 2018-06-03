package com.drkiettran.petexamples.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PetDetailPage extends PageObject {

	@FindBy(xpath = "//input[@value='Adopt Me!']")
	private WebElement adoptMeButton;

	public void adopts() {
		adoptMeButton.click();
	}

}
