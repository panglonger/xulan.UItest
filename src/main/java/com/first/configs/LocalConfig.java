package com.first.configs;

import com.first.utils.PropertiesUtils;

public class LocalConfig {
	
	static PropertiesUtils propertiesUtils= new PropertiesUtils("local.properties");
	
	public static final String URL = propertiesUtils.getPropertieValue("url");
	public static final String CHROME_PATH = propertiesUtils.getPropertieValue("chromeDriverPath");
	public static final String FIREFOX_PATH= propertiesUtils.getPropertieValue("fireDriverPath");
	public static final String IE_PATH = propertiesUtils.getPropertieValue("ieDriverPath");
	public static final String SCREENSHOTPATH = propertiesUtils.getPropertieValue("shotPath");




}
