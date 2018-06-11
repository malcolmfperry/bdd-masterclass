package com.drkiettran.examples;

import java.io.File;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(JUnit4.class)
public class BasicAuthTest {
	private static final String AUTHENTICATED_TEXT = "Authenticated!";
	private static final Object UNAUTHORIZED_TEXT = "Unauthorized";
	private static ChromeDriverService service;
	private WebDriver driver;

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
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void shouldAuthenticateUsernamePassword() {
		driver.get("http://username:password1234*^@192.168.1.63:9904/form");
		String xpath = String.format("//*[text()='%s']", AUTHENTICATED_TEXT);
		assertThat(driver.findElement(By.xpath(xpath)).getText(), equalTo(AUTHENTICATED_TEXT));
	}

	// Not testing for the negative scenario because of a popup. It would take
	// too much time to imnplement the robot.

}