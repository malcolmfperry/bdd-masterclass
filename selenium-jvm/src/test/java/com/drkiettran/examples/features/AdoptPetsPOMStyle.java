package com.drkiettran.examples.features;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.drkiettran.examples.model.PaymentInfo;
import com.drkiettran.examples.pom.AdoptionPage;
import com.drkiettran.examples.pom.PaymentPage;
import com.drkiettran.examples.pom.PetDetailPage;
import com.drkiettran.examples.pom.PetListingPage;
import com.drkiettran.examples.pom.PetShoppingCartPage;

@RunWith(JUnit4.class)
public class AdoptPetsPOMStyle {
	private static final Logger logger = Logger.getLogger(AdoptPetsPOMStyle.class.toString());
	private static ChromeDriverService service;
	private WebDriver driver;
	private AdoptionPage adoptionPage;
	private PetListingPage petListingPage;
	private PetDetailPage petDetailPage;
	private PetShoppingCartPage petShoppingCartPage;
	private PaymentPage paymentPage;

	@BeforeClass
	public static void createAndStartService() throws Exception {
		String chromePath = System.getenv("WEBDRIVER_CHROME_DRIVER");
		// @formatter:off
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(chromePath))
				.usingAnyFreePort()
				.build();
		// @formatter:on
		service.start();
	}

	@AfterClass
	public static void stopService() {
		service.stop();
	}

	@Before
	public void setUp() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		adoptionPage = new AdoptionPage(driver);
		petListingPage = new PetListingPage(driver);
		petDetailPage = new PetDetailPage(driver);
		petShoppingCartPage = new PetShoppingCartPage(driver);
		paymentPage = new PaymentPage(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void shouldAdoptOnePet() throws Exception {
		given_I_am_at_the_Puppy_Adoption_Agency();
		when_I_adopt_a_pet_named("Topsy");
		and_I_pay_for_it_using(
				new PaymentInfo("Check", "John Doe", "123 Main Street, New York, NY 12345", "jdoe@email.com"));
		then_I_should_see_this_thank_you_message("Thank you for adopting a puppy!");
	}

	private void then_I_should_see_this_thank_you_message(String expectedNote) {
		assertThat(adoptionPage.getNotes(), equalTo(expectedNote));
		logger.info("Found the thank you note!");
	}

	private void and_I_pay_for_it_using(PaymentInfo payInfo) {
		paymentPage.placesOrder(payInfo.getPayType(), payInfo.getPayer(), payInfo.getPayerAddress(),
				payInfo.getPayerEmail());
		logger.info("Paid for the adoption!");
	}

	private void when_I_adopt_a_pet_named(String petName) throws Exception {
		for (;;) {
			if (petListingPage.looksFor(petName).isFound()) {
				logger.info("Found " + petName);
				break;
			}

			if (petListingPage.looksForNextButton().isFound()) {
				petListingPage.clicksNext();
				logger.info("next page.");
				continue;
			}
			throw new Exception("The pet is not found!");
		}

		petListingPage.viewsDetail(petName);
		petDetailPage.adopts(petName);
		petShoppingCartPage.complesAdoption(petName);
		logger.info("Completed the adoption!");
	}

	private void given_I_am_at_the_Puppy_Adoption_Agency() {
		String websiteURL = System.getenv("PUPPY_WEBSITE");
		adoptionPage.visit(websiteURL);
		logger.info("Opened website!");
	}
}
