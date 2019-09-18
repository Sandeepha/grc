package com.sc.pages;

import org.openqa.selenium.WebDriver;

import com.framework.utils.ExcelUtils;
import com.sc.objects.repository.ProductsPageObjects;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void AddProducts()
	{
		String Noofproducts = ExcelUtils.getDataByColumnName("Products", "NoOfProducts");
		int noofproducts = Integer.parseInt(Noofproducts);
		System.out.println("No of Products = " +noofproducts);
		for(int i = 2; i<= noofproducts+1; i++)
		{
		String product = ExcelUtils.getDataByColumnNameWithRowIndex("Products", "GRC Product", i);
		System.out.println("Adding product: " +product);
		elementHandler.writeText(ProductsPageObjects.ProductKeywordTextBox, product);
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(ProductsPageObjects.ProductSearchButton);
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(ProductsPageObjects.FirstProductselectionbox, ProductsPageObjects.PrductselectButtn);
		elementHandler.clickElement(ProductsPageObjects.PrductselectButtn, ProductsPageObjects.ProductQuantitytab);
		String Productquantity = ExcelUtils.getDataByColumnNameWithRowIndex("Products", "Product Quantity", i);
		String ProductUnitPrice = ExcelUtils.getDataByColumnNameWithRowIndex("Products", "Product NetPrice", i);
		elementHandler.writeText(ProductsPageObjects.ProductQuantitytab, Productquantity, ProductsPageObjects.ProductNewpricetab);
		elementHandler.writeText(ProductsPageObjects.ProductNewpricetab, ProductUnitPrice, ProductsPageObjects.Productsavebutton);
		if(i<noofproducts+1)
		{
		elementHandler.clickElement(ProductsPageObjects.ProductSaveandMorebutton);
		elementHandler.waitForPageToLoad();
		}
		else
		{
			elementHandler.clickElement(ProductsPageObjects.Productsavebutton);
			elementHandler.waitForPageToLoad();
		}
		
		
	}
	

}
}
