package com.MyStore.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	//create property file object
	Properties properties;
	String path="../MAVEN_PROJECT/Configuration/config.properties";
	
	public ReadConfig()
	{
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		}
		catch(Exception e) {
			
		}
	}

	public String getBaseUrl() {
		String value = properties.getProperty("BaseUrl");
		//To check value is null or not
		if(value!=null)
		return value;
		else throw new RuntimeException("Url is not Specifies in config file");
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("Browser");
		if(value!=null)
			return value;
		else new RuntimeException("Url is not specified config file");
		return value;
	}

	
}
