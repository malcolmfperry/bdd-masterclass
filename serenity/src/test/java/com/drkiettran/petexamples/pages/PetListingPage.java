package com.drkiettran.petexamples.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PetListingPage extends PageObject {

	@FindBy(xpath = "//div[@class='name']//h3")
	private List<WebElement> nameElements;

	@FindBy(xpath = "//div[@class='view']//input")
	private List<WebElement> viewElements;

	@FindBy(xpath = "//a[@class='next_page']")
	private List<WebElement> nextPageElements;

	public boolean looksFor(String pet) {
		// @formatter:off
		return 
		nameElements.stream()
					.filter(nameElement -> nameElement.getText().equalsIgnoreCase(pet))
					.collect(Collectors.toList()).size() == 1;
		// @formatter:on
	}

	public void selects(String selectedPet) {
		for (int i = 0; i < nameElements.size(); i++) {
			if (nameElements.get(i).getText().equalsIgnoreCase(selectedPet)) {
				viewElements.get(i).click();
			}
		}
	}

	public void clicksNext() {
		if (nextPageElements.size() == 1) {
			nextPageElements.get(0).click();
		}
	}

	public boolean searchesNextPage() {
		return nextPageElements.size() == 1;
	}

}
