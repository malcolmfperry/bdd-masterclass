package com.drkiettran.examples.pf;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

	private WebDriver driver;

	@FindBy(id = "order_name")
	private WebElement orderName;

	@FindBy(id = "order_address")
	private WebElement orderAddress;

	@FindBy(id = "order_email")
	private WebElement orderEmail;

	@FindBy(id = "order_pay_type")
	private WebElement orderPayTypes;

	@FindBy(xpath = "//input[@value='Place Order']")
	private WebElement placeOrderButton;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void placesOrder(String payType, String payerName, String payerAddress, String payerEmail) {
		orderName.sendKeys(payerName);
		orderAddress.sendKeys(payerAddress);
		orderEmail.sendKeys(payerEmail);

		Select dropDown = new Select(orderPayTypes);
		List<WebElement> options = dropDown.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(payType)) {
				option.click();
				break;
			}
		}

		placeOrderButton.click();
	}

}
