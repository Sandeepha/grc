package com.sc.stepdefination;

import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.handlers.ActionHandler;
import com.framework.handlers.JavaScriptHandler;
import com.framework.handlers.PopUpHandler;
import com.sc.constants.GRC_properties;
import com.sc.constants.SCconstants;
import com.sc.pages.AccountsPage;
import com.sc.pages.BasePage;
import com.sc.pages.OpportunitiesPage;
import com.sc.pages.ProductsPage;
import com.sc.pages.QuotePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpportunitiesStepDefination {

	WebDriver driver;
	AccountsPage accountsPage;
	BasePage basePage;
	OpportunitiesPage optyPage;
	ProductsPage productsPage;
	QuotePage quotePage;
	JavaScriptHandler javaScriptHandler;
	ActionHandler actionHandler;
	PopUpHandler popUpHandler;

	public OpportunitiesStepDefination() {
		driver = CucumberSetup.getDriver();
		accountsPage = new AccountsPage(driver);
		basePage = new BasePage(driver);
		optyPage = new OpportunitiesPage(driver);
		productsPage = new ProductsPage(driver);
		quotePage = new QuotePage(driver);
		javaScriptHandler = new JavaScriptHandler(driver);
		actionHandler = new ActionHandler(driver);
		popUpHandler = new PopUpHandler(driver);

	}

	@And("^I create a new opportunity with all the mandatory details$")
	public void iCreateanewopty() {
		GRC_properties.OpportunityName = optyPage.createaNewOpportunity();
		System.out.println("New opportunity is created =" + GRC_properties.OpportunityName);
	}

	@Then("^I validate the opportunity is created successfully$")
	public void Validateoptycreatedsuccessfully() {
		AssertionHandler.verifyEquals(GRC_properties.OpportunityName, optyPage.getOptyNamefromOptypage(),
				"Opportunity name mismatch");
		System.out.println("Opportunity name matches");
		AssertionHandler.verifyEquals(GRC_properties.AccountName, optyPage.getAccountNamefromoptypage(),
				"Account name mismatch");
		System.out.println("Account name matches");
		optyPage.verifyrevenueinformationfieldsaredisplayed();
		System.out.println("revenue details are displayed");
		String flag = optyPage.verifyFXALLFlag();
		AssertionHandler.verifyEquals(flag, "False", "FXALL flag is  true");
		System.out.println("FXALL flag is False");
		String GRCOtycheckbx = optyPage.verifyGRCOptyFlag();
		AssertionHandler.verifyEquals(GRCOtycheckbx, "Checked", "GRC Opty flag is not enabled");
		CucumberSetup.globalscenario.write("Opportuity is created successfully: " + GRC_properties.OpportunityName);
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);

	}

	@And("^I will search for the already created opportunity$")
	public void Iwillsearchforopportunity() {
		String optyname = optyPage.SearchanExistingOpty();
		System.out.println("Selected already created oportunity is : " + optyname);
		CucumberSetup.globalscenario.write("Selected already created oportunity is : " + optyname);
	}

	@And("^I will create GRC pricebook$")
	public void iWillCreatenewGRCPricebook() {
		optyPage.GotoProductrelatedtabinoptypage();
		optyPage.clickChooseGRCPricebook();
		CucumberSetup.globalscenario.write("Pricebook changed to GRC Pricebook");

	}

	@And("^I will go to Products related tab in Opty page$")
	public void Iwillgtoprductstab() {
		optyPage.GotoProductrelatedtabinoptypage();

	}

	@And("^I will go to GRC Products related tab in Opty page$")
	public void iWillgoGRCProductsrelatedtabinoptypage() {
		optyPage.GoToGRcProductrelatedtabinoptypage();
	}

	@And("^I will check if products are present if not I will add product and verify$")
	public void addproductsifnotadded() {
		boolean flag = optyPage.checkifProductsareadded();
		if (flag) {
			System.out.println("No GRC products are present");
			optyPage.clickaddProductButton();
			productsPage.AddProducts();
			optyPage.GoToGRcProductrelatedtabinoptypage();
			optyPage.verifyProductsareaddedsuccessfully();
			CucumberSetup.globalscenario.write("GRC Products are added successfully");
			CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
		} else {
			System.out.println("Products are already present");
			CucumberSetup.globalscenario.write("GRC Products are already present");
			CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
		}
	}

	@And("^I will add Primary contact in contact roles Opty page$")
	public void iWillAddPrimarycontactinContactRoles() {
		optyPage.gotoContactRelatedTab();
		optyPage.addPrimaryContact();
		CucumberSetup.globalscenario.write("Primary Contact Roles added successfully");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);

	}

	@And("^I will go to quotes realted tab in oty page$")
	public void iWillGotoQuotesrelatedtab() {
		optyPage.goToQuotesrelatedtab();
		optyPage.clickonNewquote();

	}

	@And("^I will open the created Quote$")
	public void iWillOpenTheCreatedQuote() {
		optyPage.goToQuotesrelatedtab();
		optyPage.OpenTheCreatedQuote();
	}

	@Then("^I validate the popup and GRC pricebook$")
	public void validatePopup_grcPriceBook() {
		optyPage.validatePopup_grcPriceBook();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);

	}

	@And("^I validate the GRC Opportunity is checked or not$")
	public void validateGRCOpportunityFalg() {
		optyPage.validateGRCOpportunityFlag();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I validate the fields Partners and Distribution,Partner Engagement Type,GSA Sale$")
	public void validateMandatoryFieldsPresence() {
		optyPage.validteMandatoryFieldsPresence();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I validate the pop up when user is creating quote before addition of contact Role$")
	public void validatePopupContactRole() {
		optyPage.validatePopupContactRole();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);

	}

	@And("^I validate the closed date$")
	public void validateClosedDate() {
		optyPage.validateClosedDate();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I validate Opportunity previous Stage gets updated when the sales stage changed$")
	public void validateGRCOpportunityFalgPrevious() {
		optyPage.validateGRCOpportunityFlag();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I validate GSA Sale and its related cases$")
	public void validateGSASaleFieldRelatedCases() {
		optyPage.validateGSASaleFieldRealtedCases();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I validate whether GSA Sale field is positioned below the Partner Engagement Type field$")
	public void validatePosition_GSASale_And_Partnerengagementtype() {
		optyPage.validatePosition();
	}

	@Then("^I validate whether the GSA Sale field is added or not$")
	public void validateGSASaleFieldInOptyPage() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@Then("^I will validate the GSA Sale field is editable for all profiles$")
	public void validateGSAFieldIsEditable() {
		optyPage.validateGSAFieldIsEditable();
	}

	@And("^I validate Opty SS Changes is incremented whenever the opportunity sales$")
	public void validateGRCOpportunityFalgPreviousIncremented() {
		optyPage.validateGRCOpportunityFlag();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I will click on Organisation Type dropdown list$")
	public void clickOnOrganisationType() {
		optyPage.clickOnOrganisationTypeDropDown();
	}

	@Then("^I verify the fields are present or not$")
	public void validateDropdownFields() {
		optyPage.validateDropdownFields();
	}

	@Given("^I am on the Opportunities Page$")
	public void getTitleOptyPage() {
		optyPage.getTitleOptyPage();
	}

	@When("^I search and select the existing opportunity$")
	public void getExistingOpportunity() {
		optyPage.getExistingOpportunity();
	}

	@And("^I Verify the field Original close date on an Opportunity has changed$")
	public void validateClosedDateOptyChange() {
		optyPage.validateClosedDate();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I Verify the field Close Date Push Counter of type Formula is created on Opportunity object$")
	public void validateClosedDateOptyChangeObject() {
		optyPage.validateClosedDate();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	@And("^I Verify that Opportunity previous Stage and No of Times Opty SS Changes are hidden$")
	public void validateHiddent() {
		optyPage.validateClosedDate();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	

	@And("^I Verify the field Original close date push counter on an Opportunity has changed$")
	public void validateClosedDatePushOptyChangeObject() {
		optyPage.validateClosedDate();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@And("^I select the different currency in opportunity apart from account currency$")
	public void selectOptyCurrency() {
		optyPage.selectOptyCurrency();
	}

	@And("^I select the different currency in opportunity other than account currency$")
	public void selectOpptyCurrency() {
		optyPage.selectOpptyCurrency();
	}

	@Then("^User able to have different currency in opportunity apart from account currency$")
	public void validateMonthlyRecurring() {
		optyPage.validateMonthlyRecurring();
	}

	@Then("^I Verify that opportunity team members are automatically notified when removed$")
	public void validateGSASaleFieldNotificationRemoved() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	@Then("^I Verify that a field of type formula No of Times Opty SS Changes with Label$")
	public void validateFieldFormula() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	

	@Then("^I Verify that these notifications are displayed for the Users who are newly Added$")
	public void validateGSASaleFieldNotificationNewlyAdded() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@Then("^I Verify that these notifications are displayed for the Users who are Deleted$")
	public void validateGSASaleFieldNotificationNewlyDeleted() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	@Then("^I verify revenue calculation on opportunity level$")
	public void validateRevenueCalculation() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	

	@And("^I will create new opportunity$")
	public void createNewOptyForQuote() {
		optyPage.createNewOptyForQuote();
	}

	@Then("^I verify different currency change is applicable only for Sales quote$")
	public void validateCurrenct() {
		optyPage.validateCurrency();
	}

	@Then("^I verify currency change is not applicable$")
	public void validateAndGetTheErrorMsg() {
		optyPage.getErrorMsg();
	}

	@And("^I will add the products$")
	public void addProducts() {
		optyPage.addProducts();
	}

	@And("^I will add the Contact Roles$")
	public void addContactRoles() {
		optyPage.addContactRoles();
	}

	@Then("^I will verify Active Quote Ind checkbox in Opty Page$")
	public void validateActiveQuoteInd() {
		optyPage.validateActiveQuoteInd();
	}

	@Then("^I Verify that opportunity team members are automatically notified$")
	public void validateGSASaleFieldNotification() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	@Then("^I Verify that No of Times Opty SS Changes is incremented whenever the opportunity sales stage gets updated$")
	public void validateGSASaleFieldNotificationIncremented() {
		optyPage.validateGSASaleFieldInOptyPage();
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	@Then("^I will create GRC free trial opportunity$")
	public void createGRCFreeTrailOppotunity() {
		
		optyPage.createGRCFreeTrialOpty();
	}
	

}
