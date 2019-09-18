package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPageObjects {


@FindBy(xpath = "//h1[@class='pageType'][contains(text(),'Account')]")
public static WebElement Accountpageheader;

@FindBy(xpath = "//span[contains(text(),'Opportunities')]")
public static WebElement Opportunitiestab;

@FindBy(xpath = "//input[@title='New Sale Opportunity']")
public static WebElement Newsaleopportunitybuton;

@FindBy(xpath = "//h2[@class='pageDescription'][contains(text(),' New Opportunity')]")
public static WebElement NewoportunityPagedescription;

@FindBy(xpath = "//span[contains(text(),'Agreement Type')]/../..//td[2]//div")
public static WebElement ContractInfoAgreementtype;

@FindBy(xpath = "//span[contains(text(),'Agreement Status')]/../..//td[2]//div")
public static WebElement ContractInfoAgreementstatus;

@FindBy(xpath = "//span[contains(text(),'Agreement No.')]/../..//td[2]//div")
public static WebElement ContractAgreementNumber;

@FindBy(xpath = "//td[text()='Organisation Type']//..//select")
public static WebElement selectOrganisationTypeDropdown;

@FindBy(xpath = "//span[text()='Account Classification']/../../td[2]/div")
public static WebElement accountClasificationFieldValue;

@FindBy(xpath = "//span[text()='Organisation Type']")
public static WebElement organisationTypeField;

@FindBy(xpath = "//span[text()='Organisation Type']/../../td[4]/div")
public static WebElement organisationTypeFieldValue;


}
