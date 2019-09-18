package com.sc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.asserts.AssertionHandler;
import com.framework.config.GlobalProperties;
import com.framework.config.PropertiesRepository;
import com.framework.handlers.ActionHandler;
import com.framework.handlers.ElementHandler;
import com.framework.handlers.JavaScriptHandler;
import com.framework.handlers.PopUpHandler;
import com.framework.handlers.WindowHandler;
import com.framework.utils.ExcelUtils;
import com.sc.constants.GRC_properties;
import com.sc.objects.repository.AccountsPageObjects;
import com.sc.objects.repository.BasePageObjects;
import com.sc.objects.repository.ChatterPageObjects;
import com.sc.objects.repository.DynamicPageObjects;
import com.sc.objects.repository.LeadsPageObjects;
import com.sc.objects.repository.OpportunitiesPageObjects;
import com.sc.objects.repository.ProductsPageObjects;
import com.sc.objects.repository.QuotePageObjects;
import com.sc.objects.repository.ReportsPageObjects;
//import com.sc.stepdefination.CucumberSetup;

public class BasePage {

	WebDriver driver;
	protected ElementHandler elementHandler;
	protected ActionHandler actionHandler;
	protected WindowHandler windowHandler;
	protected PopUpHandler popUpHandler;
	protected JavaScriptHandler javaScriptHandler;
	protected DynamicPageObjects dynamicPageObjects;
	// protected DynamicPageObjects dynamicPageObjects;

	public BasePage(WebDriver webDriver) {
		
		this.driver = webDriver;
		
		PageFactory.initElements(webDriver, BasePageObjects.class);
		PageFactory.initElements(webDriver, AccountsPageObjects.class);
		PageFactory.initElements(webDriver, OpportunitiesPageObjects.class);
		PageFactory.initElements(webDriver, ProductsPageObjects.class);
		PageFactory.initElements(webDriver, QuotePageObjects.class);
		PageFactory.initElements(webDriver, ReportsPageObjects.class);
		PageFactory.initElements(webDriver, LeadsPageObjects.class);
		PageFactory.initElements(webDriver, ChatterPageObjects.class);
				
		
		elementHandler = new ElementHandler(driver);
		actionHandler = new ActionHandler(driver);
		windowHandler = new WindowHandler(driver);
		popUpHandler = new PopUpHandler(driver);
		javaScriptHandler = new JavaScriptHandler(driver);
		dynamicPageObjects = new DynamicPageObjects(driver);
		ExcelUtils.setExcel(System.getProperty("user.dir") + PropertiesRepository.getString("testdata.excel.file"));
		
	}

	public void salesforcelogin() {
		String username = null;
		String password = null;

		switch (GlobalProperties.Environment.toLowerCase()) {
		case GlobalProperties.QAEnv:
			username = ExcelUtils.getDataByColumnName("Login", "QAUsername");
			password = ExcelUtils.getDataByColumnName("Login", "QAPassword");
			break;
		case GlobalProperties.UATEnv:
			username = ExcelUtils.getDataByColumnName("Login", "UATUsername");
			password = ExcelUtils.getDataByColumnName("Login", "UATPassword");
			break;
		default:
			username = ExcelUtils.getDataByColumnName("Login", "QAUsername");
			password = ExcelUtils.getDataByColumnName("Login", "QAPassword");
			break;

		}

		elementHandler.writeText(BasePageObjects.loginUsername, username);		
		elementHandler.writeText(BasePageObjects.loginPassword, password);
		elementHandler.clickElement(BasePageObjects.loginButton);
		actionHandler.waitForPageToLoad();
		// System.out.println("Login is successful");
	}

	public void verifySalesforceLogin() {
		elementHandler.setWebDriverWait(BasePageObjects.HomeTab);
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(BasePageObjects.UserNavLabel),
				"Login is not successful");
		System.out.println("Login is successful");
	}

	public boolean GlobalSearch(String searchString) {
		elementHandler.writeText(BasePageObjects.GlobalSearchBox, searchString);
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(BasePageObjects.SearchButton, BasePageObjects.textBoxSecondSearchText);
		actionHandler.waitForSomeTime(2000);
		return elementHandler.isElementDisplayed(BasePageObjects.textBoxSecondSearchText);
	}

	public String profileLogin() {
		elementHandler.clickElement(BasePageObjects.lnkPeople, BasePageObjects.lnkProfileUser);
		elementHandler.clickElement(BasePageObjects.lnkProfileUser, BasePageObjects.userActionmenu);
		elementHandler.clickElement(BasePageObjects.userActionmenu, BasePageObjects.Userdetails);
		elementHandler.clickElement(BasePageObjects.Userdetails, BasePageObjects.Userlogin);
		elementHandler.clickElement(BasePageObjects.Userlogin, BasePageObjects.lblProfileUser);
		return elementHandler.getText(BasePageObjects.lblProfileUser);

	}

	public void profileLogout() {
		actionHandler.waitForSomeTime(8000);			
		elementHandler.clickElement(BasePageObjects.Usenavarrow, BasePageObjects.userLogout);
		elementHandler.clickElement(BasePageObjects.userLogout, BasePageObjects.Userlogin);
		actionHandler.waitForSomeTime(3000);
	}

	public AccountsPage navigateToAccountsPage() {
		elementHandler.clickElement(BasePageObjects.Navigatetoaccuntstab, BasePageObjects.Accountshometab);
		return new AccountsPage(driver);		

	}

	public void AddAccountInOptyPage(String Accountname) {
		elementHandler.clickElement(BasePageObjects.AccountNameLookupicon);
		String parentWindow = windowHandler.getParentWindow();
		windowHandler.switchToLatestWindow(BasePageObjects.AccountLookupsearchframe);
		windowHandler.waitForFrameAndSwitchIt(BasePageObjects.AccountLookupsearchframe,
				BasePageObjects.AccountLookupbox);
		elementHandler.writeText(BasePageObjects.AccountLookupbox, Accountname, BasePageObjects.AccountlookupGoButton);
		elementHandler.clickElement(BasePageObjects.AccountlookupGoButton);
		windowHandler.switchToMainFrame();
		windowHandler.waitForFrameAndSwitchIt(BasePageObjects.AccuntLookuupresultsframe);
		actionHandler.waitForSomeTime(3000);
		GRC_properties.AccountName = elementHandler.getText(BasePageObjects.LinkLookupAccount);
		elementHandler.clickElement(BasePageObjects.LinkLookupAccount);
		windowHandler.switchToParentWindow(parentWindow, OpportunitiesPageObjects.OptyBottomSaveButton);

	}

	public void navigatetoOptyPage() {
		elementHandler.clickElement(BasePageObjects.NavigatetoOpportunitestab);	
		elementHandler.clickElement(OpportunitiesPageObjects.newOptyCreationBtn);
		elementHandler.clickElement(OpportunitiesPageObjects.continueBtn);
		//return new OpportunitiesPage(driver);
	}

}
