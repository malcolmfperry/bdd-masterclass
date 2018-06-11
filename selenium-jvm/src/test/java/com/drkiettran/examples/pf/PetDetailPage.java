package com.drkiettran.examples.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetDetailPage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@value='Adopt Me!']")
	private WebElement adoptMeButton;

	public PetDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void adopts(String petName) {
		adoptMeButton.click();
	}

}
