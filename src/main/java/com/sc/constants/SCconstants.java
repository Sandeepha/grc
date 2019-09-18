package com.sc.constants;

import com.framework.config.PropertiesRepository;

public class SCconstants {
	public static final String ScreenShotPath = System.getProperty("user.dir")
			+ PropertiesRepository.getString("screenshot.path");
	public static final String featureSheetName = "Features";
	public static final String dataProviderMethod = "featureList";
	public static final String executionStatus = "Y";
	public static final String imageType = "image/png";
	
}
