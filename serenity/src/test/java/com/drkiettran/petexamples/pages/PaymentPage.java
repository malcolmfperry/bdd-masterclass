package com.drkiettran.petexamples.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PaymentPage extends PageObject {

	@FindBy(id = "order_name")
	private WebElement orderNameTextField;

	@FindBy(id = "order_address")
	private WebElement orderAddrTextField;

	@FindBy(id = "order_email")
	private WebElement orderEmailTextField;

	@FindBy(xpath = "//input[@value='Place Order']")
	private WebElement placeOrderButton;

	public void fillsOut(String name, String address, String email, String payType) throws Exception {
		orderNameTextField.sendKeys(name);
		orderAddrTextField.sendKeys(address);
		orderEmailTextField.sendKeys(email);

		String xpath = String.format("//option[@value='%s']", payType);
		List<WebElement> options = getDriver().findElements(By.xpath(xpath));

		if (options.size() != 1) {
			throw new Exception("Invalid payment method " + payType);
		}

		options.get(0).click();
	}

	public void placesOrder() {
		placeOrderButton.click();
	}

}
