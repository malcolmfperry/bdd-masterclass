package com.drkiettran.petexamples.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class AdoptionPage extends PageObject {

	@FindBy(id = "notice")
	private WebElement noticePara;

	public String getThankYouNote() {
		return noticePara.getText();
	}

}
