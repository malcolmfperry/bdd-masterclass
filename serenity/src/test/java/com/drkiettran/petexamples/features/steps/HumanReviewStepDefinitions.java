package com.drkiettran.petexamples.features.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.petexamples.features.steps.serenity.HumanReviewSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class HumanReviewStepDefinitions {
	
	private static Logger logger = LoggerFactory.getLogger(HumanReviewStepDefinitions.class);
	private String url;
	
	@Steps
	private HumanReviewSteps humanReview;
	
	@Given("^I am at the HR website$")
	public void i_am_at_the_HR_website() {
		logger.info("***: Visiting the human review website!");
		this.url = getWebsiteUrl();
		logger.info("***: open web browser @: " + url);
		humanReview.goToUrl(url);
	}

	@When("^I login using user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_using_user_and_password(String username, String password) {
		humanReview.entersUsernameAndPassword(username, password);
		humanReview.login();
	}

	@Then("^I should be landed on the main page with welcome message \"([^\"]*)\"$")
	public void i_should_be_landed_on_the_main_page_with_welcome_message(String expectedWelcomeMessage) {
		String welcomeMessage = humanReview.findWelcomeMessage();
		assertThat(welcomeMessage, is(expectedWelcomeMessage));
	}
	
	private String getWebsiteUrl() {
		return System.getProperty("website.url");
	}
}