package com.drkiettran.examples.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdoptionPage {

	private WebDriver driver;
	
	@FindBy(id="notice")
	private WebElement note;

	public AdoptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void visit(String websiteURL) {
		driver.get(websiteURL);
	}

	public String getNotes() {
		return note.getText();
	}

}
