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
import com.sc.pages.ChatterPage;
import com.sc.pages.OpportunitiesPage;
import com.sc.pages.ProductsPage;
import com.sc.pages.QuotePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChatterStepDefination {

	WebDriver driver;
	AccountsPage accountsPage;
	BasePage basePage;
	OpportunitiesPage optyPage;
	ProductsPage productsPage;
	QuotePage quotePage;
	ChatterPage chatterPage;
	JavaScriptHandler javaScriptHandler;
	ActionHandler actionHandler;
	PopUpHandler popUpHandler;

	public ChatterStepDefination() {
		driver = CucumberSetup.getDriver();
		chatterPage  = new ChatterPage(driver);
		/*accountsPage = new AccountsPage(driver);
		basePage = new BasePage(driver);
		optyPage = new OpportunitiesPage(driver);
		productsPage = new ProductsPage(driver);
		quotePage = new QuotePage(driver);*/
		javaScriptHandler = new JavaScriptHandler(driver);
		actionHandler = new ActionHandler(driver);
		popUpHandler = new PopUpHandler(driver);

	}

	@And("^I will Reject the request in Chatter Page and logout$")
	public void clickRejectBtnInChatterPage() {
		chatterPage.clickRejectBtn();
		chatterPage.profileLogout();
	}
	@Then("^I will approve the Quote$")
	public void clickAcceptBtnInChatterPage() {
		chatterPage.clickAcceptBtn();
		chatterPage.profileLogout();
	}
	
	
	

}
