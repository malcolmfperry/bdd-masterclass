package com.drkiettran.examples.cukes.pages;

import com.drkiettran.examples.automation.WebDriverHandler2;
import com.drkiettran.examples.cukes.activities.Visit;

public class VisitAdoptionAgencyPage implements Visit {

	private final WebDriverHandler2 wdHandler;
	
	public VisitAdoptionAgencyPage(WebDriverHandler2 wdHandler) {
		super();
		this.wdHandler = wdHandler;
	}

	@Override
	public void goesToAdoptionAgency() {
		wdHandler.getRemoteWebDriver().get(wdHandler.getWebSiteURL());
	}

}
