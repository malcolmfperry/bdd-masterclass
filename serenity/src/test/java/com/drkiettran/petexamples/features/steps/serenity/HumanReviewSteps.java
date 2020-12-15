package com.drkiettran.petexamples.features.steps.serenity;

import com.drkiettran.petexamples.pages.HumanReviewLoginPage;
import net.thucydides.core.annotations.Step;

public class HumanReviewSteps {

	private HumanReviewLoginPage humanReviewLoginPage;
	
	@Step
	public void goToUrl(String url) {
		humanReviewLoginPage.openAt(url);
	}
	
	@Step
	public void entersUsernameAndPassword(String username, String password) {
		humanReviewLoginPage.enterUsernameAndPassword(username, password);
	}
	
	@Step
	public void login() {
		humanReviewLoginPage.login();
	}
	
	@Step
	public String findWelcomeMessage() {
		return humanReviewLoginPage.findWelcomeMessage();
	}
}