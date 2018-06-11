package com.drkiettran.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PetDetailPage {

	private WebDriver driver;
	private By byAdoptMeButton = By.xpath("//input[@value='Adopt Me!']");

	public PetDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void adopts(String petName) {
		driver.findElement(byAdoptMeButton).click();
	}

}
