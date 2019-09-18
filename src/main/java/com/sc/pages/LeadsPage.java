package com.sc.pages;

import org.openqa.selenium.WebDriver;
import com.framework.asserts.AssertionHandler;
import com.sc.objects.repository.LeadsPageObjects;


public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver webDriver) {
		super(webDriver);

	}

	public void clickOnLeadsTab() {
		elementHandler.clickElement(LeadsPageObjects.leadsTab);
		elementHandler.clickElement(LeadsPageObjects.createNewLeadBtn);
		System.out.println("Leads tab is clicked");
	}

	public void clickOnContinueBtn() {
		elementHandler.clickElement(LeadsPageObjects.continueBtn);
	}

	public void clickOnDropDownList() {
		javaScriptHandler.scrollIntoView(LeadsPageObjects.selectOrganisationType);
		elementHandler.clickElement(LeadsPageObjects.selectOrganisationType);
		System.out.println("Clicked on Organisation Type drop down list");
		actionHandler.waitForSomeTime(2000);

	}

	public void selectRecordType(String leadRecordType) {

		elementHandler.selectByVisibleText(LeadsPageObjects.selectLeadecordType, leadRecordType);
		System.out.println("The selected Lead Record Type: "+leadRecordType);

	}

	public void verifyTheFields() {
		String text1 = elementHandler.getTextFromAttribute(LeadsPageObjects.corporateManufacturingField, "value");
		AssertionHandler.verifyEquals(text1, "Corporate - Manufacturing");
		System.out.println("Corporate - Manufacturing is there in the OrganisationTypeDropDown List ");
		String text2 = elementHandler.getTextFromAttribute(LeadsPageObjects.corporateRetailField, "value");
		AssertionHandler.verifyEquals(text2, "Corporate - Retail");
		System.out.println("Corporate - Retail is there in the OrganisationTypeDropDown List ");
		String text3 = elementHandler.getTextFromAttribute(LeadsPageObjects.individualInvestorField, "value");
		AssertionHandler.verifyEquals(text3, "Individual Investor");
		System.out.println("Individual Investor is there in the OrganisationTypeDropDown List ");
		String text4 = elementHandler.getTextFromAttribute(LeadsPageObjects.corporateTechnologyField, "value");
		AssertionHandler.verifyEquals(text4, "Corporate - Technology");
		System.out.println("Corporate – Technology is there in the OrganisationTypeDropDown List ");

	}

}
