package com.sc.objects.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPageObjects {

	@FindBy(xpath="//option[@value='Corporate - Manufacturing']")
	public static WebElement corporateManufacturingField;
	
	@FindBy(xpath="//option[@value='Corporate - Retail']")
	public static WebElement corporateRetailField;

	@FindBy(xpath = "//a[text()='Leads']")
	public static WebElement leadsTab;

	@FindBy(xpath = "//input[@value=' New ' and @name='new']")
	public static WebElement createNewLeadBtn;

	@FindBy(xpath = "//div[contains(@class,'requiredInput')]//select")
	public static WebElement selectLeadecordType;

	@FindBy(xpath = "//input[@value='Continue' and @title='Continue']")
	public static WebElement continueBtn;
	
	@FindBy(xpath = "//input[@id='name_firstlea2']")
	public static WebElement firstNameInput;
	
	@FindBy(xpath = "//input[@id='name_lastlea2']")
	public static WebElement lastNameInput;
	
	@FindBy(xpath = "//input[@id='lea3']")
	public static WebElement companyInput;
	
	@FindBy(xpath = "//label[text()='Organisation Type']/../../..//td[2]//select")
	public static WebElement selectOrganisationType;

	@FindBy(xpath = "//option[@value='Corporate - Technology']")
	public static WebElement corporateTechnologyField;

	@FindBy(xpath = "//option[@value='Individual Investor']")
	public static WebElement individualInvestorField;
	
	
	
	
	
	
	
	
	
	

}
