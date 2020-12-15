package com.drkiettran.petexamples.pages;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HumanReviewLoginPage extends PageObject {
	
	@FindBy(id = "UserName")
	private WebElement userNameInput;

	@FindBy(id = "Password")
	private WebElement passwordInput;
	
	@FindBy(id = "LoginButton")
	private WebElement loginButton;
	
	@FindBy(id = "welcomeMessage")
	private WebElement welcomeMessage;
	
	public void enterUsernameAndPassword(String username, String password) {
		userNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
	}
	
	public void login() {
		loginButton.click();
	}
	
	public String findWelcomeMessage() {
		return welcomeMessage.getText();
	}
}