package com.sc.stepdefination;

import org.openqa.selenium.WebDriver;

import com.sc.pages.ReportsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsStepDefination {

	WebDriver driver;
	ReportsPage reportsPage;

	public ReportsStepDefination() {

		driver = CucumberSetup.getDriver();
		reportsPage = new ReportsPage(driver);

	}

	@When("^I will click on Reports tab$")
	public void clickOnReportsTab() {

		reportsPage.clickOnReportsTab();

	}

	@And("^I will click on New Report$")
	public void clickOnNewReportButton() {
		reportsPage.clickOnNewReportButton();

	}

	@And("^I will search and click on Oportunities$")
	public void searchOpportunities() {
		reportsPage.searchAndClickOpportunities();
	}

	@And("^I will click on Create button$")
	public void clickCreateButton() {
		reportsPage.clickOnCreateButton();
	}
	
	@And("^I will click and search GSA Sale$")
	public void searchGSASale(){
		reportsPage.searchGSASale();
	}
	
	@And("^I wll drag and drop GSA sale to the Report$")
	public void dragAndDropGSASale(){
		reportsPage.dragAndDropGSASale();
	}
	
	@Then("^I will validate where the GSA sale field is in header section of the report$")
	public void validateGSASaleReportable(){
		reportsPage.validateGSASaleReportable();
		
		
	}
	
	

}
