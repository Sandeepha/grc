package com.sc.stepdefination;

import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.config.PropertiesRepository;
import com.framework.utils.ExcelUtils;
import com.sc.constants.SCconstants;
import com.sc.pages.BasePage;
import com.sc.pages.ReportsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaseStepDefination {

	WebDriver driver;
	BasePage basePage;
	ReportsPage reportsPage;
	

	public BaseStepDefination() {
		driver = CucumberSetup.getDriver();
		basePage = new BasePage(driver);
		reportsPage=new ReportsPage(driver);
	}

	@Given("^I have application URL$")
	public void iHaveValidApplicationUR() {
		driver.get(PropertiesRepository.getString("test.application.url"));
	}

	@When("^I login with valid credentials$")
	public void iLoginwithvalidcredentials() {
		basePage.salesforcelogin();
	}

	@Then("^I should be able to see home page$")
	public void iShouldbeabletoseethehomepage() {
		basePage.verifySalesforceLogin();
		CucumberSetup.globalscenario.write("Login is successful");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@Given("^I login as a GRC users$")
	public void iLoginasaprofileuser() {
		String profilename = ExcelUtils.getDataByColumnName("Login", "GRC User");
		boolean isSearchedUser = basePage.GlobalSearch(profilename);
		AssertionHandler.verifyTrue(isSearchedUser, "User profile not found");
		String getProfileUser = basePage.profileLogin();
		System.out.println("User profile from method is = " + getProfileUser);
		AssertionHandler.verifyEquals(profilename, getProfileUser, "User profile not logged in");
		CucumberSetup.globalscenario.write(" user: " + getProfileUser + " is logged in to the application");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	@And("^I login as a GRC user$")	
	public void iLoginasaprofileuser1() {
		String profilename = ExcelUtils.getDataByColumnName("Login", "GRC User");
		boolean isSearchedUser = basePage.GlobalSearch(profilename);
		AssertionHandler.verifyTrue(isSearchedUser, "User profile not found");
		String getProfileUser = basePage.profileLogin();
		System.out.println("User profile from method is = " + getProfileUser);
		AssertionHandler.verifyEquals(profilename, getProfileUser, "User profile not logged in");
		CucumberSetup.globalscenario.write(" user: " + getProfileUser + " is logged in to the application");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}
	
	
	@Given("^I login as \"([^\"]*)\"$")
	public void iLoginasaprofileuser(String profilename) {
		//String profilename = ExcelUtils.getDataByColumnName("Login", "GRC User");
		boolean isSearchedUser = basePage.GlobalSearch(profilename);		
		AssertionHandler.verifyTrue(isSearchedUser, "User profile not found");
		String getProfileUser = basePage.profileLogin();
		System.out.println("User profile from method is = " + getProfileUser);
		AssertionHandler.verifyEquals(profilename, getProfileUser, "User profile not logged in");
		CucumberSetup.globalscenario.write(" user: " + getProfileUser + " is logged in to the application");
		CucumberSetup.globalscenario.embed(CucumberSetup.attachScreenshot(), SCconstants.imageType);
	}

	@When("^I will click on Accounts tab$")
	public void iWillclickonAccountstab() {
		basePage.navigateToAccountsPage();

	}

	@When("^I will click on Opportunities tab$")
	public void iWillclickonOptyTab() {
		basePage.navigatetoOptyPage();
	}
}
