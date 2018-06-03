package com.drkiettran.petexamples.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.drkiettran.petexamples.model.PaymentInfo;

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

	public void fillsOut(PaymentInfo payInfo) throws Exception {
		orderNameTextField.sendKeys(payInfo.getName());
		orderAddrTextField.sendKeys(payInfo.getAddress());
		orderEmailTextField.sendKeys(payInfo.getEmail());

		String xpath = String.format("//option[@value='%s']", payInfo.getPayType());
		List<WebElement> options = getDriver().findElements(By.xpath(xpath));

		if (options.size() != 1) {
			throw new Exception("Invalid payment method " + payInfo.getPayType());
		}

		options.get(0).click();
	}

	public void placesOrder() {
		placeOrderButton.click();
	}

}
