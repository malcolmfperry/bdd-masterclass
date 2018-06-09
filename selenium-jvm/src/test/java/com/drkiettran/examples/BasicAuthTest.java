package com.drkiettran.examples;

import java.io.File;

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

@RunWith(JUnit4.class)
public class BasicAuthTest {
    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass

    public static void createAndStartService() throws Exception {
        String chromePath = System.getenv("WEBDRIVER_CHROME_DRIVER");
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("c:/drkiettran/bin/misc/chromedriver-240.exe")).usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass

    public static void createAndStopService() {
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
    }
}