package com.DemoBlaze.testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoBlaze.base.ReadConfigProp;
import com.DemoBlaze.base.TestBase;
import com.DemoBlaze.pageClasses.IndexPage;

public class IndexPageTest extends TestBase{

	IndexPage index;
	
	@Test(priority=1)
	public void VerifyTitle() {
		index=new IndexPage();
		String actTitle=index.getTitleIndex();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, ReadConfigProp.readTitle());
	}
	
	@Test(priority=2)
	public void VerifyUrlOfIndexPage() throws IOException {
		index=new IndexPage();
		String actURL=index.getURL();
		System.out.println(actURL);
		Assert.assertEquals(actURL, ReadConfigProp.readURL());
	}
	
	@Test(priority=3)
	public void VerifyHomeOptionDisplayedOrNot() {
		index=new IndexPage();
		boolean flag=index.getHomeOption();
		System.out.println("Home displayed or not - "+flag);
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=4)
	public void VerifyCarousealImagesPresentOrNo() throws InterruptedException {
		index=new IndexPage();
		boolean flag=index.flierImagesDislaysOrNot();
		System.out.println("Carousel images present - "+flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void VerifyProductDisplayedOnIndexPageOrNot() throws InterruptedException {
		index=new IndexPage();
		Thread.sleep(5000);
		boolean flag=index.imagesDisplayedOrNot();
		System.out.println("Products are displayed - "+flag+"\n");
		Assert.assertTrue(flag);
	}
	
}