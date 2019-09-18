package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPageObjects {

	@FindBy(xpath = "//h1[contains(@class,'pageType noSecondHeader')][contains(text(),'Reports & Dashboards')]")
	public static  WebElement reportsAndDashBoardsHeader;
	
	@FindBy(xpath="//a[contains(@title,'Reports Tab')]")
	public static WebElement reportsTab;
	
	@FindBy(xpath="//input[@title='New Report...']")
	public static WebElement newReportBtn;
	
	@FindBy(xpath="//input[@id='quickFindInput']")
	public static WebElement quickFindSearch;	
	
	@FindBy(xpath="//span[text()='Opportunities']")
	public static  WebElement opportunitiesFieldLabel; //get(1)	
	
	@FindBy(xpath="//input[@value='Create' and @class='btn']")
	public static WebElement createBtn;   //Wait for page to load
	
	@FindBy(xpath="//span[text()='GSA Sale']")
	public static WebElement gsaSaleFieldLabel;
	
	@FindBy(xpath="//div[@id='gridViewScrollpreviewPanelGrid']")
	public static WebElement gridViewScrollpreviewPanelGrid;	
	
	@FindBy(xpath="//div[@id='gridViewHeaderpreviewPanelGrid']//a[@class='x-grid3-hd-btn']/..")
	public static List <WebElement> totalFeildsInHeader;
	
	@FindBy(xpath="//div[@id='gridViewHeaderpreviewPanelGrid']")
	public static WebElement gridViewHeaderpreviewPanelGrid;
	
	
	
	
	
	
	
	

}
