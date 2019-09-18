package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BasePageObjects {
	
	@FindBy(id = "username")
	public static WebElement loginUsername;
	
	@FindBy(id = "password")
	public static WebElement loginPassword;
	
	@FindBy(id= "Login")
	public static WebElement loginButton;
	
    @FindBy(xpath = "//a[@title='Home Tab - Selected']")
    public static WebElement HomeTab;
    
    @FindBy(id = "phSearchInput")
    public static WebElement GlobalSearchBox;
    
    @FindBy(id = "userNavLabel")
    public static WebElement UserNavLabel;
    
    @FindBy(id = "phSearchButton")
    public static WebElement SearchButton;
    
    @FindBy(id = "secondSearchText")
    public static WebElement textBoxSecondSearchText;
    
    @FindBy(xpath = "//span[@class='truncate'][contains(text(),'People')]")
    public static WebElement lnkPeople;
    
    @FindBy(xpath = "//div[@id='User_body']/table/tbody/tr[2]//div[@class='displayName']/a")
    public static WebElement lnkProfileUser;
    
    @FindBy(id = "moderatorMutton")
    public static WebElement userActionmenu;
    
    @FindBy(id = "USER_DETAIL")
    public static WebElement Userdetails;
    
    @FindBy(xpath = "//td[@class='pbButton']//input[@title='Login']")
    public static WebElement Userlogin;
    
    @FindBy(xpath ="//div[@class='content']/span/h1/a")
    public static WebElement lblProfileUser;
    
    @FindBy(id = "userNav-arrow")
    public static WebElement Usenavarrow;
    
    @FindBy(xpath = "//a[@title='Logout']")
    public static WebElement userLogout;
    
    @FindBy(xpath = "//a[@title='Accounts Tab']")
    public static WebElement Navigatetoaccuntstab;
    
    @FindBy(xpath = "//a[@title='Opportunities Tab']")
    public static WebElement NavigatetoOpportunitestab;
    
    @FindBy(xpath = "//td[@id='bodyCell']//h1")
    public static WebElement Accountshometab;
    
	@FindBy(xpath = "//span[@class='truncate'][contains(text(),'Accounts')]")
	public static WebElement linkAccounts;
	
	//@FindBy(xpath = "//div[@id='Account_body']//tr[contains(@class,'dataRow even first')]//th//a")
	@FindBy(xpath = "//div[@id='Account_body']//table//tbody//tr[2]//th//a")
	public static WebElement linkAccountName;
	
	@FindBy(xpath = "//span[contains(@class,'truncate')][contains(text(),'Opportunities')]")
	public static WebElement linkOpportunities;
	
	@FindBy(xpath = "//div[@id='Opportunity_body']//table//tbody//tr[2]//th//a")
	public static WebElement LinkOptyName;
	
	@FindBy(xpath ="//div[@id='Opportunity_body']//table//tbody//tr//td[2]//a")
	public static List<WebElement> OptySearchresultsoptyAccountName;
	
	
	public static String LinkOptyNamesmany ="//div[@id='Opportunity_body']//table//tbody//tr[#]//th//a";
	
	@FindBy(xpath = "//img[contains(@title,'Account Name Lookup (New Window)')]")
	public static WebElement AccountNameLookupicon;
	
	@FindBy(id = "searchFrame")
	public static WebElement AccountLookupsearchframe;
	
	@FindBy(id = "searchFrame")
	public static WebElement ContactLookupsearchframe;
	
	@FindBy(id = "lksrch")
	public static WebElement AccountLookupbox;
	
	@FindBy(id = "lksrch")
	public static WebElement CntactLookupbox;
	
	@FindBy(xpath = "//input[contains(@title,'Go!')]")
	public static WebElement AccountlookupGoButton;
	
	@FindBy(xpath = "//input[contains(@title,'Go!')]")
	public static WebElement ContactlookupGoButton;
	
	@FindBy(id = "resultsFrame")
	public static WebElement AccuntLookuupresultsframe;
	
	@FindBy(id = "resultsFrame")
	public static WebElement ContactLookuupresultsframe;
	
	@FindBy(xpath = "//div[@id='Account_body']/table/tbody/tr[2]/th/a")
	public static WebElement LinkLookupAccount;
	
	@FindBy(xpath = "//div[@id='Contact_body']/table/tbody/tr[2]/th/a")
	public static WebElement LinkLookupContact;
	
	@FindBy(xpath = "//div[contains(@class,'ptBody')]//div//h1[contains(text(), 'Opportunities')]")
	public static WebElement OpportunitiesHomeIcon;

	
	
	
	
}
