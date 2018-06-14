package com.drkiettran.examples.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetShoppingCartPage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@value='Complete the Adoption']")
	private WebElement completeAdoptionButton;

	public PetShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void complesAdoption() {
		completeAdoptionButton.click();
	}

}
