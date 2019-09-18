package com.sc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.framework.asserts.AssertionHandler;
import com.framework.utils.ExcelUtils;
import com.sc.constants.GRC_properties;
import com.sc.objects.repository.AccountsPageObjects;
import com.sc.objects.repository.BasePageObjects;
import com.sc.objects.repository.QuotePageObjects;

public class AccountsPage extends BasePage {

	public AccountsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public String selectAnExistingAccount() {
		if (GRC_properties.AccountName == null) {
			GRC_properties.AccountName = ExcelUtils.getDataByColumnName("SearchData", "AccountName");

		}
		GlobalSearch(GRC_properties.AccountName);
		//elementHandler.clickElement(BasePageObjects.linkAccounts, BasePageObjects.linkAccountName);		

		elementHandler.clickElement(BasePageObjects.linkAccountName);
		//, AccountsPageObjects.Accountpageheader);
		actionHandler.waitForPageToLoad();
		String AccountName = elementHandler.getText(AccountsPageObjects.Accountpageheader);
		return AccountName;
		
		

	}

	public String selectAnExistingProspectAccount() {
		/*
		 * if(GRC_properties.AccountName==null) { GRC_properties.AccountName =
		 * ExcelUtils.getDataByColumnName("SearchData", "AccountName");
		 * 
		 * }
		 */
		GlobalSearch("ATP Account_001");
		elementHandler.clickElement(BasePageObjects.linkAccounts, BasePageObjects.linkAccountName);
		elementHandler.clickElement(BasePageObjects.linkAccountName, AccountsPageObjects.Accountpageheader);
		actionHandler.waitForPageToLoad();
		String AccountName = elementHandler.getText(AccountsPageObjects.Accountpageheader);
		return AccountName;

	}

	public void GoToOpportunitiestab() {
		elementHandler.clickElement(AccountsPageObjects.Opportunitiestab, AccountsPageObjects.Newsaleopportunitybuton);
	}

	public OpportunitiesPage Clickonnewsaleopportunity() {
		elementHandler.clickElement(AccountsPageObjects.Newsaleopportunitybuton,
				AccountsPageObjects.NewoportunityPagedescription);
		return new OpportunitiesPage(driver);
	}

	public void verifyContractInformation() {
		elementHandler.clickElement(QuotePageObjects.QuoteAccountName, AccountsPageObjects.Accountpageheader);
		AssertionHandler.verifyEquals(AccountsPageObjects.ContractInfoAgreementtype.getText(), "TRMA",
				"Agreement type is not displayed");
		AssertionHandler.verifyEquals(AccountsPageObjects.ContractInfoAgreementstatus.getText(), "Draft",
				"Agreement status is not displayed");
		AssertionHandler.verifyNotEquals(AccountsPageObjects.ContractAgreementNumber.getText(), " ",
				"Agreement number is not displayed");

	}

	public void selectValueFromDropDown() {
		elementHandler.selectByValue(AccountsPageObjects.selectOrganisationTypeDropdown, "Corporate - Manufacturing");
		driver.findElement(By.xpath("//input[@value='OK']")).click();
		actionHandler.waitForSomeTime(3000);
		System.out.println("The drop down clicked and Corporate - Manufacturing value is selected");

	}

	public void validateAccountClassification() {
		javaScriptHandler.scrollIntoView(AccountsPageObjects.accountClasificationFieldValue);
		String text = elementHandler.getText(AccountsPageObjects.accountClasificationFieldValue);
		AssertionHandler.verifyEquals(text, "Buy Side");
		System.out.println("Account classification field is populated with Buy Side");

	}

	public void validateAccountClassificationCorpRetail() {
		javaScriptHandler.scrollIntoView(AccountsPageObjects.organisationTypeField);
		Actions a = new Actions(driver);
		a.doubleClick(AccountsPageObjects.organisationTypeFieldValue).build().perform();		
		elementHandler.selectByValue(AccountsPageObjects.selectOrganisationTypeDropdown, "Corporate - Retail");
		driver.findElement(By.xpath("//input[@value='OK']")).click();
		actionHandler.waitForSomeTime(3000);
		System.out.println("The drop down clicked and Corporate - Retail value is selected");
		javaScriptHandler.scrollIntoView(AccountsPageObjects.accountClasificationFieldValue);
		String text = elementHandler.getText(AccountsPageObjects.accountClasificationFieldValue);
		AssertionHandler.verifyEquals(text, "Buy Side");
		System.out.println("Account classification field is populated with Buy Side");
	}
	
	
}
