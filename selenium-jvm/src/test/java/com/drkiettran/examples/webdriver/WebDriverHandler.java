package com.drkiettran.examples.webdriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverHandler {

	private static ChromeDriverService service;
	private static RemoteWebDriver webDriver;

	public static void startChromeDriverService() throws IOException {
		String chromePath = System.getenv("WEBDRIVER_CHROME_DRIVER");
		// @formatter:off
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(chromePath))
				.usingAnyFreePort()
				.build();
		// @formatter:on
		service.start();
		webDriver = new RemoteWebDriver(WebDriverHandler.getUrl(), DesiredCapabilities.chrome());
	}

	public static void stopChromeDriverService() {
		service.stop();
	}

	public static URL getUrl() {
		return service.getUrl();
	}

	public static RemoteWebDriver getRemoteWebDriver() {
		return webDriver;
	}

	public static void quit() {
		webDriver.quit();
	}

}
