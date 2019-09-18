package com.sc.objects.repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicPageObjects {
WebDriver driver;
	
	public DynamicPageObjects(WebDriver webDriver) {
		driver = webDriver;
	}
	
	public  WebElement dynamicElement(String xpathExpression, String substituteValue) {
		xpathExpression = xpathExpression.replace("#", substituteValue);
		return driver.findElement(By.xpath(xpathExpression));
	}

	public  List<WebElement> dynamicElementList(String xpathExpression, String substituteValue) {
		xpathExpression = xpathExpression.replace("#", substituteValue);
		return driver.findElements(By.xpath(xpathExpression));
	}	


}
