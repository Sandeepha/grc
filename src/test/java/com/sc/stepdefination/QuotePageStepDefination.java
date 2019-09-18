package com.sc.stepdefination;

import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.sc.constants.GRC_properties;
import com.sc.constants.SCconstants;
import com.sc.pages.AccountsPage;
import com.sc.pages.BasePage;
import com.sc.pages.OpportunitiesPage;
import com.sc.pages.ProductsPage;
import com.sc.pages.QuotePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class QuotePageStepDefination {
	WebDriver driver;
	AccountsPage accountsPage;
	BasePage basePage;
	OpportunitiesPage optyPage;
	ProductsPage productsPage;
	QuotePage quotePage;

	public QuotePageStepDefination() {
		driver = CucumberSetup.getDriver();
		accountsPage = new AccountsPage(driver);
		basePage = new BasePage(driver);
		optyPage = new OpportunitiesPage(driver);
		productsPage = new ProductsPage(driver);
		quotePage = new QuotePage(driver);
	}

	@And("^I will create new quote$")
	public void iWillcreateanewQuote() {
		GRC_properties.QuoteNumber = quotePage.createANewQuote();
		System.out.println("New Quote is created successfully: " + GRC_properties.QuoteNumber);		
		CucumberSetup.globalscenario.write("Sale Quote Created successfully:" + GRC_properties.QuoteNumber);
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	@And("^I will create new Free trial quote$")
	public void iWillcreateanewFreeTrialQuote() {
		GRC_properties.FreeTrialQuoteNumber = quotePage.createANewFreeTrialQuote();
		System.out.println("New Free trial Quote is created successfully: " + GRC_properties.FreeTrialQuoteNumber);		
		CucumberSetup.globalscenario.write("Sale Quote Created successfully:" + GRC_properties.QuoteNumber);
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@Then("^I will verify the quote is created successfully$")
	public void iWillverifyquoteiscreatedsuccessfully() {
		quotePage.verifyquoteiscreated();
		CucumberSetup.globalscenario.write("Sale Quote is verified successfully:" + GRC_properties.QuoteNumber);
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
		// accountsPage.verifyContractInformation();

	}

	@And("^I will submit quote for Approval$")
	public void iWillSubmitQuoteForApproval() {
		quotePage.submitQuoteForApproval();
		CucumberSetup.globalscenario.write("Sale Quote is submitted successfully");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);

	}

	@Then("^I will verify the status of quote$")
	public void iWillVerifyTheStatusOfQuoteafterSubmittingForApproval() {
		quotePage.verifyStatusOfQuoteAfterSubmittingForApproval();
		CucumberSetup.globalscenario.write("Sale Quote status is Awaiting Approval");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I will submit the quote for Approval$")
	public void submitQuoteForApproval() {
		quotePage.submitQuoteForApproval();
	}
	
	@And("^I will submit the Free Trial Quote for Approval$")
	public void submitFreeTrialQuoteForApproval() {
		quotePage.submitFreeTrialQuoteApproval();
	}

	@And("^I will get the GAM user and login$")
	public void loginAsGamApprover() {
		quotePage.loginAsGamApprovar();
	}

	@Then("^I will validate free trial opportunity is created automatically$")
	public void validateFreeTrialQuotePage() {
		quotePage.validateStartStopSyncButton();
	}

	@Then("^I will validate whether Primary contact and billing contact is mandatory to create a sale quote$")
	public void validatePrimaryAndBillingContact() {
		quotePage.validatePrimaryAndBillingContact();
	}

	@Then("^I will validate Quote status is moved to Rejected$")
	public void validateQuoteStatusInQuotePage() {
		quotePage.validateQuoteStatus();
	}

	@And("^I will validate Quote Status is changed from Rejected to In Progress after click on EDIT button$")
	public void validateQuoteStatusAfterClickingEDITButton() {
		quotePage.validateQuoteStatusAfterEditBtn();
	}

	@And("^I will validate user is able to resubmit GRC Quote without Editing the quot$")
	public void validateSubmitWithoutEdit() {
		quotePage.validateSubmitWithoutEdit();
	}

	@Then("^I will validate Start sync/Stop sync button is available in the quote header page$")
	public void validateStartStopSyncButtonQuotePage() {
		quotePage.validateStartStopSyncButton();
	}

	@Then("^I will Verify that synchronization is occurred if the start sync button is clicked$")
	public void validateStartSyncButtonQuotePageStart() {
		quotePage.validateStartButton();
	}

	@Then("^I will Verify that synchronization is occurred if the stop sync button is clicked$")
	public void validateStopSyncButtonQuotePageStop() {
		quotePage.validateStopButton();
	}

	@And("^I will approve as CA user$")
	public void approveCA() {
		quotePage.approveCA();
		
	}
	
	@And("^I will approve all the scervice delivery and billing CAA$")
	public void approveAllCAA() {
		quotePage.approveCA();
	}
	
	
	@And("^I will approve all the service delivery activities$")
	public void approveAll() {
		quotePage.approveCA();
	}
	
	@And("^I will create order form and send to client with docsign$")
	public void createOrderFormSendToClient() {
		quotePage.createOrderFormSendToClient();
	}
	
	@And("^I will create Order form and send the order form to client$")
	public void createOrderFormSendToClientFreeTrial() {
		quotePage.createOrderFormSendToClientFreeTrial();
	}
	
	@And("^I will submit for fullfillment$")
 	public void submitQuoteForFullfilment() {
		quotePage.submitQuoteForFullfillment();
	}
	
	@And("^I will send the orderform to client$")
	public void sendTheDocs() {
		quotePage.sendDocs();
	}
	
	@And("^I will submit for fullfillment to create order form$")
 	public void submitQuoteForFullfilmentOrderForm() {
		quotePage.submitQuoteForFullfillmentOrderForm();
	}
	
	@And("^I will extend the quote line item on free trial quote$")
	public void extendQuoteLineItem() {
		quotePage.extendQuoteLineItem();
	}
}
