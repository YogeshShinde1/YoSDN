package com.DemoBlaze.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProp {
	
	public static Properties prop;
	static FileInputStream fis;
	static String propertiesPath=System.getProperty("user.dir")+"//Configuration//Config.properties";
	
	public static Properties readConfig() throws IOException {
		prop=new Properties();
		fis=new FileInputStream(propertiesPath);
		prop.load(fis);
		return prop;
	}

	public static String readURL() throws IOException {
		readConfig();
		String url = prop.getProperty("url");
		return url;
	}

	public static String readTitle() {
		String titleIndex = prop.getProperty("titleOfIndex");
		return titleIndex;
	}	
}