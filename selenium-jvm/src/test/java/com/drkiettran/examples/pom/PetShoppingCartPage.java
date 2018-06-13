package com.drkiettran.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PetShoppingCartPage {

	private WebDriver driver;
	private By byCompleteButton = By.xpath("//input[@value='Complete the Adoption']");

	public PetShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void complesAdoption() {
		driver.findElement(byCompleteButton).click();
	}

}
