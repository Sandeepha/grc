package com.sc.stepdefination;

import org.openqa.selenium.WebDriver;

import com.sc.pages.BasePage;
import com.sc.pages.LeadsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeadsStepDefination {
	
	WebDriver driver;
	LeadsPage leadsPage;
	BasePage basePage;
	
	public LeadsStepDefination(){
		driver = CucumberSetup.getDriver();
		leadsPage = new LeadsPage(driver);
		basePage = new BasePage(driver);		
		
	}
	
	@When("^I will click on the Leads tab$")
	public void clickOnLeadsTab(){
		leadsPage.clickOnLeadsTab();
	}
	
	@And("^I will click on continue button$")
	public void clickOnContinueBtn(){
		leadsPage.clickOnContinueBtn();	
		
	}
	
	@And("^I will click on dropdown List$")
	public void clickOnDropDownList(){
		leadsPage.clickOnDropDownList();
	}
	
	@And("^I will select the \"([^\"]*)\"$")
	public void selectLeadRecordType(String leadRecordType){
		
		leadsPage.selectRecordType(leadRecordType);
	}
	
	@Then("^I verify Corporate - Manufacturing and Corporate - Retail value are enabled$")
	public void verifyTheFields(){
		leadsPage.verifyTheFields();
	}
	

}
