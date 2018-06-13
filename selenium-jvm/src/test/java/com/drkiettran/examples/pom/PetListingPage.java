package com.drkiettran.examples.pom;

import java.util.List;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.drkiettran.examples.model.Found;

public class PetListingPage {
	private static final Logger logger = LogManager.getLogger(PetListingPage.class.toString());
	private WebDriver driver;
	private By byPetName = By.xpath("//div[@class='name']//h3");
	private By byNextButton = By.xpath("//a[@class='next_page']");
	private By byViewDetails = By.xpath("//div[@class='view']//input");

	public PetListingPage(WebDriver driver) {
		this.driver = driver;
	}

	public Found looksFor(String petName) {
		List<WebElement> nameElements = driver.findElements(byPetName);

		// @formatter:off
		return new Found(
			nameElements.stream()
						.filter(nameElement -> nameElement.getText().equalsIgnoreCase(petName))
						.collect(Collectors.toList()).size() == 1);
		// @formatter:on
	}

	public Found looksForNextButton() {
		List<WebElement> nextButtons = driver.findElements(byNextButton);
		return new Found(nextButtons.size() == 1);
	}

	public void clicksNext() {
		List<WebElement> nextButtons = driver.findElements(byNextButton);
		nextButtons.get(0).click();
	}

	public void viewsDetail(String petName) {
		List<WebElement> nameElements = driver.findElements(byPetName);
		List<WebElement> viewDetails = driver.findElements(byViewDetails);
		for (int i = 0; i < nameElements.size(); i++) {
			if (nameElements.get(i).getText().equalsIgnoreCase(petName)) {
				logger.info(String.format("View %s in details", nameElements.get(i).getText()));
				viewDetails.get(i).click();
				break;
			}
		}
	}

}
