package com.sc.objects.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPageObjects {
	@FindBy(xpath = "//h1[@class='pageType'][contains(text(),'Product Selection for')]")
	public static WebElement ProductSelectinpageheader;
	
	@FindBy(xpath = "//input[@id='search']")
	public static WebElement ProductKeywordTextBox;
	
	@FindBy(id = "save_filter_PricebookEntry")
	public static WebElement ProductSearchButton;
	
	@FindBy(xpath = "//div[@class='x-grid3-body']//div[1]//tr[1]//td[1]//div[@class='x-grid3-cell-inner x-grid3-col-checkbox']//input")
	public static WebElement FirstProductselectionbox;
	
	@FindBy(xpath = "//input[@title='Select']")
	public static WebElement PrductselectButtn;
	
	@FindBy(xpath = "//tr[contains(@valign,'top')]//td[2]//input")
	public static WebElement ProductQuantitytab;
	
	@FindBy(xpath = "//tr[contains(@valign,'top')]//td[4]//input")
	public static WebElement ProductNewpricetab;
	
	@FindBy(xpath = "//tr[7]//td[1]//input[@title='Save']")
	public static WebElement Productsavebutton;
	
	@FindBy(xpath = "//tr[7]//td[1]//input[@title='Save & More']")
	public static WebElement ProductSaveandMorebutton;
	
	@FindBy(xpath = "//div[@title='Product Name']")
	public static WebElement productNameHeader;
	

}
