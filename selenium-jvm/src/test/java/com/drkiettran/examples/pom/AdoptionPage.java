package com.drkiettran.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdoptionPage {

	private WebDriver driver;
	private By byNoteId = By.id("notice");

	public AdoptionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit(String websiteURL) {
		driver.get(websiteURL);
	}

	public String getsNote() {
		return driver.findElement(byNoteId).getText();
	}

}
