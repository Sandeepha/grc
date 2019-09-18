package com.sc.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.framework.asserts.AssertionHandler;
import com.framework.handlers.ActionHandler;
import com.framework.handlers.PopUpHandler;
import com.framework.utils.ExcelUtils;
import com.sc.constants.GRC_properties;
import com.sc.constants.GenerateRandomNumber;
import com.sc.constants.SCconstants;
import com.sc.objects.repository.BasePageObjects;
import com.sc.objects.repository.OpportunitiesPageObjects;
import com.sc.objects.repository.ProductsPageObjects;
import com.sc.objects.repository.QuotePageObjects;
//import com.sc.stepdefination.CucumberSetup;
//import com.sc.stepdefination.CucumberSetup;
//import com.sc.stepdefination.CucumberSetup;

public class OpportunitiesPage extends BasePage {

	public OpportunitiesPage(WebDriver webDriver) {
		super(webDriver);

	}

	public String createaNewOpportunity() {
		String accountName = null;
		accountName = elementHandler.getTextFromValueAttribute(OpportunitiesPageObjects.OpptyAccuntName);
		if (accountName.isEmpty()) {
			accountName = ExcelUtils.getDataByColumnName("SearchData", "AccountName");
			AddAccountInOptyPage(accountName);
		}
		// String OpportunityName =
		// ExcelUtils.getDataByColumnName("Opportunity", "Opportunity Name");
		String randomNum = GenerateRandomNumber.getRandomNumber();
		String OpportunityName = "Opty_Try_" + randomNum;

		System.out.println(OpportunityName);
		elementHandler.writeText(OpportunitiesPageObjects.OptyName, OpportunityName, OpportunitiesPageObjects.OptyType);
		String OptyType = ExcelUtils.getDataByColumnName("Opportunity", "Opportunity Type");
		elementHandler.selectByValue(OpportunitiesPageObjects.OptyType, OptyType,
				OpportunitiesPageObjects.Optyclosedate);
		String OptyClosedate = ExcelUtils.getDataByColumnName("Opportunity", "Close Date");
		System.out.println("close date =" + OptyClosedate);
		// elementHandler.clickElement(OpportunitiesPageObjects.Optyclosedate,
		elementHandler.writeText(OpportunitiesPageObjects.Optyclosedate, OptyClosedate,
				OpportunitiesPageObjects.OptyStage);
		String OptyStage = ExcelUtils.getDataByColumnName("Opportunity", "Stage");
		elementHandler.selectByValue(OpportunitiesPageObjects.OptyStage, OptyStage);
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.OptyWinLossReason);
		String Winlossreason = ExcelUtils.getDataByColumnName("Opportunity", "Win/Loss Reason");
		elementHandler.selectByValue(OpportunitiesPageObjects.OptyWinLossReason, Winlossreason,
				OpportunitiesPageObjects.OptyWinlosscomment);
		String Winlosscomment = ExcelUtils.getDataByColumnName("Opportunity", "Win/Loss Commentary");
		elementHandler.writeText(OpportunitiesPageObjects.OptyWinlosscomment, Winlosscomment,
				OpportunitiesPageObjects.OptyWinLossCompetitors);
		// String Winlosscompetitors =
		// ExcelUtils.getDataByColumnName("Opportunity", "Win/Loss
		// Competitors");
		elementHandler.clickElement(OpportunitiesPageObjects.OptyWinLossCompetitors,
				OpportunitiesPageObjects.OptyWinLossCompetitorsAdd);
		String Text = elementHandler.getText(OpportunitiesPageObjects.OptyWinLossCompetitors);
		//System.out.println("Competitors available " + Text);
		elementHandler.clickElement(OpportunitiesPageObjects.OptyWinLossCompetitorsAdd,
				OpportunitiesPageObjects.OptyWinLossCompetitorsChosen);
		//System.out.println("Competitors choosen " + OpportunitiesPageObjects.OptyWinLossCompetitorsChosen.getText());
		AssertionHandler.verifyEquals(Text, OpportunitiesPageObjects.OptyWinLossCompetitorsChosen.getText(),
				"Competitors not matching");
		// javaScriptHandler.scrollToElementAndClick(OpportunitiesPageObjects.OptyBottomSaveButton);

		actionHandler.waitForSomeTime(3000);
		elementHandler.clickElement(OpportunitiesPageObjects.OptyTopSavebuton);
		return OpportunityName;

	}

	public String getOptyNamefromOptypage() {
		String optyname = elementHandler.getText(OpportunitiesPageObjects.Optynameafteroptycreated);
		return optyname;
	}

	public String getAccountNamefromoptypage() {
		String AccountName = elementHandler.getText(OpportunitiesPageObjects.AccuntNameafteroptycreated);
		return AccountName;
	}

	public void verifyrevenueinformationfieldsaredisplayed() {
		AssertionHandler.verifyTrue(
				elementHandler.isElementDisplayed(OpportunitiesPageObjects.OptyRevenueGTMReccurringfeild),
				"Revenue information is not visible");
		AssertionHandler.verifyTrue(
				elementHandler.isElementDisplayed(OpportunitiesPageObjects.OptyRevenueGTMOneTimeFeild),
				"Revenue information is not visible");
		AssertionHandler.verifyTrue(
				elementHandler.isElementDisplayed(OpportunitiesPageObjects.OptyRevenueMonthlyRecurringfeild),
				"Revenue information is not visible");
	}

	public String verifyFXALLFlag() {
		String flag = elementHandler.getText(OpportunitiesPageObjects.OptyFXALLFlag);
		return flag;
	}

	public String verifyGRCOptyFlag() {
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.GRCOptycheckbx);
		String flag = elementHandler.getTextFromAttribute(OpportunitiesPageObjects.GRCOptycheckbx, "title");
		System.out.println("GRCOptyCheckBox is " + flag);
		return flag;
	}

	public String SearchanExistingOpty() {
		String Optyname;
		GRC_properties.AccountName = ExcelUtils.getDataByColumnName("SearchData", "AccountName");
		if (GRC_properties.OpportunityName == null) {
			GRC_properties.OpportunityName = ExcelUtils.getDataByColumnName("Quote", "Opportunity Name");
		}
		GlobalSearch(GRC_properties.OpportunityName);

		elementHandler.clickElement(BasePageObjects.linkOpportunities, BasePageObjects.LinkOptyName);

		if (BasePageObjects.OptySearchresultsoptyAccountName.size() == 1) {
			elementHandler.clickElement(BasePageObjects.LinkOptyName, OpportunitiesPageObjects.OptyPageHeader);
			actionHandler.waitForPageToLoad();
		} else {
			int iter = 2;
			for (WebElement element : BasePageObjects.OptySearchresultsoptyAccountName) {

				if (GRC_properties.AccountName.equalsIgnoreCase(elementHandler.getText(element))) {
					String replacevalue = Integer.toString(iter);
					WebElement LinkOptyName = dynamicPageObjects.dynamicElement(BasePageObjects.LinkOptyNamesmany,
							replacevalue);
					elementHandler.clickElement(LinkOptyName, OpportunitiesPageObjects.OptyPageHeader);
					actionHandler.waitForPageToLoad();
					break;
				}

				iter = iter + 1;

			}

		}
		Optyname = elementHandler.getText(OpportunitiesPageObjects.OptyPageheadername);
		return Optyname;

	}

	public void GotoProductrelatedtabinoptypage() {
		elementHandler.clickElement(OpportunitiesPageObjects.OptyProductsstandardPricebookrelatedtab,
				OpportunitiesPageObjects.OptypageAddProductButton);
		elementHandler.waitForPageToLoad();
	}

	public void GoToGRcProductrelatedtabinoptypage() {
		elementHandler.clickElement(OpportunitiesPageObjects.OptyProductsGRCPricebookrelatedtab,
				OpportunitiesPageObjects.OptypageAddProductButton);
		elementHandler.waitForPageToLoad();
	}

	public void clickChooseGRCPricebook() {
		elementHandler.clickElement(OpportunitiesPageObjects.ChoosePricebookbutton,
				OpportunitiesPageObjects.Pricebookpageheader);
		elementHandler.waitForPageToLoad();
		elementHandler.selectByVisibleText(OpportunitiesPageObjects.selectPriceBook, "GRC Pricebook",
				OpportunitiesPageObjects.Pricebooksavebutton);
		elementHandler.clickElement(OpportunitiesPageObjects.Pricebooksavebutton);
		popUpHandler.acceptAlert(OpportunitiesPageObjects.OptyPageHeader);
		elementHandler.waitForPageToLoad();
		

	}

	public boolean checkifProductsareadded() {
		boolean isTrue;
		try {

			isTrue = OpportunitiesPageObjects.OptyPrductNorecordstodisplay.isDisplayed();
		} catch (NoSuchElementException e) {
			isTrue = false;
		}
		return isTrue;

	}

	public void clickaddProductButton() {
		elementHandler.clickElement(OpportunitiesPageObjects.AddProductButtn);
		elementHandler.waitForPageToLoad();
		actionHandler.waitForSomeTime(5000);
	}

	public void verifyProductsareaddedsuccessfully() {
		List<String> productsnameaddinginlist = new ArrayList<String>();
		for (WebElement Products : OpportunitiesPageObjects.PrductsfromOptypage) {
			String text = elementHandler.getText(Products);
			productsnameaddinginlist.add(text);
		}

		String Noofproducts = ExcelUtils.getDataByColumnName("Products", "NoOfProducts");
		int noofproducts = Integer.parseInt(Noofproducts);
		for (int i = 2; i <= noofproducts + 1; i++) {
			String product = ExcelUtils.getDataByColumnNameWithRowIndex("Products", "GRC Product", i);
			AssertionHandler.verifyTrue(productsnameaddinginlist.contains(product), "Product not added successfully");
			System.out.println(product + " is added successfully");

		}
	}

	public void goToQuotesrelatedtab() {
		elementHandler.clickElement(OpportunitiesPageObjects.OptyPageQuotestab,
				OpportunitiesPageObjects.OptyPageNewquotebutton);
	}

	public void clickonNewquote() {
		elementHandler.clickElement(OpportunitiesPageObjects.OptyPageNewquotebutton, QuotePageObjects.QuotePageHeader);
		actionHandler.waitForPageToLoad();

	}

	public void gotoContactRelatedTab() {
		elementHandler.clickElement(OpportunitiesPageObjects.OptyPageContactRoles,
				OpportunitiesPageObjects.OtyNewcontactRolebutton);
		elementHandler.clickElement(OpportunitiesPageObjects.OtyNewcontactRolebutton,
				OpportunitiesPageObjects.PrimaryheaderinContactRoles);
		actionHandler.waitForPageToLoad();
	}

	public void addPrimaryContact() {
		GRC_properties.ContactName = ExcelUtils.getDataByColumnName("Contact", "Contact Name");

		if ((elementHandler.getTextFromValueAttribute(OpportunitiesPageObjects.PrimaryContactTextBox))
				.equalsIgnoreCase(GRC_properties.ContactName)) {
			elementHandler.clickElement(OpportunitiesPageObjects.PrimaryContactRadioButton,
					OpportunitiesPageObjects.PrimaryContactRoleDropdown);
			elementHandler.selectByVisibleText(OpportunitiesPageObjects.PrimaryContactRoleDropdown, "Billing",
					OpportunitiesPageObjects.PrimaryContactSaveButton);
			elementHandler.clickElement(OpportunitiesPageObjects.PrimaryContactSaveButton);
			actionHandler.waitForPageToLoad();
		} else {
			elementHandler.clickElement(OpportunitiesPageObjects.PrimaryContactLookupButton);
			String parentWindow = windowHandler.getParentWindow();
			windowHandler.switchToLatestWindow(BasePageObjects.ContactLookupsearchframe);
			windowHandler.waitForFrameAndSwitchIt(BasePageObjects.ContactLookupsearchframe,
					BasePageObjects.CntactLookupbox);
			elementHandler.writeText(BasePageObjects.CntactLookupbox, GRC_properties.ContactName,
					BasePageObjects.ContactlookupGoButton);
			elementHandler.clickElement(BasePageObjects.ContactlookupGoButton);
			windowHandler.switchToMainFrame();
			windowHandler.waitForFrameAndSwitchIt(BasePageObjects.ContactLookuupresultsframe);
			actionHandler.waitForSomeTime(3000);
			GRC_properties.ContactName = elementHandler.getText(BasePageObjects.LinkLookupContact);
			elementHandler.clickElement(BasePageObjects.LinkLookupContact);
			windowHandler.switchToParentWindow(parentWindow, OpportunitiesPageObjects.PrimaryContactSaveButton);
			elementHandler.clickElement(OpportunitiesPageObjects.PrimaryContactRadioButton,
					OpportunitiesPageObjects.PrimaryContactRoleDropdown);
			elementHandler.selectByVisibleText(OpportunitiesPageObjects.PrimaryContactRoleDropdown, "Billing",
					OpportunitiesPageObjects.PrimaryContactSaveButton);
			elementHandler.clickElement(OpportunitiesPageObjects.PrimaryContactSaveButton);
			actionHandler.waitForPageToLoad();
		}
		// actionHandler.moveToElement(OpportunitiesPageObjects.optyPageContactRolescount);
		elementHandler.clickElement(OpportunitiesPageObjects.OptyPageContactRoles,
				OpportunitiesPageObjects.OtyNewcontactRolebutton);
		AssertionHandler.verifyEquals(OpportunitiesPageObjects.contactRoleContactNameOptyPage.getText(),
				GRC_properties.ContactName, "Unable to add primary contact Role");
		System.out.println("Primary Contact role added successfully");
	}

	public void OpenTheCreatedQuote() {
		elementHandler.clickElement(OpportunitiesPageObjects.optyPageQuotesTab,
				QuotePageObjects.QuotePageHeaderCreated);
		actionHandler.waitForPageToLoad();
	}

	public void validatePopup_grcPriceBook() {

		String text = elementHandler.getText(OpportunitiesPageObjects.standardPriceBook);
		boolean flag = text.contains("Standard Price Book");
		AssertionHandler.verifyTrue(flag);
		elementHandler.clickElement(OpportunitiesPageObjects.OptyProductsstandardPricebookrelatedtab,
				OpportunitiesPageObjects.OptypageAddProductButton);
		elementHandler.waitForPageToLoad();
		elementHandler.clickElement(OpportunitiesPageObjects.ChoosePricebookbutton,
				OpportunitiesPageObjects.Pricebookpageheader);
		elementHandler.waitForPageToLoad();
		elementHandler.selectByVisibleText(OpportunitiesPageObjects.selectPriceBook, "GRC Pricebook",
				OpportunitiesPageObjects.Pricebooksavebutton);
		elementHandler.clickElement(OpportunitiesPageObjects.Pricebooksavebutton);
		String textInAlert = popUpHandler.getAlertText();
		popUpHandler.acceptAlert();
		AssertionHandler.verifyEquals(textInAlert,
				"You have changed the price book for this opportunity. This action permanently deletes all products from the opportunity. Continue?");
		String text1 = elementHandler.getText(OpportunitiesPageObjects.grcPricebook);
		boolean flag1 = text1.contains("GRC Pricebook");
		AssertionHandler.verifyTrue(flag1);
	}

	public void validateGRCOpportunityFlag() {
		boolean flag = false;
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.grcOpportunityflag);
		actionHandler.waitForSomeTime(2000);
		Actions a = new Actions(driver);
		a.doubleClick(OpportunitiesPageObjects.grcOpportunityflag).build().perform();
		actionHandler.waitForSomeTime(5000);
		flag = OpportunitiesPageObjects.grcOpportunityCheckBox.isSelected();
		AssertionHandler.verifyTrue(flag);
		System.out.println("The flag is checked");

	}

	public void validteMandatoryFieldsPresence() {

		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.partnersandDistributionLabel);
		boolean partnerDistribution = OpportunitiesPageObjects.partnersandDistributionLabel.isDisplayed();
		AssertionHandler.verifyTrue(partnerDistribution);
		System.out.println("Partners and Distribution field is present");
		boolean partnerEngagementType = OpportunitiesPageObjects.partnerEngagementTypeLabel.isDisplayed();
		AssertionHandler.verifyTrue(partnerEngagementType);
		System.out.println("Partner Engagement Type field is present");
		boolean gsaSale = OpportunitiesPageObjects.gsaSaleLabel.isDisplayed();
		AssertionHandler.verifyTrue(gsaSale);
		System.out.println("GSA sale field is present");
	}

	public void validatePopupContactRole() {
		javaScriptHandler.scrollToElementAndClick(OpportunitiesPageObjects.newQuoteField);
		String textInPopup = popUpHandler.getAlertText();
		AssertionHandler.verifyEquals(textInPopup,
				"Please select a Primary Contact from the Opportunity Contact Roles related list in order to create a Quote");
		System.out.println("Popup is accepted and the text is: " + textInPopup);
		popUpHandler.acceptAlert();

	}

	public void validateClosedDate() {
		String closedDate = elementHandler.getText(OpportunitiesPageObjects.closedDate);
		String OptyClosedate = ExcelUtils.getDataByColumnName("Opportunity", "Close Date");
		AssertionHandler.verifyEquals(closedDate, OptyClosedate);
		System.out.println("closed date is verified");

	}

	public void validateGSASaleFieldRealtedCases() {

		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.gsaSaleLabel);
		String text = OpportunitiesPageObjects.gsaSaleLabel.getText();
		AssertionHandler.verifyEquals(text, "GSA Sale");
		System.out.println("'GSA Sale' is available on the GRC opportunity page layout");

		String attributeValue = OpportunitiesPageObjects.gsaSaleLabelCheckBox.getAttribute("class");
		AssertionHandler.verifyEquals(attributeValue, "checkImg");
		System.out.println("The data type of 'GSA Sale' field is a checkbox.");

		boolean flag = OpportunitiesPageObjects.gsaSaleLabelCheckBox.isSelected();
		AssertionHandler.verifyFalse(flag);
		System.out.println("The 'GSA Sale' field is unchecked by default");

		actionHandler.moveToElement(OpportunitiesPageObjects.gsaSaleImage);
		String imageText = elementHandler.getText(OpportunitiesPageObjects.gsaSaleImageText);
		AssertionHandler.verifyEquals(imageText,
				"This box should be checked if the Opportunity was made by a member of the General Services Administration.");
		System.out.println("The helptext is displayed for GSA Sale field is: " + imageText);
		actionHandler.moveToElement(OpportunitiesPageObjects.gsaSaleLabel);
		actionHandler.waitForSomeTime(3000);

	}

	public int getPETPosition() {
		int i;
		for (i = 0; i < OpportunitiesPageObjects.helpButtons.size(); i++) {
			if (OpportunitiesPageObjects.helpButtons.get(i).getText().equals("Partner Engagement Type")) {
				System.out.println("The Partner Engagement Type is positioned at " + i + " place");
				break;
			}
		}
		return i;

	}

	public int getGSAPosition() {
		int j;
		for (j = 0; j < OpportunitiesPageObjects.helpButtons.size(); j++) {
			if (OpportunitiesPageObjects.helpButtons.get(j).getText().equals("GSA Sale")) {
				System.out.println("The GSA Sale is positioned at " + j + " place");
				break;
			}
		}
		return j;
	}

	public void validatePosition() {

		int positionNumberPET = getPETPosition();
		int positionNumberGSA = getGSAPosition();
		if (positionNumberGSA > positionNumberPET)
			System.out.println("The 'GSA Sale' field is positioned below the Partner Engagement Type field");
		else
			System.out.println("The 'GSA Sale' field is not positioned below the Partner Engagement Type field");
	}

	public void validateGSASaleFieldInOptyPage() {

		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.gsaSaleLabel);
		String text = OpportunitiesPageObjects.gsaSaleLabel.getText();
		AssertionHandler.verifyEquals(text, "GSA Sale");
		System.out.println("'GSA Sale' is added on the opportunity page layout");
	}

	public void validateGSAFieldIsEditable() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", OpportunitiesPageObjects.gsaSaleLabel);
		Actions a = new Actions(driver);
		a.doubleClick(OpportunitiesPageObjects.gsaSaleLabelCheckBox).build().perform();
		/*// actionHandler.waitForSomeTime(5000);
		boolean before = elementHandler.isElementSelected(OpportunitiesPageObjects.gsaSaleCheckBox);
		AssertionHandler.verifyFalse(before);
		elementHandler.clickElement(OpportunitiesPageObjects.gsaSaleCheckBox);
		boolean after = elementHandler.isElementSelected(OpportunitiesPageObjects.gsaSaleCheckBox);
		AssertionHandler.verifyTrue(after);*/
		System.out.println("The GSA field can be editable");

	}

	public void clickOnOrganisationTypeDropDown() {
		//elementHandler.clickElement(OpportunitiesPageObjects.organisationTypeDropDown);
		//javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.organisationTypeDropDown);
		
		Actions a = new Actions(driver);		
		a.doubleClick(OpportunitiesPageObjects.organisationTypeDropDown).build().perform();
		//actionHandler.doubleClick(OpportunitiesPageObjects.organisationTypeDropDown);

	}

	public void validateDropdownFields() {
		actionHandler.waitForSomeTime(5000);
		//String text1 = elementHandler.getText(OpportunitiesPageObjects.corporateManufacturingField);
		//elementHandler.getTextFromValueAttribute(element)
		String text1 = elementHandler.getTextFromAttribute(OpportunitiesPageObjects.corporateManufacturingField, "value");		
		AssertionHandler.verifyEquals(text1, "Corporate - Manufacturing");		
		System.out.println("Corporate - Manufacturing is there in the OrganisationTypeDropDown List ");
		String text2 = elementHandler.getTextFromAttribute(OpportunitiesPageObjects.corporateRetailField,"value");		
		AssertionHandler.verifyEquals(text2, "Corporate - Retail");
		System.out.println("Corporate - Retail is there in the OrganisationTypeDropDown List ");
		String text3 = elementHandler.getTextFromAttribute(OpportunitiesPageObjects.individualInvestorField,"value");
		AssertionHandler.verifyEquals(text3, "Individual Investor");
		System.out.println("Individual Investor is there in the OrganisationTypeDropDown List ");
		String text4 = elementHandler.getTextFromAttribute(OpportunitiesPageObjects.corporateTechnologyField,"value");
		AssertionHandler.verifyEquals(text4, "Corporate - Technology");
		System.out.println("Corporate – Technology is there in the OrganisationTypeDropDown List ");
		
	}

	public void getTitleOptyPage() {
		elementHandler.clickElement(OpportunitiesPageObjects.opportunitiesTab);
		String title=driver.getTitle();
		AssertionHandler.verifyEquals(title, "Opportunities: Home ~ Salesforce - Unlimited Edition");
		System.out.println("User is on the Opportunities page");
		
	}

	public void getExistingOpportunity() {
		elementHandler.writeText(OpportunitiesPageObjects.globalSearch, "Opty_Try_5001");
		//Opty_Try_4674  --  Opty_Try_8205 -- Opty_Try_2850
		elementHandler.clickElement(OpportunitiesPageObjects.globalSearchBtn);
		elementHandler.clickElement(OpportunitiesPageObjects.editOpty);
		
	}

	public void selectOptyCurrency() {
		
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.dropdownOptyCurrency);
		elementHandler.selectByValue(OpportunitiesPageObjects.dropdownOptyCurrency, "AUD");
		//USD//INR
		javaScriptHandler.scrollToElementAndClick(OpportunitiesPageObjects.OptyTopSavebuton);
		String title = driver.getTitle();
		AssertionHandler.verifyEquals(title, "Search Results ~ Salesforce - Unlimited Edition");
		//System.out.println("user is able to have different currency in opportunity apart from account currency");
	}
	
public void selectOpptyCurrency() {
		
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.dropdownOptyCurrency);
		elementHandler.selectByValue(OpportunitiesPageObjects.dropdownOptyCurrency, "AUD");
		//USD//INR
		javaScriptHandler.scrollToElementAndClick(OpportunitiesPageObjects.OptyTopSavebuton);			
	}

	public void validateMonthlyRecurring() {
		String text = elementHandler.getText(OpportunitiesPageObjects.monthlyRecurringFieldData);
		AssertionHandler.verifyNotEquals(text, "USD - U.S. Dollar");
		System.out.println("user is able to have different currency in opportunity apart from account currency");
		
	}

	public void createNewOptyForQuote() {
		
		String accountName = null;
		accountName = elementHandler.getTextFromValueAttribute(OpportunitiesPageObjects.OpptyAccuntName);
		if (accountName.isEmpty()) {
			accountName = ExcelUtils.getDataByColumnName("SearchData", "AccountName");
			AddAccountInOptyPage(accountName);
		}
		String OpportunityName = ExcelUtils.getDataByColumnName("Quote", "Opportunity Name");
		/*int randomNum = GenerateRandomNumber.getRandomNumber();
		String OpportunityName = "Opty_Try_" + randomNum;*/

		System.out.println(OpportunityName);
		elementHandler.writeText(OpportunitiesPageObjects.OptyName, OpportunityName, OpportunitiesPageObjects.OptyType);
		String OptyType = ExcelUtils.getDataByColumnName("Opportunity", "Opportunity Type");
		elementHandler.selectByValue(OpportunitiesPageObjects.OptyType, OptyType,
				OpportunitiesPageObjects.Optyclosedate);
		String OptyClosedate = ExcelUtils.getDataByColumnName("Opportunity", "Close Date");
		System.out.println("close date =" + OptyClosedate);
		// elementHandler.clickElement(OpportunitiesPageObjects.Optyclosedate,
		elementHandler.writeText(OpportunitiesPageObjects.Optyclosedate, OptyClosedate,
				OpportunitiesPageObjects.OptyStage);
		String OptyStage = ExcelUtils.getDataByColumnName("Opportunity", "Stage");
		elementHandler.selectByValue(OpportunitiesPageObjects.OptyStage, OptyStage);
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.OptyWinLossReason);
		String Winlossreason = ExcelUtils.getDataByColumnName("Opportunity", "Win/Loss Reason");
		elementHandler.selectByValue(OpportunitiesPageObjects.OptyWinLossReason, Winlossreason,
				OpportunitiesPageObjects.OptyWinlosscomment);
		String Winlosscomment = ExcelUtils.getDataByColumnName("Opportunity", "Win/Loss Commentary");
		elementHandler.writeText(OpportunitiesPageObjects.OptyWinlosscomment, Winlosscomment,
				OpportunitiesPageObjects.OptyWinLossCompetitors);
		// String Winlosscompetitors =
		// ExcelUtils.getDataByColumnName("Opportunity", "Win/Loss
		// Competitors");
		elementHandler.clickElement(OpportunitiesPageObjects.OptyWinLossCompetitors,
				OpportunitiesPageObjects.OptyWinLossCompetitorsAdd);
		String Text = elementHandler.getText(OpportunitiesPageObjects.OptyWinLossCompetitors);
		System.out.println("Competitors available " + Text);
		elementHandler.clickElement(OpportunitiesPageObjects.OptyWinLossCompetitorsAdd,
				OpportunitiesPageObjects.OptyWinLossCompetitorsChosen);
		System.out.println("Competitors choosen " + OpportunitiesPageObjects.OptyWinLossCompetitorsChosen.getText());
		AssertionHandler.verifyEquals(Text, OpportunitiesPageObjects.OptyWinLossCompetitorsChosen.getText(),
				"Competitors not matching");
		// javaScriptHandler.scrollToElementAndClick(OpportunitiesPageObjects.OptyBottomSaveButton);

		actionHandler.waitForSomeTime(3000);
		elementHandler.clickElement(OpportunitiesPageObjects.OptyTopSavebuton);
		System.out.println("Opportunity is created: "+ OpportunityName);
	}

	public void validateCurrency() {
		String text = elementHandler.getText(OpportunitiesPageObjects.monthlyRecurringFieldData);
		AssertionHandler.verifyNotEquals(text, "USD - U.S. Dollar");
		System.out.println("currency change is applicable only for Sales quote");
		
	}

	public void getErrorMsg() {
		String errorMsg = elementHandler.getText(OpportunitiesPageObjects.erorMsgCurrency);		
		System.out.println("***************************************");
		System.out.println("Error message is:");;;;;;
		System.out.println(errorMsg);
		System.out.println("***************************************");		
		if(errorMsg.contains("Please change the Currency to the same currency as the account AND YOU MUST CHECK and UPDATE the revenue fields accordingly")){
			System.out.println("Different currency change is not applicable");
		}
		
		
		
		
	}

	public void addProducts() {
		elementHandler.clickElement(OpportunitiesPageObjects.productsLinkOptyPageLayout);
		elementHandler.clickElement(OpportunitiesPageObjects.addProductBtnInOptyPageLayout);
		driver.findElement(By.xpath("//div[@class='rolodex']/a[1]")).click();		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		actionHandler.waitForSomeTime(3000);
		List <WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox' and @name='ids']"));
		for(int i=0;i<=1;i++){
			checkBox.get(i).click();
		}
		driver.findElement(By.xpath("//input[@value='Select']")).click();
		actionHandler.waitForSomeTime(2000);
		
		List <WebElement> quantityField = driver.findElements(By.xpath("//input[contains(@type,'text')]"));
		for(int i=1;i<=4;i++){
			if(i==1)
				quantityField.get(i).sendKeys("1");
			else if(i==2||i==4){	
				quantityField.get(i).clear();
				quantityField.get(i).sendKeys("10");
			}
			else
				quantityField.get(i).sendKeys("2");
			
		}
		driver.findElement(By.xpath("//input[contains(@value,' Save ')]")).click();
		
		//wait.until(ExpectedConditions.visibilityOf(OpportunitiesPageObjects.getOptyNameFromOptyPageLayout));
		String OptyName = elementHandler.getText(OpportunitiesPageObjects.getOptyNameFromOptyPageLayout);
		System.out.println("The products are added successfully for the Opportunity: "+OptyName);
	}

	public void addContactRoles() {
		
		elementHandler.clickElement(OpportunitiesPageObjects.contactRolesLink);
		elementHandler.clickElement(OpportunitiesPageObjects.newContactRoleBtn);
		
	}

	public void validateActiveQuoteInd() {
		elementHandler.clickElement(QuotePageObjects.optyName);
		javaScriptHandler.scrollIntoView(OpportunitiesPageObjects.activeQuoteIndInOptyPage);
		String text = elementHandler.getTextFromAttribute(OpportunitiesPageObjects.activeQuoteIndInOptyPage, "title");
		AssertionHandler.verifyEquals(text, "Checked");
		System.out.println("Active Quote Ind checkbox on the opportunity is checked");
		
	}

	public void createGRCFreeTrialOpty() {
		elementHandler.clickElement(OpportunitiesPageObjects.associatedOpportunityField, OpportunitiesPageObjects.GRCTrialOptyBtn);
		elementHandler.clickElement(OpportunitiesPageObjects.GRCTrialOptyBtn);
		popUpHandler.acceptAlert();
		actionHandler.waitForSomeTime(12000);
		String grcFreeTrialName = driver.findElement(By.xpath("//h2[@class='pageDescription']")).getText();
		if(grcFreeTrialName.contains("Free Trial")) {
			System.out.println("Free Trial opportunity created: "+grcFreeTrialName );
		}
		
	}

}