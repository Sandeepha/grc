package com.sc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.asserts.AssertionHandler;
import com.framework.cucumber.helper.CucumberSetup;
import com.framework.handlers.ActionHandler;
import com.framework.utils.ExcelUtils;
import com.sc.constants.GRC_properties;
import com.sc.objects.repository.BasePageObjects;
import com.sc.objects.repository.OpportunitiesPageObjects;
import com.sc.objects.repository.QuotePageObjects;

public class QuotePage extends BasePage {

	public QuotePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public String createANewQuote() {
		String contractType = ExcelUtils.getDataByColumnName("Quote", "Contract type");
		System.out.println("Contract Type = " + contractType);
		elementHandler.selectByVisibleText(QuotePageObjects.QuotePageContractType, contractType);
		String Justification = ExcelUtils.getDataByColumnName("Quote", "Commercial Justification");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", QuotePageObjects.QuotePageJustification);
		elementHandler.writeText(QuotePageObjects.QuotePageJustification, Justification,
				QuotePageObjects.QuotesaveButton);
		elementHandler.clickElement(QuotePageObjects.QuotesaveButton, QuotePageObjects.showQuoteDetailImg);
		actionHandler.waitForPageToLoad();
		// elementHandler.clickElement(QuotePageObjects.showQuoteDetailImg);
		actionHandler.waitForSomeTime(2000);
		GRC_properties.QuoteName = elementHandler.getText(QuotePageObjects.quotename);
		return elementHandler.getText(QuotePageObjects.QuoteNumber);

	}
	
	public String createANewFreeTrialQuote() {
		
		elementHandler.clickElement(QuotePageObjects.QuotesaveButton);
		actionHandler.waitForPageToLoad();
		// elementHandler.clickElement(QuotePageObjects.showQuoteDetailImg);
		actionHandler.waitForSomeTime(2000);
		GRC_properties.QuoteName = elementHandler.getText(QuotePageObjects.freeTrialQuotename);
		return elementHandler.getText(QuotePageObjects.freeTrialQuoteNumber);

	}

	public void verifyquoteiscreated() {
		AssertionHandler.verifyEquals((elementHandler.getText(QuotePageObjects.QuoteAccountName)),
				GRC_properties.AccountName, "Quote account name mismatch");
		AssertionHandler.verifyEquals((elementHandler.getText(QuotePageObjects.QuoteptyName)),
				GRC_properties.OpportunityName, "Quote opty name mismatch");
		AssertionHandler.verifyEquals((elementHandler.getText(QuotePageObjects.QuoteStatus)), "In Progress",
				"Quote status mismatch");

	}

	public void submitQuoteForApproval() {

		elementHandler.clickElement(QuotePageObjects.QuoteSubmitForApproval);
		popUpHandler.acceptAlert();
		popUpHandler.acceptAlert();
		elementHandler.clickElement(QuotePageObjects.QuoteSubmitForApprovalButton);
		actionHandler.waitForPageToLoad();
		System.out.println("The quote is submitted for Approval");
		actionHandler.waitForSomeTime(2000);
		String quoteStatus = QuotePageObjects.quoteStatusField.getText();
		AssertionHandler.verifyEquals(quoteStatus, "Awaiting Approval");
		System.out.println("The Quote Status is changed to: " + quoteStatus);
		actionHandler.waitForSomeTime(2000);

	}

	public void verifyStatusOfQuoteAfterSubmittingForApproval() {
		AssertionHandler.verifyEquals((elementHandler.getText(QuotePageObjects.QuoteStatus)), "Awaiting Approval",
				"Quote status mismatch");

	}

	public void loginAsGamApprovar() {
		actionHandler.waitForSomeTime(2000);
		WebElement downArrowMark = driver.findElement(By.xpath("//div[@id='userNavButton']//div[1]"));
		WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Logout']"));
		WebElement globalSearch = driver.findElement(By.xpath("//input[@id='phSearchInput']"));
		javaScriptHandler.scrollIntoView(QuotePageObjects.GamApprovarName);
		String gamApprovar = QuotePageObjects.GamApprovarName.getText();
		javaScriptHandler.scrollIntoView(downArrowMark);
		elementHandler.clickElement(downArrowMark);
		elementHandler.clickElement(logoutBtn);
		GlobalSearch(gamApprovar);
		profileLogin();
		System.out.println("GAM approver is logged in: " + gamApprovar);
		actionHandler.waitForSomeTime(3000);

	}

	public void validatePrimaryAndBillingContact() {
		javaScriptHandler.scrollIntoView(QuotePageObjects.contactNameFieldData);
		QuotePageObjects.contactNameFieldData.clear();
		QuotePageObjects.billingContactFieldData.clear();
		javaScriptHandler.scrollIntoView(QuotePageObjects.QuotesaveButton);
		elementHandler.clickElement(QuotePageObjects.QuotesaveButton);
		String errorMessage = QuotePageObjects.errorMsgWhenSaveQuote.getText();
		System.out.println("****************************************");
		System.out.println("The error message is:");
		System.out.println(errorMessage);
		System.out.println("****************************************");
		if (errorMessage.contains("Review all error messages below to correct your data")) {
			System.out.println("Primary contact and billing contact is mandatory to create a sale quote");
		} else {
			System.out.println("Primary contact and billing contact are not mandatory to create a sale quote");
		}

	}

	public void validateQuoteStatus() {

		elementHandler.writeText(BasePageObjects.GlobalSearchBox, GRC_properties.QuoteNumber);
		elementHandler.clickElement(BasePageObjects.SearchButton);
		driver.findElement(By.xpath("//a[text()='Quote Name']/../../..//tr[2]//th//a")).click();
		actionHandler.waitForPageToLoad();
		String quoteStatus = elementHandler.getText(QuotePageObjects.QuoteStatus);
		AssertionHandler.verifyEquals(quoteStatus, "Rejected");
		System.out.println("Quote status is moved  to Rejected");

	}

	public void validateQuoteStatusAfterEditBtn() {
		elementHandler.clickElement(QuotePageObjects.editQuoteBtn, QuotePageObjects.QuotesaveButton);
		elementHandler.clickElement(QuotePageObjects.QuotesaveButton, QuotePageObjects.QuoteSubmitForApproval);
		actionHandler.waitForPageToLoad();
		submitQuoteForApproval();
		System.out.println("Quote Status is changed from Rejected to In Progress after click on EDIT button");
	}

	public void validateSubmitWithoutEdit() {
		elementHandler.clickElement(QuotePageObjects.QuoteSubmitForApproval);
		String textInAlert = popUpHandler.getAlertText();
		if (textInAlert.contains("Quote cannot be Approved since its in Rejected Status!")) {
			System.out
					.println("user is not able to resubmit GRC rejected quote for approval without editing the quote");
		} else {
			System.out.println("user is able to resubmit GRC rejected quote for approval without editing the quote");
		}
		popUpHandler.acceptAlert();
		actionHandler.waitForPageToLoad();
	}

	public void validateStartStopSyncButton() {
		String text = elementHandler.getText(OpportunitiesPageObjects.stopStartSyncBtn);
		if (text.contains("Stop")) {
			System.out.println("The Stop Sync Button is present");
		} else
			System.out.println("The Stop Sync Button is not present");

		elementHandler.clickElement(OpportunitiesPageObjects.stopStartSyncBtn);
		String text1 = elementHandler.getText(OpportunitiesPageObjects.stopStartSyncBtn);
		if (text1.contains("Start")) {
			System.out.println("The Start Sync Button is present");
		} else
			System.out.println("The Start Sync Button is not present");

	}

	public void validateStartButton() {
		String text = elementHandler.getText(OpportunitiesPageObjects.stopStartSyncBtn);
		if (text.contains("Stop")) {
			System.out.println("The Stop Sync Button is present");
		} else
			System.out.println("The Stop Sync Button is not present");

		elementHandler.clickElement(OpportunitiesPageObjects.stopStartSyncBtn);
		String text1 = elementHandler.getText(OpportunitiesPageObjects.stopStartSyncBtn);
		if (text1.contains("Start")) {
			System.out.println("The Start Sync Button is present");
		} else
			System.out.println("The Start Sync Button is not present");

	}

	public void validateStopButton() {
		String text = elementHandler.getText(OpportunitiesPageObjects.stopStartSyncBtn);
		if (text.contains("Stop")) {
			System.out.println("The Stop Sync Button is present");
		} else
			System.out.println("The Stop Sync Button is not present");

		elementHandler.clickElement(OpportunitiesPageObjects.stopStartSyncBtn);
		String text1 = elementHandler.getText(OpportunitiesPageObjects.stopStartSyncBtn);
		if (text1.contains("Start")) {
			System.out.println("The Start Sync Button is present");
		} else
			System.out.println("The Start Sync Button is not present");

	}

	public void approveCA() {
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(QuotePageObjects.quoteBtn, QuotePageObjects.quoteName);
		elementHandler.clickElement(QuotePageObjects.quoteName);
		actionHandler.waitForSomeTime(5000);
		elementHandler.clickElement(QuotePageObjects.customerAdminActivities);
		elementHandler.clickElement(QuotePageObjects.activityIDCA);
		elementHandler.clickElement(QuotePageObjects.changeBtn);
		elementHandler.writeText(QuotePageObjects.changeOwnerName, "Sarah Inman");
		driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]")).click();
		driver.findElement(By.xpath("//td[text()='Quote']//parent::tr//td[2]/a")).click();
		elementHandler.clickElement(QuotePageObjects.editBtn.get(0));
		elementHandler.clickElement(QuotePageObjects.selectApprovedDropdown);
		elementHandler.clickElement(QuotePageObjects.saveBtn);
		String quoteStatus = driver.findElement(By.xpath("//td[text()='Quote Status']//following-sibling::td"))
				.getText();
		Assert.assertEquals(quoteStatus, "Approved");

	}

	public void createOrderFormSendToClient() {
		actionHandler.waitForSomeTime(2000);
		driver.findElement(By.xpath("//input[@title='Create Order Form']")).click();
		actionHandler.waitForSomeTime(50000);

		driver.navigate().refresh();
		actionHandler.waitForSomeTime(5000);
		elementHandler.clickElement(QuotePageObjects.sendWithDocSignBtn);
		actionHandler.moveToElement(QuotePageObjects.addRecipientBtn);
		// elementHandler.clickElement(QuotePageObjects.addRecipientBtn,
		// QuotePageObjects.quickAddField);
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(QuotePageObjects.quickAddField);
		elementHandler.writeText(QuotePageObjects.addRecipientName, "Sweta");
		elementHandler.writeText(QuotePageObjects.emailAddress, "sweta.purohit@thomsonreuters.com");
		elementHandler.clickElement(QuotePageObjects.saveRecipientBtn, QuotePageObjects.nextBtn);
		actionHandler.waitForSomeTime(3000);
		elementHandler.clickElement(QuotePageObjects.nextBtn);
		actionHandler.waitForSomeTime(15000);		
		driver.switchTo().frame("ds-iframe");
		driver.findElement(By.xpath("//span[text()=' send ']")).click();
		driver.findElement(By.xpath("//a[text()='Return to Quote']")).click();
		driver.switchTo().defaultContent();
		actionHandler.waitForSomeTime(10000);
		driver.navigate().refresh();
		actionHandler.waitForSomeTime(10000);
		/*
		 * String quoteStatus1 = driver.findElement(By.
		 * xpath("//td[text()='Quote Status']//following-sibling::td")) .getText();
		 * Assert.assertEquals(quoteStatus1, "Submitted to Client");
		 */
		

	}

	public void submitFreeTrialQuoteApproval() {
		elementHandler.clickElement(QuotePageObjects.QuoteSubmitForApproval);
		popUpHandler.acceptAlert();
		popUpHandler.acceptAlert();
		elementHandler.clickElement(QuotePageObjects.QuoteSubmitForApprovalButton);
		actionHandler.waitForPageToLoad();
		System.out.println("The quote is submitted for Approval");
		actionHandler.waitForSomeTime(2000);
		String quoteStatus = QuotePageObjects.quoteStatusField.getText();
		AssertionHandler.verifyEquals(quoteStatus, "Approved");
		System.out.println("The Quote Status is changed to: " + quoteStatus);
		actionHandler.waitForSomeTime(2000);
		System.out.println("The Free trial quote is approved");
		
	}

	public void sendDocs() {
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(OpportunitiesPageObjects.submitForFullfillmentBtn);
		actionHandler.waitForSomeTime(10000);
		String quoteStatus = elementHandler.getText(OpportunitiesPageObjects.quoteStatusField);
		if(quoteStatus.contains("Fulfilment In Progress")){
			AssertionHandler.verifyTrue(true);
		}
		
		System.out.println("The order form sent to the client");
		
	}

	public void createOrderFormSendToClientFreeTrial() {
		actionHandler.waitForSomeTime(2000);
		driver.findElement(By.xpath("//input[@title='Create Order Form']")).click();
		actionHandler.waitForSomeTime(50000);

		driver.navigate().refresh();
		actionHandler.waitForSomeTime(5000);
		elementHandler.clickElement(QuotePageObjects.sendWithDocSignBtn);
		actionHandler.moveToElement(QuotePageObjects.addRecipientBtn);
		// elementHandler.clickElement(QuotePageObjects.addRecipientBtn,
		// QuotePageObjects.quickAddField);
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(QuotePageObjects.quickAddField);
		elementHandler.writeText(QuotePageObjects.addRecipientName, "Sweta");
		elementHandler.writeText(QuotePageObjects.emailAddress, "sweta.purohit@thomsonreuters.com");
		elementHandler.clickElement(QuotePageObjects.saveRecipientBtn, QuotePageObjects.nextBtn);
		actionHandler.waitForSomeTime(3000);
		elementHandler.clickElement(QuotePageObjects.nextBtn);
		actionHandler.waitForSomeTime(15000);		
		driver.switchTo().frame("ds-iframe");
		driver.findElement(By.xpath("//span[text()=' send ']")).click();
		driver.findElement(By.xpath("//a[text()='Return to Quote']")).click();
		driver.switchTo().defaultContent();
		actionHandler.waitForSomeTime(10000);
		driver.navigate().refresh();
		actionHandler.waitForSomeTime(10000);
		
	}

	public void submitQuoteForFullfillment() {
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(OpportunitiesPageObjects.submitForFullfillmentBtn);
		actionHandler.waitForSomeTime(5000);
		String quoteStatus = elementHandler.getText(OpportunitiesPageObjects.quoteStatusField);
		if(quoteStatus.contains("Fulfilment In Progress")){
			AssertionHandler.verifyTrue(true);
		}
		
		System.out.println("Free Trial Quote is submitted for fullfillment");
		
	}

	public void submitQuoteForFullfillmentOrderForm() {
		actionHandler.waitForSomeTime(5000);
		elementHandler.clickElement(OpportunitiesPageObjects.submitForFullfillmentBtn);
		actionHandler.waitForSomeTime(8000);
		String quoteStatus = elementHandler.getText(OpportunitiesPageObjects.quoteStatusField);
		if(quoteStatus.contains("Fulfilment In Progress")){
			AssertionHandler.verifyTrue(true);
		}
		
		System.out.println("Free Trial Quote is submitted to create order form");
		
	}

	public void extendQuoteLineItem() {
		logoutAndLoginAsAdmin();
		extendQuoteLineItems();
		
	}
	
	public void logoutAndLoginAsAdmin() {
		String quoteNumber = driver.findElement(By.xpath("//td[text()='Quote Number']//following-sibling::td[1]")).getText();
		driver.findElement(By.id("userNavButton")).click();
		elementHandler.clickElement(BasePageObjects.userLogout);
		elementHandler.writeText(BasePageObjects.GlobalSearchBox, quoteNumber);
		elementHandler.clickElement(BasePageObjects.SearchButton);
		elementHandler.clickElement(QuotePageObjects.QuoteBtnLatest);
		actionHandler.waitForSomeTime(10000);
		//elementHandler.clickElement(QuotePageObjects.customeAdminActities);
		elementHandler.clickElement(QuotePageObjects.editInCAA);
		actionHandler.waitForSomeTime(2000);
		driver.findElement(By.xpath("//label[text()='Status']//parent::span//parent::td//following-sibling::td//select")).sendKeys("Closed");
		//elementHandler.writeText(QuotePageObjects.QuoteStatusLatest, "Closed");
		elementHandler.clickElement(QuotePageObjects.saveBtn);	
		
	}
	
	public void extendQuoteLineItems() {
		driver.findElement(By.xpath("//input[@name='ids']")).click();
		driver.findElement(By.xpath("//input[@name='extend']")).click();
		actionHandler.waitForSomeTime(3000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[text()='Product']//ancestor::tbody[1]//child::tbody/tr/td//input"));
		for(int i=0;i<elements.size();i++) {
			if(i==0)
				elements.get(i).click();
			else if(i==1) {
				elements.get(i).clear();
				elements.get(i).sendKeys("2");
			}
			
			else if(i==2) {
				elements.get(i).clear();
				elements.get(i).sendKeys("30");
			}
				
		}
		
		try {
			driver.findElement(By.xpath("//input[@value='Extend and Submit for Approval']")).click();;;;
			actionHandler.waitForSomeTime(15000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QuotePageObjects.QuoteSubmitForApprovalButton.click();
		System.out.println("Quote line items are extended");
	}

}
