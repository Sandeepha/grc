package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotePageObjects {
	@FindBy(xpath = "//h2[@class='pageDescription'][contains(text(),'New Quote')]")
	public static WebElement QuotePageHeader;
	
	@FindBy(xpath = "//h3[contains(text(),'Quote Detail')]/../following-sibling::div//table//tr[4]//td[2]//div//span//select")
	public static WebElement QuotePageContractType;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[contains(@title,'Save')]")
	public static WebElement QuotesaveButton;
	
	@FindBy(xpath = "//h3[contains(text(),'Quote Information')]/../following-sibling::div//table//tbody//tr[8]//td[2]//textarea")
	public static WebElement QuotePageJustification;
	
	@FindBy(xpath = "//div[@id='ep']//div[4]//table[1]//tbody[1]//tr[3]//td[2]")
	public static WebElement quotename;
	
	@FindBy(xpath = "//div[@id='ep']//div[4]//table[1]//tbody[1]//tr[1]//td[2]//a")
	public static WebElement QuoteAccountName;
	
	@FindBy(xpath = "//div[@id='ep']//div[4]//table[1]//tbody[1]//tr[2]//td[2]//a")
	public static WebElement QuoteptyName;
	
	@FindBy(xpath = "//div[@id='ep']//div[4]//table[1]//tbody[1]//tr[5]//td[4]")
	public static WebElement QuoteStatus;
	
	@FindBy(xpath = "//div[@id='ep']//div[4]//table[1]//tbody[1]//tr[6]//td[2]")
	public static WebElement QuoteContractType;
	
	@FindBy(xpath = "//div[@id='ep']//div[4]//table[1]//tbody[1]//tr[4]//td[2]")
	public static WebElement QuoteNumber;
	
	@FindBy(xpath = "//h1[text()='Quote']")
	public static WebElement QuotePageHeaderCreated;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Submit For Approval']")
	public static WebElement QuoteSubmitForApproval;
	
	@FindBy(xpath = "//input[@value='Submit for Approval']")
	public static WebElement QuoteSubmitForApprovalButton;

	@FindBy(xpath = "//td[text()='Quote Status']/../td[4]")
	public static WebElement quoteStatusField;

	@FindBy(xpath = "//th[text()='Actual Approver']/../../tr[3]/td[4]/a")
	public static WebElement GamApprovarName;

	@FindBy(xpath = "//label[text()='Contact Name']/../../td[4]//div/span/input")
	public static WebElement contactNameFieldData;
	
	@FindBy(xpath = "//label[text()='Billing Contact']/../../td[4]//div/span/input")
	public static WebElement billingContactFieldData;

	@FindBy(xpath = "//div[@class='pbError']")
	public static WebElement errorMsgWhenSaveQuote;

	@FindBy(xpath="//td[text()='Opportunity Name']/../td[2]/a")
	public static WebElement optyName;

	@FindBy(xpath="//h3[text()='Quote Detail']/..//img")
	public static WebElement showQuoteDetailImg;

	@FindBy(xpath="//td[@id='topButtonRow']//input[@value=' Edit ']")
	public static WebElement editQuoteBtn;
	
	@FindBy(xpath="//a[text()='Quotes']")
	public static WebElement quoteBtn;
	
	@FindBy(xpath="//table[@class='list']//child::tr[2]/th/a")
	public static WebElement quoteName;

	@FindBy(xpath="//span[text()='Customer Admin Activities']")
	public static WebElement customerAdminActivities;

	@FindBy(xpath="//a[text()='Edit']")
	public static List<WebElement> editBtn;

	@FindBy(xpath="//option[text()='Approved']")
	public static WebElement selectApprovedDropdown;
	
	@FindBy(xpath="//input[@value=' Save ']")
	public static WebElement saveBtn;

	@FindBy(xpath="//td[text()='GRC Approval']//parent::tr//th/a")
	public static WebElement activityIDCA;

	@FindBy(xpath="//td[text()='Owner']//parent::tr//td[2]//a[text()='[Change]']")
	public static WebElement changeBtn;

	@FindBy(xpath="//input[@id='newOwn']")
	public static WebElement changeOwnerName;

	@FindBy(xpath="//input[@id='newOwn']//parent::span//a")	
	public static WebElement searchBtn;
	
	
	@FindBy(xpath="//tr[@class='headerRow']//parent::tbody//a")
	public static WebElement selectOwnerName;

	@FindBy(xpath="//input[@name='send_with_docusign']")
	public static WebElement sendWithDocSignBtn;
	
	@FindBy(xpath="//a[text()='Add Recipient']")
	public static WebElement addRecipientBtn;
	
	@FindBy(xpath="//a[text()='Quick Add']")
	public static WebElement quickAddField;

	@FindBy(xpath="//label[text()='Name']//following-sibling::input[1]")
	public static WebElement addRecipientName;

	@FindBy(xpath="//input[@id='quick-add-email']")
	public static WebElement emailAddress;

	@FindBy(xpath="//a[text()='Save Recipient']")
	public static WebElement saveRecipientBtn;

	@FindBy(xpath="//a[text()='Next']")
	public static WebElement nextBtn;

	@FindBy(xpath="//td[text()='Quote Name']//following-sibling::td[1]")
	public static WebElement freeTrialQuotename;

	@FindBy(xpath="//td[text()='Quote Number']//following-sibling::td[1]")
	public static WebElement freeTrialQuoteNumber;

	@FindBy(xpath="//div[@id='Quote_body']//child::tr[2]/th/a")
	public static WebElement QuoteBtnLatest;

	@FindBy(xpath="//span[text()='Customer Admin Activities']")
	public static WebElement customeAdminActities;

	@FindBy(xpath="//th[text()='Action']//parent::tr//following-sibling::tr//a[text()='Edit']")
	public static WebElement editInCAA;

	@FindBy(xpath="//label[text()='Status']//parent::span//parent::td//following-sibling::td//select")
	public static WebElement QuoteStatusLatest;
	
	
	
	
	
	
	
	
	

}
