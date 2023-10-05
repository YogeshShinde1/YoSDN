package com.DemoBlaze.pageClasses;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.DemoBlaze.base.TestBase;
import com.DemoBlaze.utilities.Utility;

public class IndexPage extends TestBase{
	
	@FindBy (xpath="//*[@class=\"navbar-brand\"]//img") WebElement logo;
	@FindBy (xpath="//*[@class=\"navbar-nav ml-auto\"]/li[1]") WebElement homeOption;
	@FindBy (xpath="//*[@class=\"carousel-control-prev\"]") WebElement leftButton;
	@FindBy (xpath="//*[@class=\"carousel-control-next\"]") WebElement rightButton;
	@FindBy (xpath="//*[@data-ride=\"carousel\"]") WebElement carousel;
	@FindBy (xpath="//*[@class=\"carousel-inner\"]/div") WebElement carouselImagesList;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleIndex() {
		return Utility.title();
	}
	
	public String getURL() {
		return Utility.uRL();
	}
	
	public boolean getHomeOption() {
		boolean flag=Utility.displayedOrNot(homeOption);
		return flag;
	}
	
	public boolean flierImagesDislaysOrNot() throws InterruptedException {
		// Optional: You might want to add a wait to ensure the carousel is loaded and ready to interact
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(carousel));
       
       ((JavascriptExecutor)driver).executeScript("clearInterval(10)");
       
       List<WebElement> li=driver.findElements(By.xpath("//*[@class=\"carousel-inner\"]/div"));
       int countOfImages=li.size();
       System.out.println("Total flying images are "+countOfImages);
    // Going back to the previous images using the left button
       for (int i = 0; i < countOfImages; i++) {
            rightButton.click();
            Thread.sleep(2000);
       }
    // Going back to the previous images using the left button
        for (int i = 0; i < countOfImages; i++) {
            leftButton.click();
            Thread.sleep(2000);
        }
		return true;
	}
	
	public boolean imagesDisplayedOrNot() {
		WebElement listProduct=driver.findElement(By.xpath("//*[@class=\"row\" and @id=\"tbodyid\"]/div[1]"));
		boolean flag=listProduct.isDisplayed();
		return flag;
	}
	
}