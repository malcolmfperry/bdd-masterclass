package com.drkiettran.examples.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

	private WebDriver driver;
	private By byPayerName = By.id("order_name");
	private By byPayerAddress = By.id("order_address");
	private By byPayerEmail = By.id("order_email");
	private By byPayType;
	private By byPlaceOrderButton = By.xpath("//input[@value='Place Order']");

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void placesOrder(String payType, String payerName, String payerAddress, String payerEmail) {
		driver.findElement(byPayerName).sendKeys(payerName);
		driver.findElement(byPayerAddress).sendKeys(payerAddress);
		driver.findElement(byPayerEmail).sendKeys(payerEmail);
		byPayType = By.xpath(String.format("//option[@value='%s']", payType));
		driver.findElement(byPayType).click();
		driver.findElement(byPlaceOrderButton).click();
	}

}
