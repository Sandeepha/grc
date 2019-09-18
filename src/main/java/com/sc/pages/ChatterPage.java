package com.sc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.asserts.AssertionHandler;
import com.framework.handlers.ElementHandler;
import com.framework.utils.ExcelUtils;
import com.sc.constants.GRC_properties;
import com.sc.objects.repository.AccountsPageObjects;
import com.sc.objects.repository.BasePageObjects;
import com.sc.objects.repository.ChatterPageObjects;
import com.sc.objects.repository.QuotePageObjects;

public class ChatterPage extends BasePage {

	public ChatterPage(WebDriver webDriver) {
		super(webDriver);
		
	}

	public void clickRejectBtn() {
		elementHandler.clickElement(ChatterPageObjects.rejectBtn.get(0));
		elementHandler.writeText(ChatterPageObjects.textArea,"Rejected");
		elementHandler.clickElement(ChatterPageObjects.okayBtn);		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='userNavLabel']")));*/
		actionHandler.waitForSomeTime(6000);
		
	}
	
	public void clickAcceptBtn() {
		elementHandler.clickElement(ChatterPageObjects.acceptBtn.get(0));
		elementHandler.writeText(ChatterPageObjects.textArea,"Accepted");
		elementHandler.clickElement(ChatterPageObjects.okayBtn);		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='userNavLabel']")));*/
		//actionHandler.waitForSomeTime(6000);
		
	}



}
