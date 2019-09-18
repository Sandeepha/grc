package com.sc.testrunner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.config.GlobalProperties;
import com.framework.config.PropertiesRepository;
import com.framework.cucumber.helper.TestNGRunnerHelper;
import com.framework.reports.CucumberReports;
import com.sc.constants.SCconstants;

import cucumber.helper.Data;

public class TestNGTestRunner {
	private static Logger logger = LogManager.getLogger(TestNGTestRunner.class);

	static {
		try {
			PropertiesRepository.loadAllProperties();
		} catch (Exception e) {
			logger.error("Unable to load properties files", e);
		}
	}

	@Parameters({ "browser", "suitename", "environment" })
	@BeforeSuite
	public void setUp(String browserType, String suiteName, String environment) {
		GlobalProperties.BrowserType = browserType;
		GlobalProperties.SuiteName = suiteName;
		GlobalProperties.Environment = environment;

	}

	@Test(dataProvider = SCconstants.dataProviderMethod, dataProviderClass = Data.class)
	public void runFeatures(String feature, String tag, String status)

	{
		if (feature != null && SCconstants.executionStatus.equals(status)) {
			TestNGRunnerHelper.runTestNG(feature, tag);
		}
	}

	@AfterSuite
	public void generateReport() {
		CucumberReports.generateCucumberReport(GlobalProperties.SuiteName);
	}

}
