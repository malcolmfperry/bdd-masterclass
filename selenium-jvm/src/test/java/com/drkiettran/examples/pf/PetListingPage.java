package com.drkiettran.examples.pf;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.drkiettran.examples.model.Found;

public class PetListingPage {
	private static final Logger logger = Logger.getLogger(PetListingPage.class.toString());
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='name']//h3")
	private List<WebElement> nameElements;

	@FindBy(xpath = "//a[@class='next_page']")
	private List<WebElement> nextButtons;

	@FindBy(xpath = "//div[@class='view']//input")
	private List<WebElement> viewDetails;

	public PetListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public Found looksFor(String petName) {

		// @formatter:off
		return new Found(
			nameElements.stream()
						.filter(nameElement -> nameElement.getText().equalsIgnoreCase(petName))
						.collect(Collectors.toList()).size() == 1);
		// @formatter:on
	}

	public Found looksForNextButton() {
		return new Found(nextButtons.size() == 1);
	}

	public void clicksNext() {
		nextButtons.get(0).click();
	}

	public void viewsDetail(String petName) {
		for (int i = 0; i < nameElements.size(); i++) {
			if (nameElements.get(i).getText().equalsIgnoreCase(petName)) {
				logger.info(String.format("View %s in details", nameElements.get(i).getText()));
				viewDetails.get(i).click();
				break;
			}
		}
	}

}
