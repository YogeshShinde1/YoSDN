package com.DemoBlaze.utilities;

import org.openqa.selenium.WebElement;
import com.DemoBlaze.base.TestBase;

public class Utility extends TestBase{

	public static String title() {
		String title=driver.getTitle();
		return title;
	}
	
	public static String uRL() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public static String sendText(WebElement element, String string) {
		element.sendKeys(string);
		return "";
	}
	
	public static boolean displayedOrNot(WebElement element) {
		boolean flag=element.isDisplayed();
		return flag;
	}
	
	
	
}
