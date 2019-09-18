package com.sc.stepdefination;

import org.openqa.selenium.WebDriver;

import com.sc.pages.AccountsPage;
import com.sc.pages.BasePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AccountStepDefination {

	WebDriver driver;
	AccountsPage accountsPage;
	BasePage basePage;

	public AccountStepDefination() {
		driver = CucumberSetup.getDriver();
		accountsPage = new AccountsPage(driver);
		basePage = new BasePage(driver);
	}

	@And("^I will search for the existing account from the list$")
	public void iWillsearchfortheexistingaccountfromlist() {
		String accountname = accountsPage.selectAnExistingAccount();
		System.out.println("Selected existing account is : " + accountname);
		CucumberSetup.globalscenario.write("Selected existing account is : " + accountname);

	}
	
	@And("^I will search for the existing prospect account$")
	public void iWillsearchfortheProspectaccountfromlist()
	{
		String accountname = accountsPage.selectAnExistingProspectAccount();
		System.out.println("Selected existing Prospect account is : " + accountname);
		CucumberSetup.globalscenario.write("Selected existing account is : " + accountname);
	}
	
	@And("^I go to the opportunites related list$")
	public void iGotoopportunitestab() {
		accountsPage.GoToOpportunitiestab();
	}

	@And("^I click on the new sale opportunity$")
	public void iClickonnewsaleopportunity() {
		accountsPage.Clickonnewsaleopportunity();
		CucumberSetup.globalscenario.write("Navigated to new opportunity page");
	}
	
	@And("^I will select the Org Type Values from drop down$")
	public void selectValueFromDropdown(){
		accountsPage.selectValueFromDropDown();
		
	}
	
	@Then("^I validate the Account classification field present on the account detail page for Corporate - Manufacturing$")
	public void validateAccountClassification(){
		accountsPage.validateAccountClassification();
	}
	
	@And("^I validate the Account classification field present on the account detail page for Corporate - Retail value$")
	public void validateAccountClassificationCorpRetail(){
		accountsPage.validateAccountClassificationCorpRetail();
	}
	
	
	
	
	
	
}
