package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPageObjects {

	@FindBy(id = "opp4")
	public static WebElement OpptyAccuntName;

	@FindBy(id = "opp3")
	public static WebElement OptyName;

	@FindBy(id = "00N40000001MfKZ")
	public static WebElement OptyType;

	@FindBy(id = "opp9")
	public static WebElement Optyclosedate;

	@FindBy(id = "opp11")
	public static WebElement OptyStage;

	@FindBy(id = "opp16")
	public static WebElement OptyCurrency;

	@FindBy(xpath = "//label[contains(text(),'Win/Loss Reason')]/following::td[1]/span/span/select")
	public static WebElement OptyWinLossReason;

	@FindBy(xpath = "//label[contains(text(),'Win/Loss Commentary')]/following::td[1]/textarea")
	public static WebElement OptyWinlosscomment;

	@FindBy(xpath = "//label[contains(text(),'Competitors')]/following::td[1]/table/tbody/tr[@class='multiSelectPicklistRow']/td/span[1]/select[@multiple='multiple']/optgroup[@label='Available']//option[@value='1']")
	public static WebElement OptyWinLossCompetitors;

	@FindBy(xpath = "//label[contains(text(),'Competitors')]/following::td[1]/table/tbody/tr[@class='multiSelectPicklistRow']/td/span[1]/select[@multiple='multiple']/optgroup[@label='Chosen']/following-sibling::option[@value='1']")
	public static WebElement OptyWinLossCompetitorsChosen;

	@FindBy(xpath = "//h3[contains(text(),'Win/Loss Information')]/../following-sibling::div[1][@class='pbSubsection']//tr[2]//td[2][@class='multiSelectPicklistCell']/a[1]//img[1][contains(@class,'picklistArrowRight')]")
	public static WebElement OptyWinLossCompetitorsAdd;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
	public static WebElement OptyTopSavebuton;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	public static WebElement OptyBottomSaveButton;

	@FindBy(id = "opp3_ileinner")
	public static WebElement Optynameafteroptycreated;

	@FindBy(id = "opp4_ileinner")
	public static WebElement AccuntNameafteroptycreated;

	@FindBy(xpath = "//span[contains(text(), 'GTM Recurring')]")
	public static WebElement OptyRevenueGTMReccurringfeild;

	@FindBy(xpath = "//span[contains(text(), 'GTM One Time')]")
	public static WebElement OptyRevenueGTMOneTimeFeild;

	@FindBy(xpath = "//span[contains(text(), 'Monthly Recurring')]")
	public static WebElement OptyRevenueMonthlyRecurringfeild;

	@FindBy(xpath = "//td[contains(text(),'FXall Flag')]/..//td[@class='dataCol col02 inlineEditLock']//div")
	public static WebElement OptyFXALLFlag;

	@FindBy(id = "calMonthPicker")
	public static WebElement OptyClosedateCalmonth;

	@FindBy(id = "calYearPicker")
	public static WebElement OptyClosedateCalyear;

	@FindBy(xpath = "//h1[@class='pageType'][contains(text(),'Opportunity')]")
	public static WebElement OptyPageHeader;

	@FindBy(xpath = "//h2[@class='pageDescription']")
	public static WebElement OptyPageheadername;

	@FindBy(xpath = "//span[@class='listTitle'][contains(text(),'Products (Standard Price Book)')]")
	public static WebElement OptyProductsstandardPricebookrelatedtab;

	@FindBy(xpath = "//span[@class='listTitle'][contains(text(),'Products (GRC Pricebook)')]")
	public static WebElement OptyProductsGRCPricebookrelatedtab;

	@FindBy(xpath = "//td[@class='pbButton']//input[@title='Add Product']")
	public static WebElement OptypageAddProductButton;

	@FindBy(xpath = "//div[contains(@class,'listRelatedObject opportunityLineItemBlock')]//div[contains(@class,'bPageBlock brandSecondaryBrd secondaryPalette')]//div[@class='pbBody']//table//tbody//tr//th[contains(text(),'No records to display')]")
	public static WebElement OptyPrductNorecordstodisplay;

	// @FindBy(xpath = "//input[contains(@title,'Add Product')]")
	@FindBy(xpath = "//div[contains(@class,'listRelatedObject opportunityLineItemBlock')]//div[contains(@class,'bPageBlock brandSecondaryBrd secondaryPalette')]//input[contains(@title,'Add Product')]")
	public static WebElement AddProductButtn;

	@FindBy(xpath = "//div[contains(@class,'listRelatedObject opportunityLineItemBlock')]//div[contains(@class,'bPageBlock brandSecondaryBrd secondaryPalette')]//div[@class='pbBody']//table//tbody//tr//th[@class=' dataCell  ']//a")
	public static List<WebElement> PrductsfromOptypage;

	@FindBy(xpath = "//input[@title='Choose Price Book']")
	public static WebElement ChoosePricebookbutton;

	@FindBy(xpath = "//h1[@class='pageType'][contains(text(),'Choose Price Book for')]")
	public static WebElement Pricebookpageheader;

	@FindBy(id = "p1")
	public static WebElement selectPriceBook;

	@FindBy(xpath = "//input[@title='Save']")
	public static WebElement Pricebooksavebutton;

	@FindBy(xpath = "//div[@id='00N40000003NOb1_ileinner']//img[@id='00N40000003NOb1_chkbox']")
	public static WebElement GRCOptycheckbx;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[contains(@title,'Edit')]")
	public static WebElement OptyPageEditButton;

	@FindBy(xpath = "//span[contains(@class,'listTitle')][contains(text(),'Quotes')]")
	public static WebElement OptyPageQuotestab;

	@FindBy(xpath = "//input[contains(@title,'New Quote')]")
	public static WebElement OptyPageNewquotebutton;

	@FindBy(xpath = "//span[contains(@class,'listTitle')][contains(text(),'Contact Roles')]")
	public static WebElement OptyPageContactRoles;

	@FindBy(xpath = "//td[contains(@class,'pbButton')]//input[contains(@title,'New Contact Roles')]")
	public static WebElement OtyNewcontactRolebutton;

	@FindBy(xpath = "//tr[contains(@class,'last detailRow')]//tr[1]//th[contains(text(),'Primary')]")
	public static WebElement PrimaryheaderinContactRoles;

	@FindBy(xpath = "//h3[contains(text(),'Contact Roles')]/../../../../../..//div[2]//tr[2]//th//a")
	public static WebElement contactRoleContactNameOptyPage;

	@FindBy(id = "contact0")
	public static WebElement PrimaryContactTextBox;

	@FindBy(id = "primary0")
	public static WebElement PrimaryContactRadioButton;

	@FindBy(id = "role0")
	public static WebElement PrimaryContactRoleDropdown;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[contains(@title,'Save')]")
	public static WebElement PrimaryContactSaveButton;

	@FindBy(xpath = "//tr[4]//td[2]//span//a[contains(@title,'Contact Lookup (New Window)')]//img")
	public static WebElement PrimaryContactLookupButton;

	@FindBy(xpath = "//span[contains(@class,'listTitle')][contains(text(),'Contact Roles')]//span")
	public static WebElement optyPageContactRolescount;

	@FindBy(xpath = "//h3[text()='Quotes']/../../../../../following-sibling::div/table/tbody/tr[2]/th/a")
	public static WebElement optyPageQuotesTab;

	@FindBy(xpath = "//span[text() = 'Products (GRC Pricebook)']")
	public static WebElement grcPricebook;

	@FindBy(xpath = "//span[text()='Products (Standard Price Book)']")
	public static WebElement standardPriceBook;

	@FindBy(xpath = "//span[text()='GRC Opportunity'] /../../td[2]/div/img")
	public static WebElement grcOpportunityflag;

	@FindBy(xpath = "//span[text()='Partners and Distribution']")
	public static WebElement partnersandDistributionLabel;

	@FindBy(xpath = "//span[text()='Partner Engagement Type']")
	public static WebElement partnerEngagementTypeLabel;

	@FindBy(xpath = "//span[text()='GSA Sale']")
	public static WebElement gsaSaleLabel;

	@FindBy(xpath = "//span[text()='Quotes']")
	public static WebElement quotesField;

	@FindBy(xpath = "//input[@value='New Quote']")
	public static WebElement newQuoteField;

	@FindBy(xpath = "//span[text()='Close Date'] /../../td[4]/div")
	public static WebElement closedDate;

	@FindBy(xpath = "//span[text()='GSA Sale']/../..//td[4]/div/img[@class='checkImg']")
	public static WebElement gsaSaleLabelCheckBox;

	@FindBy(xpath = "//span[text()='GSA Sale']/img")
	public static WebElement gsaSaleImage;

	@FindBy(xpath = "//div[text()='This box should be checked if the Opportunity was made by a member of the General Services Administration.']")
	public static WebElement gsaSaleImageText;

	@FindBy(xpath = "//span[@class='helpButton']")
	public static List<WebElement> helpButtons;

	@FindBy(xpath = "//span[text()='GSA Sale']/../../td[4]/div[2]/input")
	public static WebElement gsaSaleCheckBox;

	@FindBy(xpath = "//span[text()='GSA Sale']/../..//td[4]/div")
	public static WebElement gsaSaleBar;

	@FindBy(xpath = "//span[text()='GRC Opportunity']/../../td[2]/div[2]/input")
	public static WebElement grcOpportunityCheckBox;

	@FindBy(xpath = "//span[text()='Organisation Type']/../../td[4]/div")
	public static WebElement organisationTypeDropDown;

	@FindBy(xpath = "//td[text()='Organisation Type']/../td[2]/div/span/select/option")
	public static List<WebElement> organisationTypeDropDownText;

	@FindBy(xpath = "//td[text()='Organisation Type']/../td[2]/div/span/select//option[@value='Corporate - Manufacturing']")
	public static WebElement corporateManufacturingField;

	@FindBy(xpath = "//td[text()='Organisation Type']/../td[2]/div/span/select//option[@value='Corporate - Retail']")
	public static WebElement corporateRetailField;

	@FindBy(xpath = "//td[text()='Organisation Type']/../td[2]/div/span/select//option[@value='Individual Investor']")
	public static WebElement individualInvestorField;

	@FindBy(xpath = "//td[text()='Organisation Type']/../td[2]/div/span/select//option[@value='Corporate - Technology']")
	public static WebElement corporateTechnologyField;

	@FindBy(xpath = "//li[@id='Opportunity_Tab']//a[contains(text(),'Opportunities')]")
	public static WebElement opportunitiesTab;

	@FindBy(xpath = "//input[@id='phSearchInput']")
	public static WebElement globalSearch;

	@FindBy(xpath = "//input[@id='phSearchButton']")
	public static WebElement globalSearchBtn;

	@FindBy(xpath = "//a[text()='Edit']")
	public static WebElement editOpty;

	@FindBy(xpath = "//label[text()='Opportunity Currency']/../..//select")
	public static WebElement dropdownOptyCurrency;

	@FindBy(xpath = "//a[text()='Monthly Recurring']/../../../tr[2]/td[4]")
	public static WebElement monthlyRecurringFieldData;

	@FindBy(xpath = "//input[@value=' New ']")
	public static WebElement newOptyCreationBtn;

	@FindBy(xpath = "//input[@value='Continue']")
	public static WebElement continueBtn;

	@FindBy(xpath = "//div[contains(@id,'errorDiv')]")
	public static WebElement erorMsgCurrency;

	@FindBy(xpath = "//div[@class='listHoverLinks']//a[1]/span")
	public static WebElement productsLinkOptyPageLayout;

	@FindBy(xpath = "//input[@value='Add Product']")
	public static WebElement addProductBtnInOptyPageLayout;

	@FindBy(xpath = "//div[@class='content']//h2")
	public static WebElement getOptyNameFromOptyPageLayout;

	@FindBy(xpath = "//span[text()='Contact Roles']")
	public static WebElement contactRolesLink;

	@FindBy(xpath = "//input[@value=' New ']")
	public static WebElement newContactRoleBtn;

	@FindBy(xpath = "//span[text()='Active Quote Ind']/../../td[2]//img[@title='Checked']")
	public static WebElement activeQuoteIndInOptyPage;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[2]")	
	public static WebElement stopStartSyncBtn;

	@FindBy(xpath = "//span[text()='Associated Opportunity']")
	public static WebElement associatedOpportunityField;

	@FindBy(xpath = "//input[@title='Genesis/GRC Trial Opportunity']")
	public static WebElement GRCTrialOptyBtn;

	@FindBy(xpath = "//input[@title='Submit to fulfilment']")
	public static WebElement submitForFullfillmentBtn;

	@FindBy(xpath = "//td[text()='Quote Status']//following-sibling::td[1]")
	public static WebElement quoteStatusField;
	

	

}
