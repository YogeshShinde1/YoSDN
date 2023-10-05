package com.DemoBlaze.base;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void set_Up() throws IOException {
		
		Properties prop=ReadConfigProp.readConfig();
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))		
			driver=new ChromeDriver();
			if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))		
				driver=new FirefoxDriver();
			if(prop.getProperty("browser").equalsIgnoreCase("MSEdge"))		
				driver=new EdgeDriver();
		driver.get(ReadConfigProp.readURL());
		driver.manage().window().maximize();	
	}
	
	@AfterClass
	public void tear_Down() {
		driver.close();
	}

}