package com.drkiettran.examples.cukes.pages;

import com.drkiettran.examples.automation.WebDriverHandler;
import com.drkiettran.examples.cukes.activities.Visit;

public class VisitAdoptionAgencyPage implements Visit {

	private final WebDriverHandler wdHandler;
	
	public VisitAdoptionAgencyPage(WebDriverHandler wdHandler) {
		super();
		this.wdHandler = wdHandler;
	}

	@Override
	public void goesToAdoptionAgency() {
		wdHandler.getRemoteWebDriver().get(wdHandler.getWebSiteURL());
	}

}
