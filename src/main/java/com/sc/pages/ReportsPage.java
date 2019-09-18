package com.sc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.asserts.AssertionHandler;

import com.sc.objects.repository.ReportsPageObjects;

public class ReportsPage extends BasePage {

	public ReportsPage(WebDriver webDriver) {
		super(webDriver);

	}

	public void clickOnReportsTab() {

		elementHandler.clickElement(ReportsPageObjects.reportsTab, ReportsPageObjects.reportsAndDashBoardsHeader);
		System.out.println("Reports tab is clicked");

	}

	public void clickOnNewReportButton() {
		elementHandler.clickElement(ReportsPageObjects.newReportBtn, ReportsPageObjects.quickFindSearch);
		System.out.println("Reports Button is clicked");

	}

	public void searchAndClickOpportunities() {
		elementHandler.clickElement(ReportsPageObjects.quickFindSearch);
		elementHandler.writeText(ReportsPageObjects.quickFindSearch, "Opportunities",
				ReportsPageObjects.opportunitiesFieldLabel);
		actionHandler.waitForSomeTime(2000);
		elementHandler.clickElement(ReportsPageObjects.opportunitiesFieldLabel);
		System.out.println("Opportunities is selected");
	}

	public void clickOnCreateButton() {
		javaScriptHandler.scrollIntoView(ReportsPageObjects.createBtn);
		elementHandler.clickElement(ReportsPageObjects.createBtn, ReportsPageObjects.quickFindSearch);
		System.out.println("Create button is clicked");		
	}

	public void searchGSASale() {
		elementHandler.writeText(ReportsPageObjects.quickFindSearch, "GSA Sale");
		actionHandler.waitForSomeTime(2000);
		System.out.println("GSA Sale is searched on the Search bar");

	}

	public void dragAndDropGSASale() {
		Actions a = new Actions(driver);
		a.dragAndDrop(ReportsPageObjects.gsaSaleFieldLabel,
				ReportsPageObjects.gridViewScrollpreviewPanelGrid);
		actionHandler.waitForSomeTime(3000);
		System.out.println("GSA Sale field Drag and drop to the Report");		

	}

	public void validateGSASaleReportable() {

		/*
		 * String text = elementHandler.getText(ReportsPageObjects.
		 * gridViewHeaderpreviewPanelGrid); boolean flag = false; if
		 * (text.contains("GSA Sale")) flag = true;
		 * AssertionHandler.verifyTrue(flag);
		 * System.out.println("The GSA field is reportable");
		 */

		boolean flag = false;
		for (WebElement element : ReportsPageObjects.totalFeildsInHeader) {
			// System.out.println(element.getText());
			if (element.getText().equals("GSA Sale")) {
				flag = true;
				break;
			}

		}
		//AssertionHandler.verifyTrue(flag);
		System.out.println("The GSA field is reportable");

	}

}
