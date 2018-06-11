package com.drkiettran.examples.model;

public class PaymentInfo {

	private String payType;
	private String payer;
	private String payerAddress;
	private String payerEmail;

	public PaymentInfo(String payType, String payer, String payerAddress, String payerEmail) {
		this.payType = payType;
		this.payer = payer;
		this.payerAddress = payerAddress;
		this.payerEmail = payerEmail;
	}

	public String getPayType() {
		return payType;
	}

	public String getPayer() {
		return payer;
	}

	public String getPayerAddress() {
		return payerAddress;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

}
